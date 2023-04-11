<template>
  <div class="order">
    <van-nav-bar
        title="我的订单"
        :fixed=true
        left-arrow
        @click-left="onClickLeft"
    />
    <van-tabs class="order-category" v-model="activeName" @click="onClickOrder" sticky>
      <van-tab title="全部" :name="-1">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="待付款" :name="0">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="已付款" :name="1">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="待发货" :name="2">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="待收货" :name="3">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="待评价" :name="4">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="已完成" :name="5">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="已取消" :name="6">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="已退款" :name="7">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
      <van-tab title="已删除" :name="8">
        <OrderList :orderList="orderList"></OrderList>
      </van-tab>
    </van-tabs>
  </div>
</template>
<script>
import OrderList from '@/components/orderlist'
import {postorderlist} from "@/api/orderlist";
export default {
  name: "order",
  data() {
    return {
      //activeName: this.$route.params.active,
      activeName: this.$route.params.active,
      orderList: [],
    };
  },
  mounted() {
    this.initData()
  },
  components: {
    OrderList
  },
  methods: {
    initData() {

      this.getOrderList()

    },
    onClickLeft() {
      this.$router.back();
    },
    onClickOrder() {
      this.getOrderList()
    },
    // getOrderList() {
    //   this.orderList = []
    //   if (this.activeName === 0) {
    //     var data = {
    //       "maijiaid": 2
    //     }
    //   } else {
    //     var data = {
    //       "maijiaid": 2,
    //       "state": this.activeName
    //     }
    //   }
    //
    //     getOrderList(data).then(response => {
    //       if (response.data && response.data.length > 0) {
    //         console.log(response.data)
    //           this.orderList = response.data
    //       }
    //     })
    //   },
      getOrderList(){
        postorderlist({
          status: this.activeName,
          uid: 0
        }).then(res => {
          if(res.code == 200){
            this.orderList = res.data
          }
        })
      }
    }
}
</script>

<style lang="less" scoped>

.order {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #f5f5f5;
  z-index: 2000;
  padding-top: 44px;
  overflow: auto;
}
</style>
