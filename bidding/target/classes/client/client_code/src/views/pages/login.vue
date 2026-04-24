<template>
    <div>
        <div class="login_view">
            <el-form :model="loginForm" class="login_form">
                <div class="title_view">基于springboot的在线招标投标系统的设计与实现登录</div>
                <div class="list_item" v-if="loginType==1">
                    <div class="list_label">
                        账号：
                    </div>
                    <input class="list_inp" v-model="loginForm.username" name="username" placeholder="请输入账号"/>
                </div>
                <div class="list_item" v-if="loginType==1">
                    <div class="list_label">
                        密码：
                    </div>
                    <input class="list_inp" v-model="loginForm.password" type="password" placeholder="请输入密码"
                           @keydown.enter.native="handleLogin"/>
                </div>
                <div class="list_type" v-if="userList.length>1">
                    <el-radio v-for="(item,index) in userList" :key="index" v-model="loginForm.role"
                              :label="item.roleName">{{item.roleName}}
                    </el-radio>
                </div>
                <div class="forget-wrapper">
                    <div class="forget" @click="context?.$router.push('/forget')">忘记密码？</div>
                </div>
                <div class="login-wrapper">
                    <el-button class="login" v-if="loginType==1" @click="handleLogin">登录</el-button>
                </div>
                <div class="face-wrapper">
                </div>
                <div class="register-wrapper">
                    <el-button class="register" @click="handleRegister('toubiaodanwei')">注册投标单位</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script setup>
    import {
        ref,
        getCurrentInstance,
        nextTick,
        onMounted,
    } from "vue";
    import {
        useStore
    } from 'vuex';

    const store = useStore()
    import menu from '@/utils/menu'

    const userList = ref([])
    const menus = ref([])
    const loginForm = ref({
        role: '',
        username: '',
        password: ''
    })
    const tableName = ref('')
    const loginType = ref(1)
    const context = getCurrentInstance()?.appContext.config.globalProperties;
    //注册
    const handleRegister = (tableName) => {
        context?.$router.push(`/${tableName}Register`)

    }
    const handleLogin = () => {
        if (!loginForm.value.username) {
            context?.$toolUtil.message('请输入用户名', 'error')
            return;
        }
        if (!loginForm.value.password) {
            context?.$toolUtil.message('请输入密码', 'error')
            return;
        }
        if (userList.value.length > 1) {
            if (!loginForm.value.role) {
                context?.$toolUtil.message('请选择角色', 'error')
                verifySlider.reset()
                return;
            }
            for (let i = 0; i < menus.value.length; i++) {
                if (menus.value[i].roleName == loginForm.value.role) {
                    tableName.value = menus.value[i].pathName || menus.value[i].tableName;
                }
            }
        } else {
            tableName.value = userList.value[0].pathName || userList.value[0].tableName;
            loginForm.value.role = userList.value[0].roleName;
        }
        login()
    }
    const login = () => {
        context?.$http({
            url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
            method: 'post'
        }).then(res => {
            context?.$toolUtil.storageSet("frontToken", res.data.token);
            context?.$toolUtil.storageSet("frontRole", loginForm.value.role);
            context?.$toolUtil.storageSet("frontSessionTable", tableName.value);
            store.dispatch('user/getSession')
            let path = context?.$toolUtil.storageGet('toPath')
            if (path && path != '/login') {
                context?.$router.push(path)
                context?.$toolUtil.storageRemove('toPath')
                return
            }
            context?.$router.push(`/index/${tableName.value}Center`)
        }, err => {
        })
    }
    //获取菜单
    const getMenu = async () => {
        let arr = menu.list()
        if (!arr) {
            let res = await context?.$http.get("menu/list")
            context?.$toolUtil.storageSet("menus", res.data.data.list[0].menujson);
            arr = JSON.parse(res.data.data.list[0].menujson)
        }
        menus.value = arr
        for (let i = 0; i < menus.value.length; i++) {
            if (menus.value[i].hasFrontLogin == '是') {
                userList.value.push(menus.value[i])
            }
        }
    }
    //初始化
    const init = async () => {
        await getMenu();
        loginForm.value.role = userList.value[0].roleName
    }
    onMounted(() => {
        init()

    })
</script>

<style lang="scss" scoped>
    .login_view {
        background-image: url("http://clfile.zggen.cn/20241221/41cd90678320415aaa5e92bfac9609f7.webp");
        // 表单盒子
        .login_form {
        }

        .title_view {
        }

        // item盒子
        .list_item {
            // label
            .list_label {
            }

            // 输入框
            .list_inp {
            }
        }

        // 用户类型样式
        .list_type {
            // 未选中样式
            :deep(.el-radio) {
                // 单选框
                .el-radio__inner {
                }

                // 提示文字
                .el-radio__label {
                }
            }

            // 选中样式
            :deep(.is-checked) {
                // 单选框
                .el-radio__inner {
                }

                // 提示文字
                .el-radio__label {
                }
            }
        }

        // 按钮盒子
        .btn_view {
            // 登录
            .login {
            }

            // 注册
            .register {
            }
        }
    }

