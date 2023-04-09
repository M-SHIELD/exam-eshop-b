<template>
  <div>
    <!--  导航  -->
    <van-nav-bar
        left-arrow
        right-text="注册"
        @click-left="$router.push('/')"
        @click-right="$router.push('/landing')"
    />
    <div class="textbox">
      <span>手机快捷登录</span><br/>
      <span class="two">未注册过的手机将自动创建账号</span>
    </div>

    <van-form validate-first>
      <!-- 通过 pattern 进行正则校验 -->
      <van-field
          v-model="username"
          name="pattern"
          placeholder="请输入用户名"
      />
      <!-- 通过 validator 进行函数校验 -->
      <van-field
          v-model="password"
          name="validator"
          placeholder="请输入密码"
          :rules="[{ pattern: /\d{6}/,message: '密码错误' }]"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit" @click="loginSuccess">登录</van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import {getUUID} from '@/utils/uuid'
import {postlogin} from "@/api/login";
import {Toast} from "vant";
export default {
  name: "login",
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods:{
    loginSuccess(){
      postlogin({
        username: this.username,
        password: this.password
          }).then(res => {
        if(res.msg == '登录成功'){
          localStorage.setItem('TOKEN',res.token)
          this.$router.push('/')
        }
      })

    }
  }
}
</script>

<style lang="less" scoped>
.textbox{
  margin: 0.5rem;
  .two{
    font-size: 5px;
    color: #cccccc;
  }
}
</style>
