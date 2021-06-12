// import http from '@/http-common';
// initial state
const state = () => ({
  items: [],
  dong: '',
});

// getters
const getters = {
  getItemList(state) {
    return state.items;
  },
  getdong(state) {
    return state.dong;
  },
};

// actions
const actions = {
  resetFacilityState({ commit }) {
    commit('resetFState');
  },
  resetFacilityStateAll({ commit }) {
    commit('resetFStateAll');
  },
  setItemList({ commit }, items) {
    commit('SET_ITEM_LIST', items);
  },
  setDong({ commit }, dong) {
    commit('SET_DONG', dong);
  },
};

// mutations
const mutations = {
  resetFState(state) {
    state.items = [];
  },
  resetFStateAll(state) {
    state.items = [];
    state.dong = '';
  },
  SET_ITEM_LIST(state, items) {
    state.items = items;
  },
  SET_DONG(state, dong) {
    state.dong = dong;
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
