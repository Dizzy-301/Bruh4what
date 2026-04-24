<template>
    <div>
        <div class="center_view edit_form">
            <el-form class="userinfo_form" ref="userinfoFormRef" :model="user" label-width="120px">
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="代理公司账号" prop="dailigongsizhanghao">
                            <el-input class="list_inp" v-model="user.dailigongsizhanghao" readonly placeholder="代理公司账号"
                                      clearable/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="代理公司名称" prop="dailigongsimingcheng">
                            <el-input class="list_inp" v-model="user.dailigongsimingcheng" placeholder="代理公司名称"
                                      clearable/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="联系电话" prop="lianxidianhua">
                            <el-input class="list_inp" v-model="user.lianxidianhua" placeholder="联系电话"
                                      clearable/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="资质" prop="zizhi">
                            <uploads
                                action="file/upload" 
                                tip="请上传资质" 
                                :fileUrls="user.zizhi?user.zizhi:''" 
                                @change="zizhiUploadSuccess">
                            </uploads>
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="满意度" prop="manyidu">
                            <el-input class="list_inp" :value="user.manyidu?Number(user.manyidu).toFixed(1):'0.0'" readonly placeholder="满意度" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="等级" prop="dengji">
                            <el-input class="list_inp" v-model="user.dengji" readonly placeholder="等级" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <el-form-item label="入行时间" prop="addtime">
                            <el-input class="list_inp" :value="user.addtime?user.addtime.substring(0,7):''" readonly placeholder="入行时间" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="24">
                        <span class="formModel_btn_box">
                            <el-button class='confirm_btn' type="primary" @click="onSubmit">保存</el-button>
                        </span>
                    </el-col>
                </el-row>
            </el-form>
        </div>
    </div>
</template>

<script setup>
    import {isNumber, isIntNumer, isEmail, isMobile, isPhone, isURL, checkIdCard} from "@/utils/toolUtil";
    import {
        reactive,
        ref,
        getCurrentInstance
    } from 'vue'
    import {useStore} from 'vuex'

    const store = useStore()
    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const tableName = ref('zhaobiaodaili')
    const user = ref({})
    const init = () => {
    }
    const onSubmit = () => {
        if ((!user.value.dailigongsizhanghao)) {
            context?.$toolUtil.message(`代理公司账号不能为空`, 'error')
            return false
        }
        if ((!user.value.dailigongsimingcheng)) {
            context?.$toolUtil.message(`代理公司名称不能为空`, 'error')
            return false
        }
        if (user.value.lianxidianhua && !context?.$toolUtil.isMobile(user.value.lianxidianhua)) {
            context?.$toolUtil.message(`联系电话格式错误`, 'error')
            return false
        }
        store.dispatch('user/update', user.value).then(res => {
            if (res?.data && res.data.code == 0) context?.$toolUtil.message('修改成功', 'success')
        })

    }
    const getInfo = () => {
        context?.$http({
            url: `${tableName.value}/session`,
            method: 'get'
        }).then(res => {
            user.value = res.data.data
            init()
        })
    }
    const zizhiUploadSuccess = (fileUrls) => {
        user.value.zizhi = fileUrls;
    }
    getInfo()
</script>

<style lang="scss" scoped>
    // 表单
    .userinfo_form {
        // form item
        :deep(.el-form-item) {
            // 内容盒子
            .el-form-item__content {
            }

            // 输入框
            .list_inp {
            }

        }

        // 按钮盒子
        .formModel_btn_box {
            // 确定按钮
            .confirm_btn {
            }

            // 确定按钮-悬浮
            .confirm_btn:hover {
            }
        }
    }
</style>
