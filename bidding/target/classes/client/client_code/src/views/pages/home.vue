<template>
    <div>
        <div class="home_box">
            <!-- 系统公告 -->
            <div class="newsList_view">
                <div class="newtitle">
                    <div class="in">系统公告</div>
                </div>

                <div class="list">
                    <template v-for="(item,index) in newsList">
                        <div class="item0" v-if="index==0" @click="newsDetailClick(item)">
                            <div class="imgbox">
                                <img :src="item.imgUrl">
                            </div>
                            <div class="infobox">
                                <div class="title">{{item.title}}</div>
                                <div class="info">{{item.introduction}}</div>
                                <div class="time">{{moment(item.addtime).format('YYYY-MM-DD')}}</div>
                            </div>
                        </div>
                        <div class="item" :key="index" v-else @click="newsDetailClick(item)">
                            <div class="row1">
                                <img :src="item.imgUrl">
                                <div class="time">
                                    {{moment(item.addtime).format('YYYY-MM-DD')}}
                                </div>
                            </div>
                            <div class="infobox">
                                <div class="title">{{item.title}}</div>
                                <div class="info">{{item.introduction}}</div>
                            </div>
                        </div>
                    </template>
                </div>

                <div class="nmore" @click="moreClick('news')" style="cursor: pointer">查看更多 +</div>
            </div>

            <!-- 招标代理推荐 -->
            <div class="recomList_view">
                <div class="recomList_title">
                    <div class="in">招标代理推荐</div>
                </div>
                <div class="list">
                    <div v-for="(item, index) in recommendList" :key="index" class="item" @click="detailClick('zhaobiaodaili', item.id)">
                        <div class="infobox">
                            <div class="title">{{ item.dailigongsimingcheng }}</div>
                            <div class="info">账号: {{ item.dailigongsizhanghao }}</div>
                            <div class="info" v-if="item.lianxidianhua">电话: {{ item.lianxidianhua }}</div>
                        </div>
                    </div>
                </div>
                <div class="nmore" @click="router.push('/index/zhaobiaodailiRecommend')" style="cursor: pointer">查看更多 +</div>
            </div>

        </div>
        <formModel ref="newsFormModelRef"></formModel>
    </div>
</template>

<script setup>
    import {
        ref,
        getCurrentInstance
    } from 'vue';
    import moment from 'moment'
    import {
        useRouter
    } from 'vue-router';

    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const router = useRouter()
    //系统公告弹窗
    import formModel from './news/formModel'

    const newsFormModelRef = ref(null)
    //系统公告
    const newsList = ref([])
    const getNewsList = () => {
        context?.$http({
            url: 'news/list',
            method: 'get',
            params: {
                page: 1,
                limit: 5
            }
        }).then(res => {
            newsList.value = res.data.data.list
            newsList.value.forEach(item => {
                if (!isHttp(item.picture)) {
                    item.imgUrl = context.$config.url + item.picture.split(',')[0]
                }
            })
        })
    }
    const newsDetailClick = (item) => {
        if (item && item.id) {
            newsFormModelRef.value.init(item.id)
        }
    }
    //判断图片链接是否带http
    const isHttp = (str) => {
        return str && str.substr(0, 4) == 'http';
    }
    //跳转详情
    const detailClick = (table, id) => {
        router.push(`/index/${table}Detail?id=${id}`)
    }
    const moreClick = (table) => {
        router.push(`/index/${table}List`)
    }
    const init = () => {
        //系统公告
        getNewsList()
        //招标代理推荐
        getRecommendList()
    }
    //招标代理推荐
    const recommendList = ref([])
    const getRecommendList = () => {
        context?.$http({
            url: 'zhaobiaodaili/autoSort2',
            method: 'get',
            params: {
                page: 1,
                limit: 6
            }
        }).then(res => {
            recommendList.value = res.data.data.list
        })
    }
    init()
</script>

