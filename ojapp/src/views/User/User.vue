<template>
  <a-layout>
  <Menu></Menu>
  <a-layout :style="{ marginLeft: '100px' }">
    <a-layout-header :style="{ background: '#cdd6f5', height:'15vh',padding: 0 }">
      <div style="margin-left: 20px;margin-top: 20px">
        <b style="font-size: 20px">用户信息</b>
        <a-button type="primary" style="float: right;margin-top: 18px ;margin-right: 40px" @click="showInsert()">新增</a-button>
        <a-input-search
            v-model="value"
            style="float: right;margin-top:18px;margin-right:20px;width: 400px"
            placeholder="请输入用户账号或用户名"
            enter-button
            @search="onSearch(value)"
        />

      </div>
    </a-layout-header>
    <a-layout-content :style="{ margin: '24px 16px 0', background: 'aliceblue' ,overflow: 'initial' }">
      <a-table rowKey="userId"
               :columns="columns"
               :data-source="data"
               :pagination="{ pageSize: 20 }"

      >
        <span slot="action" slot-scope="text">
          <a-button type="danger" @click="showDelete(text)">删除</a-button>
          <a-divider type="vertical"/>
          <a-button type="primary" @click="showUpadta(text)">还原密码</a-button>
        </span>
      </a-table>
    </a-layout-content>

  </a-layout>
</a-layout>

</template>

<script>
const columns = [
  {
    title: '用户账号',
    dataIndex: 'userId',
    key: 'userId',
    width: 80,
  },
  {
    title: '用户名',
    dataIndex: 'users.nick',
    key: 'users.nick',
    width: 80,
  },
  {
    title: '类别',
    dataIndex: 'category',
    key: 'category',
    width: 50,
  },
  {
    title: '提交次数',
    dataIndex: 'users.submit',
    key: 'users.submit',
    width: 50,
  },
  {
    title: '通过次数',
    dataIndex: 'users.solved',
    key: 'users.solved',
    width: 50,
  },
  {
    title: '积分',
    dataIndex: 'integral',
    key: 'integral',
    width:50,
  },
  {
    title: '等级',
    dataIndex: 'rank',
    key: 'rank',
    width: 100,
  },
  {
    title: '操作',
    key: 'action',
    scopedSlots: {customRender: 'action'},
    width: 80,
    ellipsis: true,
  },

];
export default {
  name: "User",
  data(){
    return{
      data:[],
      columns,
      value:'',
      integral:'',
      rank:'',
      User:{
        userId:'',
        category:'',
        users:{
          nick:'',
          solved:'',
          submit:''
        }
      }
    }
  },
  created() {
    this.getRoleList();
  },
  methods:{
    getRoleList(){
      this.$axios.post('http://localhost:8080/User/searchAll').then(res => {
        console.log(res)
        this.data= res.data.users;
      })
    },
    showInsert() {
      this.$router.push('/AddUser')
    },
    onSearch(data){
      let d={"key":data}
      alert(JSON.stringify(d))
      this.$axios({
        url: 'http://localhost:8080/User/searchUser',
        method: 'post',
        data: d
      }).then(res => {
        this.data = res.data;
      })
    },
    showUpadta(text){
      let d={"userId":text.userId}
      this.$axios({
        url: 'http://localhost:8080/User/updatePassword',
        method: 'post',
        data: d
      })
      alert("密码初始化成功")
    }

  }
}
</script>

<style scoped>

</style>