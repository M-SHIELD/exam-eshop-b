<template>
  <van-tabbar active-color="red" v-model="isActive">
    <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
    <van-tabbar-item to="/type" icon="apps-o" >分类</van-tabbar-item>
    <van-tabbar-item to="/cart" icon="cart-o" badge="2">购物车</van-tabbar-item>
    <van-tabbar-item to="/user" dot icon="contact">个人</van-tabbar-item>
  </van-tabbar>
</template>

<script>
export default {
  name: "FooterMenu",
  props:{
    active:{
      default: 0, //
      type: Number
    },
  },
  data(){
    return{
      isActive:this.active
    }
  }
}
</script>

<style scoped>

</style>
