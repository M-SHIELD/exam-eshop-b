<template>
  <div>

    <!--    吸顶-->
    <!--    第一行-->
    <van-sticky>
      <van-row style="background: white">
        <van-col>
          <img class="header-logo" src="@/assets/logo.svg" alt="">
        </van-col>
        <van-col>
          <van-search class="header-search" v-model="search_value" placeholder="请输入搜索关键词" @click="gotosearch"/>
        </van-col>
        <van-col>
          <van-button class="header-btn-login" size="small" plain hairline type="danger" @click="$router.push('/login')" v-if="token">登录</van-button>
        </van-col>
      </van-row>
      <!--    滚动的按钮-->
      <van-tabs>
        <van-tab v-for="(list,index) in tabList" :key="index" :title="list">
          <!--        {{ list }}-->
        </van-tab>
      </van-tabs>
    </van-sticky>
    <!--轮播图-->
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
      <van-swipe-item :key="index" v-for="(list,index) in imgList">
        <img class="swipe-item" :src="list" alt="">
      </van-swipe-item>
    </van-swipe>
    <!--三个广告提示-->
    <van-row class="service-info">
      <van-col span="8"><i class="icon icon_1"></i>网易自营品牌</van-col>
      <van-col span="8"><i class="icon icon_2"></i>30天无忧退货</van-col>
      <van-col span="8"><i class="icon icon_3"></i>48小时快速退款</van-col>
    </van-row>

    <!--    10个图标列表-->
    <van-grid :border="false" :column-num="5">
      <van-grid-item v-for="(list,index) in iconList" :key="index" :icon="list.icon" :text="list.text">
        <!--        <img :src="list.icon" alt="">-->
      </van-grid-item>
    </van-grid>


    <!--    商品列表-->
    <div class="goods-title">类目畅销榜</div>
    <!--    大图-->
    <van-grid :border="false" :column-num="2">
      <van-grid-item v-for="(list,index) in 2" :key="index">
        <div @click="toProductList(index)" class="goods-room">
          <img class="goods-img" :src="goodsList[index].imgurl" alt="">
          <div class="goods-list-text">
            {{ goodsList[index].text }}
          </div>
        </div>
      </van-grid-item>
    </van-grid>

    <van-grid :border="false" :gutter="10" :column-num="4">
      <van-grid-item class="sec-goods-list" v-if="index>1" v-for="(list,index) in goodsList" :key="index"
                     :icon="list.imgurl"
                     :text="list.text">
      </van-grid-item>
    </van-grid>


    <!--    底部空余空间-->
    <div class="footer">
      <van-button plain hairline type="info">app下载</van-button>
      <van-button plain hairline type="info">访问原网站</van-button>
    </div>
    <!--    底部导航-->
    <FooterMenu :active="0"></FooterMenu>


  </div>
</template>

<script>
import FooterMenu from "@/components/footerMenu";

