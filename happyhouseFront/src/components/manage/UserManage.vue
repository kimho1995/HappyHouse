<template>
  <div class="_usermanage">
    <h1>유저 관리</h1>
    <!-- <div class="search_box  form-group row">
      <select class="form-control col-sm-1" v-model="searchType">
        <option value="title">제목</option>
        <option value="content">내용</option>
      </select>
      <input class="form-control-plaintext col-sm-6" type="text" name="name" v-model="searchName" />
      <b-button class="_writebtn" @click="writeBoard">검색</b-button>
    </div> -->
    <div class="search">
      <b-input-group>
        <b-input-group-prepend>
          <b-form-select v-model="selected" class="mb-3">
            <!-- This slot appears above the options from 'options' prop -->
            <template #first>
              <b-form-select-option :value="null">-- 선택 --</b-form-select-option>
            </template>

            <!-- These options will appear after the ones from 'options' prop -->
            <b-form-select-option value="userid">아이디</b-form-select-option>
            <b-form-select-option value="address">주소</b-form-select-option>
          </b-form-select>
        </b-input-group-prepend>
        <b-form-input type="text" v-model="searchText"></b-form-input>
        <b-input-group-append>
          <b-button variant="outline-secondary" @click="searchBoard">검색</b-button>
        </b-input-group-append>
      </b-input-group>
    </div>
    <b-table striped hover :items="items" :current-page="currentPage" :fields="fields">
      <template #cell(delete)="row">
        <b-button size="sm" class="mr-2" @click="userDelete(row.item.userid)" variant="danger">
          삭제
        </b-button>
      </template>
    </b-table>
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
export default {
  name: 'UserManage',
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      totalPage: '',
      searchText: '',
      selected: null,
      fields: [
        {
          key: 'userid',
          label: '아이디',
        },
        {
          key: 'username',
          label: '이름',
        },
        {
          key: 'email',
          label: '이메일',
        },
        {
          key: 'number',
          label: '전화번호',
        },
        {
          key: 'address',
          label: '주소',
        },
        {
          key: 'created_at',
          label: '작성일',
        },
        {
          key: 'delete',
          label: '삭제',
        },
      ],
      items: {},
    };
  },
  methods: {
    nextList(button, page) {
      console.log(page);
      http
        .get('/admin/user/', {
          params: {
            currentPage: page,
          },
        })
        .then((response) => {
          console.log(response);
          if (response.data == '') {
            alert('유저목록이 없습니다');
          } else {
            this.items = response.data;
          }
        })
        .catch(() => {
          console.log('유저목록 불러오기 실패.');
        });
    },
    userDelete(userid) {
      if (userid == 'admin') {
        alert('관리자 계정입니다');
        return;
      }
      var isDelete = confirm('삭제하시겠습니까?');
      if (isDelete) {
        http
          .delete('/admin/user/' + userid)
          .then((response) => {
            console.log(response);
            if (response.data == '') {
              alert('유저목록이 없습니다');
            } else {
              this.$router.push('/main/manage/usermanage');
            }
          })
          .catch(() => {
            console.log('유저목록 불러오기 실패.');
          });
      }
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
        .get('/admin/user/', {
          params: {
            key: this.selected,
            word: this.searchText,
          },
        })
        .then((response) => {
          console.log(response);
          if (response.data == '') {
            alert('유저목록이 없습니다');
          } else {
            this.items = response.data;
          }
        })
        .catch(() => {
          console.log('유저목록 불러오기 실패.');
        });

      http
        .get('/admin/total/', {
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
          console.log('유저목록 불러오기 실패.');
        });
    },
  },
  mounted() {
    http
      .get('/admin/user')
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('유저목록이 없습니다');
        } else {
          this.items = response.data;
        }
      })
      .catch(() => {
        console.log('유저목록 불러오기 실패.');
      });

    http
      .get('/admin/total')
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
        console.log('유저목록 불러오기 실패.');
      });
  },
};
</script>

<style>
._writebtn {
  margin-right: 20px;
  float: right;
}
.search {
  padding-left: 80%;
}
._usermanage {
  margin-top: 50px;
  min-height: 610px;
}
</style>
