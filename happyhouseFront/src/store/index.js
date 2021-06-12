import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

import deal from './modules/deal.js';
import facility from './modules/facility.js';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    profile: [],
  },
  getters: {
    getProfile(state) {
      return state.profile;
    },
  },
  mutations: {
    LOGIN(state, profile) {
      state.profile = profile;
    },
    LOGOUT(state) {
      state.profile = '';
    },
  },
  actions: {
    getLogin({ commit }, profile) {
      commit('LOGIN', profile);
    },
    logout({ commit }) {
      commit('LOGOUT');
    },
  },
  modules: {
    deal,
    facility,
  },
  plugins: [createPersistedState()],
});
