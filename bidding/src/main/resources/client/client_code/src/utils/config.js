const config = {
    get() {
        return {
            url: process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
            menuList: [
                {
                    name: '招标项目管理',
                    icon: '',
                    child: [

                        {
                            name: '招标项目',
                            url: '/index/zhaobiaoxiangmuList'
                        },
                    ]
                },
                {
                    name: '中标公告管理',
                    icon: '',
                    child: [

                        {
                            name: '中标公告',
                            url: '/index/zhongbiaogonggaoList'
                        },
                    ]
                },
                {
                    name: '招标公告管理',
                    icon: '',
                    child: [

                        {
                            name: '招标公告',
                            url: '/index/zhaobiaogonggaoList'
                        },
                    ]
                },
                {
                    name: '推荐管理',
                    icon: '',
                    child: [
                        {
                            name: '招标代理推荐',
                            url: '/index/zhaobiaodailiRecommend'
                        },
                    ]
                },
            ]
        }
    },
    getProjectName() {
        return {
            projectName: "基于springboot的在线招标投标系统的设计与实现"
        }
    }
}
export default config
