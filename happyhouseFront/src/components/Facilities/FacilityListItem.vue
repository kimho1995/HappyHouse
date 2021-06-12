<template>
    <b-list-group-item
        class="flex-column align-items-start"
    >
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">{{item.place_name}}</h5>
      <small> {{item.phone}} </small>
    </div>
    <div >
       <h8>{{item.address_name}}</h8>
    </div>
    </b-list-group-item>
</template>

<script>
export default {
    name:'FacilityListItem',
    props:{
        item: {}
    },

}
</script>

<style>

</style>