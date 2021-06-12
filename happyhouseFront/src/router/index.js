import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import About from '@/views/About.vue';
import Login from '@/components/Login.vue';
import Register from '@/components/Register.vue';
import UserInfo from '@/components/UserInfo.vue';
import FindPw from '@/components/FindPw.vue';

import BoardList from '@/components/board/BoardList.vue';
import BoardDetail from '@/components/board/BoardDetail.vue';
import BoardWrite from '@/components/board/BoardWrite.vue';
import BoardModify from '@/components/board/BoardModify.vue';
import UserManage from '@/components/manage/UserManage.vue';

import NoticeList from '@/components/notice/NoticeList.vue';
import NoticeDetail from '@/components/notice/NoticeDetail.vue';
import NoticeWrite from '@/components/notice/NoticeWrite.vue';
import NoticeModify from '@/components/notice/NoticeModify.vue';

import HomePrice from '@/views/HomePrice.vue';
import DealList from '@/components/houseDeal/DealList.vue';
import DealDetail from '@/components/houseDeal/DealDetail.vue';
import RentDetail from '@/components/houseDeal/RentDetail.vue';

import Facility from '@/views/Facility.vue';

import ChartPage from '@/components/chart/ChartPage.vue';
import ApartDealAvg from '@/components/chart/ApartDealAvg.vue';

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(() => {
    return window.location.reload();
  });
};

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Main',
    redirect: '/main/',
  },
  {
    path: '/main/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/main/about',
    name: 'About',
    component: About,
  },
  {
    path: '/main/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/main/register',
    name: 'Register',
    component: Register,
  },
  {
    path: '/main/userinfo',
    name: 'UserInfo',
    component: UserInfo,
  },
  {
    path: '/main/findPw',
    name: 'FindPw',
    component: FindPw,
  },
  {
    path: '/main/board/boardList',
    name: 'BoardList',
    component: BoardList,
  },
  {
    path: '/main/board/detail/:bid',
    name: 'BoardDetail',
    component: BoardDetail,
    props: true,
  },
  {
    path: '/main/board/write',
    name: 'BoardWrite',
    component: BoardWrite,
  },
  {
    path: '/main/board/modify/:bid',
    name: 'BoardModify',
    component: BoardModify,
    props: true,
  },
  {
    path: '/main/manage/usermanage',
    name: 'UserManage',
    component: UserManage,
  },
  {
    path: '/main/notice/noticeList',
    name: 'NoticeList',
    component: NoticeList,
  },
  {
    path: '/main/notice/detail/:nid',
    name: 'NoticeDetail',
    component: NoticeDetail,
    props: true,
  },
  {
    path: '/main/notice/write',
    name: 'NoticeWrite',
    component: NoticeWrite,
  },
  {
    path: '/main/notice/modify/:nid',
    name: 'NoticeModify',
    component: NoticeModify,
    props: true,
  },
  {
    path: '/main/price',
    name: 'HomePrice',
    component: HomePrice,
    children: [
      {
        path: '',
        component: DealList,
      },
      {
        path: 'dealDetail',
        component: DealDetail,
      },
      {
        path: 'rentDetail',
        component: RentDetail,
      },
    ],
  },
  {
    path: '/main/facility',
    name: 'Facility',
    component: Facility,
  },
  {
    path: '/main/chartPage',
    name: 'ChartPage',
    component: ChartPage,
  },
  {
    path: '/main/apartAvg',
    name: 'ApartDealAvg',
    component: ApartDealAvg,
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

export default router;
