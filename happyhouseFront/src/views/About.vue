<template>
  <b-container class="bv-example-row">
    <b-row>
      <b-col>
        <div>
          <b-jumbotron header="Happy House" lead="행복한 우리집 만들기">
            <p>SSAFY Happy House Project</p>
            <b-button variant="primary" @click="goHome">Home</b-button>
          </b-jumbotron>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
export default {
  name: 'About',
  methods: {
    goHome() {
      this.$router.push('/');
    },
  },
};
</script>
