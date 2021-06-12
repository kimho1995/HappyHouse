<template>
<b-container v-if="rent.jibun" class="bv-example-row mt-2 ml-2 padding-top">
        <b-row>
        <b-col><h3>{{ rent.name }}</h3></b-col>
        </b-row>
        <b-row v-if="rent.rentMoney != 0">
        <b-col>
            <b-alert show variant="danger"
            >월세 : {{ (rent.rentMoney.replace(',', '') * 10000) | price }}원</b-alert
            >
        </b-col>
        <b-col>
            <b-alert show variant="danger"
            >보증금 : {{ (rent.deposit.replace(',', '') * 10000) | price }}원</b-alert
            >
        </b-col>
        </b-row>
        <b-row v-else>
        <b-col>
            <b-alert show variant="danger"
            >전세(보증금) : {{ (rent.deposit.replace(',', '') * 10000) | price }}원</b-alert>
        </b-col>
        </b-row>
        <b-row>
        <b-col>
            <b-alert show variant="primary">아파트/주택 명 : {{ rent.name }}</b-alert>
        </b-col>
            <b-row>
            <b-col>
                <b-alert show variant="warning">층수 : {{ rent.floor }}층</b-alert>
            </b-col>
            </b-row>
        </b-row>
         <b-row>
            <b-col>
                <b-alert show variant="warning">전용 면적 / 평 : {{ rent.area }} ㎡ /  {{ Math.round(this.rent.area/3.3057) }} 평 </b-alert>
            </b-col>
        </b-row>
        <b-row>
        <b-col>
            <b-alert show variant="info">법정동 : {{ rent.dong }}</b-alert>
        </b-col>
        </b-row>
        <b-row>
        <b-col>
            <b-alert show variant="secondary">건축 년도 : {{ rent.buildYear }} 년</b-alert>
        </b-col>
            <b-row>
            <b-col>
                <b-alert show variant="secondary">거래 일자 : {{ rent.dealYear }}/ {{ rent.dealMonth }}/ {{ rent.dealDay }}</b-alert>
            </b-col>
            </b-row>
        </b-row>
    <b-button variant="outline-warning" @click="goBack">이전</b-button>
</b-container>
<b-container v-else class="bv-example-row mt-3">
    <b-row>
    <b-col><b-alert show>거래 정보를 불러오지 못했습니다.</b-alert></b-col>
    </b-row>
</b-container>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
    name: 'RentDetail',
    created(){ 
        console.log("Rent - detail 화면!!");
    },
    computed: {
        ...mapGetters('deal',{
            rent : 'getRent'
        }),
    },
    methods:{
        goBack(){
            this.$router.go(-1);
        }
    },
    filters: {
        price(value) {
        if (!value) return value;
        return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        },
    },
}
</script>

<style>

</style>