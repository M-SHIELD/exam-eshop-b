<template>
  <div>
    <van-nav-bar @click-left="$router.back()" fixed safe-area-inset-top title="购物车" left-arrow>
      <template #right>
        <van-icon name="search" size="18"/>
      </template>
    </van-nav-bar>
    <!--    顶栏空间-->
    <div class="fixedroom"></div>

    <!-- 购物车列表 -->
    <van-checkbox-group checked-color="red" class="car-room" v-model="checkedGroup" ref="checkboxGroup">
      <van-card
          :price="item.price"
          :desc="item.desc"
          v-for="(item,index) in shopCart" :key="index"
      >
        <template slot="title">  <!-- 自定义标题部分，主要是为了添加删除商品按钮 -->
          <span>{{ item.title }}</span>
          <span style="float:right;" @click="removeShop(item)"><van-icon name="delete"/></span>
        </template>
        <template slot="thumb">  <!-- 自定义左侧部分，为了添加左侧checkbox -->
          <van-checkbox :name="item.title" icon-size="12px"></van-checkbox>
          <van-image :src="item.thumb"></van-image>
        </template>
        <template slot="bottom">  <!-- 自定义底部，为了实现商品数量功能 -->
          <div class="num">
            <van-button size="small" @click="minusnum(item)" :disabled="item.num <=1">-</van-button> <!-- 数量小于1时禁用按钮 -->
            {{ item.num }}
            <van-button size="small" @click="addnum(item)">+</van-button>
          </div>
        </template>
      </van-card>

      <!-- 统计 -->
      <van-submit-bar :price="allcount" button-text="结算" @submit="onSubmit">
        <van-checkbox @click="checkAll" v-model="isAllChecked">全选</van-checkbox>
      </van-submit-bar>
    </van-checkbox-group>




    <!--  底部菜单-->
    <FooterMenu :active="2"></FooterMenu>

  </div>
</template>

<script>
import FooterMenu from "@/components/footerMenu";
import {mapState} from "vuex";

export default {
  name: "BuyCar",
  components: {FooterMenu},
  data() {
    return {
      checkedGroup: []
    }
  },
  computed: {
    ...mapState(['shopCart']),
    shopCart() {
      return this.$store.state.shopCart
    },
    isAllChecked() {
      if (this.checkedGroup.length === this.shopCart.length && this.shopCart.length !== 0) { //选中数与商品总数相等并且购物车内存在商品
        return true //表示全选状态
      } else {
        return false //表示未全选
      }
    },
    //computed中
    allcount() {
      let sumup = 0
      for (let i = 0; i < this.shopCart.length; i++) {
        if (this.checkedGroup.find(item => { //判断是否选中商品，未选中不计算在内
          return item === this.shopCart[i].title
        })) {
          sumup += this.shopCart[i].num * this.shopCart[i].price
        } else {
          continue
        }
      }
      return sumup
    },//methods中，点击删除商品图标按钮时
  },
  methods: {
    onSubmit(){//结算

    },
    checkAll() {
      if (this.checkedGroup.length !== 0) { //有商品卡片选中
        if (this.checkedGroup.length === this.shopCart.length) { //总商品数与选中商品卡片数相等，说明此时已全选
          this.$refs.checkboxGroup.toggleAll(false); //令所有选中的反选，即全不选
        } else { //商品卡片数部分选中
          this.$refs.checkboxGroup.toggleAll(true); //令所有商品全部选中
        }
      } else { //没有商品卡片选中，直接全选
        this.$refs.checkboxGroup.toggleAll(true);
      }
    }, addnum(item) {
      this.shopCart.find(element => {
        return element.title === item.title
      }).num = parseInt(item.num) + 1
    },
    minusnum(item) {
      this.shopCart.find(element => {
        return element.title === item.title
      }).num = parseInt(item.num) - 1
    },
    removeShop(item) {
      for (let i = 0; i < this.shopCart.length; i++) {
        if (item.title === this.shopCart[i].title) {
          let index = this.checkedGroup.indexOf(item.title)
          this.shopCart.splice(i, 1) //移除商品
          if (index === -1) {
            return
          }
          this.checkedGroup.splice(index, 1) //移除checkedGroup中刚刚删除的商品，不然不会即时刷新
        }
      }
    }
  }
}
</script>

<style scoped>
.fixedroom {
  height: 55px;
}

.cartext {
  padding: .2rem .4rem;
  font-size: .5rem;
}

.car-room {
  padding-top: .2rem;
  background: #f8f8f8;
  height: 90vh;
}

/deep/ .van-button--normal {
  padding: 0;
  height: 5vh;
}

.count {
  position: fixed;
  bottom: 9vh;
  width: 100%;
  /*height: .6rem;*/
}

/deep/ .van-card {
  background-color: #FFFFFF;
}
/deep/.van-submit-bar{
  position: fixed;
  bottom: 7vh;
}
</style>
