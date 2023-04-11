<template>
  <div class="orderbox">
    <van-nav-bar
        left-text="JD京东官方自营旗舰店>"
        right-text='完成'
        @click-left=""
        @click-right=""
    />
    <van-card
        v-for="item in orderList"
        :key='item.id'
        :num="item.quantity"
        :price="item.product_price"
        desc="描述信息"
        :title="item.product_name"
        :thumb="item.product_image"
    />

    <div class="butbox">
      <span class="more">更多</span>
      <van-button color="#a4a4a4" plain type="mini" round><span class="buttext">查看发票</span></van-button>
      <van-button color="#a4a4a4" plain type="mini" round><span class="buttext">退换/售后</span></van-button>
      <van-button color="red" plain type="mini" round><span>再次购买</span></van-button>
    </div>
  </div>
</template>

<script>
import {orderList} from "@/api/mockaddress/address";

export default {
  name: "orderlist",
  props: {
    orderList: Array,
  },
  mounted() {
  },
  // watch: {
  //   deep: true,
  //   orderList: function (newValue, oldValue) {
  //     this.orderList = newValue
  //     console.log(this.orderList)
  //   }
  // },

}
</script>

<style lang="less" scoped>
.orderbox {
  background: white;
  width: 95%;
  border-radius: 5%;
  margin: auto;
  margin-top: 10px;
}

/deep/ .van-nav-bar__text {
  font-weight: bold;
  color: black;
}

.van-card:not(:first-child) {
  margin-top: 0px;
}

.butbox {
  height: 50px;
  display: flex;
  justify-content: flex-end;
  align-items: center;

  .van-button {
    display: flex;
    padding: 10px;
    margin: 0px 5px;
  }

  .more {
    padding-right: 50px;
    font-weight: bold;
    font-size: 15px;
  }
}

.buttext {
  color: black;
  font-weight: bold;
}
</style>
