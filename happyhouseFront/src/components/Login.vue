<template>
  <div class="container">
    <div class="row no-gutter">
      <!-- The image half -->
      <div class="col-md-6 d-none d-md-flex bg-image"></div>
      <!-- The content half -->
      <div class="col-md-6 bg-light">
        <div class="login d-flex align-items-center py-5">
          <!-- Demo content-->
          <div class="container">
            <div class="row">
              <div class="col-lg-10 col-xl-7 mx-auto">
                <h3 class="display-4">로그인</h3>
                <p class="text-muted mb-4"></p>
                <form class="login" @submit.prevent="login(userid, password)">
                  <div class="form-group mb-3">
                    <input
                      type="text"
                      id="_userid"
                      name="id"
                      value
                      data-msg="ID를"
                      size="30"
                      title="아이디"
                      required
                      v-model="userid"
                      placeholder="아이디"
                      autofocus=""
                      class="form-control rounded-pill border-0 shadow-sm px-4"
                    />
                  </div>
                  <div class="form-group mb-3">
                    <input
                      type="password"
                      id="_pwd"
                      name="pwd"
                      value
                      required
                      v-model="password"
                      placeholder="패스워드"
                      size="30"
                      title="패스워드"
                      class="form-control rounded-pill border-0 shadow-sm px-4 text-primary"
                    />
                  </div>
                  <button
                    type="submit"
                    class="btn btn-warning btn-block text-uppercase mb-2 rounded-pill shadow-sm"
                  >
                    login
                  </button>
                  <div class="text-center d-flex justify-content-between mt-4">
                    <p>
                      가입:
                      <b-button variant="link" class="font-italic text-muted" @click="moveToReg"
                        ><u>singup</u></b-button
                      >
                    </p>
                    <p>
                      찾기:
                      <b-button variant="link" class="font-italic text-muted" @click="moveToFind"
                        ><u>findpw</u></b-button
                      >
                    </p>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <!-- End -->
        </div>
      </div>
      <!-- End -->
    </div>
  </div>
</template>

<script>
import http from '@/http-common';
import { mapActions } from 'vuex';
export default {
  name: 'Login',
  data() {
    return {
      userid: '',
      password: '',
      submitted: false,
      profile: [],
    };
  },
  methods: {
    ...mapActions(['getLogin']),
    login: function(userid, password) {
      if (this.userid != null && this.password != null) {
        http
          .post('/user/login', {
            userid: userid,
            password: password,
          })
          .then((response) => {
            console.log(response.data);
            if (response.data == '') {
              alert('아이디/패스워드를 확인해주세요.');
              this.userid = '';
              this.password = '';
            } else {
              this.profile = response.data;
              this.getLogin(this.profile);
              this.$router.push('/');
            }
          })
          .catch(() => {
            console.log('로그인 실패.');
          });
      } else alert('입력바람');
    },
    moveToReg() {
      this.$router.push('/main/register');
    },
    moveToFind() {
      this.$router.push('/main/findPw');
    },
  },
};
</script>

<style scope>
.login,
.image {
  min-height: 100px;
}
.bg-image {
  background-image: url('../assets/login_banner.png');
  background-size: cover;
  background-position: center center;
}
</style>
