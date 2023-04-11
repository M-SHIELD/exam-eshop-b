<template>
  <div v-if="orderList.length">
    <div class="orderbox" v-for="item in orderList" :key="item.id">
      <van-nav-bar
          :left-text='item.shopName + ">"'
          :right-text='formatOrderStatus(item.status)'
          @click-left=""
          @click-right=""
      />
      <van-card
          v-for="card in item.products"
          :key="card.id"
          :num="card.quantity"
          :price="card.productPrice"
          desc="描述信息"
          :title="card.productName"
          :thumb="card.productImage"
      />

      <div class="butbox">
        <span class="more">更多</span>
        <van-button color="#a4a4a4" plain type="mini" round><span class="buttext">查看发票</span></van-button>
        <van-button color="#a4a4a4" plain type="mini" round><span class="buttext">退换/售后</span></van-button>
        <van-button color="red" plain type="mini" round><span>再次购买</span></van-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "orderlist",
  data() {
    return {
      msg: ''
    }
  },
  props: {
    orderList: Array,
  },
  mounted() {
  },
  watch: {
    deep: true,
    orderList: function (newValue, oldValue) {
      this.orderList = newValue
      console.log(this.orderList)
    }
  },
  methods: {
    formatOrderStatus(status) {
      let desc;
      if (status === 0) {
        desc = '待支付'
      } else if (status === 1) {
        desc = '已支付'
      } else if (status === 2) {
        desc = '待发货'
      } else if (status === 3) {
        desc = '已发货'
      } else if (status === 4) {
        desc = '已收货'
      } else if (status === 5) {
        desc = '已完成'
      } else if (status === 6) {
        desc = '已取消'
      } else if (status === 6) {
        desc = '已取消'
      } else if (status === 6) {
        desc = '已删除s'
      }
      return desc
    }
  }
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
