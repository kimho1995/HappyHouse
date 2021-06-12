import http from '@/http-common';
// initial state
// shape: [{ id, quantity }]
const getDefaultState = () => ({
  type: '',
  pay: '',
  sidoCode: '',
  gunguCode: '',
  dong: '',
  deals: [],
  deal: {},
  rents: [],
  rent: {},
});

const state = getDefaultState();

// getters
const getters = {
  getDealList(state) {
    return state.deals;
  },
  getDeal(state) {
    return state.deal;
  },
  getRentList(state) {
    return state.rents;
  },
  getRent(state) {
    return state.rent;
  },
  getType(state) {
    return state.type;
  },
  getPay(state) {
    return state.pay;
  },
  getSidoCode(state) {
    return state.sidoCode;
  },
  getGunguCode(state) {
    return state.gunguCode;
  },
  getDong(state) {
    return state.dong;
  },
  getPosition(state) {
    if (state.rent != '') {
      return state.rent;
    } else {
      return state.deal;
    }
  },
};

// actions
const actions = {
  resetCartState({ commit }) {
    commit('resetState');
  },
  resetCartStateAll({ commit }) {
    commit('resetStateAll');
  },
  selectDeal({ commit }, deal) {
    commit('SELECT_DEAL', deal);
  },
  selectRent({ commit }, rent) {
    commit('SELECT_RENT', rent);
  },
  /* 타입 설정 */
  setType({ commit }, type) {
    commit('SET_TYPE', type);
  },
  setPay({ commit }, pay) {
    commit('SET_PAY', pay);
  },
  /* 지역 설정 */
  setSidoCode({ commit }, sidoCode) {
    commit('SET_SIDO_CODE', sidoCode);
  },
  setGunguCode({ commit }, gunguCode) {
    commit('SET_GUNGU_CODE', gunguCode);
  },
  setDong({ commit }, dong) {
    commit('SET_DONG', dong);
  },

  /* 아파트 */
  getAptDealList({ commit }, paramList) {
    http
      .get('/aptDealList/' + paramList[0] + '/' + paramList[1] + '/' + paramList[2])
      .then(({ data }) => {
        commit('GET_APT_DEAL_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  getAptRentList({ commit }, paramList) {
    http
      .get(
        '/aptRentList/' +
          paramList[0] +
          '/' +
          paramList[1] +
          '/' +
          paramList[2] +
          '/' +
          paramList[3]
      )
      .then(({ data }) => {
        commit('GET_APT_RENT_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  /* 연립 다세대 */
  getHomeDealList({ commit }, paramList) {
    http
      .get('/homeDealList/' + paramList[0] + '/' + paramList[1] + '/' + paramList[2])
      .then(({ data }) => {
        commit('GET_HOME_DEAL_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  getHomeRentList({ commit }, paramList) {
    http
      .get(
        '/homeRentList/' +
          paramList[0] +
          '/' +
          paramList[1] +
          '/' +
          paramList[2] +
          '/' +
          paramList[3]
      )
      .then(({ data }) => {
        commit('GET_HOME_RENT_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  /* 오피스텔 */
  getOfficeDealList({ commit }, paramList) {
    http
      .get('/officeDealList/' + paramList[0] + '/' + paramList[1] + '/' + paramList[2])
      .then(({ data }) => {
        commit('GET_OFFICE_DEAL_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  getOfficeRentList({ commit }, paramList) {
    http
      .get(
        '/officeRentList/' +
          paramList[0] +
          '/' +
          paramList[1] +
          '/' +
          paramList[2] +
          '/' +
          paramList[3]
      )
      .then(({ data }) => {
        commit('GET_OFFICE_RENT_LIST', data);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
};

// mutations
const mutations = {
  resetState(state) {
    Object.assign(state, getDefaultState());
  },
  resetStateAll(state) {
    Object.assign(state, getDefaultState());
    state.type = '';
    state.pay = '';
    state.sidoCode = '';
    state.gunguCode = '';
    state.dong = '';
  },
  SELECT_DEAL(state, deal) {
    state.deal = deal;
  },
  SELECT_RENT(state, rent) {
    state.rent = rent;
  },

  SET_TYPE(state, type) {
    state.type = type;
  },
  SET_PAY(state, pay) {
    state.pay = pay;
  },
  SET_SIDO_CODE(state, sidoCode) {
    state.sidoCode = sidoCode;
  },
  SET_GUNGU_CODE(state, gunguCode) {
    state.gunguCode = gunguCode;
  },
  SET_DONG(state, dong) {
    state.dong = dong;
  },

  GET_APT_DEAL_LIST(state, deals) {
    state.deals = deals;
    state.rent = [];
  },
  GET_APT_RENT_LIST(state, rents) {
    state.rents = rents;
    state.deals = [];
  },
  GET_HOME_DEAL_LIST(state, deals) {
    state.deals = deals;
    state.rent = [];
  },
  GET_HOME_RENT_LIST(state, rents) {
    state.rents = rents;
    state.deals = [];
  },
  GET_OFFICE_DEAL_LIST(state, deals) {
    state.deals = deals;
    state.rent = [];
  },
  GET_OFFICE_RENT_LIST(state, rents) {
    state.rents = rents;
    state.deals = [];
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
