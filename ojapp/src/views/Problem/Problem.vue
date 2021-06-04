<template>
  <a-layout>
    <Menu></Menu>
    <a-layout :style="{ marginLeft: '100px' }">
      <a-layout-header :style="{ background: '#cdd6f5', height:'15vh',padding: 0 }">
        <div style="margin-left: 20px;margin-top: 20px">
        <b style="font-size: 20px">题目列表</b>
          <a-button type="primary" style="float: right;margin-top: 18px ;margin-right: 40px" @click="showInsert()">新增</a-button>
          <a-input-search
              v-model="value"
              style="float: right;margin-top:18px;margin-right:20px;width: 400px"
              placeholder="输入要查询的题号或标题关键字"
              enter-button
              @search="onSearch(value)"
          />

        </div>
      </a-layout-header>
      <a-layout-content :style="{ margin: '24px 16px 0', background: 'aliceblue' ,overflow: 'initial' }">
        <a-table rowKey="problemId"
                 :columns="columns"
                 :data-source="data"
                 :pagination="{ pageSize: 10 }"

        >
        <span slot="action" slot-scope="text">
          <a-button type="danger" @click="showDelete(text)">删除</a-button>
          <a-divider type="vertical"/>
          <a-button type="primary" @click="showUpadte(text)">修改</a-button>
        </span>
        </a-table>
      </a-layout-content>

    </a-layout>
  </a-layout>

</template>
<script>
const columns = [
  {
    title: '题目编号',
    dataIndex: 'problemId',
    key: 'problemId',
    width: 80,
  },
  {
    title: '标题',
    dataIndex: 'title',
    key: 'title',
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

  data() {
    return {
      data:[],
      columns,
      Problem:{
        problemId:'',
        title:'',
        timeLimit:'',
        memoryLimit:'',
        description:'',
        input:'',
        output:'',
        sampleInput:'',
        sampleOutput:'',
        spj:'',
        hint:'',
        source:'',
      },
    };
  },
  created() {
    this.getRoleList();
  },
  methods: {
    getRoleList() {
      this.$axios.post('http://localhost:8080/Problem/selectAll').then(res => {
        this.data = res.data;
        // alert(JSON.stringify(this.data));
      })
    },
    showDelete(text){
      alert(JSON.stringify(text));
    },
    showInsert(){
      this.$router.push('/AddProblem');
    },
    onSearch(data){
      let d={"key": data};
      alert(JSON.stringify(d))
      this.$axios({
        url: 'http://localhost:8080/Problem/selectproblem',
        method: 'post',
        data: d
      }).then(res => {
        this.data = res.data;
      })
    },
    showUpadte(text){
      this.Problem.problemId=text.problemId
      this.Problem.title=text.title
      this.Problem.timeLimit=text.timeLimit
      this.Problem.memoryLimit=text.memoryLimit
      this.Problem.description=text.description
      this.Problem.input=text.input
      this.Problem.output=text.output
      this.Problem.sampleInput=text.sampleInput
      this.Problem.sampleOutput=text.sampleOutput
      this.Problem.spj=text.spj
      this.Problem.hint=text.hint
      this.Problem.source=text.source
      this.$router.push({
        path:'/UpdateProblem',
        query:this.Problem
      })
    }
  }
};
</script>
