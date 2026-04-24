<template>
    <div class="home_view">
        <div class="projectTitle">欢迎使用 {{projectName}}</div>
        <div class="count_list">
        </div>
        <div class="card_list">
        </div>
    </div>
</template>

<script setup>
    import {
        inject,
        nextTick,
        ref,
        getCurrentInstance
    } from 'vue';

    const context = getCurrentInstance()?.appContext.config.globalProperties;
    const projectName = context.$project.projectName
    //权限验证
    const btnAuth = (e, a) => {
        return context?.$toolUtil.isAuth(e, a)
    }
    const init = () => {
    }
    init()
</script>
<style lang="scss">
    // 首页盒子
    .home_view {
        background-image: url("http://clfile.zggen.cn/20240917/60616291f70642f1aba356139f3fc2db.webp");
    }

    .home_view .projectTitle {
    }

    .showIcons {
        transition: transform 0.3s;
        margin-right: 10px;
    }

    .showIcons1 {
        transform: rotate(-180deg);
    }

    // 总数盒子
    .count_list {
        // 总数card
        .card_view {
            // card头部
            .el-card__header {
                // 头部盒子
                .index_card_head {
                    // 标题
                    .card_head_title {
                    }

                    // 按钮盒子
                    .card_head_right {
                        // 按钮
                        .el-icon {
                        }
                    }
                }
            }

            // body
            .el-card__body {
                // body盒子
                .count_item {
                    // 总数标题
                    .count_title {
                    }

                    // 总数数字
                    .count_num {
                    }
                }
            }
        }
    }

    // 统计图盒子
    .card_list {
        // 统计图card
        .card_view {
            // 头部
            .el-card__header {
                // 头部盒子
                .index_card_head {
                    // 标题
                    .card_head_title {
                    }

                    // 按钮盒子
                    .card_head_right {
                        // 按钮
                        .el-icon {
                        }
                    }
                }
            }

            // body
            .el-card__body {
                // body盒子
                .card_item {
                }
            }
        }
    }
