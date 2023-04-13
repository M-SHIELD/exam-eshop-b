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

    <!--    收藏展示区域-->
    <div class="proRoom">

      <van-grid :border="false" :column-num="2">
        <van-grid-item v-for="(item,index) in collectList" :key="index">
          <div class="pro">
            <div v-if="isManage" class="check">
              <!--              {{item.isCheck}}-->
              <van-checkbox @click="changeCheck(item.id)" v-model="item.isCheck"></van-checkbox>
            </div>
            <div @click="toDetail(item.id)" class="proitem">
              <div class="propic">
                <img :src="item.image" alt="">
              </div>
              <div class="proname">{{ item.name }}</div>
              <div class="proprice">￥{{ item.price }}</div>
            </div>
          </div>
        </van-grid-item>
      </van-grid>

    </div>

    <van-submit-bar v-if="isManage" :price="0" button-text="删除" @submit="onRemove">
      <van-checkbox @click="clickAll()" v-model="isAll">全选</van-checkbox>
    </van-submit-bar>

    <van-pagination
        v-if="show"
        v-model="proList.currPage"
        :total-items="proList.totalPage"
        :show-page-size="3"
        force-ellipses
    />

    <van-empty v-if="!show" image="error" description="没有搜到该商品，换个关键词试试吧！"/>

  </div>
</template>

<script>
import {getAllcollect,delallcollect} from "@/api/collect";

export default {
  name: "index",
  mounted() {
    this.getData()
  },
  data() {
    return {
      isManage: false,
      isAll: false,
      arr: [],
      proList: {},
      collectList: [],
      show: '',
      checkeddata: false
    }
  },
  methods: {
    changeCheck(id) {
      let count = 0
      this.proList.list.forEach(e => {
        if(e.id === id){
          if(e.isCheck){
            if(this.arr.indexOf(id) === -1){
              this.arr.push(id)
              // console.log(this.arr)
            }
            count++
          }else{
            this.arr.splice(this.arr.indexOf(id),1)
            // console.log(this.arr)
          }
        }

        // if (e.isCheck) {
        //
        // }
      })

      if (count === this.collectList.length) {
        this.isAll = true
      } else {
        this.isAll = false
      }

      // this.isAll = !this.isAll
    },
    clickAll() {
      if (!this.isAll) {
        this.collectList.forEach(e => {
          e.isCheck = false
          this.arr.pop()
          // console.log(this.arr)
        })

      } else {
        this.collectList.forEach(e => {
          e.isCheck = true
          this.arr.push(e.id)
          // console.log(this.arr)
        })
      }
      // this.isAll = !this.isAll
    },
    manage() {
      this.isManage = !this.isManage
    },
    toDetail(id) {
      this.$router.push('/goods/' + id)
    },
    onRemove() {
      delallcollect({
        behaviorType: 1,
        currPage: 0,
        productId: this.arr.toString()
      }).then(res => {
        if(res.code === 200){
          this.$router.go(0)
        }
      })
    },
    getData() {
      getAllcollect({
        behaviorType: 1,
        currPage: 1,
        productId: ""
      }).then(res => {


        if (res.code === 200) {
          this.proList = res.page

          this.show = res.page.list.length

          this.proList.list.forEach(e => {
            // e.isCheck = false
            this.$set(e, "isCheck", false)
          })
          this.collectList = this.proList.list

        }
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
