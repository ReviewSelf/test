<template>
  <a-layout>
    <a-layout-header style="height: 10vh;background: #ffffff;text-align: center">
      <b style="font-size: 30px">登录界面</b>
    </a-layout-header>
      <a-layout style="height: 100vh">
        <a-layout-content >
          <div style="width: 550px;height:450px;position:absolute;margin-left: 36%;margin-top:9%;background: #FFFFFF" >
          <a-form style="">
            <br>
            <a-form-item   style="text-align: center" >
              <a-icon type="user" style="color: #0000e3;font-size: 50px;border-radius: 100%;border: 1px solid #000000"/>
            </a-form-item>
            <a-form-item label="登录账号" style="margin-left: 30%">
              <a-input
                  v-model="user.userId"
                  style="width: 60%"
                  placeholder="请输入你的账号"
              >
                <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
              </a-input>
            </a-form-item>
            <a-form-item label="登录密码" style="margin-left: 30%">
              <a-input
                  v-model="user.password"
                  style="width: 60%"
                  type="password"
                  placeholder="请输入密码"
              >
                <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
              </a-input>
            </a-form-item  >
            <a-form-item  style="text-align: center">
              <a-button  type="primary" @click="submit()" >
                登录
              </a-button>

              <br>
              <a style="margin-left: 20px" href="">
              忘记密码? 点击联系管理员
            </a>
            </a-form-item>
          </a-form>
          </div>
        </a-layout-content>
      </a-layout>
  </a-layout>


</template>

<script>
import {routes2} from "@/router";

export default {
  data(){
    return {
      user:{
        userId:'',
        password:'',
      }
    }
  },
  methods: {
    submit(){
      this.$axios({
        url:'http://localhost:8080/User/searchLoginUser',
        method:"post",
        data:this.user
      }).then(res => {
        if(res.data!=''){
            this.$store.commit("login");
            this.$store.commit("saveLoginUser",res.data)
            this.$router.addRoutes(routes2);
            this.$router.push('/Problem')
        }
        else {
          alert("登录账号或密码错误")
        }

      })
    }
  },
};
</script>
<style>

</style>
