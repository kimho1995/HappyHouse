<template>
  <div class="container">
    <!-- <h1>회원 가입</h1> -->
    <b-form @submit.prevent="submitForm">
      <b-card bg-variant="light">
        <b-form-group
          label-cols-lg="4"
          label="회원가입"
          label-size="lg"
          label-class="font-weight-bold pt-0"
          class="mb-0"
        >
          <b-form-group
            label="아이디:"
            label-for="nested-userid"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input
              id="userid"
              v-model="userid"
              type="text"
              @blur="idcheck"
              :state="validation"
              required
            ></b-form-input>
            <b-form-valid-feedback :state="validation">
              사용 가능한 아이디입니다.
            </b-form-valid-feedback>
          </b-form-group>

          <b-form-group
            label="이름:"
            label-for="nested-username"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="username" v-model="username" required></b-form-input>
          </b-form-group>

          <b-form-group
            label="비밀번호:"
            label-for="nested-password"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input type="password" id="password" v-model="password" required></b-form-input>
          </b-form-group>

          <b-form-group
            label="비밀번호 확인:"
            label-for="nested-passwordConfirm"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input
              type="password"
              id="passwordConfirm"
              v-model="passwordConfirm"
              @blur="passcheck"
              :state="pwValidation"
              required
            ></b-form-input>
            <b-form-valid-feedback :state="pwValidation">
              비밀번호가 일치합니다.
            </b-form-valid-feedback>
          </b-form-group>

          <b-form-group
            label="이메일:"
            label-for="nested-email"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="email" v-model="email" required></b-form-input>
          </b-form-group>
          <b-form-group
            label="전화번호:"
            label-for="nested-phone"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="phone" v-model="phone" required></b-form-input>
          </b-form-group>
          <b-form-group
            label="주소:"
            label-for="nested-address"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="address" v-model="address" required></b-form-input>
          </b-form-group>
          <b-button type="submit" block variant="warning">JOIN</b-button>
        </b-form-group>
      </b-card>
    </b-form>
  </div>
</template>

<script>
import http from '@/http-common';
export default {
  name: 'Register',
  data() {
    return {
      userid: '',
      username: '',
      password: '',
      passwordConfirm: '',
      email: '',
      phone: '',
      address: '',
      isvaild: false,
      pwVaild: false,
    };
  },
  methods: {
    idcheck() {
      if (this.userid == '') {
        return;
      }
      http
        .get('user/' + this.userid)
        .then((response) => {
          console.log(response.data);
          if (response.data.count == true) {
            this.isvaild = true;
          } else {
            this.isvaild = false;
            this.userid = '';
          }
        })
        .catch(() => {
          alert('사용할 수 없는 아이디입니다.');
        });
    },
    passcheck() {
      if (this.password == '') return;
      if (this.password == this.passwordConfirm) {
        this.pwVaild = true;
      } else {
        this.pwVaild = false;
        this.password = '';
        this.passwordConfirm = '';
      }
    },
    submitForm() {
      http
        .post('/user', {
          userid: this.userid,
          username: this.username,
          password: this.password,
          email: this.email,
          number: this.phone,
          address: this.address,
        })
        .then((response) => {
          console.log('sdffs');
          console.log(response.data);
          if (response.data.count == true || response.data.count == 'true') {
            alert('성공적으로 가입 하였습니다. 로그인 하십시오.');
            this.$router.push('/main/login');
          } else {
            alert('가입을 하지 못했습니다.');
            this.userid = '';
            this.name = '';
            this.password = '';
            this.passwordConfirm = '';
            this.email = '';
            this.phone = '';
            this.addr = '';
          }
        })
        .catch(() => {
          alert('가입을 하지 못했습니다.');
        });
    },
  },
  computed: {
    validation() {
      return this.isvaild;
    },
    pwValidation() {
      return this.pwVaild;
    },
  },
};
</script>

<style>
</style>
