<template>
  <div class="container">
    <!-- <h1>회원 정보</h1> -->
    <b-form @submit.prevent="submitForm">
      <b-card bg-variant="light">
        <b-form-group
          label-cols-lg="4"
          label="회원정보 수정"
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
            <b-form-input id="userid" v-model="this.getProfile.userid" readonly></b-form-input>
          </b-form-group>

          <b-form-group
            label="이름:"
            label-for="nested-username"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="username" :value="this.getProfile.username" required></b-form-input>
          </b-form-group>

          <b-form-group
            label="비밀번호:"
            label-for="nested-password"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input type="password" id="password"></b-form-input>
          </b-form-group>

          <b-form-group
            label="이메일:"
            label-for="nested-email"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="email" :value="this.getProfile.email" required></b-form-input>
          </b-form-group>
          <b-form-group
            label="전화번호:"
            label-for="nested-phone"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="phone" :value="this.getProfile.number" required></b-form-input>
          </b-form-group>
          <b-form-group
            label="주소:"
            label-for="nested-address"
            label-cols-sm="2"
            label-align-sm="right"
          >
            <b-form-input id="address" :value="this.getProfile.address" required></b-form-input>
          </b-form-group>
          <b-button type="submit" variant="primary">회원수정</b-button> |
          <b-button type="button" variant="danger" @click="deleteUser">회원탈퇴</b-button>
        </b-form-group>
      </b-card>
    </b-form>
  </div>
</template>

<script>
import http from '@/http-common';
import { mapGetters, mapActions } from 'vuex';
export default {
  name: 'Register',
  data() {
    return {
      userid: '',
      username: '',
      password: '',
      email: '',
      phone: '',
      address: '',
    };
  },
  methods: {
    ...mapActions(['logout']),
    submitForm() {
      this.username = document.getElementById('username').value;
      this.email = document.getElementById('email').value;
      this.password = document.getElementById('password').value;
      this.phone = document.getElementById('phone').value;
      this.address = document.getElementById('address').value;
      if (this.username == '') {
        alert('이름을 입력하세요.');
        return;
      }
      if (this.email == '') {
        alert('이메일을 입력하세요.');
        return;
      }
      if (this.password == '') {
        this.password = this.getProfile.password;
      }
      if (this.phone == '') {
        alert('전화번호 입력하세요.');
        return;
      }
      if (this.address == '') {
        alert('주소를 입력하세요.');
        return;
      }
      alert(this.username);
      // alert(this.getProfile.username);
      http
        .put('/user', {
          userid: this.getProfile.userid,
          username: this.username,
          password: this.password,
          email: this.email,
          number: this.phone,
          address: this.address,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data != '') {
            alert('성공적으로 수정 하였습니다.');
            // store에서도 값을 변경해주어야됨
            this.logout();
            this.$router.push('/');
          } else {
            alert('수정을 하지 못했습니다.');
          }
        })
        .catch(() => {
          alert('수정을 하지 못했습니다.');
        });
    },
    deleteUser() {
      var isDelete = confirm('탈퇴하겠습니까?');
      if (isDelete) {
        http
          .delete('/user/' + this.getProfile.userid)
          .then((response) => {
            console.log(response.data);
            if (response.data.count == true || response.data.count == 'true') {
              alert('성공적으로 탈퇴 하였습니다.');
              // store에서도 값을 변경해주어야됨
              this.logout();
              this.$router.push('/');
            } else {
              alert('탈퇴 하지 못했습니다.');
            }
          })
          .catch(() => {
            alert('탈퇴 하지 못했습니다.');
          });
      }
    },
  },
  computed: {
    ...mapGetters(['getProfile']),
  },
};
</script>

<style></style>
