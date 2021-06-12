<template>
    <b-list-group-item v-if="deal && deal.length != 0"
        class="flex-column align-items-start"
        @mouseover="colorChange(true)"
        @mouseout="colorChange(false)"
        @click="chooseDeal"
        :class="{ 'mouse-over-bgcolor': isColor }"
    >
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1"> 매매 {{ deal.dealAmount}} 만원</h5>
      <small>{{ Math.round(this.deal.area/3.3057) }} 평 </small>
    </div>
    <div >
        {{ deal.name }} [ {{ deal.floor}} 층 ]
    </div>
    </b-list-group-item>
    <b-list-group-item v-else-if="rent && rent.length != 0"
        class="m-2 row"
        @mouseover="colorChange(true)"
        @mouseout="colorChange(false)"
        @click="chooseRent"
        :class="{ 'mouse-over-bgcolor': isColor }"
    >
    <div v-if="rent.rentMoney == 0" class="d-flex w-100 justify-content-between">
       <h5 class="mb-1"> 전세 {{ rent.deposit}} 만원</h5>
       <small>{{ Math.round(this.rent.area/3.3057) }} 평 </small>
    </div>
    <div v-else class="d-flex w-100 justify-content-between">
        <h5 class="mb-1">월세 {{ rent.rentMony }} / 보증금 {{ rent.deposit }}만원</h5>
        <small>{{ Math.round(this.rent.area/3.3057) }} 평</small>
    </div>
    <div cols="5" >
        {{ rent.name }} [ {{ rent.floor}}층 ]
    </div>
    </b-list-group-item>
</template>

<script>
import { mapActions } from 'vuex';
export default {
    name: 'DealListItem',
    data() {
        return {
        isColor: false,
        };
    },
    props: {
        deal: {},
        rent: {}
    },
    methods: {
        ...mapActions('deal',['selectDeal','selectRent']),
        chooseDeal() {
            this.selectDeal(this.deal);
            this.$router.push('/main/price/dealDetail');
        },
        chooseRent() {
            this.selectRent(this.rent);
            this.$router.push('/main/price/rentDetail');
        },
        colorChange(flag) {
        this.isColor = flag;
        },
    },
}
</script>

<style scoped>
.img-list {
    width: 100px;
}
.mouse-over-bgcolor {
    background-color: lightblue;
}
</style>