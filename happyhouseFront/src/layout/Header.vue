<template>
  <div class="main">
    <!-- <img :src="require(`@/assets/title.png`)" id="_img" /> -->
    <!-- <h1>HappyHouse</h1> -->
    <b-navbar toggleable="lg" type="light" variant="warning">
      <b-navbar-brand href="#" @click="moveToMain" class="_nav"
        ><b-icon icon="house-fill" scale="1.25" shift-v="1.25" aria-hidden="true"></b-icon> HOME
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item href="#" class="_nav" @click="moveToNotice">공지사항</b-nav-item>
          <b-nav-item href="#" class="_nav" @click="moveToBoard"> 게시판</b-nav-item>
          <b-nav-item-dropdown class="_nav" text="SEARCH" right>
            <b-dropdown-item href="#" @click="moveToDeal">주택거래정보 </b-dropdown-item>
            <b-dropdown-item href="#" @click="moveToFac">동네주변시설 </b-dropdown-item>
            <b-dropdown-item href="#" @click="moveToStore">상권정보 </b-dropdown-item>
            <b-dropdown-item href="#" @click="moveToAptDealAvg"
              >구별아파트거래평균
            </b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item href="#" v-if="this.getProfile == ''" @click="moveToLogin">로그인</b-nav-item>
          <b-nav-item href="#" v-else @click="onClickLogout">로그아웃</b-nav-item>
          <b-nav-item href="#" v-if="this.getProfile == ''" @click="moveToReg">회원가입</b-nav-item>
          <b-nav-item
            href="#"
            v-if="this.getProfile != '' && this.getProfile.rolename == 'ROLE_USER'"
            @click="moveToInfo"
            >내정보</b-nav-item
          >
          <b-nav-item
            href="#"
            v-if="this.getProfile != '' && this.getProfile.rolename == 'ROLE_ADMIN'"
            @click="moveToManage"
            >유저관리</b-nav-item
          >
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
export default {
  name: 'Header',
  computed: {
    ...mapGetters(['getProfile']),
  },
  methods: {
    ...mapActions(['logout']),
    ...mapActions('deal', ['resetCartStateAll']),
    ...mapActions('facility', ['resetFacilityStateAll']),
    onClickLogout: function() {
      this.logout();
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/');
    },
    moveToMain() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/');
    },
    moveToNotice() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/notice/noticeList');
    },
    moveToBoard() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/board/boardList');
    },
    moveToDeal() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/price');
    },
    moveToLogin() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/login');
    },
    moveToReg() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/register');
    },
    moveToFac() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/facility');
    },
    moveToStore() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/chartPage');
    },
    moveToInfo() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/userinfo');
    },
    moveToManage() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/manage/usermanage');
    },
    moveToAptDealAvg() {
      this.resetCartStateAll();
      this.resetFacilityStateAll();
      this.$router.push('/main/apartAvg');
    },
  },
};
</script>

<style scope>
.main {
  /* margin-top: 30px; */
  font-weight: bold;
}
._nav {
  margin-right: 20px;
}
</style>
