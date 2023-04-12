<template>
  <div class="body">
    <!--    顶部-->
    <van-nav-bar @click-left="$router.back()" fixed safe-area-inset-top :title="isScore==='1'?'积分商品':'商品列表'" left-arrow>
      <template #right>
        <van-icon name="search" size="18"/>
      </template>
    </van-nav-bar>

    <!--    顶栏空间-->
    <div class="fixedroom">

    </div>
    <!--排序方式-->
    <van-grid :border="false" :column-num="3">
      <van-grid-item v-for="(item,index) in sortedList" :key="index">
        <div @click="switchSort(item)" :class="+item.active?'sort active':'sort'">
          {{ item.name }}
          <span v-if="item.type==='complex'">
          <van-icon @click="transformIconState(item)" v-if="item.state==='desc'" name="descending"/>
          <van-icon @click="transformIconState(item)" v-if="item.state==='asc'" name="ascending"/>
          </span>
        </div>
      </van-grid-item>
    </van-grid>


    <!--    商品展示区域-->
    <div class="proRoom">
      <van-grid gutter="10" :border="false" :column-num="2">
        <van-grid-item v-for="(item,index) in productList.list" :key="index">
          <div @click="toDetail(item.id)" class="pro">
            <div class="propic">
              <img :src="item.image" alt="">
            </div>
            <div class="proname">{{ item.name }}</div>
            <div class="proprice">￥{{ item.price }}</div>
          </div>
        </van-grid-item>
      </van-grid>
      <van-pagination
          v-model="productList.currPage"
          :total-items="productList.totalPage"
          :show-page-size="3"
          force-ellipses
      />
    </div>

    <!--底部导航-->
    <FooterMenu :active="-1"></FooterMenu>
  </div>
</template>

<script>
import FooterMenu from "@/components/footerMenu";
import {getAllProduct} from "@/api/product";
export default {
  name: "index",
  components: {
    FooterMenu
  },
  created() {
    this.isScore=this.$route.query.isScore
    // console.log(this.isScore)
    this.getData()
    this.init()
  },
  data() {
    return {
      isScore: false,
      sortedList: [
        {
          name: '综合',
          type: 'normal',
          code: 0,
          active:true
        },
        {
          name: '价格',
          type: 'complex',
          state: 'asc',
          code: 1,
          active:false
        },
        {
          name: '新品',
          type: 'normal',
          code: 2,
          active:false
        }
      ],
      productList: {}
    }
  },
  methods: {
    getData(){
      var orderBy;
      var descOrAsc=0;
      this.sortedList.forEach(e=>{
        if (e.active){
          //获取排序
           orderBy=e.code
          if (e.type==='complex'){          //判断排序方式
            descOrAsc=e.state==='asc'?0:1
          }
        }
      })

      // var param={
      //   "isfictitious":this.isScore, //score
      //   "descOrAsc":descOrAsc,//s j
      //   "orderBy":orderBy,//0 1new 2 price
      //   "current":1,//page
      //   "size":5,
      //   "pid":null,
      //   "categoryId":null
      // }
      // goodsList(param).then(e=>{
      //   // console.log(e)
      //   this.proList=e.data.records
      // })
    },
    toDetail(id){
      this.$router.push('/goods/'+id)
    },
    switchSort(item){
      console.log(item.state)
      this.init(item.code,item.state)
      this.sortedList.forEach(e=>{
        e.active=false
      })

      // console.log(item)
      item.active=true
      this.getData()
    },
    transformIconState(item) {
      item.state = item.state === 'asc' ? 'desc' : 'asc'
    },
    init(code,state){
      // console.log(code,state)
      getAllProduct({
        currPage: 1,
        isHot: 0,
        isIntegral: 0,
        keyWord: "",
        order: code === undefined ? 0 : code,
        orderType: state === undefined ? 'asc' : state,
        status:1
      }).then(res => {
        if(res.code === 200){
          this.productList =res.page
          // console.log(this.productList)
        }
      })
    }
    }
  }
</script>

<style lang="scss" scoped>
.more {
  font-size: 16px;
  text-align: center;
  vertical-align: middle;
  color: #8d8b8b;
  margin-top: 10px;
}

.footerroom {
  height: 55px;
}

.fixedroom {
  height: 55px;
}

.sort {
  font-size: 16px;

}

.active{
  color: red;
}

.body {
  background-color: #f8f8f8;
  height: 100%;
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
  .van-pagination{
    margin-bottom: 50px;
  }
}
</style>
