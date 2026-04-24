<template>
    <div class="center_view" :style='{}'>
        <div class="section_title">
            <span>{{formName}}</span>
        </div>
        <div class="usersView">
            <div class="usersTabView">
                <div class="usersTab" :class="tabIndex=='center'?'usersTabActive':''"
                     @click="tabClick({tableName:'center'})">个人中心
                </div>
                <div class="usersTab " :class="tabIndex=='updatePassword'?'usersTabActive':''"
                     @click="tabClick({tableName:'updatePassword'})">修改密码
                </div>
                <template v-for="(item,index) in menuList">
                    <div v-if="item.child.length>1" class="usersTab" @mouseenter="usersTabHover(index)"
                         @mouseleave="usersTabLeave">
                        {{item.menu}}
                        <el-collapse-transition>
                            <div class="usersTabHoverView" v-if="usersTabIndex==index">
                                <div class="usersTabHoverTab" v-for="(items,indexs) in item.child"
                                     @click="tabClick(items)">
                                    {{items.menu}}
                                </div>
                            </div>
                        </el-collapse-transition>
                    </div>
                    <div v-else-if="hasBack(item.child[0]) " class="usersTab" @click="tabClick(item.child[0])">
                        {{item.child[0].menu}}
                    </div>
                </template>
            </div>
            <div class="usersBox updateInfo" v-if="tabIndex=='center'">
                <el-form class="usersForm" ref="userFormRef" :model="userForm" label-width="120px" :rules="rules">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item prop="dailigongsizhanghao" label="代理公司账号">
                                <el-input class="list_inp" v-model="userForm.dailigongsizhanghao" placeholder="代理公司账号"
                                          readonly></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item prop="dailigongsimingcheng" label="代理公司名称">
                                <el-input class="list_inp" v-model="userForm.dailigongsimingcheng"
                                          placeholder="代理公司名称"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <div class="formModel_btn_box">
                        <el-button class="formModel_confirm" @click="updateSession">更新信息</el-button>
                        <el-button class="formModel_cancel" @click="loginout" type="danger">退出登录</el-button>
                    </div>
                </el-form>
            </div>
            <div class="usersBox updatePassword" v-if="tabIndex=='updatePassword'">
                <el-form class="usersForm" ref="passwordFormRef" :model="passwordForm" label-width="120px"
                         :rules="passwordRules">
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="原密码" prop="mima">
                                <el-input class="list_inp" v-model="passwordForm.mima" placeholder="原密码"
                                          type="password"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="新密码" prop="newmima">
                                <el-input class="list_inp" v-model="passwordForm.newmima" placeholder="新密码"
                                          type="password"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="确认密码" prop="newmima2">
                                <el-input class="list_inp" v-model="passwordForm.newmima2" placeholder="确认密码"
                                          type="password"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <div class="formModel_btn_box">
                        <el-button class="formModel_confirm" @click="updatePassword">修改密码</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script setup>
    import {
        ElMessageBox
    } from 'element-plus'
    import moment from 'moment'
    import {
        ref,
        getCurrentInstance,
        watch,
        onUnmounted,
        onMounted,
    } from 'vue';
    import {
        useRoute,
        useRouter
    } from 'vue-router';
    import {useStore} from 'vuex'

    const store = useStore()
    import menu from '@/utils/menu'

    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const route = useRoute()
    const router = useRouter()
    //基础信息
    const tableName = 'zhaobiaodaili'
    const formName = '个人中心'
    //基础信息
    const uploadUrl = context.$config.url + 'file/upload'
    //个人信息
    const userFormRef = ref(null)
    const userForm = ref({})
    //修改密码
    const passwordFormRef = ref(null)
    const passwordForm = ref({
        mima: '',
        newmima: '',
        newmima2: ''
    })
    const passwordRules = ref({
        mima: [{
            required: true,
            message: '请输入',
            trigger: 'blur'
        },],
        newmima: [{
            required: true,
            message: '请输入',
            trigger: 'blur'
        },],
        newmima2: [{
            required: true,
            message: '请输入',
            trigger: 'blur'
        },],
    })
    //验证规则
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
        dailigongsizhanghao: [
            {required: true, message: '请输入', trigger: 'blur'},
        ],
        mima: [
            {required: true, message: '请输入', trigger: 'blur'},
        ],
        dailigongsimingcheng: [
            {required: true, message: '请输入', trigger: 'blur'},
        ],
    })
    const getSession = () => {
        context?.$http({
            url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
            method: 'get'
        }).then(res => {
            context?.$toolUtil.storageSet('userid', res.data.data.id)
            context?.$toolUtil.storageSet("frontName", res.data.data.dailigongsizhanghao)
            userForm.value = res.data.data
        })
    }
    //菜单跳转
    const tabIndex = ref('center')
    const tabClick = (item) => {
        if (item.tableName == 'center') {
            tabIndex.value = 'center'
            return
        }
        if (item.tableName == 'updatePassword') {
            passwordForm.value = {
                mima: '',
                newmima: '',
                newmima2: ''
            }
            tabIndex.value = 'updatePassword'
            return
        }
        if (item.tableName == 'examrecord' && item.menuJump == '22') {
            router.push(`/index/examfailrecord?centerType=1`)
            return
        }
        if (item.tableName == 'forum' && item.menuJump == '14') {
            router.push(`/index/forumList?centerType=1&&myType=1`)
            return
        }
        router.push(`/index/${item.classname || item.tableName}List?centerType=1${item.menuJump ? '&menuJump=' + item.menuJump : ''}`)
    }
    const hasBack = (menu) => {
        return true
    }
    // 修改密码
    const updatePassword = async () => {
        passwordFormRef.value.validate(async (valid) => {
            if (valid) {
                if (passwordForm.value.mima != userForm.value.mima) {
                    context?.$toolUtil.message('原密码不正确', 'error')
                    return false
                }
                if (passwordForm.value.newmima != passwordForm.value.newmima2) {
                    context?.$toolUtil.message('两次密码输入不正确', 'error')
                    return false
                }
                userForm.value.mima = passwordForm.value.newmima
                store.dispatch('user/update', userForm.value).then(res => {
                    if (res?.data && res.data.code == 0) {
                        context?.$toolUtil.message('更新成功', 'success')
                        passwordForm.value = {
                            mima: '',
                            newmima: '',
                            newmima2: ''
                        }
                        getSession()
                    }
                })
            }
        })
    }
    //菜单
    const menuList = ref([])
    const role = ref('')
    //初始化
    const init = () => {
        const menus = menu.list()
        let arr = []
        if (menus) {
            menuList.value = menus
        }
        role.value = context?.$toolUtil.storageGet('frontRole')
        for (let i = 0; i < menuList.value.length; i++) {
            if (menuList.value[i].roleName == role.value) {
                arr = menuList.value[i].backMenu
                break;
            }
        }
        if (arr) {
            arr = arr.map(item => {
                if (item.child) {
                    item.child = item.child.filter(c => c.tableName !== 'dailipingjia')
                }
                return item
            }).filter(item => item.child && item.child.length > 0)
        }
        menuList.value = arr
        getSession()
    }
    //菜单悬浮的显示与隐藏
    const usersTabIndex = ref(-1)
    const usersTabHover = (index) => {
        usersTabIndex.value = index
    }
    const usersTabLeave = () => {
        usersTabIndex.value = -1
    }
    //富文本
    const editorChange = (e, name) => {
        userForm.value[name] = e
    }
    //保存
    const updateSession = () => {
        userFormRef.value.validate((valid) => {
            if (valid) {
                store.dispatch('user/update', userForm.value).then(res => {
                    if (res?.data && res.data.code == 0) {
                        context?.$toolUtil.message('更新成功', 'success')
                        getSession()
                    }
                })
            }
        })
    }
    //退出登录
    const loginout = () => {
        context?.$toolUtil.message('退出成功', 'success')
        context?.$toolUtil.storageClear()
        router.replace('/index/home')
    }
    init()
