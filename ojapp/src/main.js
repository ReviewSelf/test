
import App from './App.vue'
import 'ant-design-vue/dist/antd.css';
import Antd from 'ant-design-vue';
import axios from 'axios';
import Menu from "@/components/Menu";
import Vue from 'vue';
import { FormModel } from 'ant-design-vue';
import router from "@/router/index";
import store from "@/store/index";
import VueUeditorWrap from 'vue-ueditor-wrap';
import { Chart } from "frappe-charts/dist/frappe-charts.min.esm"
import 'frappe-charts/dist/frappe-charts.min.css'
Vue.component(Chart);
Vue.use(FormModel);
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
Vue.use(Antd);
Vue.component('VueUeditorWrap',VueUeditorWrap)
Vue.component('Menu',Menu)
new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')


