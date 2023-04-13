<template>
  <div>
    <van-nav-bar
        left-arrow
        right-text="登录"
        @click-left="$router.push('/')"
        @click-right="$router.push('/login')"
    />
    <div class="textbox">
      <img src="./images/yanxuan.svg" />
      <span class="text">欢迎来到网易严选</span>
    </div>
   <div class="registerbox">
    <van-form validate-first>
      <van-field
          v-model="phone"
          placeholder="请输入手机号码"
          :rules="[{ required: true, message: '请填写手机号码' }]"
      />
      <van-field
          v-model="sms"
          center
          clearable
          placeholder="请输入短信验证码"
      >
        <template #button>
          <van-button color="#1E90FF" size="small" type="primary" @click="sendCaptcha">发送验证码</van-button>
        </template>
      </van-field>
      <van-field
          v-model="username"
          name="pattern"
          placeholder="请输入用户名"
          :rules="[{ required: true, message: '请填写用户名' }]"
      />
      <van-field
          v-model="email"
          name="validator"
          placeholder="请输入邮箱"
          :rules="[{ required: true, message: '请填写邮箱' }]"
      />
      <van-field
          v-model="password"
          name="validator"
          placeholder="请输入密码"
          :rules="[{ required: true, message: '请填写密码' }]"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit" @click="goregister">注册</van-button>
      </div>
    </van-form>
   </div>
  </div>
</template>

<script>
import {postregister} from "@/api/register";
import {Toast} from "vant";
export default {
  name: "register",
  data() {
    return {
      phone:'',
      sms:'',
      username:'',
      email:'',
      password:'',
    };
  },
  methods:{
    sendCaptcha(){
      if(this.phone !== ''){
        this.sms = 135791
      }else{
        Toast("请输入手机号码！")
      }
    },
    goregister(){
      if(this.phone !== '' && this.sms == '135791' && this.username !== '' && this.email !== '' && this.password !== ''){
        postregister({
          email:this.email,
          password: this.password,
          phone: this.phone,
          username: this.username
        }).then(res => {
          if(res.code == 200){
            this.$router.push('/login')
          }
        })
      }else{
        Toast("所有内容不能为空！")
      }
    }
  }
}
</script>

<style lang="less" scoped>
.textbox{
  margin-top: 1rem;
  height: 40px;
  display: flex;
  align-items: flex-start;
  img{
    display: flex;
    margin-bottom: 0px;
    width: 35px;
    height: 35px;
  }
  .text{
    display: flex;
    color: #cccccc;
  }
}
.registerbox{
  width: 100%;
  margin-top: 1rem;
  .landignbt{
    width: 5rem;
    margin: 1rem 2.3rem;
  }
}

</style>