<style lang="scss">
    .home_box {
    }

    // 推荐
    .recomList_view {
        .recomList_title {
        }

        // list
        .recommend_list_one {
            .recommend_item {
            }

            .recommend_img_box {
                .recommend_img {
                }
            }

            .recommend_content {
                .recommend_title {
                }

                .recommend_price {
                }

                .recommend_bottom {
                    .recommend_like {
                        .like_icon {
                        }

                        .num {
                        }
                    }

                    .recommend_collect {
                        .el-icon {
                        }

                        .num {
                        }
                    }

                    .recommend_clickNum {
                        .el-icon {
                        }

                        .num {
                        }
                    }
                }
            }
        }

        // list
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
        // 更多
        .recommend_more_view {
            .recommend_more_text {
            }
        }
    }

    // 推荐
    // 新闻资讯
    .newsList_view {

        .newsList_title {
        }

        // list
        .news_list_one {
            display: flex;
            flex-wrap: wrap;

            .news_item {
                box-shadow: 0 4px 6px rgba(0, 0, 0, .3);
                margin: 0 10px 10px;
                background: #fff;
                display: flex;
                width: calc(33% - 20px);
                align-items: center;

                .news_img_box {
                    width: 40%;
                    font-size: 0;

                    .news_img {
                        object-fit: cover;
                        width: 100%;
                        height: 200px;
                    }
                }

                .news_content {
                    margin: 0 0 0 20px;
                    width: calc(60% - 20px);

                    .news_title {
                        font-weight: bold;
                        font-size: 20px;
                    }

                    .news_text {
                        font-size: 14px;
                        line-height: 1.5;
                    }

                    .news_time {
                        color: #999;
                        width: 100%;
                        text-align: right;
                    }
                }
            }
        }

        // list
        // animation
        .animation_box {
            transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
            z-index: initial;
        }

        .animation_box:hover {
            transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
            -webkit-perspective: 1000px;
            perspective: 1000px;
            transition: 0.3s;
        }

        .animation_box img {
            transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
            z-index: initial;
        }

        .animation_box img:hover {
            transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
            -webkit-perspective: 1000px;
            perspective: 1000px;
            transition: 0.3s;
        }

        // animation
        // 更多
        .news_more_view {
            .news_more_text {
            }

            .el-icon {
            }
        }
    }

    // 新闻资讯
    // 首页展示
    .homeList_view {

        .homeList_title {
        }

        // list
        .home_list_two {
            .home_item {
                .home_img_box {
                    .home_img {
                    }
                }

                .home_content {
                    .home_title {
                    }
                }
            }
        }

        // list
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
        // 更多
        .homeList_more_view {
            .homeList_more_text {
            }
        }
    }

    // 首页展示
