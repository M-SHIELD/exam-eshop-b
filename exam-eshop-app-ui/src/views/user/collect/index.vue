<!--
*@index
*@author micah
*@date 2022/4/27 23:56
-->
<template>
  <div class="body">
    <van-nav-bar @click-left="$router.back()" fixed safe-area-inset-top title="我的收藏" left-arrow>
      <template #right>
        <van-icon name="search" size="18"/>
      </template>
    </van-nav-bar>
    <!--    顶栏空间-->
    <div class="fixedroom"></div>

    <!--管理按钮-->
    <van-cell-group>
      <van-cell @click="manage" title="" :value="isManage?'取消':'管理'"/>

    </van-cell-group>

    <!--    足迹展示区域-->
    <div class="proRoom">

      <van-grid :border="false" :column-num="2">
        <van-grid-item v-for="(item,index) in proList" :key="index">

          <div class="pro">
            <div v-if="isManage" class="check">
              <van-checkbox @click="changeCheck" v-model="item.isCheck"></van-checkbox>
            </div>
            <div @click="toDetail(item.id)" class="proitem">
              <div class="propic">
                <img :src="item.goodsImg" alt="">
              </div>
              <div class="proname">{{ item.goodsName }}</div>
              <div class="proprice">￥{{ item.price }}</div>
            </div>
          </div>
        </van-grid-item>
      </van-grid>


    </div>

    <van-submit-bar v-if="isManage" :price="0" button-text="删除" @submit="onRemove">
      <van-checkbox @click="clickAll" v-model="isAll">全选</van-checkbox>
    </van-submit-bar>

  </div>
</template>

<script>
import {collectList} from "@/api/collect";

export default {
  name: "index",
  mounted() {
    this.getData()
  },
  data() {
    return {
      isManage: false,
      isAll: false,
      proList: [
        {
          name: '华为手机',
          price: '6996.0',
          pic: require('@/assets/images/huawei.png'),
          id: 1,
          isCheck: false
        }, {
          id: 2,
          name: '华为手机',
          price: '6996.0',
          pic: require('@/assets/images/huawei.png'),
          isCheck: false
        }, {
          id: 3,
          name: '华为手机',
          price: '6996.0',
          pic: require('@/assets/images/huawei.png'),
          isCheck: false
        }
      ]
    }
  },
  methods: {
    changeCheck() {
      var count = 0
      this.proList.forEach(e => {
        if (e.isCheck)
          count++
      })
      if (count === this.proList.length) {
        this.isAll = true
      } else {
        this.isAll = false
      }


    },
    clickAll() {
      if (this.isAll) {
        this.proList.forEach(e => {
          e.isCheck = true
        })
      } else {
        this.proList.forEach(e => {
          e.isCheck = false
        })
      }
    },
    manage() {
      this.isManage = !this.isManage
    },
    toDetail(id) {
      this.$router.push('/goods/' + id)
    },
    onRemove() {

    },
    getData() {
      collectList({
        "maiJiaId": 2
      }).then(e => {
        this.proList = e.data
        this.proList.forEach(e=>{
          e.isCheck=false
        })
      })
    }
  },
}
</script>

<style lang="scss" scoped>
/deep/ .van-submit-bar__text {
  color: #FFFFFF;

  .van-submit-bar__price {
    color: #FFFFFF;
  }
}

.body {
  background-color: #f8f8f8;
  height: 100vh;
  padding: 10px;
}

.fixedroom {
  height: 55px;
}

.check {
  display: block;
  float: left;
  text-align: start;
  vertical-align: initial;
  align-items: start;

  /deep/ .van-checkbox {
    display: block;
    float: left;
    text-align: start;
    vertical-align: initial;
    align-items: start;
  }
}

.proRoom {
  margin: 10px 5px;

  .pro {
    display: flex;
    flex-direction: column;


    .proprice {
      font-size: 24px;
      color: #f2842b;
      text-align: center;
      vertical-align: middle;

    }

    .proname {
      font-size: 16px;
      text-align: center;
      vertical-align: middle;
    }

    .propic {

      img {
        width: 120px;
        height: 120px;
        text-align: center;
        vertical-align: middle;
      }
    }
  }
}
</style>