export default {
  name: 'home',
  components: {FooterMenu},
  data() {
    return {
      token: localStorage.getItem('TOKEN')?0:1,
      active: 0,
      search_value: "",
      tabList: [`推荐`, `居家生活`, '宠物生活', '服饰鞋包', '美食酒水', '个护清洁', '母婴亲子', '运动旅行', '数码家电', '严选全球'],
      imgList: [
        'https://yanxuan.nosdn.127.net/1ee93870749720a4272be014b495bad1.jpg?type=webp&imageView&quality=75&thumbnail=750x0',
        'https://yanxuan.nosdn.127.net/static-union/1646926679c6f282.jpg?type=webp&imageView&quality=75&thumbnail=750x0',
        'https://yanxuan.nosdn.127.net/58702e843600b189decbe353bf5fbefe.jpg?type=webp&imageView&quality=75&thumbnail=750x0',
        'https://yanxuan.nosdn.127.net/07d7b500df8be0c6f956f72edda4c73d.jpg?type=webp&imageView&quality=75&thumbnail=750x0'
      ],
      iconList: [
        {
          text: "新品首发", icon: require('../../../assets/icon-init/icon_l_1.png')
        }, {
          text: "居家生活", icon: require('../../../assets/icon-init/icon_l_2.png')
        }, {
          text: "服饰鞋包", icon: require('../../../assets/icon-init/icon_l_3.png')
        }, {
          text: "美食酒水", icon: require('../../../assets/icon-init/icon_l_4.png')
        }, {
          text: "个护清洁", icon: require('../../../assets/icon-init/icon_l_5.png')
        }, {
          text: "母婴亲子", icon: require('../../../assets/icon-init/icon_l_6.png')
        }, {
          text: "运动旅行", icon: require('../../../assets/icon-init/icon_l_7.png')
        }, {
          text: "数码家电", icon: require('../../../assets/icon-init/icon_l_8.png')
        }, {
          text: "宠物生活", icon: require('../../../assets/icon-init/icon_l_9.png')
        }, {
          text: "每日秒杀", icon: require('../../../assets/icon-init/icon_l_10.png')
        },
      ],
      goodsList: [
        {
          imgurl: require('../../../assets/icon-init/icon_g_1.webp'),
          text: '全部商品'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_2.webp'),
          text: '积分商品'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_3.webp'),
          text: '居家生活榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_4.webp'),
          text: '个护清洁榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_5.webp'),
          text: '数码家电榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_6.webp'),
          text: '宠物生活榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_7.webp'),
          text: '母婴亲子榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_8.webp'),
          text: '运动旅行榜'
        }, {
          imgurl: require('../../../assets/icon-init/icon_g_9.webp'),
          text: '严选全球榜'
        },
      ]

    }
  },
  methods: {
    toProductList(index) {
      // console.log(123)
      if (index === 0) {//全部
        this.$router.push('/prolist?isScore=0')
      }
      if (index === 1) {//积分
        this.$router.push('/prolist?isScore=1')
      }
    },
    gotosearch() {
      this.$router.push({name:'search'})
    }
  }
}
</script>

<style scoped>
.header-logo {
  width: 1rem;
  display: inline-block;
  margin: .4rem .1rem 0 .5rem;
  height: 0.8rem;
  line-height: 1.8rem;
}

.van-search__content {
  border-radius: .2rem;
}

.header-search {
  width: 6rem;
  height: 1.5rem;
}

.header-btn-login {
  padding: 0 .2rem 0 .2rem;
  height: .6rem;
  margin-top: .5rem;
  /*border-radius: .9rem;*/
}

.swipe-item {
  height: 5rem;
}

.service-info {
  font-size: .2rem;
  height: .6rem;
  line-height: .6rem;
  text-align: center;
}

.icon {
  display: inline-block;
  background: no-repeat;
  background-size: 100%;
  vertical-align: middle;
  width: .42667rem;
  height: 0.5rem;
}

.icon.icon_1 {
  background-image: url('@/assets/icon-init/icon_1.png');
}

.icon.icon_2 {
  background-image: url('@/assets/icon-init/icon_2.png');
}

.icon.icon_3 {
  background-image: url('@/assets/icon-init/icon_3.png');
}

.goods-title {
  font-size: .5rem;
  margin: .2rem 0 0 .3rem;
}

.goods-room {
  background-color: #ebeff6;
  height: 2.6rem;
}

.goods-img {
  width: 2.6rem;
  flex: 1;
}

.goods-list-text {
  font-size: .3rem;
  display: inline-block;
  flex: 1;
  border-bottom: .1rem solid #2d2c2c;
  position: relative;
  top: -2.5rem;
  left: 1.4rem;
  margin-left: 1rem;
}

.footer {
  height: 4rem;
  color: white;
  margin-top: .4rem;
  text-align: center;
  background-color: #414141;
}

.sec-goods-list /deep/ .van-grid-item__content--center {
  background-color: #f5f5f5;
}

.footer /deep/ .van-button--info {
  background: #414141;
  color: white;
  border-radius: .1rem;
  border: #8d8b8b 1px solid;
  margin-left: .2rem;
  margin-top: .5rem;
}
</style>
