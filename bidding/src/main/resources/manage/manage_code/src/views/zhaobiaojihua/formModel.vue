<template>
    <div>
        <el-dialog modal-class="edit_form_modal" class="edit_form" v-model="formVisible" :title="formTitle" width="50%"
                   destroy-on-close :fullscreen='false'>
            <el-form class="formModel_form" ref="formRef" :model="form" :rules="rules">
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="项目名称" prop="xiangmumingcheng">
                            <el-input class="list_inp" v-model="form.xiangmumingcheng" placeholder="项目名称"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.xiangmumingcheng?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="企业账号" prop="qiyezhanghao">
                            <el-input class="list_inp" v-model="form.qiyezhanghao" placeholder="企业账号"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.qiyezhanghao?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="企业名称" prop="qiyemingcheng">
                            <el-input class="list_inp" v-model="form.qiyemingcheng" placeholder="企业名称"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.qiyemingcheng?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="招标范围" prop="zhaobiaofanwei">
                            <el-input class="list_inp" v-model="form.zhaobiaofanwei" placeholder="招标范围"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.zhaobiaofanwei?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="计划文件" prop="jihuawenjian">
                            <uploads
                                    :disabled="!isAdd||disabledForm.jihuawenjian?true:false"
                                    type="file"
                                    action="file/upload"
                                    tip="请上传计划文件"
                                    :limit="1"
                                    style="width: 100%;text-align: left;"
                                    :fileUrls="form.jihuawenjian?form.jihuawenjian:''"
                                    @change="jihuawenjianUploadSuccess">
                            </uploads>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="投标截止时间" prop="toubiaojiezhishijian">
                            <el-date-picker
                                    class="list_date"
                                    v-model="form.toubiaojiezhishijian"
                                    format="YYYY 年 MM 月 DD 日"
                                    value-format="YYYY-MM-DD"
                                    type="datetime"
                                    :readonly="!isAdd||disabledForm.toubiaojiezhishijian?true:false"
                                    placeholder="请选择投标截止时间"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="开标时间" prop="kaibiaoshijian">
                            <el-date-picker
                                    class="list_date"
                                    v-model="form.kaibiaoshijian"
                                    format="YYYY 年 MM 月 DD 日"
                                    value-format="YYYY-MM-DD"
                                    type="datetime"
                                    :readonly="!isAdd||disabledForm.kaibiaoshijian?true:false"
                                    placeholder="请选择开标时间"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="项目地点" prop="xiangmudidian">
                            <el-input class="list_inp" v-model="form.xiangmudidian" placeholder="项目地点"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.xiangmudidian?true:false"/>
                        </el-form-item>
                    </el-col>

                    <el-col :span="24">
                        <el-form-item label="项目周期" prop="xiangmuzhouqi">
                            <el-input class="list_inp" v-model="form.xiangmuzhouqi" placeholder="项目周期"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.xiangmuzhouqi?true:false"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="项目预算" prop="xiangmuyusuan">
                            <el-input class="list_inp" v-model="form.xiangmuyusuan" placeholder="项目预算"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.xiangmuyusuan?true:false"/>
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
    const tableName = 'zhaobiaojihua'
    const formName = '招标计划'
    //基础信息
    //form表单
    const form = ref({})
    const disabledForm = ref({
        xiangmumingcheng: false,
        qiyezhanghao: false,
        qiyemingcheng: false,
        zhaobiaofanwei: false,
        jihuawenjian: false,
        toubiaojiezhishijian: false,
        kaibiaoshijian: false,
        xiangmudidian: false,
        xiangmuzhouqi: false,
        xiangmuyusuan: false,
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
        xiangmumingcheng: [],
        qiyezhanghao: [],
        qiyemingcheng: [],
        zhaobiaofanwei: [],
        jihuawenjian: [],
        toubiaojiezhishijian: [],
        kaibiaoshijian: [],
        xiangmudidian: [],
        xiangmuzhouqi: [],
        xiangmuyusuan: [{
            validator: validateNumber,
            trigger: 'blur'
        }],
    })
    //表单验证

    const formRef = ref(null)
    const id = ref(0)
    const type = ref('')
    //计划文件上传回调
    const jihuawenjianUploadSuccess = (e) => {
        form.value.jihuawenjian = e
    }

    //获取唯一标识
    const getUUID = () => {
        return new Date().getTime();
    }
    //重置
    const resetForm = () => {
        form.value = {
            xiangmumingcheng: '',
            qiyezhanghao: '',
            qiyemingcheng: '',
            zhaobiaofanwei: '',
            jihuawenjian: '',
            toubiaojiezhishijian: '',
            kaibiaoshijian: '',
            xiangmudidian: '',
            xiangmuzhouqi: '',
            xiangmuyusuan: '',
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
                if (x == 'xiangmumingcheng') {
                    form.value.xiangmumingcheng = row[x];
                    disabledForm.value.xiangmumingcheng = true;
                    continue;
                }
                if (x == 'qiyezhanghao') {
                    form.value.qiyezhanghao = row[x];
                    disabledForm.value.qiyezhanghao = true;
                    continue;
                }
                if (x == 'qiyemingcheng') {
                    form.value.qiyemingcheng = row[x];
                    disabledForm.value.qiyemingcheng = true;
                    continue;
                }
                if (x == 'zhaobiaofanwei') {
                    form.value.zhaobiaofanwei = row[x];
                    disabledForm.value.zhaobiaofanwei = true;
                    continue;
                }
                if (x == 'jihuawenjian') {
                    form.value.jihuawenjian = row[x];
                    disabledForm.value.jihuawenjian = true;
                    continue;
                }
                if (x == 'toubiaojiezhishijian') {
                    form.value.toubiaojiezhishijian = row[x];
                    disabledForm.value.toubiaojiezhishijian = true;
                    continue;
                }
                if (x == 'kaibiaoshijian') {
                    form.value.kaibiaoshijian = row[x];
                    disabledForm.value.kaibiaoshijian = true;
                    continue;
                }
                if (x == 'xiangmudidian') {
                    form.value.xiangmudidian = row[x];
                    disabledForm.value.xiangmudidian = true;
                    continue;
                }
                if (x == 'xiangmuzhouqi') {
                    form.value.xiangmuzhouqi = row[x];
                    disabledForm.value.xiangmuzhouqi = true;
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
            formVisible.value = true
        }

        context?.$http({
            url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
            method: 'get'
        }).then(res => {
            var json = res.data.data
            if (json.hasOwnProperty('qiyezhanghao') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.qiyezhanghao = json.qiyezhanghao
                disabledForm.value.qiyezhanghao = true;
            }
            if (json.hasOwnProperty('qiyemingcheng') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.qiyemingcheng = json.qiyemingcheng
                disabledForm.value.qiyemingcheng = true;
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
        if (form.value.jihuawenjian != null) {
            form.value.jihuawenjian = form.value.jihuawenjian.replace(new RegExp(context?.$config.url, "g"), "");
        }
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

                //文件上传样式
                .upload-demo {
                    width: 100%;
                    //外部盒子
                    .el-upload-dragger {
                    }

                    //图标
                    .el-icon--upload {
                    }

                    //提示文字
                    .el-upload__text {
                        em {
                        }
                    }

                    //提示文字
                    .el-upload__tip {
                    }
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
