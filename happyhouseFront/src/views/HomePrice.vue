<template>
  <div class="bv-example-row">
    <b-row class="mt-4">
      <b-col cols="5" align="left">
        <search-bar />
        <router-view/>
      </b-col>
      <b-col cols="7">
        <deal-map />
      </b-col>
    </b-row>
  </div>
</template>

<script>
import SearchBar from '@/components/houseDeal/HomeDealSearchBar.vue';
import DealMap from '@/components/houseDeal/DealMap.vue';
export default {
    name: 'HomePrice',
    components: {
        SearchBar,
        DealMap
    },
    data() {
    return {};
    } ,
    methods: {},
}
</script>
<style>
.padding-top{
  padding-top: 25px;
}
</style>