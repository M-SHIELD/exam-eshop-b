<template>
  <div class="goods-detail">
    <van-nav-bar
        title="商品详情页"
        :fixed=true
        left-arrow
        @click-left="onClickLeft"
    />

    <!--  商品图片轮播 -->
    <van-swipe class="goods-detail-swipe"
               :autoplay="3000"
    >
      <van-swipe-item v-for="(url,index) in 1" :key="index">
        <van-image width="100%" height="280" :src="goods.sliderImage"/>
      </van-swipe-item>
    </van-swipe>

    <van-row class="goods-detail-base">
      <van-col span="20">
        <div class="goods-detail-base-name">{{ goods.name }}</div>
        <div class="goods-detail-base-title">{{ goods.subtitle }}</div>
      </van-col>
      <van-col class="goods-detail-base-share" span="4">
        <van-icon class="iconfont" class-prefix="icon" name="fenxiang"/>
      </van-col>
    </van-row>


    <van-row class="goods-detail-sales" v-show="seckill!==true">
      <van-col span="16" class="goods-detail-sales-price">
                 <span class="goods-detail-sales-price-promotion">
                    {{ goods.price|moneyFormat }}
                </span>
        <span class="goods-detail-sales-price-origin">
                    {{ goods.price|moneyFormat }}
                </span>

      </van-col>
      <van-col span="8" class="goods-detail-sales-volume" align="right">
        销量: {{ goods.sales }}
      </van-col>
    </van-row>


    <van-cell title="规格" class="goods-detail-sku" is-link @click="showSkuClicked"/>

    <van-row class="goods-detail-attribute">
      <van-cell-group title="商品参数">
        <van-cell
            v-for="attribute in attribute_list"
            :title="attribute.name"
            :value="attribute.value"
        />
      </van-cell-group>
    </van-row>

    <van-row class="goods-detail-detail">
      <div v-html="goods.description" style="width: 100%;"></div>
    </van-row>

    <van-row class="goods-detail-faq">
      <van-divider>常见问题</van-divider>
    </van-row>


    <van-goods-action style="z-index: 3000">

      <van-goods-action-icon @click="collect" v-if="!goods.isCollect" icon="star-o" text="收藏"/>
      <van-goods-action-icon @click="collect" v-if="goods.isCollect" icon="star" text="已收藏" color="#ff5000"/>

      <van-goods-action-icon icon="cart-o" text="购物车" :info="goodsNum"/>
      <van-goods-action-button type="warning" text="加入购物车" @click="onAddCartClicked"/>
      <van-goods-action-button type="danger" text="立即购买" @click="onBuyClicked"/>
    </van-goods-action>

    <!-- 商品SKU -->
    <van-action-sheet v-model="showSku" title="标题">
      <van-sku
          v-model="showSku"
          :sku="sku"
          :goods="goods"
          :goods-id="goodsId"
          :quota="quota"
      >
        <template #sku-actions="props">
          <div class="van-sku-actions">
            <!-- 空槽是为了移除sku的按钮 -->
          </div>
        </template>
      </van-sku>
    </van-action-sheet>
  </div>
</template>

