<template>
  <div class="ml-3">
    <b-list-group v-if="deals && deals.length != 0" class="mt-1 padding-top">
      <deal-list-item v-for="(deal, index) in deals" :key="index" :deal="deal" />
    </b-list-group>
    <b-list-group v-else-if="rents && rents.length != 0" class="mt-1 padding-top">
      <deal-list-item v-for="(rent, index) in rents" :key="index" :rent="rent" />
    </b-list-group>
    <b-container v-else class="mt-1 padding-top">
      <b-row>
        <b-col><b-alert show variant="warning">거래 정보가 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
    <b-pagination
      v-model="currentPage"
      :total-rows="totalPage"
      :per-page="perPage"
      align="center"
      @page-click="pageClick"
    ></b-pagination>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import DealListItem from '@/components/houseDeal/DealListItem.vue';
import http from '@/http-common';

export default {
  name: 'DealList',
  data() {
    return {
      currentPage: 1,
      perPage: 10,
      totalPage: '',
      paramList: [],
    };
  },
  created() {
    this.getTotPage();
  },
  watch: {
    deals: function() {
      this.getTotPage();
    },
    rents: function() {
      this.getTotPage();
    },
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

    pageClick: function(button, page) {
      this.currentPage = page;
      this.sendKeyword();
    },
    sendKeyword() {
      /* 아파트 */
      if (this.sidoCode && this.type == 'apart' && this.pay == 'deal') {
        // 매매
        this.paramList = [this.gunguCode, this.dong, this.currentPage];
        this.getAptDealList(this.paramList);
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'rent') {
        // 월세
        this.paramList = [1, this.gunguCode, this.dong, this.currentPage];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'deposit') {
        // 전세
        this.paramList = [2, this.gunguCode, this.dong, this.currentPage];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deal') {
        /* 연립 다세대 */
        // 매매
        this.paramList = [this.gunguCode, this.dong, this.currentPage];
        this.getHomeDealList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'rent') {
        // 월세
        this.paramList = [1, this.gunguCode, this.dong, this.currentPage];
        this.getHomeRentList(this.paramList);
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deposit') {
        // 전세
        this.paramList = [2, this.gunguCode, this.dong, this.currentPage];
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
    },
    getTotPage() {
      var url = '';
      /* 아파트 */
      if (this.sidoCode && this.type == 'apart' && this.pay == 'deal') {
        // 매매
        url = '/getTotCntAptDeal/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'rent') {
        // 월세
        url = '/getTotCntAptRent/' + 1 + '/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'apart' && this.pay == 'deposit') {
        // 전세
        url = '/getTotCntAptRent/' + 2 + '/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deal') {
        /* 연립 다세대 */
        // 매매
        url = '/getTotCntHomeDeal/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'rent') {
        // 월세
        url = '/getTotCntHomeRent/' + 1 + '/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'house' && this.pay == 'deposit') {
        // 전세
        url = '/getTotCntHomeRent/' + 2 + '/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'deal') {
        /* 오피스텔 */
        // 매매
        url = '/getTotCntOfficeDeal/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'rent') {
        // 월세
        url = '/getTotCntOfficeRent/' + 1 + '/' + this.gunguCode + '/' + this.dong;
      } else if (this.sidoCode && this.type == 'office' && this.pay == 'deposit') {
        // 전세
        url = '/getTotCntOfficeRent/' + 2 + '/' + this.gunguCode + '/' + this.dong;
      }

      http
        .get(url)
        .then((response) => {
          this.totalPage = response.data;
        })
        .catch(() => {
          console.log(url);
          console.log('페이지 처리 실패');
        });
    },
  },
  components: {
    DealListItem,
  },
  computed: {
    ...mapGetters('deal', {
      deals: 'getDealList',
      rents: 'getRentList',
      type: 'getType',
      pay: 'getPay',
      sidoCode: 'getSidoCode',
      gunguCode: 'getGunguCode',
      dong: 'getDong',
    }),
  },
};
</script>

<style scoped></style>
