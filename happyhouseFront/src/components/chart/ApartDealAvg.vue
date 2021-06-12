<template>
  <div class="_str">
    <div class="container">
      <b-row class="ml-2">
        <b-col cols="4" align="left">
          <b-form-select v-model="sidoCode" @change="setGungu">
            <option value="" disabled selected>도/광역시</option>
            <option v-for="(sido, index) in sidoList" :key="index" :value="sido.cityCode">{{
              sido.city
            }}</option>
          </b-form-select>
        </b-col>
        <b-col cols="3" align="left">
          <b-form-select v-model="gunguCode">
            <option value="" disabled selected>군</option>
            <option v-for="(gungu, index) in gunguList" :key="index" :value="gungu.guCode">{{
              gungu.gu
            }}</option>
          </b-form-select>
        </b-col>
        <b-col cols="3" align="left">
          <b-form-input type="number" v-model="dealYear" placeholder="년도 입력"></b-form-input>
        </b-col>
        <b-col cols="2" align="left">
          <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
        </b-col>
      </b-row>
    </div>
    <div>
      <h3>아파트 가격 거래평균 상위 Top5</h3>
      <reactive :chart-data="aptDescChart"></reactive>
    </div>
    <div>
      <h3>아파트 가격 거래평균 하위 Top5</h3>
      <reactive :chart-data="aptAscChart"></reactive>
    </div>
  </div>
</template>

<script>
import http from '@/http-common';
import Reactive from '@/components/chart/Reactive';
export default {
  name: 'ChartPage',
  components: {
    Reactive,
  },
  data() {
    return {
      sidoList: [],
      gunguList: [],
      sidoCode: '',
      gunguCode: '',
      dealYear: '',
      aptDealDescData: {},
      aptDealAscData: {},
      aptDescChart: {},
      aptAscChart: {},
      aptDealDesclabel: [],
      aptDealDescdata: [],
      aptDealAsclabel: [],
      aptDealAscdata: [],
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
    async sendKeyword() {
      if (this.sidoCode == '') {
        alert('선택해주세요');
        return;
      }
      if (this.gunguCode == '') {
        alert('선택해주세요');
        return;
      }
      if (this.dealYear == '') {
        alert('선택해주세요');
        return;
      }
      console.log(this.gunguCode.substr(0, 5) + ' ' + this.dealYear);
      this.aptDealDescData = await http
        .get('/apart/findAvgDesc/' + this.gunguCode.substr(0, 5) + '/' + this.dealYear)
        .then((response) => {
          console.log(response.data);
          if (response.data == '') {
            alert('목록이 없습니다');
          } else {
            return response.data;
          }
        })
        .catch(() => {
          console.log('목록 불러오기 실패.');
        });

      this.aptDealAscData = await http
        .get('/apart/findAvgAsc/' + this.gunguCode.substr(0, 5) + '/' + this.dealYear)
        .then((response) => {
          console.log(response.data);
          if (response.data == '') {
            alert('목록이 없습니다');
          } else {
            return response.data;
          }
        })
        .catch(() => {
          console.log('목록 불러오기 실패.');
        });

      this.fillData();
    },
    fillData() {
      this.aptDealDesclabel = [];
      this.aptDealDescdata = [];
      this.aptDealAsclabel = [];
      this.aptDealAscdata = [];
      for (var i = 0; i < this.aptDealDescData.length; i++) {
        this.aptDealDesclabel.push(this.aptDealDescData[i].dong);
        this.aptDealDescdata.push(this.aptDealDescData[i].dealAmountAvg);
        this.aptDealAsclabel.push(this.aptDealAscData[i].dong);
        this.aptDealAscdata.push(this.aptDealAscData[i].dealAmountAvg);
      }
      console.log('test --> ' + this.aptDealDescdata);
      this.aptDescChart = {
        labels: this.aptDealDesclabel,
        datasets: [
          {
            label: '동별 아파트 평균 가격(만원)',
            backgroundColor: '#f87979',
            // Data for the x-axis of the chart
            data: this.aptDealDescdata,
          },
        ],
      };

      this.aptAscChart = {
        labels: this.aptDealAsclabel,
        datasets: [
          {
            label: '동별 아파트 평균 가격(만원)',
            backgroundColor: '#f87979',
            // Data for the x-axis of the chart
            data: this.aptDealAscdata,
          },
        ],
      };
    },

    setGungu() {
      console.log(this.sidoCode);
      http
        .get('/apart/gu/' + this.sidoCode)
        .then(({ data }) => {
          this.gunguList = data;
        })
        .catch(() => {
          alert('에러가 발생했습니다.');
        });
    },
  },
};
</script>

<style scope>
._str {
  min-height: 660px;
}
</style>
