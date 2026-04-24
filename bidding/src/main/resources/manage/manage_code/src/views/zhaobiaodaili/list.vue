<template>
    <div>
        <div class="center_view">
            <div class="list_search_view">
                <el-form :model="searchQuery" class="search_form">
                    <div class="search_view">
                        <div class="search_label">
                            代理公司账号：
                        </div>
                        <div class="search_box">
                            <el-input class="search_inp" v-model="searchQuery.dailigongsizhanghao" placeholder="代理公司账号"
                                      clearable>
                            </el-input>
                        </div>
                    </div>
                    <div class="search_btn_view">
                        <el-button class="search_btn" type="primary" @click="searchClick()" size="small">搜索</el-button>
                    </div>
                </el-form>
                <div class="btn_view">
                    <el-button class="add_btn" type="success" @click="addClick" v-if="btnAuth('zhaobiaodaili','新增')">
                        新增
                    </el-button>
                    <el-button class="del_btn" type="danger" :disabled="selRows.length?false:true"
                               @click="delClick(null)" v-if="btnAuth('zhaobiaodaili','删除')">
                        删除
                    </el-button>
                </div>
            </div>
            <el-table
                    v-loading="listLoading"
                    border
                    :stripe='false'
                    @selection-change="handleSelectionChange"
                    ref="table"
                    v-if="btnAuth('zhaobiaodaili','查看')"
                    :data="list"
                    @row-click="listChange">
                <el-table-column :resizable='true' align="left" header-align="left" type="selection" width="55"/>
                <el-table-column label="序号" width="70" :resizable='true' align="left" header-align="left">
                    <template #default="scope">{{ (listQuery.page-1)*listQuery.limit+scope.$index + 1}}</template>
                </el-table-column>
                <el-table-column min-width="140"
                                 :resizable='true'
                                 :sortable='true'
                                 align="left"
                                 header-align="left"
                                 prop="dailigongsizhanghao"
                                 label="代理公司账号">
                    <template #default="scope">
                        {{scope.row.dailigongsizhanghao}}
                    </template>
                </el-table-column>
                <el-table-column min-width="140"
                                 :resizable='true'
                                 :sortable='true'
                                 align="left"
                                 header-align="left"
                                 prop="dailigongsimingcheng"
                                 label="代理公司名称">
                    <template #default="scope">
                        {{scope.row.dailigongsimingcheng}}
                    </template>
                </el-table-column>
                <el-table-column min-width="140"
                                 :resizable='true'
                                 :sortable='true'
                                 align="left"
                                 header-align="left"
                                 prop="lianxidianhua"
                                 label="联系电话">
                    <template #default="scope">
                        {{scope.row.lianxidianhua}}
                    </template>
                </el-table-column>
                <el-table-column label="资质" min-width="140" width="120" :resizable='true' :sortable='true' align="left"
                                 header-align="left">
                    <template #default="scope">
                        <div v-if="scope.row.zizhi">
                            <el-image v-if="scope.row.zizhi.substring(0,4)=='http'" preview-teleported
                                      :preview-src-list="[scope.row.zizhi.split(',')[0]]"
                                      :src="scope.row.zizhi.split(',')[0]" style="width:100px;height:100px"></el-image>
                            <el-image v-else preview-teleported
                                      :preview-src-list="[$config.url+scope.row.zizhi.split(',')[0]]"
                                      :src="$config.url+scope.row.zizhi.split(',')[0]" style="width:100px;height:100px">
                            </el-image>
                        </div>
                        <div v-else>无图片</div>
                    </template>
                </el-table-column>
                <el-table-column prop="manyidu" label="满意度" :resizable='true' :sortable='true' align="left" header-align="left">
                    <template #default="scope">
                        <span style="font-weight: bold;color: #f39c12;">{{scope.row.manyidu?Number(scope.row.manyidu).toFixed(1):'0.0'}}</span>
                    </template>
                </el-table-column>
                <el-table-column prop="dengji" label="等级" width="150" :resizable='true' :sortable='true' align="left" header-align="left">
                    <template #default="scope">
                        <el-tag v-if="scope.row.dengji=='金牌代理公司'" type="warning" effect="dark">{{scope.row.dengji}}</el-tag>
                        <el-tag v-else-if="scope.row.dengji=='银牌代理公司'" type="success" effect="dark">{{scope.row.dengji}}</el-tag>
                        <el-tag v-else-if="scope.row.dengji=='铜牌代理公司'" type="info" effect="dark">{{scope.row.dengji}}</el-tag>
                        <el-tag v-else type="danger">{{scope.row.dengji}}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column prop="sfsh" label="审核状态" :resizable='true' :sortable='true' align="left" header-align="left">
                    <template #default="scope">
                        <el-tag v-if="scope.row.sfsh=='是'" type="success">通过</el-tag>
                        <el-tag v-if="scope.row.sfsh=='否'" type="danger">未通过</el-tag>
                        <el-tag v-if="scope.row.sfsh=='待审核'" type="warning">待审核</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="300" :resizable='true' :sortable='true' align="left"
                                 header-align="left">
                    <template #default="scope">
                        <el-button class="view_btn" type="info" v-if=" btnAuth('zhaobiaodaili','查看')"
                                   @click="infoClick(scope.row.id)">
                            详情
                        </el-button>
                        <el-button class="edit_btn" type="primary" @click="editClick(scope.row.id)"
                                   v-if=" btnAuth('zhaobiaodaili','修改')">
                            修改
                        </el-button>
                        <el-button class="del_btn" type="danger" @click="delClick(scope.row.id)"
                                   v-if="btnAuth('zhaobiaodaili','删除')">
                            删除
                        </el-button>
                        <el-button class="sh_btn" type="warning" v-if="btnAuth('zhaobiaodaili','审核')"
                                   @click="shClick(scope.row)">
                            审核
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    background
                    :layout="layouts.join(',')"
                    :total="total"
                    :page-size="listQuery.limit"
                    v-model:current-page="listQuery.page"
                    prev-text="<"
                    next-text=">"
                    :hide-on-single-page="false"
                    :style='{}'
                    :page-sizes="[10, 20, 30, 40, 50, 100]"
                    @size-change="sizeChange"
                    @current-change="currentChange"/>
        </div>
        <formModel ref="formRef" @formModelChange="formModelChange"></formModel>
        <el-dialog v-model="shVisible" title="审核" width="500px">
            <el-form :model="shForm" label-width="80px">
                <el-form-item label="审核状态">
                    <el-select v-model="shForm.sfsh" placeholder="请选择审核状态">
                        <el-option label="通过" value="是" />
                        <el-option label="未通过" value="否" />
                    </el-select>
                </el-form-item>
                <el-form-item label="审核回复">
                    <el-input v-model="shForm.shhf" type="textarea" :rows="3" placeholder="请输入审核回复" />
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="shVisible = false">取消</el-button>
                    <el-button type="primary" @click="shUpdate">确定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>
