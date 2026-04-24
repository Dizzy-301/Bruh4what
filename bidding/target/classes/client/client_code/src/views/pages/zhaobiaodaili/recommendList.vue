<template>
    <div class="list-page" :style='{}'>
        <div class="breadcrumb-wrapper" style="width: 100%;">
            <div class="bread_view">
                <el-breadcrumb separator="—" class="breadcrumb">
                    <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item class="second_breadcrumb" v-for="(item,index) in breadList" :key="index">
                        {{item.name}}
                    </el-breadcrumb-item>
                </el-breadcrumb>
            </div>
        </div>
        <div class="page_list">
            <div class="data_box">
                <div class="table_view">
                    <el-table v-loading="listLoading" class="data_table" :data="list" border
                              :row-style="{'cursor':'pointer'}"
                              @row-click="tableDetailClick" :stripe='true'>
                        <el-table-column label="序号" width="120" :resizable='true' align="left" header-align="left">
                            <template #default="scope">{{ (listQuery.page-1)*listQuery.limit+scope.$index + 1}}
                            </template>
                        </el-table-column>
                        <el-table-column label="代理公司账号" :resizable='true' align="left" header-align="left">
                            <template #default="scope">
                                {{scope.row.dailigongsizhanghao}}
                            </template>
                        </el-table-column>
                        <el-table-column label="代理公司名称" :resizable='true' align="left" header-align="left">
                            <template #default="scope">
                                {{scope.row.dailigongsimingcheng}}
                            </template>
                        </el-table-column>
                        <el-table-column label="联系电话" :resizable='true' align="left" header-align="left">
                            <template #default="scope">
                                {{scope.row.lianxidianhua}}
                            </template>
                        </el-table-column>
                    </el-table>
                </div>
                <el-pagination
                        background
                        :layout="layouts.join(',')"
                        :total="total"
                        :page-size="listQuery.limit"
                        v-model:current-page="listQuery.page"
                        prev-text="上一页"
                        next-text="下一页"
                        :hide-on-single-page="false"
                        :style='{}'
                        @size-change="sizeChange"
                        @current-change="currentChange"/>
            </div>
        </div>
    </div>
</template>

<script setup>
    import {
        ref,
        getCurrentInstance,
        computed,
    } from 'vue';
    import {
        useRoute,
        useRouter
    } from 'vue-router';

    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const router = useRouter()
    const route = useRoute()
    //基础信息
    const tableName = 'zhaobiaodaili'
    const formName = '招标代理推荐'
    //基础信息
    const breadList = ref([{
        name: formName
    }])
    const list = ref([])
    const listQuery = ref({
        page: 1,
        limit: 20,
    })
    const total = ref(0)
    const listLoading = ref(false)

    //分页
    const layouts = ref(["prev", "pager", "next"])
    const sizeChange = (size) => {
        listQuery.value.limit = size
        getList()
    }
    const currentChange = (page) => {
        listQuery.value.page = page
        getList()
    }
    //列表
    const getList = () => {
        listLoading.value = true
        let params = JSON.parse(JSON.stringify(listQuery.value))
        context?.$http({
            url: `${tableName}/autoSort2`,
            method: 'get',
            params: params
        }).then(res => {
            listLoading.value = false
            list.value = res.data.data.list
            total.value = Number(res.data.data.total)
        })
    }
    const tableDetailClick = (row) => {
        router.push(`/index/${tableName}Detail?id=` + row.id)
    }
    const init = async () => {
        getList()
    }
    init()
</script>
<style lang="scss" scoped>
    .bread_view {
        :deep(.breadcrumb) {
            .el-breadcrumb__separator {
            }

            .first_breadcrumb {
                .el-breadcrumb__inner {
                }
            }

            .second_breadcrumb {
                .el-breadcrumb__inner {
                }
            }
        }
    }

    // 数据盒子
    .page_list {
        padding: 20px calc(50% - 600px);
        //列表
        .data_box {
            .table_view {
                // 表格样式
                .el-table {
                }
            }
        }
    }

    // 分页器
    .el-pagination {
        margin-top: 20px;
        justify-content: center;
    }
</style>
