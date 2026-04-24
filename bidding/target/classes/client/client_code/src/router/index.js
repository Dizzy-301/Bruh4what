import {createRouter, createWebHashHistory} from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import forget from '../views/pages/forget.vue'
import zhaobiaodailiRecommend from '@/views/pages/zhaobiaodaili/recommendList'
import yezhudanweiList from '@/views/pages/yezhudanwei/list'
import yezhudanweiDetail from '@/views/pages/yezhudanwei/formModel'
import yezhudanweiAdd from '@/views/pages/yezhudanwei/formAdd'
import toubiaodanweiList from '@/views/pages/toubiaodanwei/list'
import toubiaodanweiDetail from '@/views/pages/toubiaodanwei/formModel'
import toubiaodanweiAdd from '@/views/pages/toubiaodanwei/formAdd'
import toubiaodanweiRegister from '@/views/pages/toubiaodanwei/register'
import toubiaodanweiCenter from '@/views/pages/toubiaodanwei/center'
import zhaobiaodailiList from '@/views/pages/zhaobiaodaili/list'
import zhaobiaodailiDetail from '@/views/pages/zhaobiaodaili/formModel'
import zhaobiaodailiAdd from '@/views/pages/zhaobiaodaili/formAdd'
import zhaobiaoxiangmuList from '@/views/pages/zhaobiaoxiangmu/list'
import zhaobiaoxiangmuDetail from '@/views/pages/zhaobiaoxiangmu/formModel'
import zhaobiaoxiangmuAdd from '@/views/pages/zhaobiaoxiangmu/formAdd'
import toubiaoxinxiList from '@/views/pages/toubiaoxinxi/list'
import toubiaoxinxiDetail from '@/views/pages/toubiaoxinxi/formModel'
import toubiaoxinxiAdd from '@/views/pages/toubiaoxinxi/formAdd'
import zhongbiaogonggaoList from '@/views/pages/zhongbiaogonggao/list'
import zhongbiaogonggaoDetail from '@/views/pages/zhongbiaogonggao/formModel'
import zhongbiaogonggaoAdd from '@/views/pages/zhongbiaogonggao/formAdd'
import tousuxinxiList from '@/views/pages/tousuxinxi/list'
import tousuxinxiDetail from '@/views/pages/tousuxinxi/formModel'
import tousuxinxiAdd from '@/views/pages/tousuxinxi/formAdd'
import newsList from '@/views/pages/news/list'
import hetongbeianList from '@/views/pages/hetongbeian/list'
import hetongbeianDetail from '@/views/pages/hetongbeian/formModel'
import hetongbeianAdd from '@/views/pages/hetongbeian/formAdd'
import zhaobiaojihuaList from '@/views/pages/zhaobiaojihua/list'
import zhaobiaojihuaDetail from '@/views/pages/zhaobiaojihua/formModel'
import zhaobiaojihuaAdd from '@/views/pages/zhaobiaojihua/formAdd'
import zhaobiaogonggaoList from '@/views/pages/zhaobiaogonggao/list'
import zhaobiaogonggaoDetail from '@/views/pages/zhaobiaogonggao/formModel'
import zhaobiaogonggaoAdd from '@/views/pages/zhaobiaogonggao/formAdd'
import changdiyuyueList from '@/views/pages/changdiyuyue/list'
import changdiyuyueDetail from '@/views/pages/changdiyuyue/formModel'
import changdiyuyueAdd from '@/views/pages/changdiyuyue/formAdd'

const routes = [{
    path: '/',
    redirect: '/index/home'
},
    {
        path: '/index',
        component: index,
        children: [{
            path: 'home',
            component: home
        }
            , {
                path: 'yezhudanweiList',
                component: yezhudanweiList
            }, {
                path: 'yezhudanweiDetail',
                component: yezhudanweiDetail
            }, {
                path: 'yezhudanweiAdd',
                component: yezhudanweiAdd
            }
            , {
                path: 'toubiaodanweiList',
                component: toubiaodanweiList
            }, {
                path: 'toubiaodanweiDetail',
                component: toubiaodanweiDetail
            }, {
                path: 'toubiaodanweiAdd',
                component: toubiaodanweiAdd
            }
            , {
                path: 'toubiaodanweiCenter',
                component: toubiaodanweiCenter
            }
            , {
                path: 'zhaobiaodailiList',
                component: zhaobiaodailiList
            }, {
                path: 'zhaobiaodailiDetail',
                component: zhaobiaodailiDetail
            }, {
                path: 'zhaobiaodailiAdd',
                component: zhaobiaodailiAdd
            }
            , {
                path: 'zhaobiaoxiangmuList',
                component: zhaobiaoxiangmuList
            }, {
                path: 'zhaobiaoxiangmuDetail',
                component: zhaobiaoxiangmuDetail
            }, {
                path: 'zhaobiaoxiangmuAdd',
                component: zhaobiaoxiangmuAdd
            }
            , {
                path: 'toubiaoxinxiList',
                component: toubiaoxinxiList
            }, {
                path: 'toubiaoxinxiDetail',
                component: toubiaoxinxiDetail
            }, {
                path: 'toubiaoxinxiAdd',
                component: toubiaoxinxiAdd
            }
            , {
                path: 'zhongbiaogonggaoList',
                component: zhongbiaogonggaoList
            }, {
                path: 'zhongbiaogonggaoDetail',
                component: zhongbiaogonggaoDetail
            }, {
                path: 'zhongbiaogonggaoAdd',
                component: zhongbiaogonggaoAdd
            }
            , {
                path: 'tousuxinxiList',
                component: tousuxinxiList
            }, {
                path: 'tousuxinxiDetail',
                component: tousuxinxiDetail
            }, {
                path: 'tousuxinxiAdd',
                component: tousuxinxiAdd
            }
            , {
                path: 'newsList',
                component: newsList
            }
            , {
                path: 'hetongbeianList',
                component: hetongbeianList
            }, {
                path: 'hetongbeianDetail',
                component: hetongbeianDetail
            }, {
                path: 'hetongbeianAdd',
                component: hetongbeianAdd
            }
            , {
                path: 'zhaobiaojihuaList',
                component: zhaobiaojihuaList
            }, {
                path: 'zhaobiaojihuaDetail',
                component: zhaobiaojihuaDetail
            }, {
                path: 'zhaobiaojihuaAdd',
                component: zhaobiaojihuaAdd
            }
            , {
                path: 'zhaobiaogonggaoList',
                component: zhaobiaogonggaoList
            }, {
                path: 'zhaobiaogonggaoDetail',
                component: zhaobiaogonggaoDetail
            }, {
                path: 'zhaobiaogonggaoAdd',
                component: zhaobiaogonggaoAdd
            }
            , {
                path: 'changdiyuyueList',
                component: changdiyuyueList
            }, {
                path: 'changdiyuyueDetail',
                component: changdiyuyueDetail
            }, {
                path: 'changdiyuyueAdd',
                component: changdiyuyueAdd
            },
            {
                path: 'zhaobiaodailiRecommend',
                component: zhaobiaodailiRecommend
            }
        ]
    },
    {
        path: '/login',
        component: login
    },
    {
        path: '/forget',
        component: forget
    }
]

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
})

export default router
