import {
    createRouter,
    createWebHashHistory
} from 'vue-router'
import news from '@/views/news/list'
import toubiaoxinxi from '@/views/toubiaoxinxi/list'
import zhaobiaodaili from '@/views/zhaobiaodaili/list'
import menu_manage from '@/views/menu_manage/list'
import users from '@/views/users/list'
import tousuxinxi from '@/views/tousuxinxi/list'
import hetongbeian from '@/views/hetongbeian/list'
import zhaobiaojihua from '@/views/zhaobiaojihua/list'
import yezhudanwei from '@/views/yezhudanwei/list'
import toubiaodanwei from '@/views/toubiaodanwei/list'
import zhaobiaoxiangmu from '@/views/zhaobiaoxiangmu/list'
import zhongbiaogonggao from '@/views/zhongbiaogonggao/list'
import dailipingjia from '@/views/dailipingjia/list'
import config from '@/views/config/list'
import zhaobiaogonggao from '@/views/zhaobiaogonggao/list'
import changdiyuyue from '@/views/changdiyuyue/list'
import chengjieqingqiu from '@/views/chengjieqingqiu/list'
import usersCenter from '@/views/users/center'
import yezhudanweiRegister from '@/views/yezhudanwei/register'
import yezhudanweiCenter from '@/views/yezhudanwei/center'
import zhaobiaodailiRegister from '@/views/zhaobiaodaili/register'
import zhaobiaodailiCenter from '@/views/zhaobiaodaili/center'
import forget from '@/views/forget'

export const routes = [{
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue')
}, {
    path: '/',
    name: '首页',
    component: () => import('../views/index'),
    children: [{
        path: '/',
        name: '首页',
        component: () => import('../views/HomeView.vue'),
        meta: {
            affix: true
        }
    }, {
        path: '/updatepassword',
        name: '修改密码',
        component: () => import('../views/updatepassword.vue')
    }

        , {
            path: '/usersCenter',
            name: '管理员个人中心',
            component: usersCenter
        }
        , {
            path: '/yezhudanweiCenter',
            name: '业主单位个人中心',
            component: yezhudanweiCenter
        }
        , {
            path: '/zhaobiaodailiCenter',
            name: '招标代理个人中心',
            component: zhaobiaodailiCenter
        }
        , {
            path: '/news',
            name: '系统公告',
            component: news
        }
        , {
            path: '/toubiaoxinxi',
            name: '投标信息',
            component: toubiaoxinxi
        }
        , {
            path: '/zhaobiaodaili',
            name: '招标代理',
            component: zhaobiaodaili
        }
        , {
            path: '/menu',
            name: '菜单权限管理',
            component: menu_manage
        }
        , {
            path: '/users',
            name: '管理员',
            component: users
        }
        , {
            path: '/tousuxinxi',
            name: '投诉信息',
            component: tousuxinxi
        }
        , {
            path: '/hetongbeian',
            name: '合同备案',
            component: hetongbeian
        }
        , {
            path: '/zhaobiaojihua',
            name: '招标计划',
            component: zhaobiaojihua
        }
        , {
            path: '/yezhudanwei',
            name: '业主单位',
            component: yezhudanwei
        }
        , {
            path: '/toubiaodanwei',
            name: '投标单位',
            component: toubiaodanwei
        }
        , {
            path: '/zhaobiaoxiangmu',
            name: '招标项目',
            component: zhaobiaoxiangmu
        }
        , {
            path: '/zhongbiaogonggao',
            name: '中标公告',
            component: zhongbiaogonggao
        }
        , {
            path: '/config',
            name: '轮播图',
            component: config
        }
        , {
            path: '/zhaobiaogonggao',
            name: '招标公告',
            component: zhaobiaogonggao
        }
        , {
            path: '/changdiyuyue',
            name: '场地预约',
            component: changdiyuyue
        }
        , {
            path: '/dailipingjia',
            name: '代理评价',
            component: dailipingjia
        }
        , {
            path: '/chengjieqingqiu',
            name: '承接申请',
            component: chengjieqingqiu
        }
    ]
},
    {
        path: '/yezhudanweiRegister',
        name: '业主单位注册',
        component: yezhudanweiRegister
    },
    {
        path: '/zhaobiaodailiRegister',
        name: '招标代理注册',
        component: zhaobiaodailiRegister
    },
    {
        path: '/forget',
        name: '忘记密码',
        component: forget
    },
]

const router = createRouter({
    history: createWebHashHistory(process.env.BASE_URL),
    routes
})

export default router
