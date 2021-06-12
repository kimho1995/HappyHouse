<template>
  <div class="container">
    <h1>비밀번호 찾기</h1>
    <b-form @submit.prevent="submitForm">
      <b-card bg-variant="light">
        <b-form-group
          label-cols-lg="3"
          label="비밀번호 찾기"
          label-size="lg"
          label-class="font-weight-bold pt-0"
          class="mb-0"
        >
          <b-form-group
            label="아이디:"
            label-for="nested-userid"
            label-cols-sm="3"
            label-align-sm="right"
          >
            <b-form-input id="userid" v-model="userid"></b-form-input>
          </b-form-group>

          <b-form-group
            label="이름:"
            label-for="nested-username"
            label-cols-sm="3"
            label-align-sm="right"
          >
            <b-form-input id="username" v-model="username" required></b-form-input>
          </b-form-group>

          <b-form-group
            label="이메일:"
            label-for="nested-email"
            label-cols-sm="3"
            label-align-sm="right"
          >
            <b-form-input id="email" v-model="email" required></b-form-input>
          </b-form-group>
          <b-button type="submit" variant="primary">비밀번호 찾기</b-button>
        </b-form-group>
      </b-card>
    </b-form>
  </div>
</template>

<script>
import http from '@/http-common';
export default {
  data() {
    return {
      userid: '',
      username: '',
      email: '',
    };
  },
  methods: {
    submitForm() {
      http
        .post('/user/findpw', {
          userid: this.userid,
          username: this.username,
          email: this.email,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.count == true || response.data.count == 'true') {
            alert('해당 이메일로 임시 비밀번호를 보냈습니다.');
            // store에서도 값을 변경해주어야됨
            this.$router.push('/main/login');
          } else {
            alert('등록되어 있는 회원이 아닙니다.');
          }
        })
        .catch(() => {
          alert('등록되어 있는 회원이 아닙니다.');
        });
    },
  },
};
</script>

<style></style>
