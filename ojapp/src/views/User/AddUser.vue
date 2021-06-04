<template>

  <a-layout >
    <Menu></Menu>
    <a-layout :style="{ marginLeft: '100px' }">
      <a-layout-header :style="{ background: '#eef0f4', padding: 0 }" >
        <div style="text-align:center" > <b style="font-size: 20px;">添加用户</b></div>
      </a-layout-header>
      <a-layout-content :style="{ margin: '40px 16px 0 400px', overflow: 'initial' }">

        <a-form-model :model="User" :label-col="labelCol" :wrapper-col="wrapperCol">
          <a-form-model-item label="用户名">
            <a-input v-model="User.name"  placeholder="请输入用户名"/>
          </a-form-model-item>

          <a-form-model-item label="学号">
            <a-input v-model="User.userId" placeholder="学号"/>
          </a-form-model-item>
          <a-form-model-item label="类别">
            <a-select v-model="User.category" placeholder="选择你的类别">
              <a-select-option value="学生">
                学生
              </a-select-option>
              <a-select-option value="管理员">
                管理员
              </a-select-option>
              <a-select-option value="老师">
                老师
              </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item style="margin-left: 15%">
            注：初始密码为123456
          </a-form-model-item>
        </a-form-model>


        <div style="text-align: center;margin-right: 50%"><a-button type="primary" @click="OnSubmit()" >添加</a-button> </div>
      </a-layout-content>
      <a-layout-footer :style="{ textAlign: 'center' }">
       OJSystem
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
export default {
  data () {
    return {
      content: '',
      labelCol: { span: 4 },
      wrapperCol: { span: 8 },
      User:{
        userId:'',
        category:'',
        name:''
      },
    }
  },
  methods:{
    OnSubmit(){
      if(this.User.userId!==''){
        this.$axios({
          url: 'http://localhost:8080/User/addUser',
          method: 'post',
          data: this.User
        }).then(res=>{
          console.log(res)
          if(res.data==true){
            alert("添加成功")
            this.$router.push('/User')
          }
          else{
            alert("添加失败,可能原因：改学号已被注册")
          }
        })
      }
      else {
        alert("请输入学号")
      }


    }
  }
}
</script>
<style>

</style>
