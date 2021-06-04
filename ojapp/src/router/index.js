import Vue from 'vue';
import VueRouter from 'vue-router'
import login from "@/views/login";
import Problem from "@/views/Problem/Problem";
import AddProblem from "@/views/Problem/AddProblem";
import UpdateProblem from "@/views/Problem/UpdateProblem";
import AddUser from "@/views/User/AddUser";
import User from "@/views/User/User";
import Own from "@/views/Own/Own";
Vue.use(VueRouter)

//普通路由
export const routes1=[
    {
        path: '/',
        component: login,
        meta:{
            requireAuth: true,
        }
    },
]
//权限路由
export const routes2=[
    {
        path: '/Problem',
        component: Problem,
    },
    {
        path:'/AddProblem',
        component:AddProblem,

    },
    {
        path:'/UpdateProblem',
        component:UpdateProblem,
    },
    {
        path:'/User',
        component:User,

    },
    {
        path:'/AddUser',
        component:AddUser,
    },
    {
        path: '/Own',
        component: Own,
    },
]
const router=new VueRouter({
    routes:routes1,
})

export default router