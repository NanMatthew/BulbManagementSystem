import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
// import axios from 'axios'
import SIdentify from './views/SIdentify'
import 'element-ui/lib/theme-chalk/index.css'
import Mock from './mock'
Mock.bootstrap();
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.use(SIdentify)
// Vue.prototype.$ajax=axios
//路由守卫
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