</style>
<style>
    /*总盒子*/
    .home_view {
        width: 100%;
        margin: 0 auto;
        padding: 20px 40px 20px 40px;
        height: auto;
        min-height: 100vh;
        background: url(http://clfile.zggen.cn/20240917/226db5213b844e3785e554748e4d09fe.png) no-repeat center top / cover !important;
        border-radius: 0px;
        display: flex;
        flex-wrap: wrap;
        align-items: flex-start;
    }

    .home_view .projectTitle {
        width: 100%;
        font-size: 28px;
        font-weight: bold;
        padding: 40px 0px 20px;
        height: auto;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0px 0px 20px;
        color: #d3623d;
    }

    /*总数*/
    /*总盒子*/
    .home_view .count_list {
        width: calc(100% - 20px);
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px 0 0px;
        align-items: flex-start;
        background: #fff;
        margin: 0 auto 20px;
    }

    /*卡片盒子*/
    .home_view .count_list .card_view {
        width: calc(25% - 40px);
        height: auto;
        margin: 0px 20px 20px;
        box-sizing: border-box;
        border: 2px solid #d3623d;
        border-radius: 0px;
        background: url(http://clfile.zggen.cn/20240917/2626fb5752f24b44bb1d33bdc9100b99.png) no-repeat right top, #fff;
        padding: 5px 20px;
        flex: 1;
        box-shadow: none;
    }

    /*head 总盒子*/
    .home_view .count_list .card_view .el-card__header {
        width: 100%;
        border: 0px solid rgb(238, 238, 238);
        display: none;
    }

    /*item*/
    .home_view .count_list .card_view .el-card__header .index_card_head {
        display: flex;
        align-items: center;
        justify-content: space-between;
        width: 100%;
        height: 10px;
    }

    /*标题*/
    .home_view .count_list .card_view .el-card__header .index_card_head .card_head_title {
        font-size: 14px;
        color: rgb(51, 51, 51);
    }

    /*按钮盒子*/
    .home_view .count_list .card_view .el-card__header .index_card_head .card_head_right {
        display: flex;
        align-items: center;
    }

    /*按钮*/
    .home_view .count_list .card_view .el-card__header .index_card_head .card_head_right .showIcons {
        color: rgb(102, 102, 102);
        font-size: 20px;
        cursor: pointer;
    }

    /*body 总盒子*/
    .home_view .count_list .card_view .el-card__body {
        padding: 0px;
        background: none;
    }

    /*item*/
    .home_view .count_list .card_view .el-card__body .count_item {
        padding: 10px;
        text-align: left;
        display: flex;
        align-items: flex-start;
        justify-content: flex-start;
        flex-direction: column;
    }

    /*标题*/
    .home_view .count_list .card_view .el-card__body .count_item .count_title {
        font-size: 18px;
        color: rgb(33, 33, 33);
        line-height: 1.5;
        display: inline-block;
        margin: 0px 0px 0px 0px;
        font-weight: 500;
        order: 2;
    }

    /*数字*/
    .home_view .count_list .card_view .el-card__body .count_item .count_num {
        font-size: 32px;
        color: #000;
        line-height: 1.5;
        display: inline-block;
        font-weight: 500;
    }

    /*图表*/
    /*总盒子*/
    .home_view .card_list {
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        padding: 0px 0px 20px;
        align-items: flex-start;
        order: 11;
    }

    /*卡片 总盒子*/
    .home_view .card_list .card_view {
        width: calc(33.33% - 20px);
        height: auto;
        margin: 0px 10px 30px;
        box-sizing: border-box;
        border-radius: 0px;
        padding: 20px 10px 10px;
        box-shadow: none;
        border: 0px solid #ddd;
        background: #fff;
    }

    /*head 总盒子*/
    .home_view .card_list .card_view .el-card__header {
        width: 100%;
        border: 0px solid rgb(238, 238, 238);
        background: rgb(255, 255, 255);
        display: none;
    }

    /*item*/
    .home_view .card_list .card_view .el-card__header .index_card_head {
        display: flex;
        align-items: center;
        justify-content: space-between;
        width: 100%;
        height: 10px;
    }

    /*标题*/
    .home_view .card_list .card_view .el-card__header .index_card_head .card_head_title {
    }

    /*按钮盒子*/
    .home_view .card_list .card_view .el-card__header .index_card_head .card_head_right {
        display: none;
    }

    /*按钮*/
    .home_view .card_list .card_view .el-card__header .index_card_head .card_head_right .showIcons {
        color: rgb(238, 238, 238);
        font-size: 20px;
        cursor: pointer;
    }

    /*body 总盒子*/
    .home_view .card_list .card_view .el-card__body {
        padding: 0px;
        background: rgb(255, 255, 255);
    }

    .home_view .card_list .card_view .el-card__body .card_item {
        padding: 0px;
        text-align: center;
    }

    .home-calendar {
        border: 0px solid rgb(218, 218, 218);
        box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 0px;
        margin: 0px auto 30px;
        border-radius: 0px;
        color: rgb(102, 102, 102);
        background: #fff;
        width: calc(100% - 20px);
        font-size: inherit;
        height: auto;
        padding: 0 0 15px;
        order: 2;
        border-width: 0px;
        border-style: solid;
        border-color: #ffc77f50;
    }

    .home-calendar .header {
        padding: 17px 40px;
        flex-wrap: wrap;
        background: #d3623d;
        display: flex;
        width: 100%;
        justify-content: space-between;
        height: auto;
    }

    .home-calendar .header .btn {
        cursor: pointer;
        border: 0px solid rgb(153, 153, 153);
        padding: 0px 0px 0px 12px;
        align-items: center;
        color: #fff;
        border-radius: 4px;
        display: flex;
        width: auto;
        font-size: 16px;
        justify-content: center;
    }

    .home-calendar .header .title {
        padding: 0px 10px;
        font-size: 24px;
        align-items: center;
        justify-content: center;
        display: flex;
        color: #fff;
    }

    .home-calendar table {
        width: 100%;
        padding: 0px 0px 0px;
        height: auto;

    }

    .home-calendar tbody, thead {
        width: 100%;
    }

    .home-calendar tr {
        width: 100%;
        align-items: center;
        justify-content: center;
        display: flex;
    }

    .home-calendar th {
        align-items: center;
        flex: 1;
        display: flex;
        line-height: 50px;
        justify-content: center;
    }

    .home-calendar td {
        cursor: pointer;
        padding: 6px 12px 6px;
        flex: 1;
        display: flex;
        justify-content: center;
        text-align: center;
    }

    .home-calendar td.today .text {
        width: 80%;
        height: 80%;
        padding: 5px 0;
        background: #d3623d !important;
        color: #fff;
        border-radius: 0px;
    }

    .home-calendar td.festival .text {
        width: 80%;
        height: 80%;
        padding: 5px 0;
        background: #d3623d20;
        border-radius: 0px;
    }

</style>
