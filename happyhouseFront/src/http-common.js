import axios from 'axios';

export default axios.create({
  //baseURL: "http://172.30.1.10:8197/ssafyvue/api",
  baseURL: 'http://localhost:8197/happyhouse/api',
  headers: {
    'Content-type': 'application/json',
  },
});