</style>
<style>
    .login_view {
        min-height: 100vh;
        display: flex;

        align-items: center;
        background-size: 100% 100%;
    }

    .login_view form.el-form.login_form {
        background: #fff;
        width: 500px;
        padding: 50px;
        row-gap: 20px;
        display: flex;
        flex-wrap: wrap;
        background-size: 400px 700px;
        background-repeat: no-repeat;
        background-position: right;
        color: #fff;
        justify-content: center;
        margin-left: 10%;
        box-shadow: 1px 1px 6px rgba(0, 0, 0, 0.3);
        border-radius: 10px;
    }

    .login_view .title_view {
        width: 100%;
        order: 1;
        font-size: 24px;
        text-align: center;
        color: #000;
    }

    .login_view .tabView {
        order: 2;
        display: flex;
        width: 100%;
        height: 50px;
        border-radius: 6px;
        overflow: hidden;
    }

    .login_view .tab {
        line-height: 50px;
        height: 50px;
        background: #E2E2E2;
        color: #959595;
        text-align: center;
        font-weight: 600;
    }

    .login_view .tab.tabActive {
        background: var(--theme);
        color: #fff;
    }

    .login_view .list_item {
        order: 3;
        width: 100%;
        display: flex;
        background: #fff;
        align-items: center;
        height: 50px;
        border-bottom: 1px solid var(--theme);
        border-radius: 0;
        position: relative;
    }

    .login_view .listCode_view {
        order: 4;
        display: flex;
        align-items: center;
        background: #fff;
        height: 50px;
        border-radius: 0;
        position: relative;
        border-bottom: 1px solid var(--theme);
    }

    .login_view .face {
        order: 5;
        cursor: pointer;
        color: #fff;
        font-size: 18px;
        font-weight: 700;
        line-height: 46px;
        text-align: center;
    }

    .login_view .btn_view {
        order: 5;
        position: relative;
        margin-top: 40px;
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        gap: 30px;
    }

    .login_view .list_label {
        color: #000;
        width: 100px;
        text-align: center;
    }

    .login_view input.list_inp {
        flex: 1;
        border: none;
        line-height: 46px;
    }

    .login_view .listCode_label {
        width: 100px;
        text-align: center;
        color: #000;
        flex-shrink: 0;
    }

    .login_view input.listCode_inp {
        flex: 1;
        border: none;
        line-height: 46px;
        margin-right: 25px;
        width: 145px;
    }

    .login_view .listCode_btn {
        height: 80%;
        padding: 0 10px;
        display: flex;
        align-items: center;
        width: 120px;
        border-radius: 0;
        background: var(--theme);
        justify-content: center;
        border-radius: 6px;
    }

    .login_view .el-button.login {
        border: none;
        width: 100%;
        border-radius: 0;
        height: 46px;
        background: var(--theme);
        color: #fff;
        font-size: 18px;
        font-weight: 700;
    }

    .login_view .forget {
        cursor: pointer;
        color: #666;
        font-size: 14px;
        text-align: right;
    }
    .login_view .forget:hover {
        color: var(--theme);
        text-decoration: underline;
    }

    .login_view button.el-button.register {
        height: 50px;
        flex: 1;
        border: 1px solid var(--theme);
        border-radius: 0;
        color: var(--theme);
        margin: 0;
        background: #fff;
    }

    .login_view .list_type {
        order: 5;
        display: flex;
        height: 50px;
        align-items: center;
        width: 100%;
        border-radius: 0;
        border: 0px solid var(--theme);
        justify-content: center;
        column-gap: 30px;
        flex-wrap: wrap;
    }

    .login_view .el-select {
        flex: 1;
        line-height: 50px;
        border: none !important;
        color: #000;
        padding-right: 10px;
    }

    .forget-wrapper {
        color: rgba(102, 102, 102, 1);
        order: 6;
        width: 100%;
        text-align: center;
    }

    .login-wrapper {
        order: 7;
        width: 100%;
    }

    .face-wrapper {
        order: 8;
        background: rgba(243, 110, 66, 1);
        width: 100%;
    }

    .register-wrapper {
        order: 9;
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        column-gap: 20px;
    }

    .list_item:before, .listCode_view:before {
        position: absolute;
        content: '';
        border-top: 6px solid var(--theme);
        border-left: 6px solid transparent;
        border-right: 6px solid transparent;
        bottom: -6px;
        left: 80px;
    }

    .list_item:after, .listCode_view:after {
        position: absolute;
        content: '';
        border-top: 6px solid #fff;
        border-left: 6px solid transparent;
        border-right: 6px solid transparent;
        bottom: -5px;
        left: 80px;
    }

    .el-radio__input.is-checked .el-radio__inner {
        background: var(--theme);
        border-color: var(--theme);
    }

    .el-radio__input.is-checked + .el-radio__label {
        color: var(--theme);
    }

    .el-radio__inner:hover {
        border-color: var(--theme);
    }
</style>