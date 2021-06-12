<template>
  <b-row class="ml-2">
    <b-col cols="4" align="left">
      <b-form-select v-model="sidoCode" @change="setSido">
        <option value="" disabled selected>도/광역시</option>
        <option v-for="(sido, index) in sidoList" :key="index" :value="sido.cityCode">{{
          sido.city
        }}</option>
      </b-form-select>
    </b-col>
    <b-col cols="3" align="left">
      <b-form-select v-model="gunguCode" @change="setGungu">
        <option value="" disabled selected>군/구</option>
        <option v-for="(gungu, index) in gunguList" :key="index" :value="gungu.guCode">{{
          gungu.gu
        }}</option>
      </b-form-select>
    </b-col>
    <b-col cols="3" align="left">
      <b-form-select v-model="dong">
        <option value="" disabled selected>동</option>
        <option v-for="(dong, index) in dongList" :key="index" :value="dong.dong">{{
          dong.dong
        }}</option>
      </b-form-select>
    </b-col>
    <b-col cols="2" align="left">
      <b-button variant="outline-warning" @click="setDongData">검색</b-button>
    </b-col>
  </b-row>
</template>

<script>
import http from '@/http-common';
import { mapActions } from 'vuex';
export default {
  name: 'FacilitySearchBar',
  data() {
    return {
      sidoCode: '',
      gunguCode: '',
      dong: '',
      sidoList: [],
      gunguList: [],
      dongList: [],
    };
  },
  created() {
    http
      .get('/apart/sido')
      .then(({ data }) => {
        this.sidoList = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  methods: {
    ...mapActions('facility', ['setDong', 'resetFacilityState']),
    setSido() {
      http
        .get('/apart/gu/' + this.sidoCode)
        .then(({ data }) => {
          this.gunguList = data;
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },

    setGungu() {
      http
        .get('/apart/dong/' + this.gunguCode)
        .then(({ data }) => {
          this.dongList = data;
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
    setDongData() {
      this.resetFacilityState();
      this.setDong(this.dong);
    },
  },
};
</script>

<style></style>
