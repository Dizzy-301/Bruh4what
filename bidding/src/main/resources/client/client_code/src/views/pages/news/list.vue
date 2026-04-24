<template>
    <div class="list-page news-page" :style='{}'>
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
        <el-form inline :model="searchQuery" class="list_search">
            <div class="search_view">
                <div class="search_label">
                    标题：
                </div>
                <div class="search_box">
                    <el-input class="search_inp" v-model="searchQuery.title" placeholder="标题" clearable></el-input>
                </div>
            </div>
            <div class="search_btn_view">
                <el-button class="search_btn" type="primary" @click="searchClick">搜索</el-button>
            </div>
        </el-form>
        <div class="news_list_one">
            <div class="list-item animation_box" v-for="(item,index) in list" :key="index" @click="newsDetail(item.id)">
                <div class="news_img_box">
                    <img class="news_img" :src="$config.url + item.picture" alt="">
                </div>
                <div class="news_content">
                    <div class="news_title"><span>{{item.title}}</span></div>
                    <div class="news_intro">{{item.introduction}}</div>
                    <div class="news_time">{{item.addtime.split(' ')[0]}}</div>
                </div>
            </div>
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


        <formModel ref="formModelRef"></formModel>
    </div>
</template>

<script setup>
    import moment from 'moment'
    import formModel from './formModel'
    import {
        ref,
        nextTick,
        getCurrentInstance
    } from 'vue';
    import {
        ElMessageBox
    } from 'element-plus'
    import {
        useRoute,
        useRouter
    } from 'vue-router'

    const context = getCurrentInstance()?.appContext.config.globalProperties;
    //基础信息
    const tableName = 'news'
    const formName = '系统公告'
    const router = useRouter()
    const route = useRoute()
    //基础信息
    const breadList = ref([{
        name: formName
    }])
    //权限验证
    const btnAuth = (e, a) => {
        return context?.$toolUtil.isAuth(e, a)
    }
    const list = ref([])
    const listLoading = ref(false)
    const listQuery = ref({
        page: 1,
        limit: 20,
        sort: 'addtime',
        order: 'desc'
    })
    const searchQuery = ref({})
    //分页
    const layouts = ref(["prev", "pager", "next"])
    const total = ref(0)
    const sizeChange = (size) => {
        listQuery.value.limit = size
        getList()
    }
    const currentChange = (page) => {
        listQuery.value.page = page
        getList()
    }
    //分页
    const searchClick = () => {
        listQuery.value.page = 1
        getList()
    }
    const getList = () => {
        listLoading.value = true
        let params = JSON.parse(JSON.stringify(listQuery.value))
        if (searchQuery.value.title && searchQuery.value.title != '') {
            params['title'] = `%${searchQuery.value.title}%`
        }
        context?.$http({
            url: `news/list`,
            method: 'get',
            params: params
        }).then(res => {
            listLoading.value = false
            list.value = res.data.data.list
            total.value = res.data.data.total
        })
    }
    //判断是否从个人中心跳转
    const centerType = ref(false)
    //返回
    const backClick = () => {
        router.push(`/index/${context?.$toolUtil.storageGet('frontSessionTable')}Center`)
    }
    const init = () => {
        if (route.query.centerType) {
            centerType.value = true
        }
        getList()
    }
    //定义弹窗
    const formModelRef = ref(null)
    const newsDetail = (id = null) => {
        if (id) {
            formModelRef.value.init(id)
        }
    }
    init()
</script>

<style lang="scss" scoped>
    // 返回盒子
    .back_view {
        // 返回按钮
        .back_btn {
        }

        // 返回按钮-悬浮
        .back_btn:hover {
        }
    }

    //搜索
    .list_search {
        .search_view {
            .search_label {
            }

            .search_box {
                // 输入框
                :deep(.search_inp) {

                }
            }
        }

        .search_btn_view {
            // 搜索按钮
            .search_btn {
            }

            // 搜索按钮-悬浮
            .search_btn:hover {
            }
        }
    }

    .news_list_one {
        .list-item {
            .news_img_box {
                .news_img {
                }
            }

            .news_content {
                .news_title {
                }

                .news_intro {
                }

                .news_time {
                }
            }
        }
    }

    // animation
    .animation_box {
        transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
        z-index: initial;
    }

    .animation_box:hover {
    }

    .animation_box img {
        transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
        z-index: initial;
    }

    .animation_box img:hover {
    }

    // animation
    // 分页器
    .el-pagination {
        // 总页码
        :deep(.el-pagination__total) {
        }

        // 上一页
        :deep(.btn-prev) {
        }

        // 下一页
        :deep(.btn-next) {
        }

        // 上一页禁用
        :deep(.btn-prev:disabled) {
        }

        // 下一页禁用
        :deep(.btn-next:disabled) {
        }

        // 页码
        :deep(.el-pager) {
            // 数字
            .number {
            }

            // 数字悬浮
            .number:hover {
            }

            // 选中
            .number.is-active {
            }
        }

        // sizes
        :deep(.el-pagination__sizes) {
            .el-select {
                //去掉默认样式
                .select-trigger {
                    height: 100%;

                    .el-input {
                        height: 100%;

                    }
                }
            }
        }

        // 跳页
        :deep(.el-pagination__jump) {
            // 输入框
            .el-input {

            }
        }
    }
