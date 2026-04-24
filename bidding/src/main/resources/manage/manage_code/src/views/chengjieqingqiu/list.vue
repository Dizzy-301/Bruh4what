<template>
	<div>
		<div class="center_view">
			<div class="list_search_view">
				<el-form :inline="true" :model="listQuery" class="list_search_form">
					<el-form-item label="项目名称">
						<el-input v-model="listQuery.xiangmumingcheng" placeholder="项目名称" clearable></el-input>
					</el-form-item>
					<el-form-item label="代理公司">
						<el-input v-model="listQuery.dailigongsimingcheng" placeholder="代理公司" clearable></el-input>
					</el-form-item>
					<el-button type="primary" @click="searchClick">搜索</el-button>
				</el-form>
			</div>
			<br />
			<el-table :data="list" border stripe v-loading="listLoading" style="width: 100%" v-if="btnAuth('chengjieqingqiu','查看')">
				<el-table-column type="index" label="序号" width="50" align="left" header-align="left"></el-table-column>
				<el-table-column prop="xiangmumingcheng" label="项目名称" align="left" header-align="left"></el-table-column>
				<el-table-column prop="dailigongsizhanghao" label="代理公司账号" align="left" header-align="left"></el-table-column>
				<el-table-column prop="dailigongsimingcheng" label="代理公司名称" align="left" header-align="left"></el-table-column>
				<el-table-column prop="lianxidianhua" label="联系电话" align="left" header-align="left"></el-table-column>
				<el-table-column prop="addtime" label="申请时间" align="left" header-align="left" width="180"></el-table-column>
				<el-table-column label="操作" align="left" header-align="left" width="200">
					<template #default="scope">
						<el-button type="primary" size="small" @click="infoClick(scope.row.id)" v-if="btnAuth('chengjieqingqiu','查看')">详情</el-button>
						<el-button type="danger" size="small" @click="deleteClick(scope.row.id)" v-if="btnAuth('chengjieqingqiu','删除')">删除</el-button>
					</template>
				</el-table-column>
			</el-table>
			<el-pagination background :layout="layouts.join(',')" :total="total" :page-size="listQuery.limit"
				v-model:current-page="listQuery.page" prev-text="<" next-text=">" :page-sizes="[10, 20, 30, 40, 50, 100]"
				@size-change="sizeChange" @current-change="currentChange" />
		</div>
		<formModel ref="formModelRef" @formModelChange="searchClick"></formModel>
	</div>
</template>

<script setup>
import { ref, getCurrentInstance, onMounted } from 'vue'
import formModel from './add-or-update.vue'

const context = getCurrentInstance()?.appContext.config.globalProperties;
const list = ref([])
const total = ref(0)
const listLoading = ref(false)
const listQuery = ref({
	page: 1,
	limit: 10,
	xiangmumingcheng: '',
	dailigongsimingcheng: ''
})
const layouts = ref(["total", "prev", "pager", "next", "sizes", "jumper"])
const formModelRef = ref(null)

const getList = () => {
	listLoading.value = true
	let params = {
		page: listQuery.value.page,
		limit: listQuery.value.limit,
	}
	if (listQuery.value.xiangmumingcheng) params['xiangmumingcheng'] = '%' + listQuery.value.xiangmumingcheng + '%'
	if (listQuery.value.dailigongsimingcheng) params['dailigongsimingcheng'] = '%' + listQuery.value.dailigongsimingcheng + '%'
	
	context.$http({
		url: 'chengjieqingqiu/page',
		method: 'get',
		params: params
	}).then(res => {
		list.value = res.data.data.list
		total.value = Number(res.data.data.total)
		listLoading.value = false
	})
}

const searchClick = () => {
	listQuery.value.page = 1
	getList()
}

const sizeChange = (size) => {
	listQuery.value.limit = size
	getList()
}

const currentChange = (page) => {
	listQuery.value.page = page
	getList()
}

const infoClick = (id) => {
	formModelRef.value.init(id, 'info')
}

const deleteClick = (id) => {
	context.$confirm('确定删除该申请吗？', '提示', {
		confirmButtonText: '确定',
		cancelButtonText: '取消',
		type: 'warning'
	}).then(() => {
		context.$http({
			url: 'chengjieqingqiu/delete',
			method: 'post',
			data: [id]
		}).then(() => {
			context?.$toolUtil.message('删除成功', 'success')
			getList()
		})
	})
}

const btnAuth = (tableName, btnType) => {
	return context?.$toolUtil.isAuth(tableName, btnType)
}

onMounted(() => {
	getList()
})
</script>

<style scoped>
.center_view {
	padding: 20px;
}
.list_search_view {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
}
</style>