</script>

<style lang="scss" scoped>
    .usersView {

        .usersTabView {

            .usersTab {

                .usersTabHoverView {
                    .usersTabHoverTab {
                    }

                    .usersTabHoverTab:hover {
                    }
                }
            }

            .usersTab:hover {
            }

            .usersTabActive {
            }
        }

        .usersBox {
            .usersForm {
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
                    }
                }
            }
        }

        // 按钮盒子
        .formModel_btn_box {
            .formModel_cancel {
            }

            .formModel_cancel:hover {
            }

            .formModel_confirm {
            }

            .formModel_confirm:hover {
            }
        }
    }
</style>
<style>
    /**总盒子**/
    .center_view {
        padding: 20px calc(50% - 600px);
        background: rgba(249, 250, 255, 1);
        overflow: hidden;
        font-size: 16px;
    }

    /**标题**/
    .center_view .section_title {
        width: 250px;
        margin: 20px 0 0;
        font-size: 22px;
        color: var(--theme);
        font-weight: 600;
        background: url(http://clfile.zggen.cn/20241221/80d54ad0af844a5180b36e7219044690.webp);
        text-align: center;
        line-height: 50px;
        background-size: 100% 100%;
    }

    /**内容区**/
    .center_view .usersView {
        display: block;
        width: 100%;
        margin: 20px auto;
    }

    /**右部 总盒子**/
    .center_view .usersView .usersBox {
        width: calc(100% - 0px);
        background: #fff;
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
        box-shadow: none;
        border: 1px solid rgba(123, 123, 123, 1);
    }

    /**form盒子**/
    .center_view .usersView .usersBox .usersForm {
        width: 100%;
        padding: 30px;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item {
        margin: 0px 0px 20px;
        display: flex;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__label {
        width: 150px;
        background: none;
        text-align: right;
        display: block;
        font-size: 16px;
        color: rgb(51, 51, 51);
        font-weight: 500;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content {
        display: flex;
        justify-content: flex-start;
        align-items: center;
        flex-wrap: wrap;
        width: calc(100% - 120px);
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_inp {
        height: 36px;
        line-height: 36px;
        border: 1px solid var(--theme);
        padding: 0px 10px;
        width: 100%;
        box-sizing: border-box;
        background: rgb(255, 255, 255);
        font-size: 16px;
    }

    /**会员**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item {
        display: flex;
        align-items: center;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item .vip_inp {
        height: 36px;
        line-height: 36px;
        border: 1px solid var(--theme);
        padding: 0px 10px;
        width: 80%;
        box-sizing: border-box;
        background: rgb(255, 255, 255);
        font-size: 16px;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .vip_item .vip_btn {
        background: var(--theme);
        color: rgb(255, 255, 255);
        height: 36px;
        line-height: 36px;
        padding: 0px 20px;
        border-radius: 0px;
        margin: 0px 0px 0px 5px;
        border-color: var(--theme);
    }

    /**end**/

    /**下拉选择**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_sel {
        line-height: 36px;
        border: 1px solid var(--theme);
        box-sizing: border-box;
        width: calc(100% - 120px);
        padding: 0px 10px;
        border-radius: 0px;
        background: rgb(255, 255, 255);
        font-size: 16px;
    }

    /**end**/

    /**日期选择**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_date {
        line-height: 36px;
        border: 1px solid var(--theme);
        box-sizing: border-box;
        width: 100%;
        border-radius: 0px;
        background: rgb(255, 255, 255);
        font-size: 16px;
    }

    /**end**/

    /**radio**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio {
        display: flex;
        width: calc(100% - 120px);
        align-items: center;
        flex-wrap: wrap;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio {
        width: 30%;
        margin: 0px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio .el-radio__inner {
        border-color: #999;
        background: #fff;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio .el-radio__label {
        color: #999;
        font-size: 16px;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio.is-checked .el-radio__inner {
        border-color: var(--theme);
        background: var(--theme);
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_radio .el-radio.is-checked .el-radio__label {
        color: var(--theme);
        font-size: 16px;
    }

    /**end**/

    /**checkbox**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox {
        display: flex;
        width: calc(100% - 120px);
        flex-wrap: wrap;
        align-items: center;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox {
        width: 20%;
        margin: 0px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox .el-checkbox__inner {
        border-color: #999;
        background: #fff;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox .el-checkbox__label {
        color: #999;
        font-size: 16px;
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox.is-checked .el-checkbox__inner {
        border-color: var(--theme);
        background: var(--theme);
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_checkbox .el-checkbox.is-checked .el-checkbox__label {
        color: var(--theme);
        font-size: 16px;
    }

    /**end**/

    /**textarea**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_textarea {
    }

    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_textarea .el-textarea__inner {
        width: 100%;
        min-height: 150px;
        padding: 12px;
        border: 1px solid var(--theme);
        border-radius: 0px;
        color: #666;
        font-size: 16px;
    }

    /**end**/

    /**图片上传**/
    /* 盒子 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--picture-card {
        background-color: rgb(255, 255, 255);
        width: 100px;
        height: 90px;
        line-height: 100px;
        text-align: center;
        border: 1px solid var(--theme);
        border-radius: 0px;
        cursor: pointer;
    }

    /* 图标 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--picture-card .el-icon {
        font-size: 32px;
        color: #999;
    }

    /* 提示语 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .img-uploader .el-upload__tip {
        font-size: 15px;
        color: #666;
        margin: 0;
    }

    /**end**/

    /**文件上传**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger {
        background-color: rgb(255, 255, 255);
        border: 1px solid var(--theme);
        border-radius: 0px;
        box-sizing: border-box;
        width: 360px;
        height: 180px;
        text-align: center;
        cursor: pointer;
        overflow: hidden;
    }

    /* 图标 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger .el-icon-upload {
        font-size: 67px;
        color: var(--theme);
        line-height: 50px;
    }

    /* 提示语 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .upload-demo .el-upload__tip {
        font-size: 15px;
        color: #666;
        margin: 0px 0 0;
        line-height: 1;
    }

    /* 点击上传 */
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .el-upload--text .el-upload-dragger em {
        color: var(--theme);
        font-size: 15px;
    }

    /**end**/

    /**富文本**/
    .center_view .usersView .usersBox .usersForm .el-form-item .el-form-item__content .list_editor {
        width: 100%;
        height: auto;
        margin: 0px;
        padding: 0px;
        border-radius: 0px;
        background: rgb(255, 255, 255);
        border: 1px solid var(--theme);
        min-height: 300px;
    }

    /**end**/

    /**按钮**/
    .center_view .formModel_btn_box {
        display: flex;
        align-items: center;
        width: 100%;
        padding: 10px 0px 10px 150px;
        margin: 40px 0px 0px;
    }

    /**更新信息**/
    .center_view .formModel_btn_box .formModel_confirm {
        margin: 0px 20px 0px 0px;
        padding: 0px 24px;
        width: auto;
        height: 40px;
        font-size: 16px;
        color: rgb(255, 255, 255);
        border-radius: 0px;
        border: 0px;
        cursor: pointer;
        background: var(--theme);
        clip-path: polygon(0% 0%, 90% 0, 100% 50%, 90% 100%, 0% 100%);
    }

    .center_view .formModel_btn_box .formModel_confirm:hover {
        background: var(--theme);
    }

    /**退出登陆**/
    .center_view .formModel_btn_box .formModel_cancel {
        margin: 0px 20px 0px 0px;
        padding: 0px 24px;
        width: auto;
        height: 40px;
        font-size: 16px;
        color: rgb(255, 255, 255);
        border-radius: 0px;
        border: 0px;
        cursor: pointer;
        background: rgba(66, 66, 66, 1);
        clip-path: polygon(0% 0%, 90% 0, 100% 50%, 90% 100%, 0% 100%);
    }

    .center_view .formModel_btn_box .formModel_cancel:hover {
        background: rgba(66, 66, 66, 1);
    }


    .center_view .el-form-item .upload-demo {
        width: 360px;
    }

    /**tab总盒子**/
    .center_view .usersView .usersTabView {
        width: 100%;
        background: #fff;
        padding: 10px 10px;
        box-sizing: border-box;
        border: 1px solid rgba(123, 123, 123, 1);
        border-bottom: none;
    }

    /**item**/
    .center_view .usersView .usersTabView .usersTab {
        display: inline-block;
        width: auto;
        font-size: 16px;
        padding: 10px 20px 10px 10px;
        margin: 0px 5px 5px;
        position: relative;
        cursor: pointer;
        text-align: center;
        background: none;
        color: rgb(51, 51, 51);
    }

    .center_view .usersView .usersTabView .usersTab:hover {
        background: var(--theme);
        color: #fff;
    }

    .center_view .usersView .usersTabView .usersTab.usersTabActive {
        display: inline-block;
        width: auto;
        font-size: 16px;
        padding: 10px 20px 10px 10px;
        margin: 0px 5px 5px;
        position: relative;
        cursor: pointer;
        text-align: center;
        background: var(--theme);
        color: #fff;
    }


    .usersTabView .usersTabHoverView {
        position: absolute;
        background: #fff;
        border: 1px solid var(--theme);
        color: #000;
        width: 120%;
        left: -10%;
        top: 44px;
        z-index: 9;
    }

    .usersTabView .usersTabHoverTab {
        line-height: 36px;
        font-size: 14px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        color: #666;
    }

    .usersTabView .usersTabHoverTab:hover {
        color: var(--theme);
    }
</style>