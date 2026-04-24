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
                        <el-form-item label="招标文件" prop="zhaobiaowenjian">
                            <uploads
                                    :disabled="!isAdd||disabledForm.zhaobiaowenjian?true:false"
                                    type="file"
                                    action="file/upload"
                                    tip="请上传招标文件"
                                    :limit="1"
                                    style="width: 100%;text-align: left;"
                                    :fileUrls="form.zhaobiaowenjian?form.zhaobiaowenjian:''"
                                    @change="zhaobiaowenjianUploadSuccess">
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

                    <el-col :span="24">
                        <el-form-item label="合同条款" prop="hetongtiaokuan">
                            <uploads
                                    :disabled="!isAdd||disabledForm.hetongtiaokuan?true:false"
                                    type="file"
                                    action="file/upload"
                                    tip="请上传合同条款"
                                    :limit="1"
                                    style="width: 100%;text-align: left;"
                                    :fileUrls="form.hetongtiaokuan?form.hetongtiaokuan:''"
                                    @change="hetongtiaokuanUploadSuccess">
                            </uploads>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item prop="fengmian"
                                      label="封面"
                        >
                            <uploads
                                    :disabled="!isAdd||disabledForm.fengmian?true:false"
                                    action="file/upload"
                                    tip="请上传封面"
                                    style="width: 100%;text-align: left;"
                                    :fileUrls="form.fengmian?form.fengmian:''"
                                    @change="fengmianUploadSuccess">
                            </uploads>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="代理公司账号" prop="dailigongsizhanghao">
                            <el-select
                                    class="list_sel"
                                    :disabled="!isAdd||disabledForm.dailigongsizhanghao?true:false"
                                    v-model="form.dailigongsizhanghao"
                                    placeholder="请选择代理公司账号"
                                    @change="dailigongsizhanghaoChange">
                                <el-option v-for="(item,index) in dailigongsizhanghaoLists" :label="item" :value="item">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="代理公司名称" prop="dailigongsimingcheng">
                            <el-input class="list_inp" v-model="form.dailigongsimingcheng" placeholder="代理公司名称"
                                      type="text"
                                      :readonly="!isAdd||disabledForm.dailigongsimingcheng?true:false"/>
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
    const tableName = 'zhaobiaoxiangmu'
    const formName = '招标项目'
    //基础信息
    //form表单
    const form = ref({})
    const disabledForm = ref({
        xiangmumingcheng: false,
        qiyezhanghao: false,
        qiyemingcheng: false,
        zhaobiaofanwei: false,
        zhaobiaowenjian: false,
        toubiaojiezhishijian: false,
        kaibiaoshijian: false,
        xiangmudidian: false,
        xiangmuzhouqi: false,
        xiangmuyusuan: false,
        hetongtiaokuan: false,
        sfsh: false,
        shhf: false,
        fengmian: false,
        dailigongsizhanghao: false,
        dailigongsimingcheng: false,
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
    //日期校验
    const validateDate = (rule, value, callback) => {
        if (form.value.toubiaojiezhishijian && form.value.kaibiaoshijian) {
            if (form.value.toubiaojiezhishijian < form.value.kaibiaoshijian) {
                callback(new Error("截止时间不能早于开标时间"));
            } else {
                callback();
            }
        } else {
            callback();
        }
    }
    const rules = ref({
        xiangmumingcheng: [],
        qiyezhanghao: [],
        qiyemingcheng: [],
        zhaobiaofanwei: [],
        zhaobiaowenjian: [],
        toubiaojiezhishijian: [{
            validator: validateDate,
            trigger: 'blur'
        }],
        kaibiaoshijian: [{
            validator: validateDate,
            trigger: 'blur'
        }],
        xiangmudidian: [],
        xiangmuzhouqi: [],
        xiangmuyusuan: [{
            validator: validateNumber,
            trigger: 'blur'
        }],
        hetongtiaokuan: [],
        sfsh: [],
        shhf: [],
        fengmian: [],
        dailigongsizhanghao: [],
        dailigongsimingcheng: [],
    })
    //表单验证

    const formRef = ref(null)
    const id = ref(0)
    const type = ref('')
    //招标文件上传回调
    const zhaobiaowenjianUploadSuccess = (e) => {
        form.value.zhaobiaowenjian = e
    }
    //合同条款上传回调
    const hetongtiaokuanUploadSuccess = (e) => {
        form.value.hetongtiaokuan = e
    }
    //封面上传回调
    const fengmianUploadSuccess = (e) => {
        form.value.fengmian = e
    }
    //代理公司账号列表
    const dailigongsizhanghaoLists = ref([])

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
            zhaobiaowenjian: '',
            toubiaojiezhishijian: '',
            kaibiaoshijian: '',
            xiangmudidian: '',
            xiangmuzhouqi: '',
            xiangmuyusuan: '',
            hetongtiaokuan: '',
            sfsh: '待审核',
            shhf: '',
            fengmian: '',
            dailigongsizhanghao: '',
            dailigongsimingcheng: '',
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
            disabledForm.value.xiangmuyusuan = true
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
                if (x == 'zhaobiaowenjian') {
                    form.value.zhaobiaowenjian = row[x];
                    disabledForm.value.zhaobiaowenjian = true;
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
                if (x == 'xiangmuyusuan') {
                    form.value.xiangmuyusuan = row[x];
                    disabledForm.value.xiangmuyusuan = true;
                    continue;
                }
                if (x == 'hetongtiaokuan') {
                    form.value.hetongtiaokuan = row[x];
                    disabledForm.value.hetongtiaokuan = true;
                    continue;
                }
                if (x == 'fengmian') {
                    form.value.fengmian = row[x];
                    disabledForm.value.fengmian = true;
                    continue;
                }
                if (x == 'dailigongsizhanghao') {
                    form.value.dailigongsizhanghao = row[x];
                    disabledForm.value.dailigongsizhanghao = true;
                    continue;
                }
                if (x == 'dailigongsimingcheng') {
                    form.value.dailigongsimingcheng = row[x];
                    disabledForm.value.dailigongsimingcheng = true;
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
            if (json.hasOwnProperty('qiyezhanghao') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.qiyezhanghao = json.qiyezhanghao
                disabledForm.value.qiyezhanghao = true;
            }
            if (json.hasOwnProperty('qiyemingcheng') && context?.$toolUtil.storageGet("role") != "管理员") {
                form.value.qiyemingcheng = json.qiyemingcheng
                disabledForm.value.qiyemingcheng = true;
            }
        })
        context?.$http({
            url: `option/zhaobiaodaili/dailigongsizhanghao`,
            method: 'get'
        }).then(res => {
            dailigongsizhanghaoLists.value = res.data.data
        })
        //由上级字段带出不可改
        disabledForm.value.dailigongsimingcheng = true;
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
    const dailigongsizhanghaoChange = () => {
        context?.$http({
            url: `follow/zhaobiaodaili/dailigongsizhanghao?columnValue=` + form.value.dailigongsizhanghao,
            method: 'get'
        }).then(res => {
            if (res.data.data.dailigongsimingcheng) {
                form.value.dailigongsimingcheng = res.data.data.dailigongsimingcheng
            }
        })
    }
    //富文本
    const editorChange = (e, name) => {
        form.value[name] = e
    }
    //提交
    const save = async () => {
        if (form.value.zhaobiaowenjian != null) {
            form.value.zhaobiaowenjian = form.value.zhaobiaowenjian.replace(new RegExp(context?.$config.url, "g"), "");
        }
        if (form.value.hetongtiaokuan != null) {
            form.value.hetongtiaokuan = form.value.hetongtiaokuan.replace(new RegExp(context?.$config.url, "g"), "");
        }
        if (form.value.fengmian != null) {
            form.value.fengmian = form.value.fengmian.replace(new RegExp(context?.$config.url, "g"), "");
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

                // 下拉框
                .list_sel {
                    //去掉默认样式
                    .select-trigger {
                        height: 100%;

                        .el-input {
                            height: 100%;
                        }
                    }
                }

                //图片上传样式
                .el-upload-list {
                    //提示语
                    .el-upload__tip {
                    }

                    //外部盒子
                    .el-upload--picture-card {
                        //图标
                        .el-icon {
                        }
                    }

                    .el-upload-list__item {
                    }
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
