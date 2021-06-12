<template>
  <!-- <b-container class="bv-example-row">
    <h3>asdfdasfa</h3>
    <Main />
  </b-container> -->
  <div>
    <Main />
  </div>
</template>

<script>
// @ is an alias to /src
import Main from '@/components/Main.vue';

export default {
  name: 'Home',
  components: {
    Main,
  },
};
</script>
