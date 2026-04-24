<template>
    <div>
        <el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="50%"
                   destroy-on-close :fullscreen='false'>
            <el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="场地名称" prop="changdimingcheng">
                            <el-input class="list_inp" v-model="form.changdimingcheng" placeholder="场地名称"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.changdimingcheng?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="场地类型" prop="changdileixing">
                            <el-input class="list_inp" v-model="form.changdileixing" placeholder="场地类型"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.changdileixing?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="项目名称" prop="xiangmumingcheng">
                            <el-input class="list_inp" v-model="form.xiangmumingcheng" placeholder="项目名称"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.xiangmumingcheng?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="使用时间" prop="shiyongshijian">
                            <el-date-picker
                                    class="list_date"
                                    v-model="form.shiyongshijian"
                                    format="YYYY-MM-DD HH:mm:ss"
                                    value-format="YYYY-MM-DD HH:mm:ss"
                                    type="datetime"
                                    :readonly="!isAdd||disabledForm.shiyongshijian?true:false"
                                    placeholder="请选择使用时间"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="预约时间" prop="yuyueshijian">
                            <el-date-picker
                                    class="list_date"
                                    v-model="form.yuyueshijian"
                                    format="YYYY-MM-DD HH:mm:ss"
                                    value-format="YYYY-MM-DD HH:mm:ss"
                                    type="datetime"
                                    :readonly="!isAdd||disabledForm.yuyueshijian?true:false"
                                    placeholder="请选择预约时间"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="投标账号" prop="toubiaozhanghao">
                            <el-input class="list_inp" v-model="form.toubiaozhanghao" placeholder="投标账号"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.toubiaozhanghao?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="投标人姓名" prop="toubiaorenxingming">
                            <el-input class="list_inp" v-model="form.toubiaorenxingming" placeholder="投标人姓名"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.toubiaorenxingming?true:false"/>
                        </el-form-item>
                    </el-col>

                </el-row>
            </el-form>
            <template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="cancel_btn" @click="closeClick">取消</el-button>
					<el-button class="confirm_btn" type="primary" @click="save"
                    >
						提交
					</el-button>
				</span>
            </template>
        </el-dialog>
    </div>