<script setup>
    import axios from 'axios'
    import {
        reactive,
        ref,
        getCurrentInstance,
        nextTick,
        onMounted,
        watch,
        computed,
    } from 'vue'
    import {
        useRoute,
        useRouter
    } from 'vue-router'
    import {
        ElMessageBox
    } from 'element-plus'
    import {
        useStore
    } from 'vuex';

    const store = useStore()
    const user = computed(() => store.getters['user/session'])
    const avatar = ref(store.state.user.avatar)
    const context = getCurrentInstance()?.appContext.config.globalProperties;
    import formModel from './formModel.vue'
    //基础信息

    const tableName = 'zhaobiaodaili'
    const formName = '招标代理'
    const route = useRoute()
    //基础信息
    onMounted(() => {
    })
    //列表数据
    const list = ref(null)
    const table = ref(null)
    const listQuery = ref({
        page: 1,
        limit: 10,
        sort: 'id',
        order: 'desc'
    })
    const searchQuery = ref({})
    const selRows = ref([])
    const listLoading = ref(false)
    const listChange = (row) => {
        nextTick(() => {
            //table.value.clearSelection()
            table.value.toggleRowSelection(row)
        })
    }
    //列表
    const getList = () => {
        listLoading.value = true
        let params = JSON.parse(JSON.stringify(listQuery.value))
        params['sort'] = 'id'
        params['order'] = 'desc'
        if (searchQuery.value.dailigongsizhanghao && searchQuery.value.dailigongsizhanghao != '') {
            params['dailigongsizhanghao'] = '%' + searchQuery.value.dailigongsizhanghao + '%'
        }
        context.$http({
            url: `${tableName}/page`,
            method: 'get',
            params: params
        }).then(res => {
            listLoading.value = false
            list.value = res.data.data.list
            total.value = Number(res.data.data.total)
        })
    }
    //删
    const delClick = (id) => {
        let ids = ref([])
        if (id) {
            ids.value = [id]
        } else {
            if (selRows.value.length) {
                for (let x in selRows.value) {
                    ids.value.push(selRows.value[x].id)
                }
            } else {
                return false
            }
        }
        ElMessageBox.confirm(`是否删除选中${formName}`, '提示', {
            confirmButtonText: '是',
            cancelButtonText: '否',
            type: 'warning',
        }).then(() => {
            context.$http({
                url: `${tableName}/delete`,
                method: 'post',
                data: ids.value
            }).then(res => {
                context?.$toolUtil.message('删除成功', 'success', () => {
                    getList()
                })
            })
        })
    }
    //多选
    const handleSelectionChange = (e) => {
        selRows.value = e
    }
    //列表数据
    //分页
    const total = ref(0)
    const layouts = ref(["total", "prev", "pager", "next", "sizes", "jumper"])
    const sizeChange = (size) => {
        listQuery.value.limit = size
        getList()
    }
    const currentChange = (page) => {
        listQuery.value.page = page
        getList()
    }
    //分页
    //权限验证
    const btnAuth = (e, a) => {
        return context?.$toolUtil.isAuth(e, a)
    }
    //搜索
    const searchClick = () => {
        listQuery.value.page = 1
        getList()
    }
    //表单
    const formRef = ref(null)
    const formModelChange = () => {
        searchClick()
    }
    const addClick = () => {
        formRef.value.init()
    }
    const editClick = (id = null) => {
        if (id) {
            formRef.value.init(id, 'edit')
            return
        }
        if (selRows.value.length) {
            formRef.value.init(selRows.value[0].id, 'edit')
        }
    }

    const infoClick = (id = null) => {
        if (id) {
            formRef.value.init(id, 'info')
        } else if (selRows.value.length) {
            formRef.value.init(selRows.value[0].id, 'info')
        }
    }
    // 审核
    const shVisible = ref(false)
    const shForm = ref({
        sfsh: '是',
        shhf: ''
    })
    const shClick = (row) => {
        shForm.value = {
            id: row.id,
            sfsh: row.sfsh,
            shhf: row.shhf
        }
        shVisible.value = true
    }
    const shUpdate = () => {
        context.$http({
            url: `${tableName}/sh/${tableName}`,
            method: 'post',
            data: shForm.value
        }).then(res => {
            context?.$toolUtil.message('审核成功', 'success', () => {
                shVisible.value = false
                getList()
            })
        })
    }
    // 表单
    // 预览文件
    const preClick = (file) => {
        if (!file) {
            context?.$toolUtil.message('文件不存在', 'error')
        }
        window.open(context?.$config.url + file)
    }
    // 下载文件
    const download = (file) => {
        if (!file) {
            context?.$toolUtil.message('文件不存在', 'error')
        }
        let arr = file.replace(new RegExp('file/', "g"), "")
        axios.get((location.href.split(context?.$config.name).length > 1 ? location.href.split(context?.$config.name)[0] : '') + context?.$config.name + '/file/download?fileName=' + arr, {
            headers: {
                token: context?.$toolUtil.storageGet('Token')
            },
            responseType: "blob"
        }).then(({
                     data
                 }) => {
            const binaryData = [];
            binaryData.push(data);
            const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
                type: 'application/pdf;chartset=UTF-8'
            }))
            const a = document.createElement('a')
            a.href = objectUrl
            a.download = arr
            // a.click()
            // 下面这个写法兼容火狐
            a.dispatchEvent(new MouseEvent('click', {
                bubbles: true,
                cancelable: true,
                view: window
            }))
            window.URL.revokeObjectURL(data)
        })
    }
    //初始化
    const init = () => {
        getList()
    }
    init()
