<template>


  <a-layout-sider :trigger="null"   collapsible :style="{ overflow: 'auto', height: '100vh',background:'#34485e', position: 'fixed', left: 0 }" width="100px">
    <div class="logo"/>
    <a-menu
        mode="inline"
        :selectedKeys="[$route.path]"
        style="background: #34485e"
        @click="handleClick"
    >
        <a-menu-item  style="height: 80px">
          <a-icon :key="'/Problem'" type="container" class="icon"/>
          <router-link to="Problem"> <p class="word">题库信息</p></router-link>

        </a-menu-item>
        <a-menu-item style="height: 70px">
          <a-icon type="highlight" class="icon"/>
          <p class="word" style="margin-left: 2px">比赛</p>
        </a-menu-item>
        <a-menu-item style="height: 70px">
          <a-icon type="usergroup-delete" class="icon"/>
          <router-link to="User"> <p class="word">人员管理</p></router-link>
        </a-menu-item>
        <a-menu-item style="height: 70px">
          <a-icon type="user" class="icon" />
          <router-link to="Own"><p class="word" >个人中心</p></router-link>
        </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>

<script>
export default {
  name: "Menu",
  data() {
    return {
    };
  },
  methods: {
    handleClick(e) {
      console.log('click', e);
    },

  },

}
</script>

<style scoped>

.logo {
  height: 32px;
  background: rgba(9, 9, 9, 0.2);
  margin: 16px;
}
.word{
  color: white;
  font-weight: 600;
  margin-top: -20px;
  margin-left: -10px;
}
.icon{
  font-size:36px

}
</style>