</template>
<script setup>
    import {
        reactive,
        ref,
        getCurrentInstance,
        nextTick,
        computed,
        defineEmits
    } from 'vue'
    import {
        useStore
    } from 'vuex';

    const store = useStore()
    const user = computed(() => store.getters['user/session'])
    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const emit = defineEmits(['formModelChange'])
    //基础信息
    const tableName = 'changdiyuyue'
    const formName = '场地预约'
    //基础信息
    //form表单
    const form = ref({})
    const disabledForm = ref({
        changdimingcheng: false,
        changdileixing: false,
        xiangmumingcheng: false,
        shiyongshijian: false,
        yuyueshijian: false,
        toubiaozhanghao: false,
        toubiaorenxingming: false,
        sfsh: false,
        shhf: false,
    })
    const formVisible = ref(false)
    const isAdd = ref(false)
    const formTitle = ref('')
    //表单验证
    //匹配整数
    const validateIntNumber = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isIntNumer(value)) {
            callback(new Error("请输入整数"));
        } else {
            callback();
        }
    }
    //匹配数字
    const validateNumber = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isNumber(value)) {
            callback(new Error("请输入数字"));
        } else {
            callback();
        }
    }
    //匹配手机号码
    const validateMobile = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isMobile(value)) {
            callback(new Error("请输入正确的手机号码"));
        } else {
            callback();
        }
    }
    //匹配电话号码
    const validatePhone = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isPhone(value)) {
            callback(new Error("请输入正确的电话号码"));
        } else {
            callback();
        }
    }
    //匹配邮箱
    const validateEmail = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isEmail(value)) {
            callback(new Error("请输入正确的邮箱地址"));
        } else {
            callback();
        }
    }
    //匹配身份证
    const validateIdCard = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.checkIdCard(value)) {
            callback(new Error("请输入正确的身份证号码"));
        } else {
            callback();
        }
    }
    //匹配网站地址
    const validateUrl = (rule, value, callback) => {
        if (!value) {
            callback();
        } else if (!context?.$toolUtil.isURL(value)) {
            callback(new Error("请输入正确的URL地址"));
        } else {
            callback();
        }
    }
    const rules = ref({
        changdimingcheng: [],
        changdileixing: [],
        xiangmumingcheng: [],
        shiyongshijian: [],
        yuyueshijian: [],
        toubiaozhanghao: [],
        toubiaorenxingming: [],
        sfsh: [],
        shhf: [],
    })
    //表单验证

    const formRef = ref(null)
    const id = ref(0)
    const type = ref('')

    //获取唯一标识
    const getUUID = () => {
        return new Date().getTime();
    }
    //重置
    const resetForm = () => {
        form.value = {
            changdimingcheng: '',
            changdileixing: '',
            xiangmumingcheng: '',
            shiyongshijian: '',
            yuyueshijian: '',
            toubiaozhanghao: '',
            toubiaorenxingming: '',
            sfsh: '待审核',
            shhf: '',
        }
    }
    //获取info
    const getInfo = () => {
        context?.$http({
            url: `${tableName}/info/${id.value}`,
            method: 'get'
        }).then(res => {
            let reg = new RegExp('../../../file', 'g')
            form.value = res.data.data
            formVisible.value = true
        })
    }
    const crossRow = ref('')
    const crossTable = ref('')
    const crossTips = ref('')
    const crossColumnName = ref('')
    const crossColumnValue = ref('')
    //初始化
    const init = (formId = null, formType = 'add', formNames = '', row = null, table = null, statusColumnName = null, tips = null, statusColumnValue = null) => {
        resetForm()
        form.value.yuyueshijian = context?.$toolUtil.getCurDateTime()
        if (formId) {
            id.value = formId
            type.value = formType
        }
        if (formType == 'add') {
            isAdd.value = true
            formTitle.value = '新增' + formName
            formVisible.value = true
        } else if (formType == 'info') {
            isAdd.value = false
            formTitle.value = '查看' + formName
            getInfo()
        } else if (formType == 'edit') {
            isAdd.value = true
            formTitle.value = '修改' + formName
            getInfo()
        } else if (formType == 'cross') {
            isAdd.value = true
            formTitle.value = formNames
            // getInfo()
            for (let x in row) {
                if (x == 'changdimingcheng') {
                    form.value.changdimingcheng = row[x];
                    disabledForm.value.changdimingcheng = true;
                    continue;
                }
                if (x == 'changdileixing') {
                    form.value.changdileixing = row[x];
                    disabledForm.value.changdileixing = true;
                    continue;
                }
                if (x == 'xiangmumingcheng') {
                    form.value.xiangmumingcheng = row[x];
                    disabledForm.value.xiangmumingcheng = true;
                    continue;
                }
                if (x == 'shiyongshijian') {
                    form.value.shiyongshijian = row[x];
                    disabledForm.value.shiyongshijian = true;
                    continue;
                }
                if (x == 'yuyueshijian') {
                    form.value.yuyueshijian = row[x];
                    disabledForm.value.yuyueshijian = true;
                    continue;
                }
                if (x == 'toubiaozhanghao') {
                    form.value.toubiaozhanghao = row[x];
                    disabledForm.value.toubiaozhanghao = true;
                    continue;
                }
                if (x == 'toubiaorenxingming') {
                    form.value.toubiaorenxingming = row[x];
                    disabledForm.value.toubiaorenxingming = true;
                    continue;
                }
            }
            if (row) {
                crossRow.value = row
            }
            if (table) {
                crossTable.value = table
            }
            if (tips) {
                crossTips.value = tips
            }
            if (statusColumnName) {
                crossColumnName.value = statusColumnName
            }
            if (statusColumnValue) {
                crossColumnValue.value = statusColumnValue
            }
            form.value.sfsh = '待审核'
            formVisible.value = true
        }

        context?.$http({
            url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
            method: 'get'
        }).then(res => {
            var json = res.data.data
            if (json.hasOwnProperty('toubiaozhanghao') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.toubiaozhanghao = json.toubiaozhanghao
                disabledForm.value.toubiaozhanghao = true;
            }
            if (json.hasOwnProperty('toubiaorenxingming') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.toubiaorenxingming = json.toubiaorenxingming
                disabledForm.value.toubiaorenxingming = true;
            }
            if (json.hasOwnProperty('shhf') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.shhf = json.shhf
                disabledForm.value.shhf = true;
            }
        })
    }
    //初始化
    //声明父级调用
    defineExpose({
        init
    })
    //关闭
    const closeClick = () => {
        formVisible.value = false
    }
    //富文本
    const editorChange = (e, name) => {
        form.value[name] = e
    }
    //提交
    const save = async () => {
        var table = crossTable.value
        var objcross = JSON.parse(JSON.stringify(crossRow.value))
        let crossUserId = ''
        let crossRefId = ''
        let crossOptNum = ''
        if (type.value == 'cross') {
            if (crossColumnName.value != '') {
                if (!crossColumnName.value.startsWith('[')) {
                    for (let o in objcross) {
                        if (o == crossColumnName.value) {
                            objcross[o] = crossColumnValue.value
                        }
                    }
                    //修改跨表数据
                    changeCrossData(objcross)
                } else {
                    crossUserId = user.value.id
                    crossRefId = objcross['id']
                    crossOptNum = crossColumnName.value.replace(/\[/, "").replace(/\]/, "")
                }
            }
        }
        formRef.value.validate((valid) => {
            if (valid) {
                if (crossUserId && crossRefId) {
                    form.value.crossuserid = crossUserId
                    form.value.crossrefid = crossRefId
                    let params = {
                        page: 1,
                        limit: 1000,
                        crossuserid: form.value.crossuserid,
                        crossrefid: form.value.crossrefid,
                    }
                    context?.$http({
                        url: `${tableName}/page`,
                        method: 'get',
                        params: params
                    }).then(res => {
                        if (res.data.data.total >= crossOptNum) {
                            context?.$toolUtil.message(`${crossTips.value}`, 'error')
                            return false
                        } else {
                            context?.$http({
                                url: `${tableName}/${!form.value.id ? "save" : "update"}`,
                                method: 'post',
                                data: form.value
                            }).then(async res => {
                                emit('formModelChange')
                                context?.$toolUtil.message(`操作成功`, 'success')
                                formVisible.value = false
                            })
                        }
                    })
                } else {
                    context?.$http({
                        url: `${tableName}/${!form.value.id ? "save" : "update"}`,
                        method: 'post',
                        data: form.value
                    }).then(async (res) => {
                        emit('formModelChange')
                        context?.$toolUtil.message(`操作成功`, 'success')
                        formVisible.value = false
                    })
                }
            } else {
                context.$message.error('请完善信息')
            }
        })
    }
    //修改跨表数据
    const changeCrossData = async (row) => {
        if (type.value == 'cross') {
            await context?.$http({
                url: `${crossTable.value}/update`,
                method: 'post',
                data: row
            }).then(res => {
            })
        }
    }
</script>
<style lang="scss" scoped>
    // 表单
    .formModel_form {
        // form item
        :deep(.el-form-item) {
            //label
            .el-form-item__label {
            }

            // 内容盒子
            .el-form-item__content {
                // 输入框
                .list_inp {
                }

                //日期选择器
                .list_date {
                }
            }
        }
    }

    // 按钮盒子
    .formModel_btn_box {
        .cancel_btn {
        }

        .cancel_btn:hover {
        }

        .confirm_btn {
        }

        .confirm_btn:hover {
        }
    }
</style>
