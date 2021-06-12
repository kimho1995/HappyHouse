<template>
  <b-container>

    <b-card outlined width="100%">
      <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1"> Q&A게시판 </h5>
      </div>
    </b-card>

    <b-card  outlined width="100%"  class="text-left">
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
      </b-card-text>
        <b-card>
          <b-aspect :aspect="aspect">
            {{ info.content }}
          </b-aspect>
        </b-card>
      <b-card-text class="text-right mt-2">
      <b-button 
        type="button"
        variant="primary"
        v-if="info.userid == this.getProfile.userid"
        @click="modifyBoard"
        >수정</b-button
      >
      <b-button
        type="button"
        variant="danger"
        v-if="info.userid == this.getProfile.userid"
        @click="deleteBoard"
        >삭제</b-button
      >
      </b-card-text>
    </b-card>
    <comments :bid="bid"/>
    <b-button variant="warning" @click="moveList" size="lg"> 목록 </b-button>
  </b-container>
</template>

<script>
import http from '@/http-common';
import comments from '@/components/comment/comment.vue'
import { mapGetters } from 'vuex';
export default {
  name: 'BoardDetail',
  components:{
      comments
  },
  props: ['bid'],
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
    modifyBoard() {
      this.$router.push('/main/board/modify/' + this.bid);
    },
    deleteBoard() {
      var isDelete = confirm('삭제하겠습니까?');
      if (isDelete) {
        http
          .delete('/board/' + this.bid)
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
      this.$router.push('/main/board/boardList');
    },
  },
  mounted() {
    http
      .get('/board/' + this.bid)
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('게시글이 없습니다');
        } else {
          this.info = response.data;
        }
      })
      .catch(() => {
        console.log('게시글 불러오기 실패.');
      });
  },
};
</script>

<style></style>
