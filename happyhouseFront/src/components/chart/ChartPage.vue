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
          <b-form-select v-model="gunguCode" @change="setCategory">
            <option value="" disabled selected>군</option>
            <option v-for="(gungu, index) in gunguList" :key="index" :value="gungu.guCode">{{
              gungu.gu
            }}</option>
          </b-form-select>
        </b-col>
        <b-col cols="3" align="left">
          <b-form-select v-model="categoryCode">
            <option value="" disabled selected>--상업--</option>
            <option
              v-for="(category, index) in categoryList"
              :key="index"
              :value="category.large_category_code"
              >{{ category.large_category_name }}</option
            >
            <!-- <option value="R">교육</option> -->
          </b-form-select>
        </b-col>
        <b-col cols="2" align="left">
          <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
        </b-col>
      </b-row>
    </div>
    <div>
      <reactive :chart-data="storeChart"></reactive>
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
      categoryList: [],
      sidoCode: '',
      gunguCode: '',
      categoryCode: '',
      paramList: [],
      storeData: {},
      storeChart: {},
      storelabel: [],
      storedata: [],
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
      if (this.categoryCode == '') {
        alert('선택해주세요');
        return;
      }
      console.log(this.gunguCode.substr(0, 5) + ' ' + this.categoryCode);
      this.storeData = await http
        .get('/store/count/' + this.gunguCode.substr(0, 5) + '/' + this.categoryCode)
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
      console.log(this.storeData);
      this.storelabel = [];
      this.storedata = [];
      for (var i = 0; i < this.storeData.length; i++) {
        this.storelabel.push(this.storeData[i].dong);
        this.storedata.push(this.storeData[i].storeCnt);
      }
      this.storeChart = {
        labels: this.storelabel,
        datasets: [
          {
            label: '상업시설 개수 (TOP10이내)',
            backgroundColor: '#f87979',
            // Data for the x-axis of the chart
            data: this.storedata,
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
    setCategory() {
      http
        .get('/store/category')
        .then(({ data }) => {
          this.categoryList = data;
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
