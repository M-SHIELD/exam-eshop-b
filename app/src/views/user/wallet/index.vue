<!--
*@index
*@author micah
*@date 2022/4/27 23:18
-->
<template>
  <div class="body">
    <!--    顶部-->
    <van-nav-bar @click-left="$router.back()" fixed safe-area-inset-top title="我的钱包" left-arrow>
      <template #right>
        <van-icon name="search" size="18"/>
      </template>
    </van-nav-bar>
    <!--    顶栏空间-->
    <div class="fixedroom"></div>
    <!--资产-->
    <div class="userWallet">
      <van-row :type="'flex'" :justify="'center'" :align="'center'">
        <van-col  span="8">总资产(元)</van-col>
        <van-col span="8">累计充值(元)</van-col>
        <van-col span="8">累计消费(元)</van-col>
      </van-row>
      <van-row>
        <van-col span="8">{{ userWallet[0].money }}</van-col>
        <van-col span="8">{{ userWallet[0].totalRecharge }}</van-col>
        <van-col span="8">{{ userWallet[0].totalConsumption }}</van-col>
      </van-row>
    </div>
    <!--    方案-->
    <div class="prepaidPhonePlan">

      <van-cell title="充值xx赠送x" icon="shop-o">
        <!-- 使用 right-icon 插槽来自定义右侧图标 -->
        <template #right-icon>
          <van-button class="btn-cz" size="small" round type="danger">充值</van-button>
        </template>
      </van-cell>

      <van-cell title="充值xx赠送x" icon="shop-o">
        <!-- 使用 right-icon 插槽来自定义右侧图标 -->
        <template #right-icon>
          <van-button class="btn-cz" size="small" round type="danger">充值</van-button>
        </template>
      </van-cell>
    </div>


    <!--底部导航-->
    <FooterMenu :active="-1"></FooterMenu>
  </div>
</template>

<script>
import FooterMenu from "@/components/footerMenu";
import {walletInfo} from "@/api/wallet";

export default {
  name: "index",
  components: {FooterMenu},
  data() {
    return {
      userWallet: {
        price: 5910.4,
        accumulatedTop: 21212,
        cumulative: 7705
      }
    }
  },
  created() {
    this.getWalletInfo()
  },
  methods: {
    getWalletInfo(){
      walletInfo({
        "maijiaid":2
      }).then(e=>{
        this.userWallet=e.data
        console.log(this.userWallet)
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.body {
  background-color: #f8f8f8;
  height: 100vh;
  padding: 10px;
}

.fixedroom {
  height: 55px;
}

.btn-cz {
  padding: 0 20px;
}
.userWallet{
  background-color: #000000;
  color: #eca847;
  border-radius: 10px;
  font-size: 14px;
  padding: 10px;
  .van-col{
    padding: 5px;
    text-align: center;
    vertical-align: middle;

  }
}
.prepaidPhonePlan{
  border-radius: 10px;
  margin-top: 20px;
  background-color: #FFFFFF;
}
</style>
