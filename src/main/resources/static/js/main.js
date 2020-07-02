import Vue          from 'vue'
import VueResource  from 'vue-resource'
import App          from "pages/App.vue"
import Vuetify      from "vuetify";
import              'vuetify/dist/vuetify.min.css'
import VueKonva from 'vue-konva';



Vue.use(VueResource);
Vue.use(Vuetify);
Vue.use(VueKonva);



new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    render: a => a(App)
});