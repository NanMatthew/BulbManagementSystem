<template>
    <div id="app">
        <!--导航条-->
        <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
            <el-menu-item index="1">处理中心</el-menu-item>
            <el-submenu index="2">
                <template slot="title">订单管理</template>
                <el-menu-item index="2-1">产品订单</el-menu-item>
                <el-menu-item index="2-2">入库单</el-menu-item>
                <el-menu-item index="2-3">出库单</el-menu-item>
            </el-submenu>
              <!-- 用户头像 -->
              <el-button class="reset" style="float:right;margin-top:5px;" type="text" @click.native.prevent="handleSubmit2" :loading="logining">退出登陆</el-button>
            <div class="user-avator">
                <img src="../assets/img/img.jpg">
            </div>
        </el-menu>
       <!-- 左侧导航 -->
        <el-row class="tac">
            <el-col :span="18">
                <h5>Admin</h5>
                <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose">
                <el-submenu index="1">
                    <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>角色管理</span>
                    </template>
                    <el-menu-item index="1-1">资料</el-menu-item>
                    <el-menu-item index="1-2">增加</el-menu-item>
                    <el-menu-item index="1-3">删除</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>仓库管理</span>
                    </template>
                    <el-menu-item index="1-1">入库管理</el-menu-item>
                    <el-menu-item index="1-2">出库管理</el-menu-item>
                </el-submenu>
                
                <el-menu-item index="3">
                    <i class="el-icon-setting"></i>
                    <span slot="title">订单管理</span>
                </el-menu-item>
                </el-menu>
            </el-col>
        </el-row>
       
    </div>
</template>
<script>
    export default {
        data() {
            return {
                
                //查询输入框数据
                input: '',
                //导航条默认选项
                activeIndex: '1',
                activeIndex2: '1'
            }
        },
        methods: {
             handleSubmit2(ev) {
                this.$router.push({ path: '/home' });
              },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            indexMethod(index) {
                return index;
            },
             handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>
<style>
    #app {
        font-family: Helvetica, sans-serif;
        text-align: center;
    }
    .user-avator{
        float: right;
        margin-right: 20px;
    }
    .tac{
        float: left;
        /* border:1px solid red; */
        width:300px;
    }
    .user-avator img{
        display: block;
        width:50px;
        height:50px;
        border-radius: 50%;
    }
    .el-col{
        /* border:1px solid red; */
       margin-left: 0px;
    }
</style>

