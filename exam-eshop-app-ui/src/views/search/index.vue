<template>
  <div>
    <van-row style="background: red" type="flex" align="center">
      <van-col>
        <van-icon name="arrow-left" @click="$router.push('/')" />
      </van-col>
      <van-col span="22">
        <van-search
            v-model="value"
            shape="round"
            background="#FF0000"
            placeholder="请输入搜索关键词"
            @blur="searchcommodity"
        />
      </van-col>
    </van-row>
    <div class="history">
      <div>
        <span class="historytext">最近搜索</span>
      </div>
      <span
          class="hisitem"
          v-for="(item, index) in historylist"
          :key="index"
      >{{ item }}</span>
    </div>
    <div class="history">
      <div>
        <span class="historytext">热门搜索</span>
      </div>
      <span
          class="hisitem"
          v-for="(item, index) in historylist"
          :key="index"
      >{{ item }}</span>
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
              <img :src="item.picturepath" alt="">
            </div>
            <div class="proname">{{ item.name }}</div>
            <div class="proprice">￥{{ item.price }}</div>
          </div>
        </van-grid-item>
      </van-grid>
      <van-pagination
          v-if="show"
          v-model="productList.currPage"
          :total-items="productList.totalPage"
          :show-page-size="3"
          force-ellipses
      />
    </div>

    <van-empty v-if="!show" image="error" description="没有搜到该商品，换个关键词试试吧！" />

    <FooterMenu :active="0"></FooterMenu>
  </div>
</template>


<script>
import FooterMenu from "@/components/footerMenu";
import {getAllProduct} from "@/api/product";

export default {
  name: "search",
  components: {FooterMenu},
  data() {
    return {
      value: '',
      historylist: ['Nike', 'newbalance', 'adidas'],
      sortedList: [
        {
          name: '综合',
          type: 'normal',
          code: 0,
          active: true
        },
        {
          name: '价格',
          type: 'complex',
          state: 'asc',
          code: 2,
          active: false
        },
        {
          name: '新品',
          type: 'normal',
          code: 1,
          active: false
        }
      ],
      productList: {},
      show: ''
    };
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
    },
    searchcommodity() {
      getAllProduct({
        currPage: 1,
        isHot: 0,
        isIntegral: 0,
        keyWord: this.value,
        order: 0,
        orderType: "",
        status: 1
      }).then(res => {
        if(res.code === 200){
          this.productList = res.page
          this.show = res.page.list.length
        }
      })
    },
    switchSort(item){

      this.sortedList.forEach(e=>{
        e.active=false
      })

      // console.log(item)
      item.active=true
      this.getData()
    },
    transformIconState(item) {
      item.state = item.state === 'asc' ? 'desc' : 'asc'
      this.switchSort(item)
    },
  }
}
</script>

<style lang="less" scoped>
.history {
  height: 3rem;
}

.historytext {
  font-size: 0.4rem;
}

.hisitem {
  font-size: 0.4rem;
  background: #f3f3f3;
  color: #cccccc;
  margin: 0.3rem;
  padding: 0.1rem;
}

.sort {
  font-size: 16px;

}

.active {
  color: red;
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

.van-pagination{
  margin-bottom: 50px;
}
</style>
