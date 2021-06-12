<template>
  <div>
    <div id="_backgroundImage">
      <b-container id="searchBox" class="bv-example-row">
        <b-row class="_mainSearch">
          <b-col>
            <search-bar />
          </b-col>
        </b-row>
      </b-container>
    </div>
    <b-container class="bv-example-row">
      <b-row>
        <b-col>
          <b-row>
            <b-col>
              <strong>뉴스</strong>
            </b-col>
            <b-col>
              <b-button variant="link">더보기</b-button>
            </b-col>
          </b-row>
          <div>
            <b-table
              hover
              :items="newsData"
              :per-page="5"
              :fields="newsField"
              @row-clicked="moveNews"
            >
              <a href="#"></a>
            </b-table>
          </div>
        </b-col>
        <b-col>
          <b-row>
            <b-col>
              <strong>공지사항</strong>
            </b-col>
            <b-col>
              <b-button variant="link" @click="moveNoticeList">더보기</b-button>
            </b-col>
          </b-row>
          <div>
            <b-table
              hover
              :items="notices"
              :per-page="5"
              :fields="noticefield"
              @row-clicked="moveNotice"
            ></b-table>
          </div>
        </b-col>
        <b-col>
          <b-row>
            <b-col>
              <strong>게시판</strong>
            </b-col>
            <b-col>
              <b-button variant="link" @click="moveBoardList">더보기</b-button>
            </b-col>
          </b-row>
          <div>
            <b-table
              hover
              :items="boards"
              :per-page="5"
              :fields="boardfield"
              @row-clicked="moveBoard"
            ></b-table>
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import SearchBar from '@/components/houseDeal/HomeDealSearchBar.vue';
import http from '@/http-common';
export default {
  name: 'Main',
  components: {
    SearchBar,
  },
  data() {
    return {
      news: {},
      newsField: [
        {
          key: 'title',
          label: '제목',
        },
      ],
      newsData: {},
      boards: {},
      boardfield: [
        {
          key: 'bid',
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
      ],
      notices: {},
      noticefield: [
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
      ],
    };
  },
  methods: {
    moveNews(item, index, event) {
      window.open(this.newsData[index].originallink);
    },
    moveBoard(boards) {
      console.log(boards.bid);
      this.$router.push({
        path: `/main/board/detail/${boards.bid}`,
      });
    },
    moveBoardList() {
      this.$router.push('/main/board/boardlist');
    },
    moveNotice(notices) {
      this.$router.push({
        path: `/main/notice/detail/${notices.nid}`,
      });
    },
    moveNoticeList() {
      this.$router.push('/main/notice/noticelist');
    },
  },
  mounted() {
    http
      .get('/board')
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('게시글이 없습니다');
        } else {
          this.boards = response.data;
        }
      })
      .catch(() => {
        console.log('게시글 불러오기 실패.');
      });

    http
      .get('/notice')
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('공지글이 없습니다');
        } else {
          this.notices = response.data;
        }
      })
      .catch(() => {
        console.log('공지글 불러오기 실패.');
      });

    http
      .get('/news')
      .then((response) => {
        console.log(response);
        if (response.data == '') {
          alert('글이 없습니다');
        } else {
          console.log(response.data.items);
          this.newsData = response.data.items;
          for (var i = 0; i < 5; i++) {
            // this.newsData[i].title = {
            //   title: this.newsData[i].title.replace(/(<([^>]+)>)/gi, ''),
            // };
            this.newsData[i].title = response.data.items[i].title.replace(/(<([^>]+)>)/gi, '');
            if (this.newsData[i].title.length > 20) {
              this.newsData[i].title = this.newsData[i].title.substr(0, 20) + '...';
            }
            console.log(this.newsData);
          }
        }
      })
      .catch(() => {
        console.log('글 불러오기 실패.');
      });
  },
};
</script>

<style scope>
#_backgroundImage {
  background: url('../assets/main_background.png') no-repeat;
  background-size: cover;
  height: 500px;
}
#searchBox {
  width: 60%;
  position: relative;
  top: 40%;
}
</style>
