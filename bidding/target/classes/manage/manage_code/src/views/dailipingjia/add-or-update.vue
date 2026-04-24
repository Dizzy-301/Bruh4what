<template>
	<el-dialog v-model="formVisible" :title="formTitle" width="50%" destroy-on-close>
		<el-form :model="form" :rules="rules" ref="formRef" label-width="120px">
			<el-form-item label="项目名称" prop="xiangmumingcheng">
				<el-input v-model="form.xiangmumingcheng" readonly></el-input>
			</el-form-item>
			<el-form-item label="代理公司" prop="dailigongsimingcheng">
				<el-input v-model="form.dailigongsimingcheng" readonly></el-input>
			</el-form-item>
			<el-form-item label="满意度" prop="manyidu">
				<el-slider v-model="form.manyidu" :min="0" :max="10" :step="1" show-input :disabled="disabledForm.manyidu"></el-slider>
                <div style="font-size: 12px;color: #999;">评分范围 0-10 分</div>
			</el-form-item>
			<el-form-item label="评价内容" prop="pingjianeirong">
				<el-input v-model="form.pingjianeirong" type="textarea" :rows="4" placeholder="请输入评价内容" :disabled="disabledForm.pingjianeirong"></el-input>
			</el-form-item>
		</el-form>
		<template #footer>
			<span class="dialog-footer">
				<el-button @click="formVisible = false">取消</el-button>
				<el-button type="primary" @click="save" v-if="type!='info'">提交</el-button>
			</span>
		</template>
	</el-dialog>
</template>

<script setup>
import { ref, getCurrentInstance, nextTick } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties;
const formVisible = ref(false)
const formTitle = ref('评价代理')
const form = ref({
	xiangmumingcheng: '',
	dailigongsizhanghao: '',
	dailigongsimingcheng: '',
	manyidu: 10,
	pingjianeirong: '',
	yezhuzhanghao: '',
	yezhumingcheng: ''
})
const rules = ref({
	manyidu: [{ required: true, message: '请评分', trigger: 'blur' }]
})
const formRef = ref(null)
const emit = defineEmits(['formModelChange'])

const type = ref('')
const disabledForm = ref({
	xiangmumingcheng: false,
	dailigongsimingcheng: false,
	manyidu: false,
	pingjianeirong: false,
})

const init = (id, _type, _row) => {
	formVisible.value = true
	type.value = _type
	resetForm()
	if (_type == 'info') {
		disabledForm.value.manyidu = true
		disabledForm.value.pingjianeirong = true
		formTitle.value = '评价详情'
	} else if (_type == 'cross') {
		formTitle.value = '评价代理'
	}
	if (id) {
		getInfo(id)
	} else if (_row) {
		form.value.xiangmumingcheng = _row.xiangmumingcheng
		form.value.dailigongsizhanghao = _row.dailigongsizhanghao
		form.value.dailigongsimingcheng = _row.dailigongsimingcheng
		
        // Fetch session for owner info
        let sessionTable = context?.$toolUtil.storageGet('sessionTable')
        context?.$http({
            url: `${sessionTable}/session`,
            method: 'get'
        }).then(res => {
            if(res.data.code == 0){
                if(sessionTable == 'yezhudanwei'){
                    form.value.yezhuzhanghao = res.data.data.qiyezhanghao
                    form.value.yezhumingcheng = res.data.data.qiyemingcheng
                }
            }
        })
	}
}

const getInfo = (id) => {
	context?.$http({
		url: `dailipingjia/info/${id}`,
		method: 'get'
	}).then(res => {
		form.value = res.data.data
	})
}

const resetForm = () => {
	form.value = {
		xiangmumingcheng: '',
		dailigongsizhanghao: '',
		dailigongsimingcheng: '',
		manyidu: 10,
		pingjianeirong: '',
		yezhuzhanghao: '',
		yezhumingcheng: ''
	}
	disabledForm.value = {
		xiangmumingcheng: true,
		dailigongsimingcheng: true,
		manyidu: false,
		pingjianeirong: false,
	}
}

const save = () => {
	formRef.value.validate((valid) => {
		if (valid) {
			context?.$http({
				url: `dailipingjia/${!form.value.id ? 'save' : 'update'}`,
				method: 'post',
				data: form.value
			}).then(res => {
				context?.$toolUtil.message('操作成功', 'success')
				formVisible.value = false
				emit('formModelChange')
			})
		}
	})
}

defineExpose({ init })
</script>
