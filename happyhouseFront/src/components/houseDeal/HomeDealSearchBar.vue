<template>
  <div id="search_container">
    <b-row class="ml-2 mb-3">
      <b-col cols="5" align="left">
        <b-button-group>
          <b-button variant="warning" value="apart" @click="setHouseType">아파트</b-button>
          <b-button variant="warning" value="house" @click="setHouseType">빌라</b-button>
          <b-button variant="warning" value="office" @click="setHouseType">오피스텔</b-button>
        </b-button-group>
      </b-col>
      <b-col cols="3"></b-col>
      <b-col cols="4">
        <b-button-group>
          <b-button variant="warning" value="deal" @click="setHousePay">매매</b-button>
          <b-button variant="warning" value="deposit" @click="setHousePay">전세</b-button>
          <b-button variant="warning" value="rent" @click="setHousePay">월세</b-button>
        </b-button-group>
      </b-col>
    </b-row>
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
        <b-form-select v-model="dong" @change="setDongData">
          <option value="" disabled selected>동</option>
          <option v-for="(dong, index) in dongList" :key="index" :value="dong.dong">{{
            dong.dong
          }}</option>
        </b-form-select>
      </b-col>
      <b-col cols="2" align="left">
        <b-button variant="outline-warning" @click="sendKeyword">검색</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
import http from '@/http-common';

export default {
  name: 'SearchBar',
  data() {
    return {
      sidoList: [],
      gunguList: [],
      dongList: [],
      sidoCode: '',
      gunguCode: '',
      dong: '',
      type: '',
      pay: '',
      paramList: [],
    };
  },
  created() {
    this.sidoCode = this.getSidoCode();
    this.gunguCode = this.getGunguCode();
    this.dong = this.getDong();
    this.type = this.getType();
    this.pay = this.getPay();

    http
      .get('/apart/sido')
      .then(({ data }) => {
        this.sidoList = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    if (this.sidoCode == '') {
      return;
    }
    http
      .get('/apart/gu/' + this.sidoCode)
      .then(({ data }) => {
        this.gunguList = data;
        console.log(data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    http
      .get('/apart/dong/' + this.gunguCode)
      .then(({ data }) => {
        this.dongList = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  methods: {
    ...mapActions('deal', [
      'setType',
      'setPay',
      'setSidoCode',
      'setGunguCode',
      'setDong',
      'getAptDealList',
      'getAptRentList',
      'getHomeDealList',
      'getHomeRentList',
      'getOfficeDealList',
      'getOfficeRentList',
    ]),
    ...mapGetters('deal', ['getType', 'getPay', 'getSidoCode', 'getGunguCode', 'getDong']),
    sendKeyword() {
      if (this.sidoCode == '' || this.gunguCode == '' || this.dong == '') {
        alert('도/군/동을 입력해주세요');
        return;
      }
      if (this.type == '') {
        this.type = 'apart';
      }
      if (this.pay == '') {
        this.pay = 'deal';
      }
      /* 아파트 */
      if (this.sidoCode && this.type == 'apart' && this.pay == 'deal') {
        // 매매
        this.paramList = [this.gunguCode, this.dong, 1];
        this.getAptDealList(this.paramList);
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'rent') {
        // 월세
        this.paramList = [1, this.gunguCode, this.dong, 1];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'deposit') {
        // 전세
        this.paramList = [2, this.gunguCode, this.dong, 1];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deal') {
        /* 연립 다세대 */
        // 매매
        this.paramList = [this.gunguCode, this.dong, 1];
        this.getHomeDealList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'rent') {
        // 월세
        this.paramList = [1, this.gunguCode, this.dong, 1];
        this.getHomeRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deposit') {
        // 전세
        this.paramList = [2, this.gunguCode, this.dong, 1];
        this.getHomeRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'deal') {
        /* 오피스텔 */
        // 매매
        this.paramList = [this.gunguCode, this.dong, 1];
        this.getOfficeDealList(this.paramList);
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'rent') {
        // 월세
        this.paramList = [1, this.gunguCode, this.dong, 1];
        this.getOfficeRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'deposit') {
        // 전세
        this.paramList = [2, this.gunguCode, this.dong, 1];
        this.getOfficeRentList(this.paramList);
      }
      if (this.$route.name == 'Home') this.$router.push('/main/price');
      else this.$router.this.$router.go();
    },
    setHouseType: function(event) {
      var thisBtn = event.currentTarget;
      thisBtn.classList.add('active');
      let sibling = thisBtn.parentNode.firstChild;

      while (sibling) {
        if (sibling.nodeType === 1 && sibling !== thisBtn) {
          sibling.classList.remove('active');
        }
        sibling = sibling.nextSibling;
      }
      this.type = event.currentTarget.value;
      // store에 저장
      this.setType(this.type);
    },
    setHousePay: function(event) {
      var thisBtn = event.currentTarget;
      thisBtn.classList.add('active');
      let sibling = thisBtn.parentNode.firstChild;

      while (sibling) {
        if (sibling.nodeType === 1 && sibling !== thisBtn) {
          sibling.classList.remove('active');
        }
        sibling = sibling.nextSibling;
      }
      this.pay = event.currentTarget.value;

      // store에 저장
      this.setPay(this.pay);
    },
    setSido() {
      http
        .get('/apart/gu/' + this.sidoCode)
        .then(({ data }) => {
          this.gunguList = data;
          console.log(data);
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
      // store에 저장
      this.setSidoCode(this.sidoCode);
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
      // store에 저장
      this.setGunguCode(this.gunguCode);
    },
    setDongData() {
      // store에 저장
      this.setDong(this.dong);
    },
  },
};
</script>

<style>
#search_container {
  font-weight: bold;
}
</style>