</style>
<style>
    .home_box {
        display: flex;
        flex-direction: column;
    }

    .homeList_view {
        order: 2;
    }

    .aboutUs_view {
        order: 3;
    }

    .recomList_view {
        order: 4;
    }

    .friendLink {
        order: 5;
    }

    .newsList_view {
        order: 6;
    }

    .systemInfo_view {
        order: 7;
    }

    .onlineMessage {
        order: 8;
    }

    .newsList_view {
        background-image: radial-gradient(circle at 67% 57%, var(--theme) 5%, transparent 15%), url(http://clfile.zggen.cn/20241221/e1ec1d767d5e4fe58c6ede543a9fec67.webp);
        background-size: 100% 100%, 100% 100%;
        background-position: 30% 0, 30% 0;
        padding: 20px calc(50% - 600px) 50px;
        position: relative;
    }

    .newsList_view .newtitle {
        font-size: 22px;
        color: var(--theme);
        margin-bottom: 70px;
    }

    .newsList_view .item0 img {
        object-fit: cover;
        position: absolute;
        left: 100px;
        top: 0;
        width: 420px;
        height: 420px;
        border-radius: 50%;
        opacity: 0.7;
    }

    .newsList_view .item {
        padding: 14px;
        cursor: pointer;
        width: 300px;
        background: #fff;
    }

    .newsList_view .list {
        display: grid;
        grid-template-columns: auto auto auto;
        gap: 2px;
        color: #000;
    }

    .newsList_view .item0 .time {
        font-size: 16px;
        color: var(--theme);
        white-space: nowrap;
        width: 120px;
        text-align: center;
        line-height: 30px;
        margin: 0 auto;
        background: #fff;
    }

    .newsList_view .item .time {
        font-size: 18px;
        font-weight: 700;
        white-space: nowrap;
        height: 30px;
        line-height: 30px;
        background: var(--theme);
        padding: 0 10px;
        color: #fff;
    }

    .newsList_view .year {
        font-weight: 400;
        font-size: 12px;
        text-align: right;
        color: #999;
    }

    .newsList_view .item .title {
        font-size: 16px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        margin-top: 20px;
    }

    .newsList_view .item .info {
        font-size: 12px;
        color: #999;
        width: 100%;
        margin: 20px 0;
        display: -webkit-box;
        overflow: hidden;
        text-overflow: ellipsis;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

    .newsList_view .item .infobox {
        display: flex;
        flex-direction: column;
    }

    .newsList_view .item0 {
        grid-area: 1/1/3/2;
        position: relative;
        width: 100%;
        max-width: none;
        background: none;
        padding: 94px;
        display: flex;
        column-gap: 20px;
        align-items: center;
        cursor: pointer;
        height: 100%;
    }

    .newsList_view .item0 .info {
        margin: 20px 0;
        color: #999;
    }

    .newsList_view .item0 .title, .newsList_view .item0 .info {
        display: -webkit-box;
        overflow: hidden;
        text-overflow: ellipsis;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        color: #fff;
    }

    .newsList_view .item0 .title {
        font-size: 16px;
        line-height: 1.5em;
        text-align: center;
        color: #fff;
    }

    .newsList_view .to {
        font-size: 30px;
        line-height: 10px;
        color: #999;
    }

    .newsList_view .nmore {
        position: absolute;
        right: calc(50% - 600px);
        top: 57px;
        width: 150px;
        text-align: center;
        border: 1px solid var(--theme);
        line-height: 40px;
        color: var(--theme);
        background: rgba(208, 232, 220, 0.50);
        display: none;
    }

    .newsList_view .in {
        background: url(http://clfile.zggen.cn/20241221/80d54ad0af844a5180b36e7219044690.webp);
        background-size: 100% 100%;
        line-height: 44px;
        width: 280px;
        display: inline-block;
        text-align: center;
    }

    .newsList_view .imgbox {
    }

    .newsList_view .item0 .infobox {
        z-index: 1;
    }

    .newsList_view .item img {
        object-fit: cover;
        width: 110px;
        height: 80px;
        border-radius: 0;
    }

    .newsList_view .row1 {
        display: flex;
        justify-content: space-between;
    }

    .recomList_view {
        background: #f5f5f5;
        padding: 40px calc(50% - 600px);
        order: 5;
        .recomList_title {
            font-size: 22px;
            color: var(--theme);
            margin-bottom: 30px;
            text-align: center;
            .in {
                background: url(http://clfile.zggen.cn/20241221/80d54ad0af844a5180b36e7219044690.webp);
                background-size: 100% 100%;
                line-height: 44px;
                width: 280px;
                display: inline-block;
            }
        }
        .list {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            .item {
                background: #fff;
                padding: 20px;
                cursor: pointer;
                transition: all 0.3s;
                border-radius: 8px;
                box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
                &:hover {
                    box-shadow: 0 4px 16px 0 rgba(0,0,0,.2);
                    transform: translateY(-5px);
                }
                .title {
                    font-size: 18px;
                    font-weight: bold;
                    margin-bottom: 15px;
                    text-align: center;
                    color: #333;
                }
                .info {
                    font-size: 14px;
                    color: #666;
                    line-height: 1.8;
                }
            }
        }
        .nmore {
            margin: 30px auto 0;
            width: 150px;
            text-align: center;
            border: 1px solid var(--theme);
            line-height: 40px;
            color: var(--theme);
            border-radius: 4px;
            cursor: pointer;
        }
    }
</style>