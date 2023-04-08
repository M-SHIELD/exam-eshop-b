import Vue from 'vue'
import VueRouter from 'vue-router'
import home from "@/views/tarbar/home";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'mainRoom',
        component: home
    },
    {
        path: '/type',
        name: 'type',
        component: () => import('@/views/tarbar/type')
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/login')
    },
    {
        path: '/cart',
        name: 'cart',
        component: () => import('@/views/user/cart')
    },
    {
        path: '/prolist',
        name: 'prolist',
        component: () => import('@/components/proList')
    },

    {
        path: '/user/order',
        name: 'userOrder',
        component: () => import('@/views/user/order')
    },
    {
        path: '/user/wallet',
        name: 'wallet',
        component: () => import("@/views/user/wallet")
    },
    {
        path: '/user/footprint',
        name: 'footPrint',
        component: () => import("@/views/user/myFootprint")
    },
    {
        path: '/user/collect',
        name: 'collect',
        component: () => import("@/views/user/collect")
    },
    {
        path: '/goods/:goodsId',
        name: 'goods',
        component: () => import('@/views/goods/detail')
    },
    {
        path: '/user',
        name: 'user',
        component: () => import("@/views/user"),
    },
    {
        path: '/address',
        name: 'userAddress',
        component: () => import('../views/user/address/index'),
    },
    {
        path: '/add',
        name: 'addAddress',
        component: () => import("@/views/user/address/add")
    },
    {
        path: '/edit/:addressId',
        name: 'editAddress',
        component: () => import("@/views/user/address/edit")
    },
    {
        path: '/coupon',
        name: 'userCoupon',
        component: () => import('@/views/user/coupon')
    },
    {
        path: '/search',
        name: 'search',
        component: () => import('@/views/search')
    }
]

const router = new VueRouter({
    routes
})

export default router
