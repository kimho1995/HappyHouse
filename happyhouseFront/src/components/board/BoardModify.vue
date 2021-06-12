<template>
  <b-container>
    <b-card elevation="10" outlined width="100%" class="mx-auto">
      <b-card-title> <span>Detail</span><br /><br /> </b-card-title>
      <b-card-text>
        <b-row>
          <b-col
            ><b-input-group :key="sm" :size="sm" class="mb-3" prepend="제목">
              <b-form-input id="title" v-model="info.title"></b-form-input
            ></b-input-group>
            <br /><br />
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
          <b-form-textarea
            id="textarea-rows"
            v-model="info.content"
            placeholder="Tall textarea"
            rows="8"
          ></b-form-textarea>
        </b-card>
      </b-card-text>
      <b-button type="button" variant="primary" @click="modifyBoard">수정</b-button>
      <b-button type="button" variant="info" @click="moveList">목록</b-button>
    </b-card>
  </b-container>
</template>

<script>
import http from '@/http-common';
export default {
  name: 'BoardDetail',
  props: ['bid'],
  data() {
    return {
      aspect: '16:9',
      title: '',
      content: '',
      info: {},
    };
  },
  methods: {
    modifyBoard() {
      this.title = document.getElementById('title').value;
      this.content = document.getElementById('textarea-rows').value;
      http
        .put('/updateBoard', {
          bid: this.bid,
          title: this.title,
          content: this.content,
        })
        .then((response) => {
          console.log(response.data);
          if (response.data.count == true || response.data.count == 'true') {
            alert('성공적으로 수정 하였습니다.');
            this.moveList();
          } else {
            alert('수정 하지 못했습니다.');
          }
        })
        .catch(() => {
          alert('수정 하지 못했습니다.');
        });
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
