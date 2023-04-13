<template>
  <div class="user">
    <van-row class="user-info">

      <van-image
          round
          width="100"
          height="100"
          :src="this.userlist.avator!=null?this.userlist.avator:'https://th.bing.com/th/id/OIP.ytZ3w0NP3JfGHzPzNXO25QAAAA?w=146&h=150&c=7&r=0&o=5&dpr=1.3&pid=1.7'"
      />
      <span class="user-info-name" v-if="token">micah</span>
      <span class="user-info-name" v-if="!token"><span @click="$router.push('/login')">登录/</span><span
          @click="$router.push('/landing')">注册</span></span>
    </van-row>

    <!--    钱包-->


    <van-cell title="我的订单" is-link @click="handleOpenOrder"/>

    <div class="orderState">
      <div class="item">
        <van-icon class="iconfont" class-prefix="icon" name="daifukuan"/>
        待付款
      </div>
      <div class="item">
        <van-icon class="iconfont" class-prefix="icon" name="daifahuo"/>
        待发货
      </div>
      <div class="item">
        <van-icon class="iconfont" class-prefix="icon" name="daishouhuo"/>
        待收货
      </div>
      <div class="item">
        <van-icon class="iconfont" class-prefix="icon" name="daipingjia"/>
        待评价
      </div>
      <div class="item">
        <van-icon class="iconfont" class-prefix="icon" name="daipingjia"/>
        已完成
      </div>
    </div>


    <van-cell-group title="我的功能" class="user-func">
      <van-cell>
        <!--        <van-col span="6" @click="gotoCoupon">-->
        <!--          <van-icon class="iconfont" class-prefix="icon" name="youhuiquan"/>-->
        <!--          优惠券-->
        <!--        </van-col>-->
        <van-col @click="toCollect" span="6">
          <van-icon class="iconfont" class-prefix="icon" name="shangpinshoucang"/>
          商品收藏
        </van-col>
        <van-col @click="toFootPrint" span="6">
          <van-icon class="iconfont" class-prefix="icon" name="zuji"/>
          浏览足迹
        </van-col>
        <van-col span="6" @click="gotoAddress">
          <van-icon class="iconfont" class-prefix="icon" name="shouhuodizhi1"/>
          地址管理
        </van-col>
        <van-col span="6" @click="toWallet">
          <van-icon class="iconfont" class-prefix="icon" name="daifukuan"/>
          钱包
        </van-col>
      </van-cell>
    </van-cell-group>

    <van-cell-group title="我的服务" class="user-service">
      <van-cell>
        <van-col span="6">
          <van-icon class="iconfont" class-prefix="icon" name="bangzhuzhongxin1"/>
          帮助中心
        </van-col>
        <van-col span="6">
          <van-icon class="iconfont" class-prefix="icon" name="yijianfankui"/>
          意见反馈
        </van-col>
        <van-col span="6">
          <van-icon class="iconfont" class-prefix="icon" name="lianxikefu"/>
          联系客服
        </van-col>
        <van-col span="6">
          <van-icon class="iconfont" class-prefix="icon" name="guanyuwomen"/>
          关于我们
        </van-col>
      </van-cell>
    </van-cell-group>


    <van-row class="user-logout">
      <a href="javascript:void(0)" @click="handleClickLogout" v-if="token">退出登录</a>
    </van-row>

    <FooterMenu :active="3"></FooterMenu>

  </div>
</template>

<script>
import {Toast} from 'vant'
import FooterMenu from "@/components/footerMenu";
import {postUserInformation} from "@/api/userinformation";

export default {
  data() {
    return {
      token: localStorage.getItem('TOKEN') ? 1 : 0,
      userlist: {}
    }
  },
  components: {FooterMenu},
  mounted() {
    this.init()
  },
  methods: {
    init() {
      if (this.token) {
        postUserInformation().then(res => {
          if (res.code === 200) {
            this.userlist = res.data
          }
        })
      }
    },
    handleOpenOrder: function () {
      this.$router.push({path: '/user/order'})
    },
    handleClickLogout: function () {
      localStorage.removeItem('TOKEN')
      Toast("退出成功")
      this.$router.go(0)
    },
    gotoAddress: function () {
      this.$router.push({path: '/address'})
    },
    gotoCoupon: function () {
      this.$router.push({path: '/user/coupon'})
    },
    toWallet() {
      this.$router.push({path: '/user/wallet'})
    },
    toFootPrint() {
      this.$router.push({path: '/user/footPrint'})
    },
    toCollect() {
      this.$router.push({path: '/user/collect'})
    }
  }
};
</script>

<style lang="scss">
.orderState {
  display: flex;
  flex-direction: row;
  justify-content: center;

  .item {
    padding: 10px 22px;
    font-size: 12px;
    text-align: center;
    background-color: #fff;
  }

  .iconfont {
    display: block;
    font-size: 30px;
    padding: 5px;
  }
}

.user {
  background: #f8f8f8;
  height: 100vh;

  &-info {
    height: 100px;
    padding: 15px;
    background: url("@/assets/images/user_head_bg.png") no-repeat;
    background-size: 100%;

    &-name {
      display: inline-block;
      color: #FFFFFF;
      height: 80px;
      vertical-align: top;
      padding: 20px 0 0 10px;
      font-size: 20px;
    }
  }

  &-func, &-service, &-order {
    .van-cell {
      padding: 0;
    }

    .van-col {
      padding: 10px 0;
      font-size: 12px;
      text-align: center;
      background-color: #fff;
    }

    .van-icon, .iconfont {
      display: block;
      font-size: 30px;
      padding: 5px;
    }
  }

  &-logout {
    position: fixed;
    bottom: 7vh;
    width: 100%;
    margin-top: 20px;
    background: #FFFFFF;
    text-align: center;

    a {
      height: 60px;
      line-height: 60px;
      color: #ff6c6c;
      font-size: 20px;
    }
  }

  /*转场动画*/

  .router-slider-enter-active,
  .router-slider-leave-active {
    transition: all 0.3s;
  }

  .router-slider-enter,
  .router-slider-leave-active {
    transform: translate3d(2rem, 0, 0);
    opacity: 0;
  }

  .van-cell:not(:last-child)::after {
    left: 0 !important;
  }
}
</style>
