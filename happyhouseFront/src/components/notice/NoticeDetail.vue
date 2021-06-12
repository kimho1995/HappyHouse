<template>
  <b-container>
    <b-card elevation="10" outlined width="100%" class="mx-auto">
      <b-card-title> <span>Detail</span><br /><br /> </b-card-title>
      <b-card-text>
        <b-row>
          <b-col :style="{ fontSize: '20px' }"
            >제목: <strong :style="{ fontSize: '30px' }">{{ info.title }}</strong> <br /><br />
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            작성자: <strong>{{ info.userid }}</strong>
          </b-col>
          <b-col>
            등록일: <strong>{{ info.created_at }}</strong
            ><br /><br />
          </b-col>
        </b-row>
        Content<br /><br />
        <b-card>
          <b-aspect :aspect="aspect">
            {{ info.content }}
          </b-aspect>
        </b-card>
      </b-card-text>
      <b-button
        type="button"
        variant="primary"
        v-if="this.getProfile.rolename == 'ROLE_ADMIN'"
        @click="modifyNotice"
        >수정</b-button
      >
      <b-button
        type="button"
        variant="danger"
        v-if="this.getProfile.rolename == 'ROLE_ADMIN'"
        @click="deleteNotice"
        >삭제</b-button
      >
      <b-button type="button" variant="info" @click="moveList">목록</b-button>
    </b-card>
  </b-container>
</template>

<script>
import http from '@/http-common';
import { mapGetters } from 'vuex';
export default {
  name: 'NoticeDetail',
  props: ['nid'],
  data() {
    return {
      aspect: '16:9',
      info: {},
    };
  },
  computed: {
    ...mapGetters(['getProfile']),
  },
  methods: {
    modifyNotice() {
      this.$router.push('/main/notice/modify/' + this.nid);
    },
    deleteNotice() {
      var isDelete = confirm('삭제하겠습니까?');
      if (isDelete) {
        http
          .delete('/notice/' + this.nid)
          .then((response) => {
            console.log(response.data);
            if (response.data.count == true || response.data.count == 'true') {
              alert('성공적으로 삭제 하였습니다.');
              this.moveList();
            } else {
              alert('삭제 하지 못했습니다.');
            }
          })
          .catch(() => {
            alert('삭제 하지 못했습니다.');
          });
      }
    },
    moveList() {
      this.$router.push('/main/notice/noticeList');
    },
  },
  mounted() {
    http
      .get('/notice/' + this.nid)
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('공지글이 없습니다');
        } else {
          this.info = response.data;
        }
      })
      .catch(() => {
        console.log('공지글 불러오기 실패.');
      });
  },
};
</script>

<style></style>
