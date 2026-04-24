<template>
	<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close>
		<el-form :model="form" :rules="rules" ref="formRef" label-width="120px">
			<el-form-item label="项目名称" prop="xiangmumingcheng">
				<el-input v-model="form.xiangmumingcheng" readonly></el-input>
			</el-form-item>
			<el-form-item label="代理公司账号" prop="dailigongsizhanghao">
				<el-input v-model="form.dailigongsizhanghao" readonly></el-input>
			</el-form-item>
			<el-form-item label="代理公司名称" prop="dailigongsimingcheng">
				<el-input v-model="form.dailigongsimingcheng" readonly></el-input>
			</el-form-item>
			<el-form-item label="联系电话" prop="lianxidianhua">
				<el-input v-model="form.lianxidianhua" placeholder="请输入联系电话" :disabled="disabledForm.lianxidianhua"></el-input>
			</el-form-item>
			<el-form-item label="服务承诺" prop="fuwuchengnuo">
				<el-input v-model="form.fuwuchengnuo" type="textarea" :rows="4" placeholder="请输入服务承诺" :disabled="disabledForm.fuwuchengnuo"></el-input>
			</el-form-item>
			<el-form-item label="资质文件" prop="zizhiwenjian">
				<uploads
					v-if="!disabledForm.zizhiwenjian"
					action="file/upload" 
					tip="请上传资质文件" 
					:fileUrls="form.zizhiwenjian?form.zizhiwenjian:''" 
					@change="zizhiwenjianUploadSuccess">
				</uploads>
				<el-image v-else-if="form.zizhiwenjian" class="list_img" :src="$config.url+form.zizhiwenjian" :preview-src-list="[$config.url+form.zizhiwenjian]" />
			</el-form-item>
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button @click="formVisible = false">取消</el-button>
				<el-button type="primary" @click="save" v-if="type!='info'">提交申请</el-button>
			</span>
		</template>
	</el-dialog>
</template>

<script setup>
import { ref, getCurrentInstance, nextTick } from 'vue'

const context = getCurrentInstance()?.appContext.config.globalProperties;
const formVisible = ref(false)
const formTitle = ref('承接申请')
const form = ref({
	xiangmumingcheng: '',
	qiyezhanghao: '',
	dailigongsizhanghao: '',
	dailigongsimingcheng: '',
	lianxidianhua: '',
	fuwuchengnuo: '',
	zizhiwenjian: ''
})
const rules = ref({
	lianxidianhua: [{ required: true, message: '请输入联系电话', trigger: 'blur' }],
	fuwuchengnuo: [{ required: true, message: '请输入服务承诺', trigger: 'blur' }],
})
const formRef = ref(null)
const emit = defineEmits(['formModelChange'])

const type = ref('')
const disabledForm = ref({
	xiangmumingcheng: true,
	dailigongsizhanghao: true,
	dailigongsimingcheng: true,
	lianxidianhua: false,
	fuwuchengnuo: false,
	zizhiwenjian: false,
})

const init = (id, _type, _row) => {
	formVisible.value = true
	type.value = _type
	resetForm()
	if (_type == 'info') {
		disabledForm.value.lianxidianhua = true
		disabledForm.value.fuwuchengnuo = true
		disabledForm.value.zizhiwenjian = true
		formTitle.value = '申请详情'
	} else if (_type == 'cross') {
		formTitle.value = '提交承接申请'
	}
	if (id) {
		getInfo(id)
	} else if (_row) {
		form.value.xiangmumingcheng = _row.xiangmumingcheng
		form.value.qiyezhanghao = _row.qiyezhanghao
		
        // Fetch session for agency info
        let sessionTable = context?.$toolUtil.storageGet('sessionTable')
        context?.$http({
            url: `${sessionTable}/session`,
            method: 'get'
        }).then(res => {
            if(res.data.code == 0){
                if(sessionTable == 'zhaobiaodaili'){
                    form.value.dailigongsizhanghao = res.data.data.dailigongsizhanghao
                    form.value.dailigongsimingcheng = res.data.data.dailigongsimingcheng
                    form.value.lianxidianhua = res.data.data.lianxidianhua
                    form.value.zizhiwenjian = res.data.data.zizhi
                }
            }
        })
	}
}

const getInfo = (id) => {
	context?.$http({
		url: `chengjieqingqiu/info/${id}`,
		method: 'get'
	}).then(res => {
		form.value = res.data.data
	})
}

const resetForm = () => {
	form.value = {
		xiangmumingcheng: '',
		qiyezhanghao: '',
		dailigongsizhanghao: '',
		dailigongsimingcheng: '',
		lianxidianhua: '',
		fuwuchengnuo: '',
		zizhiwenjian: ''
	}
	disabledForm.value = {
		xiangmumingcheng: true,
		dailigongsizhanghao: true,
		dailigongsimingcheng: true,
		lianxidianhua: false,
		fuwuchengnuo: false,
		zizhiwenjian: false,
	}
}

const zizhiwenjianUploadSuccess = (fileUrls) => {
	form.value.zizhiwenjian = fileUrls;
}

const save = () => {
	formRef.value.validate((valid) => {
		if (valid) {
			context?.$http({
				url: `chengjieqingqiu/${!form.value.id ? 'save' : 'update'}`,
				method: 'post',
				data: form.value
			}).then(res => {
				context?.$toolUtil.message('提交成功', 'success')
				formVisible.value = false
				emit('formModelChange')
			})
		}
	})
}

defineExpose({ init })
</script>

<style scoped>
.list_img {
    width: 100px;
    height: 100px;
}
</style>