</style>
<style>

    .news-page {
        padding: 20px calc(50% - 600px);
        width: 100%;
        background: rgba(247, 247, 247, 1);
        position: relative;
        display: flex;
        flex-wrap: wrap;
    }


    .news-page .list_search {
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 20px auto;
        background: none;
        width: 100%;
    }

    .news-page .list_search .search_view {
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 16px;

    }

    .news-page .list_search .search_view .search_label {
        white-space: nowrap;
    }

    .news-page .list_search .search_view .search_box .el-input .el-input__inner {
        border: 1px solid #ddd;
        padding: 0 10px;
        height: 38px;
        line-height: 38px;
        background: #fff;
    }

    .news-page .list_search .search_btn_view {
        margin-left: 10px;
    }

    .news-page .list_search .search_btn_view .search_btn {
        background: var(--theme);
        border: 0px solid var(--theme);
    }

    .news-page .list_search .search_btn_view .search_btn:hover {
        opacity: 0.8;
    }


    .news-page .categorys {
        display: flex;
        align-items: center;
        font-size: 16px;
        margin: 40px 0 20px;
        background: var(--theme);
        padding: 4px;
        display: none;
    }

    .news-page .categorys .category {
        font-size: 16px;
        border: 0px solid #ddd;
        padding: 0 10px;
        height: 38px;
        line-height: 38px;
        margin-right: 10px;
        min-width: 120px;
        text-align: center;
        color: #fff;
    }

    .news-page .categorys .category:hover {
        color: var(--theme);
        border: 1px solid var(--theme);
        background: #fff;
        border-radius: 8px;
    }


    .news-page .news_list_one {
        width: 100%;
        height: auto;
        background: none;
        padding: 0px;
        display: grid;
        grid-template-columns: 585px 585px;
        grid-gap: 22px 30px;
        margin-bottom: 30px;
    }

    .news-page .news_list_one .list-item {
        width: 100%;
        display: flex;
        margin: 0px;
        height: 120px;
        justify-content: space-between;
        padding: 10px;
        cursor: pointer;
        background: #fff;
        border-radius: 6px;
    }

    .news-page .news_list_one .list-item .news_img_box {
        width: 230px;
        height: 160px;
        order: 1;
        display: none;
        flex-shrink: 0;
    }

    .news-page .news_list_one .list-item .news_img_box .news_img {
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-radius: 6px;
        position: relative;
        top: -60px;
    }

    .news-page .news_list_one .list-item .news_content {
        width: calc(100% - 170px);
        display: flex;
        flex-direction: column;
    }

    .news-page .news_list_one .list-item .news_content .news_title {
        padding: 0px;
        line-height: 24px;
        color: rgb(51, 51, 51);
        font-size: 16px;
        width: 100%;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        font-weight: 600;
    }

    .news-page .news_list_one .list-item .news_content .news_intro {
        padding: 0px;
        line-height: 22px;
        color: rgb(102, 102, 102);
        font-size: 14px;
        overflow: hidden;
        display: -webkit-box;
        -webkit-box-orient: vertical;
        -webkit-line-clamp: 2;
    }

    .news-page .news_list_one .list-item .news_content .news_time {
        padding: 4px;
        line-height: 16px;
        color: #fff;
        font-size: 12px;
        box-sizing: border-box;
        background: var(--theme);
        width: 74px;
        text-align: center;
        margin-top: auto;
    }


    .news-page .news_detail {
        width: 100%;
    }

    .news-page .news_detail .news_detail_title {
        font-size: 24px;
        font-weight: bold;
        color: rgb(0, 0, 0);
    }

    .news-page .news_detail .news_detail_time {
        text-align: right;
        font-size: 16px;
        color: rgb(153, 153, 153);
        padding: 20px 0px 0px;
    }

    .news-page .news_detail .news_detail_content {
        margin-top: 20px;
        text-align: left;
        font-size: 16px;
        line-height: 1.8;
    }


    .news-page .news_top {
        display: flex;
        column-gap: 30px;
    }


    .news-page .five_top_item {
        flex: 1;
        background: linear-gradient(180deg, #A8E3FF 0%, #EEF5FB 100%);
        border-radius: 8px;
        padding: 18px;
        top: 0;
        position: relative;
        transition: top 0.3s;
        cursor: pointer;
    }

    .news-page .img_box {
        width: 100%;
        height: 240px;
    }

    .news-page img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }

    .news-page .five_top_item .news_title {
        font-size: 18px;
        line-height: 30px;
    }

    .news-page .five_top_item .content {
        margin-top: 20px;
    }

    .news-page .news_text {
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
        text-overflow: ellipsis;
        color: rgba(140, 140, 140, 1);
    }

    .news-page .news_bottom {
        display: grid;
        grid-template-columns: 1fr 1fr;
        margin-top: 30px;
        gap: 30px;
    }

    .news-page .five_bottom_item:hover {
        background: var(--theme);
        color: #fff;
        cursor: pointer;
    }

    .news-page .five_bottom_item {
        background: #fff;
        padding: 20px;
        display: flex;
        border-radius: 8px;
        align-items: center;
    }

    .news-page .five_bottom_item .time_box {
        background: var(--theme);
        color: #fff;
        width: 50px;
        height: 50px;
        flex-shrink: 0;
        margin-right: 6px;
        font-size: 12px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        row-gap: 6px;
        border-radius: 4px;
    }

    .news-page .five_bottom_item:hover .time_box {
        background: #fff;
        color: var(--theme);
    }

    .news-page .five_bottom_item:hover .news_text {
        color: #fff;
    }

    .news-page .five_bottom_item .content {
        border-left: 1px solid rgba(219, 219, 219, 1);
        padding-left: 10px;
    }

    .news-page .five_bottom_item .news_text {
        margin-top: 10px;
    }

    .news-page .hot_img_view {
        width: 100%;
        height: 157px;
        flex-shrink: 0;
    }

    .news-page .five_top_item:hover {
        top: -10px;
    }

    .news_list_one .list-item:nth-child(1), .news_list_one .list-item:nth-child(2), .news_list_one .list-item:nth-child(3), .news_list_one .list-item:nth-child(4) {
        margin-top: 50px;
    }

    .news_list_one .list-item:nth-child(1) .news_img_box, .news_list_one .list-item:nth-child(2) .news_img_box, .news_list_one .list-item:nth-child(3) .news_img_box, .news_list_one .list-item:nth-child(4) .news_img_box {
        display: block;
    }


    .hot_view .hot_list {
        width: 100%;
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        margin: 20px 0px 0px;
        grid-gap: 20px;
    }

    .hot_view .hot_list .hot {
        box-sizing: border-box;
        cursor: pointer;
        border-radius: 4px;
        display: flex;
    }

    .hot_view .hot_list .hot .hot_img_view {
        width: 110px;
        height: 110px;
        flex-shrink: 0;
        overflow: hidden;
        position: relative;
        background: linear-gradient(270deg, #fff, transparent);
    }

    .hot_view .hot_list .hot .hot_img_view .hot_img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
    }

    .hot_view .hot_list .hot .hot_content {
        width: 175px;
        background: #fff;
        display: flex;
        align-items: center;
        padding-left: 10px;
        padding-right: 10px;
    }

    .hot_view .hot_list .hot .hot_content .hot_text {
        width: 100%;
        font-size: 16px;
        color: rgb(51, 51, 51);
        line-height: 2;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

    .hot_view img {
        object-fit: cover;
    }

    .hot_view {
        background: none;
        padding: inherit;
        margin: 30px 0;
        width: 1200px;
    }

    .hot_view .hot_title {
        color: var(--theme);
        font-size: 20px;
    }

    .hot_view span {
    }

    .hot_view .hot_title span {
        background: url(http://clfile.zggen.cn/20241221/80d54ad0af844a5180b36e7219044690.webp);
        background-size: 100% 100%;
        line-height: 44px;
        width: 280px;
        display: inline-block;
        text-align: center;
    }
</style>