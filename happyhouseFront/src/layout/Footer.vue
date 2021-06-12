<template>
  <div id="container">
    <div id="contacts">
      <div id="contacts--contact">
        <p>이메일: {{ mail }}</p>
        <p>전화번호: {{ phone }}</p>
      </div>
      <div id="contacts--social">
        <b-icon icon="twitter"></b-icon>
        <b-icon icon="instagram"></b-icon>
        <b-icon icon="chat"></b-icon>
      </div>
    </div>
    <div id="mentions">
      <p>{{ mention }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Footer',
  data() {
    return {
      mail: 'ssafy@gmail.com',
      phone: '010-1234-5678',
      mention: '2021 | ssafy 5th',
    };
  },
};
</script>

<style scope>
#container {
  bottom: 0;
  position: absolute;
  padding-top: 20px;
  margin-top: 20px;
  width: 100vw;
  color: white;
  background-color: #424242;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#contacts {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
}
#contacts--contact {
  text-align: right;
}
#contacts--social {
  width: 20%;
  display: flex;
  justify-content: space-between;
}
#contacts--social div {
  height: 30px;
  width: 30px;
  background-color: white;
  border-radius: 50%;
}
#mentions p {
  font-size: 0.5em;
}
</style>
