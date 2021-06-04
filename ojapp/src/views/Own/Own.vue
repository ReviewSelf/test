<template>
  <a-layout>
    <Menu></Menu>
    <a-layout :style="{ marginLeft: '100px' }">
      <a-layout-header :style="{ background: '#cdd6f5', height:'15vh',padding: 0, }" >
        <br>
        <b style="font-size: 20px;margin-left: 100px;">欢迎  {{User.users.nick}} ({{User.category}})</b>
      </a-layout-header>
      <a-layout>
        <a-form>
          <br><br><br>
          <a-form-item label="账号" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <b style="font-size: 15px">{{ User.userId}}</b>
          </a-form-item>
          <a-form-item label="密码" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <a-button type="primary" @click="changePassword()">修改密码</a-button>
          </a-form-item>
          <a-form-item label="邮箱" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <b style="font-size: 15px">{{ User.users.email}}</b>
          </a-form-item>

          <a-form-item label="学校" :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <b style="font-size: 15px">{{ User.users.school}}</b>
          </a-form-item>
          <a-form-item label="正确率">


          </a-form-item>
          <a-form-item style="margin-left: 20%;position:absolute;">
            <a-button type="primary" @click="revise()">修改信息</a-button>
          </a-form-item>

        </a-form>




          <a-modal
              title="修改信息"
              :visible="visible"
              :confirm-loading="confirmLoading"
              @ok="handleOk"
              @cancel="handleCancel"
          >
          <a-form :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <a-form-item label="昵称">
              <a-input v-model="User.users.nick"></a-input>
            </a-form-item>
            <a-form-item label="邮箱">
              <a-input v-model="User.users.email"></a-input>
            </a-form-item>
            <a-form-item label="学校">
              <a-input v-model="User.users.school"></a-input>
            </a-form-item>

          </a-form>


          </a-modal>



        <a-modal
            title="修改信息"
            :visible="visible1"
            :confirm-loading="confirmLoading1"
            @ok="handleOk1"
            @cancel="handleCancel1"
        >
          <a-form :label-col="{ span: 5 }" :wrapper-col="{ span: 12 }">
            <a-form-item label="旧密码">
              <a-input ></a-input>
            </a-form-item>
            <a-form-item label="新密码">
              <a-input ></a-input>
            </a-form-item>

          </a-form>


        </a-modal>


      </a-layout>
    </a-layout>
  </a-layout>

</template>
<script>

export default {
  data(){
    return{
      confirmLoading: false,
      visible: false,
      confirmLoading1: false,
      visible1: false,
      User:{
        userId:'',
        oldpassword:'',
        newpassword:'',
        category:'',
        users:{
          nick:'',
          solved:'',
          submit:'',
          email:'',
          school:'',
        }
      }
    }
  },
  created() {
    console.log(this.$store.getters.getUser);
    this.User=JSON.parse(JSON.stringify(this.$store.getters.getUser || {}))
  },
  methods: {
    revise(){
      this.visible=true;
    },
    handleOk() {
      this.confirmLoading = true;
      setTimeout(() => {
        this.visible = false;
        this.confirmLoading = false;
      }, 1000);
    },
    handleCancel() {
      this.User=JSON.parse(JSON.stringify(this.$store.getters.getUser || {}))
      this.visible = false;
    },


    changePassword(){
      this.visible1=true;
    },
    handleOk1() {
      this.confirmLoading1 = true;
      setTimeout(() => {
        this.visible1 = false;
        this.confirmLoading1 = false;
      }, 1000);
    },
    handleCancel1() {
      this.visible1 = false;
    },
  },
};
</script>
