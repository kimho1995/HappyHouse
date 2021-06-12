<template>
  <div class="_notice">
    <h1>공지사항</h1>
<!--   
    <div class="search">
      <b-input-group>
        <b-input-group-prepend>
          <b-form-select v-model="selected" class="mb-3">
            <template #first>
              <b-form-select-option :value="null">-- 선택 --</b-form-select-option>
            </template>
            <b-form-select-option value="title">제목</b-form-select-option>
            <b-form-select-option value="content">내용</b-form-select-option>
          </b-form-select>
        </b-input-group-prepend>
        <b-form-input type="text" v-model="searchText"></b-form-input>
        <b-input-group-append>
          <b-button variant="outline-secondary" @click="searchBoard">검색</b-button>
        </b-input-group-append>
      </b-input-group>
    </div> -->
    <b-row class="mr-1 mt-5 mb-3">
     <b-col cols="10" align = "left">
       <b-button variant="outline-secondary" v-show="user" class="mt-2 mb-2 ml-2" @click="writeBoard">글쓰기</b-button>
     </b-col>
     <b-col cols="2">
       <b-input-group>
       <b-input-group-prepend>
      <b-form-select v-model="selected">
          <option value=null >-- 선택 --</option>
          <option value="title" >제목</option>
          <option value="content">내용</option>
      </b-form-select>
    </b-input-group-prepend>

    <b-form-input type="text" v-model="searchText"></b-form-input>

    <b-input-group-append>
      <b-button variant="outline-secondary"  @click="searchBoard">검색</b-button>
    </b-input-group-append>
    </b-input-group>
     </b-col>
   </b-row>
    <b-table
      striped
      hover
      :items="items"
      :current-page="currentPage"
      :fields="fields"
      @row-clicked="rowClick"
    ></b-table>
    <b-button class="_writebtn" @click="writeBoard" v-if="this.getProfile.rolename == 'ROLE_ADMIN'"
      >글쓰기</b-button
    >
    <b-pagination
      v-model="currentPage"
      :total-rows="totalPage"
      :per-page="perPage"
      align="center"
      @page-click="nextList"
    ></b-pagination>
  </div>
</template>

<script>
import http from '@/http-common';
import { mapGetters } from 'vuex';
export default {
  name: 'NoticeList',
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      totalPage: '',
      searchText: '',
      selected: null,
      fields: [
        {
          key: 'nid',
          label: '번호',
        },
        {
          key: 'title',
          label: '제목',
        },
        {
          key: 'userid',
          label: '글쓴이',
        },
        {
          key: 'created_at',
          label: '작성일',
        },
      ],
      items: {},
    };
  },
  methods: {
    nextList(button, page) {
      console.log(page);
      http
        .get('/notice/', {
          params: {
            currentPage: page,
          },
        })
        .then((response) => {
          console.log(response);
          if (response.data == '') {
            alert('공지글이 없습니다');
          } else {
            this.items = response.data;
          }
        })
        .catch(() => {
          console.log('공지글 불러오기 실패.');
        });
    },
    rowClick(item) {
      console.log(item.bid);
      this.$router.push({
        path: `/main/notice/detail/${item.nid}`,
      });
    },
    writeBoard() {
      this.$router.push('/main/notice/write');
    },
    searchBoard() {
      if (this.selected == null) {
        alert('선택해주세요');
        return;
      }
      if (this.searchText == '') {
        alert('내용을 입력해주세요');
        return;
      }
      http
        .get('/notice/', {
          params: {
            key: this.selected,
            word: this.searchText,
          },
        })
        .then((response) => {
          console.log(response);
          if (response.data == '') {
            alert('공지글이 없습니다');
          } else {
            this.items = response.data;
          }
        })
        .catch(() => {
          console.log('공지글 불러오기 실패.');
        });

      http
        .get('/notice/total/', {
          params: {
            key: this.selected,
            word: this.searchText,
          },
        })
        .then((response) => {
          console.log(response);
          if (response.data.count != -1) {
            console.log(response.data);
            this.totalPage = response.data.count;
          } else {
            alert('불러오기 실패');
          }
        })
        .catch(() => {
          console.log('공지글 불러오기 실패.');
        });
    },
  },
  mounted() {
    http
      .get('/notice')
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('공지글이 없습니다');
        } else {
          this.items = response.data;
        }
      })
      .catch(() => {
        console.log('공지글 불러오기 실패.');
      });

    http
      .get('/notice/total')
      .then((response) => {
        console.log(response);
        if (response.data.count != -1) {
          console.log(response.data);
          this.totalPage = response.data.count;
        } else {
          alert('불러오기 실패');
        }
      })
      .catch(() => {
        console.log('공지글 불러오기 실패.');
      });
  },
  computed: {
    ...mapGetters(['getProfile']),
  },
};
</script>

<style scope>
._writebtn {
  margin-right: 20px;
  float: right;
}
.search {
  padding-left: 80%;
}
._notice {
  margin-top: 50px;
  min-height: 610px;
}
</style>
