<template>
  <div class="container _nwr">
    <b-card>
      <h2>공지글 작성</h2>
      <div class="form-group">
        <label for="title">제목</label>
        <input
          type="text"
          class="form-control"
          id="title"
          ref="title"
          placeholder="제목을 입력하세요"
          v-model="title"
        />
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <textarea
          type="text"
          class="form-control"
          id="contnet"
          ref="content"
          placeholder="내용을 입력하세요"
          v-model="content"
        ></textarea>
      </div>
      <div class="text-right">
        <button class="btn btn-primary" @click="writeSubmit">
          등록
        </button>
        <button class="btn btn-primary" @click="moveList">목록</button>
      </div>
    </b-card>
  </div>
</template>

<script>
import http from '@/http-common';
import { mapGetters } from 'vuex';
export default {
  name: 'NoticeWrite',
  data() {
    return {
      title: '',
      content: '',
    };
  },
  computed: {
    ...mapGetters(['getProfile']),
  },
  methods: {
    writeSubmit() {
      if (this.title == '') {
        alert('제목을 입력하세요.');
        return;
      }
      if (this.content == '') {
        alert('내용을 입력하세요.');
        return;
      }
      http
        .post('/notice', {
          userid: this.getProfile.userid,
          title: this.title,
          content: this.content,
        })
        .then((response) => {
          console.log(response);
          if (response.data.count == -1) {
            alert('공지글 등록 실패');
          } else {
            alert('공지글 등록 성공');
            this.moveList();
          }
        })
        .catch(() => {
          console.log('공지글 등록 실패.');
        });
    },
    moveList() {
      this.$router.push('/main/notice/noticeList');
    },
  },
};
</script>

<style>
.container {
  padding: 100px;
}
._nwr {
  min-height: 650px;
}
</style>