<script>
// import {goodsDetail} from '@/api/goods'
import {mapMutations, mapState} from "vuex"
import {Toast} from "vant"
import {getdetails} from "@/api/product";
import {addcollect, delcollect} from "@/api/collect";
export default {
  name: "detail",
  data() {
    return {
      seckill: this.$route.params.seckill, // 页面传值：是否秒杀商品
      goodsId: this.$route.params.goodsId, // 页面传值：商品ID
      attribute_list:[
        {name:'红色',value:'XL'},
        {name:'蓝色',value:'L'}
      ],
      goods: {},
      sku: {
        // 所有sku规格类目与其值的从属关系，比如商品有颜色和尺码两大类规格，颜色下面又有红色和蓝色两个规格值。
        // 可以理解为一个商品可以有多个规格类目，一个规格类目下可以有多个规格值。
        tree: [
          {
            k: '颜色', // skuKeyName：规格类目名称
            k_s: 's1', // skuKeyStr：sku 组合列表（下方 list）中当前类目对应的 key 值，value 值会是从属于当前类目的一个规格值 id
            v: [
              {
                id: '1', // skuValueId：规格值 id
                name: '红色', // skuValueName：规格值名称
              },
              {
                id: '2',
                name: '蓝色',
              }
            ],
          },
          {
            k: '尺寸', // skuKeyName：规格类目名称
            k_s: 's2', // skuKeyStr：sku 组合列表（下方 list）中当前类目对应的 key 值，value 值会是从属于当前类目的一个规格值 id
            v: [
              {
                id: '3', // skuValueId：规格值 id
                name: 'XL', // skuValueName：规格值名称
              },
              {
                id: '4',
                name: 'L',
              }
            ],
          }
        ],
        // 所有 sku 的组合列表，比如红色、M 码为一个 sku 组合，红色、S 码为另一个组合
        list: [
          {
            id: 2259, // skuId
            s1: '1', // 规格类目 k_s 为 s1 的对应规格值 id
            s2: '3', // 规格类目 k_s 为 s2 的对应规格值 id
            price: 999900, // 价格（单位分）
            stock_num: 13 // 当前 sku 组合对应的库存
          },
          {
            id: 2260, // skuId
            s1: '1', // 规格类目 k_s 为 s1 的对应规格值 id
            s2: '4', // 规格类目 k_s 为 s2 的对应规格值 id
            price: 999900, // 价格（单位分）
            stock_num: 81 // 当前 sku 组合对应的库存
          },
          {
            id: 2261, // skuId
            s1: '2', // 规格类目 k_s 为 s1 的对应规格值 id
            s2: '3', // 规格类目 k_s 为 s2 的对应规格值 id
            price: 999900, // 价格（单位分）
            stock_num: 187 // 当前 sku 组合对应的库存
          },{
            id: 2262, // skuId
            s1: '2', // 规格类目 k_s 为 s1 的对应规格值 id
            s2: '4', // 规格类目 k_s 为 s2 的对应规格值 id
            price: 999900, // 价格（单位分）
            stock_num: 134 // 当前 sku 组合对应的库存
          }
        ],
        price: '6999', // 默认价格（单位元）
        stock_num: 227, // 商品总库存
        collection_id: 2261, // 无规格商品 skuId 取 collection_id，否则取所选 sku 组合对应的 id
        none_sku: false, // 是否无规格商品
        messages: [
          {
            // 商品留言
            datetime: '0', // 留言类型为 time 时，是否含日期。'1' 表示包含
            multiple: '0', // 留言类型为 text 时，是否多行文本。'1' 表示多行
            name: '留言', // 留言名称
            type: 'text', // 留言类型，可选: id_no（身份证）, text, tel, date, time, email
            required: '1', // 是否必填 '1' 表示必填
            placeholder: '', // 可选值，占位文本
            extraDesc: ''  // 可选值，附加描述文案
          }
        ],
        hide_stock: false // 是否隐藏剩余库存
      },
      quota: 1, // 限购件数
      showSku: false,
      time: 30 * 60 * 60 * 1000,
      selectedGoods: ''
    }
  },
  computed: {
    ...mapState(['shopCart', 'userInfo']),
    // 监听购物车商品数量变化渲染购物车图标
    goodsNum() {
      let num = 0;
      Object.values(this.shopCart).forEach((goods, index) => {
        num += goods.num;
      });
      if (num > 0) {
        return num;
      }
    },
    userToken() {
      if (this.userInfo) {
        return this.userInfo.token
      }
    }
  },
  mounted() {
    this.initData()
    let goods = {
      id: this.goodsId,
      title: this.goods.name,
      price: this.goods.price,
      thumb: this.goods.sliderImage,
      num: 1,
      desc: this.goods.subtitle,
    }
    this.addFooterPrint(goods)
  },
  methods: {
    ...mapMutations(['ADD_TO_CART','addFooterPrint']),
    collect() {
      this.goods.isCollect = !this.goods.isCollect
      if(this.goods.isCollect){
        addcollect({
          behaviorType: 1,
          currPage: 1,
          productId: this.goodsId
        }).then(res => {
          if(res.code === 200 ){
            Toast("收藏成功！")
          }
        })
      }else{
        delcollect({
          behaviorType: 1,
          currPage: 0,
          productId: this.goodsId
        }).then(res => {
          console.log(res)
          if(res.code === 200 ){
            Toast("取消收藏成功！")
          }
        })
      }
    },
    initData() {
      getdetails(this.goodsId).then(res => {
        if (res.code === 200) {
              this.goods = res.data
              this.goods.picture = res.data.image
        } else {
              this.goods = {}
            }
      })
    },
    onClickLeft() {
      this.$router.go(-1)
    },
    showSkuClicked() {
      let arr = []
      this.goods.skus.forEach(item => {
        arr .push( item.specification.substr(0,2))
        arr .push( item.specification.substr(3,2))
        arr .push( item.specification.substr(6,2))
        arr .push( item.specification.substr(9,2))
        this.sku.tree[0].k = arr[0]
        this.sku.tree[1].k = arr[2]
        this.sku.tree[0].v[0].name = arr[1]
        this.sku.tree[0].v[1].name = arr[5]
        this.sku.tree[1].v[0].name = arr[3]
        this.sku.tree[1].v[1].name = arr[7]
      })
      this.showSku = true
    },
    onBuyClicked() {
      let sku = this.$refs.sku
      if (!sku) {
        Toast("请选择规格")
        return
      }
      const skuData = sku.getSkuData()
      if (!skuData.selectedSkuComb) {
        Toast("请选择规格")
        return
      }
      this.showSku = false

      let spec_list = this.goods.spec_list

      let specs_desc = ''
      if (skuData.selectedSkuComb.s1 && skuData.selectedSkuComb.s1 !== '0') {
        specs_desc += spec_list.filter(item => item.id === skuData.selectedSkuComb.s1).map(item => item.name + ':' + item.value + ';')[0]
      }

      if (skuData.selectedSkuComb.s2 && skuData.selectedSkuComb.s2 !== '0') {
        specs_desc += spec_list.filter(item => item.id === skuData.selectedSkuComb.s2).map(item => item.name + ':' + item.value + ';')[0]
      }

      if (skuData.selectedSkuComb.s3 && skuData.selectedSkuComb.s3 !== '0') {
        specs_desc += spec_list.filter(item => item.id === skuData.selectedSkuComb.s3).map(item => item.name + ':' + item.value + ';')[0]
      }

      this.selectedGoods = { // 购买商品信息
        spu_name: this.goods.name, // 商品名称
        spu_id: this.goods.id, // 商品id
        sku_id: skuData.selectedSkuComb.id, // 商品sku_id
        sku_price: skuData.selectedSkuComb.price / 100, // 商品价格
        sku_quantity: skuData.selectedNum, // 购买数量
        pic_url: this.goods.pic_url, // 图片路径
        specs_desc: specs_desc  // 规格描述
      }
      // console.log(this.selectedGoods)
      this.$router.push({name: 'order', params: {type: 1, goods: this.selectedGoods}});
    },
    onAddCartClicked() {
      let goods = {
        id: this.goodsId,
        title: this.goods,
        price: this.goods.price,
        thumb: this.goods.sliderImage,
        num: 1,
        desc: this.goods.subtitle,
      }
      console.log(goods)
      this.ADD_TO_CART(goods)
    }
  }
}
</script>

