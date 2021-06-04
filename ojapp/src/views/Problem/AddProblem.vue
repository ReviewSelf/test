<template>

    <a-layout >
        <Menu></Menu>
    <a-layout :style="{ marginLeft: '100px' }">
      <a-layout-header :style="{ background: '#eef0f4', padding: 0 }" >
       <div style="text-align:center" > <b style="font-size: 20px;">新增题目</b></div>
      </a-layout-header>
      <a-layout-content :style="{ margin: '24px 16px 0 200px', overflow: 'initial' }">

        <a-form
          form="form"
          model="Problem"
        >
          <a-form-item label="标题" >
            <a-input class="input" v-model="Problem.title">

            </a-input>
          </a-form-item>
          <a-form-item label="时间限制" >
            <a-input class="input" style="width: 60px" v-model="Problem.timeLimit">

            </a-input><b>sec</b>
          </a-form-item>
          <a-form-item label="内存限制">
            <a-input class="input" style="width: 60px" v-model="Problem.memoryLimit">

            </a-input><b>MB</b>
          </a-form-item>
          <a-form-item label="题目描述">
              <vue-ueditor-wrap class="input" v-model="Problem.description" :config="myConfig">22</vue-ueditor-wrap>
          </a-form-item>
          <a-form-item label="输入">
              <vue-ueditor-wrap class="input" v-model="Problem.input" :config="myConfig">22</vue-ueditor-wrap>
          </a-form-item>
          <a-form-item label="输出">
              <vue-ueditor-wrap class="input" v-model="Problem.output" :config="myConfig">22</vue-ueditor-wrap>
          </a-form-item>
          <a-form-item label="样例输入">
            <a-textarea :auto-size="{ minRows: 6,maxRows:6}"
                        class="input"
                        v-model="Problem.sampleInput"
            >

            </a-textarea>
          </a-form-item>
          <a-form-item label="样例输出">
            <a-textarea :auto-size="{ minRows: 6,maxRows:6}"
                        class="input"
                        v-model="Problem.sampleOutput"
            >

            </a-textarea>
          </a-form-item>
          <a-form-item label="测试输入">
            <a-textarea :auto-size="{ minRows:6,maxRows:6}"
                        class="input"
                        v-model="Problem.textInput"
            >

            </a-textarea>
          </a-form-item>
          <a-form-item label="测试输出">
            <a-textarea :auto-size="{ minRows: 6,maxRows:6}"
                        class="input"
                        v-model="Problem.textOutput"
            >

            </a-textarea>
          </a-form-item>
          <a-form-item label="提示">
              <vue-ueditor-wrap class="input"  v-model="Problem.hint" :config="myConfig">22</vue-ueditor-wrap>
          </a-form-item>
          <a-form-item label="特殊裁判">
            <a-radio-group v-model="Problem.spj"   >
              <a-radio value="0" >
                NO
              </a-radio>
              <a-radio value="1" >
                Yes
              </a-radio>
            </a-radio-group>
          </a-form-item>
          <a-form-item label="竞赛&作业">
            <a-select  placeholder="none">
              <a-select-option >
                none
              </a-select-option>

            </a-select>
          </a-form-item>
        </a-form>

        <div style="text-align: center;margin-right: 200px"><a-button type="primary" @click="OnSubmit()" >保存</a-button> </div>
      </a-layout-content>
      <a-layout-footer :style="{ textAlign: 'center' }">
        Ant Design ©2018 Created by Ant UED
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
export default {
  data () {
    return {
      content: '',
      Problem:{
        title:'',
        timeLimit:'1',
        memoryLimit:'128',
        description:'',
        input:'',
        output:'',
        textInput:"",
        textOutput:'',
        sampleInput:'',
        sampleOutput:'',
        spj:'0',
        hint:'',
        source:'',
      },
      myConfig: {
        // 编辑器不自动被内容撑高
        autoHeightEnabled: false,
        // 初始容器高度
        initialFrameHeight: 180,
        // 初始容器宽度
        initialFrameWidth: '100%',
        // UEditor 资源文件的存放路径，如果你使用的是 vue-cli 生成的项目，通常不需要设置该选项，vue-ueditor-wrap 会自动处理常见的情况，如果需要特殊配置，参考下方的常见问题2
        UEDITOR_HOME_URL: '/UEditor/'
      }
    }
  },
  methods:{
    OnSubmit(){
      alert(JSON.stringify(this.Problem))
      this.$axios({
        url: 'http://localhost:8080/Problem/insert',
        method: 'post',
        data: this.Problem
      })
    }
  }
}
</script>
<style>

.input{
  width: 80%;
}
</style>
