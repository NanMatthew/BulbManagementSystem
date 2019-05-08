<template>
  <div id="app">
    <el-menu
      class="el-menu"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item>
        <a class="navbar-brand" href="#" id="menuhead">X厂库存管理系统</a>
      </el-menu-item>
      <el-menu-item index="1" style="margin-left:750px">首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">关于我们</template>
        <el-menu-item index="2-1">介绍1</el-menu-item>
        <el-menu-item index="2-2">介绍2</el-menu-item>
        <el-menu-item index="2-3">介绍3</el-menu-item>
      </el-submenu>
    <el-menu-item><router-link to="/login">登陆</router-link></el-menu-item>
      <el-menu-item index="4" disabled>消息中心</el-menu-item>
      <el-menu-item index="5"><a href="https://baidu.com" target="_blank" >更多...</a></el-menu-item>
    </el-menu>
    <div id="show_frame">
          <div id="image_logo"><img :src="invent"></div>
          <p>Welcome to Bulb Inventory</p>
          <h3>security&nbsp;&nbsp;efficient&nbsp;&nbsp;convenient</h3>
          <el-button type="text" icon="el-icon-upload" @click="login">登陆</el-button>
    </div>
  </div>
</template>

<script>
import  img from "@/assets/menu.png";
export default {
  name: 'home',
  data() {
      return {
        activeIndex2: '1',
        invent:img
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>
<style lang="stylus" scoped>
#app{
  background: url(../assets/img/timg.jpg) no-repeat;
  height: 700px;
  background-size: 100% 100%;
}
.navbar-brand{
  text-decoration: none;
  font-size: 32px;
  font-family: "方正舒体";
}
#show_frame {
    width: 400px;
    height: 270px;
    padding: 13px;
    position: absolute;
    left: 50%;
    top: 65%;
    margin-left: -200px;
    margin-top: -200px;
    background-color: rgba(240, 255, 255, 0.5);
    border-radius: 10px;
    text-align: center;
} 
#image_logo {
    margin-top: 20px;
}
#image_logo img{
   border-radius:60%;
   height: 100px;
}
#show_frame p{
  font-size: 28px;
  font-family: "方正舒体";
  margin-top: 10px;
}
</style>

