//适配方案
import './assets/flexible'
import './assets/flexible.css'

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './assets/icons'
import "./assets/iconfont/iconfont.css"
import store from './store'

Vue.config.productionTip = false

// 使用vant
// import Vant from 'vant';
// import 'vant/lib/index.css';
// Vue.use(Vant);
import {SubmitBar,GoodsActionButton,GoodsActionIcon,Divider,Sku,ActionSheet,GoodsAction,Col, Row, Card, Search, Button, Swipe, SwipeItem, Tab, Tabs,Image,CheckboxGroup,Checkbox,NavBar,CellGroup,Cell} from 'vant';

Vue.use(Col).use(Row).use(Card).use(Search).use(Button).use(Tab).use(Tabs).use(Image).use(Checkbox).use(CheckboxGroup);
Vue.use(Divider);
Vue.use(GoodsActionButton);
Vue.use(GoodsActionIcon);
Vue.use(Swipe);
Vue.use(SubmitBar);
Vue.use(Sku);
Vue.use(ActionSheet);
Vue.use(GoodsAction);
Vue.use(SwipeItem);
Vue.use(Cell);
Vue.use(CellGroup);
Vue.use(NavBar);
import { Grid, GridItem } from 'vant';

Vue.use(Grid);
Vue.use(GridItem);
import { Tabbar, TabbarItem,Icon } from 'vant';

Vue.use(Tabbar);
Vue.use(TabbarItem);
Vue.use(Icon);
import { Sticky } from 'vant';
Vue.use(Sticky);
import { TreeSelect } from 'vant';
Vue.use(TreeSelect);

import { AddressList } from 'vant';
Vue.use(AddressList);

import { AddressEdit } from 'vant';
Vue.use(AddressEdit);

import { ContactEdit } from 'vant';
Vue.use(ContactEdit);

import { Empty } from 'vant';
Vue.use(Empty);

import { Form } from 'vant';
import { Field } from 'vant';
Vue.use(Form);
Vue.use(Field);

//  全局引入 过滤器
import '@/utils/filter'

import axios from "axios";

import './mock/mockserver.js'

Vue.prototype.$axios = axios

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