<style lang="less">
.goods-detail {
  &-swipe {
    padding-top: 46px;
    height: 280px;
  }

  &-seckill {
    background: #ffffff;

    &-price {
      background: #F75B52;
      color: #ffffff;

      .seckill-price {
        font-size: 20px;
        font-weight: 500;
        padding-left: 20px;
        height: 50px;
        line-height: 50px;
      }

      .price {
        font-size: 14px;
        text-decoration: line-through;
        margin: 10px 0 0 10px;
        width: 100px;

        .tag {
          font-size: 12px;
          display: inline-block;
          border: 1px solid #ffffff;
          text-align: center;

          .icon {
            display: inline-block;
            color: #F75B52;
            background: #ffffff;
            padding-top: 3px;
            width: 20px;
            height: 16px;
            float: left;
            vertical-align: middle;
          }

          .text {
            float: left;
            color: #ffffff;
            background: #F75B52;
            width: 55px;
            padding-top: 3px;
          }
        }
      }
    }

    &-time {
      padding: 5px 10px 0 0;

      .tip {
        font-size: 12px;
        color: #666666;
      }

      .item {
        display: inline-block;
        width: 20px;
        margin-right: 2px;
        color: #fff;
        font-size: 12px;
        text-align: center;
        background-color: #ffffff;
        color: #F75B52;
        border: 1px solid #f3f3f3;
      }

      .split {
        color: #F75B52;
        margin-right: 2px;
      }
    }
  }

  &-sales {
    background: #FFFFFF;
    padding: 16px;

    &-price {
      &-promotion {
        font-size: 18px;
        color: #e25450;
      }

      &-origin {
        maigin-left: 5px;
        text-decoration: line-through;
        color: #999999;
      }
    }
  }


  &-base {
    background: #FFFFFF;
    padding: 16px;

    &-name {
      height: 26px;
      line-height: 26px;
      font-size: 18px;
    }

    &-title {
      color: #999999;
      font-size: 14px;
      height: 26px;
      line-height: 26px;

    }

    &-share {
      height: 52px;
      border-left: 1px solid #cccccc;
      padding-top: 8px;

      .iconfont {
        font-size: 36px;
        color: #999999;
        margin-left: 16px;
      }
    }
  }

  &-sku {
    border-top: 1px solid #f5f5f5;
  }

  &-attribute {
    margin-top: 10px;

    .van-cell-group__title {
      background: #FFFFFF;
      color: #000;
      font-size: 16px;
    }

    .van-cell-group {
      padding: 8px;
    }

    .van-cell {
      margin-bottom: 6px;
      background: #f5f5f5;
      padding: 6px 16px;
    }
  }

  &-detail {
    background: #FFFFFF;
    margin-top: 10px;
    padding: 10px;

    img {
      width: 100%;
    }
  }

  &-faq {
    background: #FFFFFF;
    padding: 10px;

    .van-divider::after, .van-divider::before {
      border-width: 2px 0 0;
    }
  }

  .van-popup--bottom.van-popup--round {
    border-radius: 0
  }
}

</style>
