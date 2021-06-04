<template>
  <div>
    <!-- 留坑，非常重要 -->
    <router-view></router-view>
  </div>

</template>

<script>
export default {
  created() {
    this.$router.push('/')
  },

}
</script>

<style scoped>

</style>