</script>
<style lang="scss" scoped>

    // 操作盒子
    .list_search_view {
        // 搜索盒子
        .search_form {
            // 子盒子
            .search_view {
                // 搜索label
                .search_label {
                }

                // 搜索item
                .search_box {
                    // 输入框
                    :deep(.search_inp) {
                    }
                }
            }

            // 搜索按钮盒子
            .search_btn_view {
                // 搜索按钮
                .search_btn {
                }

                // 搜索按钮-悬浮
                .search_btn:hover {
                }
            }
        }

        //头部按钮盒子
        .btn_view {
            // 其他
            :deep(.el-button--default) {
            }

            // 其他-悬浮
            :deep(.el-button--default:hover) {
            }

            // 新增
            :deep(.el-button--success) {
            }

            // 新增-悬浮
            :deep(.el-button--success:hover) {
            }

            // 删除
            :deep(.el-button--danger) {
            }

            // 删除-悬浮
            :deep(.el-button--danger:hover) {
            }

            // 统计
            :deep(.el-button--warning) {
            }

            // 统计-悬浮
            :deep(.el-button--warning:hover) {
            }
        }
    }

    // 表格样式
    .el-table {
        :deep(.el-table__header-wrapper) {
            thead {
                tr {
                    th {
                        .cell {
                        }
                    }
                }
            }
        }

        :deep(.el-table__body-wrapper) {
            tbody {
                tr {
                    td {
                        .cell {
                            // 编辑
                            .el-button--primary {
                            }

                            // 编辑-悬浮
                            .el-button--primary:hover {
                            }

                            // 详情
                            .el-button--info {
                            }

                            // 详情-悬浮
                            .el-button--info:hover {
                            }

                            // 删除
                            .el-button--danger {
                            }

                            // 删除-悬浮
                            .el-button--danger:hover {
                            }

                            // 跨表
                            .el-button--success {
                            }

                            // 跨表-悬浮
                            .el-button--success:hover {
                            }

                            // 操作
                            .el-button--warning {
                            }

                            // 操作-悬浮
                            .el-button--warning:hover {
                            }
                        }
                    }
                }

                tr:hover {
                    td {
                    }
                }
            }
        }
    }

    // 分页器
    .el-pagination {
        // 总页码
        :deep(.el-pagination__total) {
        }

        // 上一页
        :deep(.btn-prev) {
        }

        // 下一页
        :deep(.btn-next) {
        }

        // 上一页禁用
        :deep(.btn-prev:disabled) {
        }

        // 下一页禁用
        :deep(.btn-next:disabled) {
        }

        // 页码
        :deep(.el-pager) {
            // 数字
            .number {
            }

            // 数字悬浮
            .number:hover {
            }

            // 选中
            .number.is-active {
            }
        }

        // sizes
        :deep(.el-pagination__sizes) {
            display: inline-block;
            vertical-align: top;
            font-size: 13px;
            line-height: 28px;
            height: 28px;

            .el-select {
            }
        }

        // 跳页
        :deep(.el-pagination__jump) {
            // 输入框
            .el-input {
            }
        }
    }
</style>
