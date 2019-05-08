<template>
<div>
  <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-position="left" label-width="80px" class="login-box">
    <h3 class="title">系统登录</h3>
    <!-- 用户名 -->
    <el-form-item label="用户名" prop="account">
      <el-input type="text" v-model="ruleForm2.account" placeholder="用户名" suffix-icon="el-icon-user-solid"></el-input>
    </el-form-item>
    <!-- 密码 -->
    <el-form-item label="密码" prop="checkPass">
      <el-input type="password" v-model="ruleForm2.checkPass" placeholder="密码" suffix-icon="el-icon-lock"></el-input>
    </el-form-item>
    <!-- 验证码 -->
      <el-form-item  prop="verifycode">
        <el-input v-model="ruleForm2.verifycode" placeholder="请输入验证码" class="identifyinput"/>
      </el-form-item>
      <el-form-item>
      <div class="identifybox">
        <div @click="refreshCode">
          <s-identify :identifyCode="identifyCode"></s-identify>
        </div>
        <el-button @click="refreshCode" type='text' class="textbtn">看不清，换一张</el-button>
      </div>
      </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click.native.prevent="handleSubmit2" :loading="logining">登录</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
import { requestLogin } from '../api/api';
  // 引入验证码组件
import SIdentify from "@/views/SIdentify.vue";
  export default {
    components: { SIdentify },
    data() {
          // 验证码自定义验证
   const validateVerifycode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入验证码'))
      } else if (value !== this.identifyCode) {
        console.log('validateVerifycode:', value)
        callback(new Error('验证码不正确!'))
      } else {
        callback()
      }
    }
    return {
         // 验证码随机数
      identifyCodes: "1234567890",
      identifyCode: "",
        logining: false,
        ruleForm2: {
          account: 'admin',
          checkPass: '123456'
        },
        rules2: {
          account: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            { min: 5, max: 20, message: '长度在 5 到 20 个字符之间', trigger: 'blur' }
          ],
          checkPass: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 5, max: 20, message: '长度在 5 到 20 个字符之间', trigger: 'blur' }
          ],
          verifycode:[
             { required: true, trigger: 'blur', validator: validateVerifycode }
          ]
        },
        checked: true
      };
    },
     //***************************** */  
  mounted() {
    // 验证码初始化
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
  },
    methods: {

      handleSubmit2(ev) {
        var _this = this;
        this.$refs.ruleForm2.validate((valid) => {
          if (valid) {
            this.logining = true;
            var loginParams = { username: this.ruleForm2.account, password: this.ruleForm2.checkPass };
            requestLogin(loginParams).then(data => {
              this.logining = false;
              let { msg, code, user } = data;
              if (code !== 200) {
                this.$message({
                  message: msg,
                  type: 'error'
                });
              } else {
                sessionStorage.setItem('user', JSON.stringify(user));
                this.$router.push({ path: '/admin' });
              }
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
       // 生成随机数
    randomNum(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    },
    // 切换验证码
    refreshCode() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
    },
    // 生成四位随机验证码
    makeCode(o, l) {
      for (let i = 0; i < l; i++) {
        this.identifyCode += this.identifyCodes[
          this.randomNum(0, this.identifyCodes.length)
        ];
      }
      console.log(this.identifyCode);
    },
    },
    created() {
    this.refreshCode();
  }
  }

</script>

<style lang="scss" scoped>
 .login-box {
    border: 1px solid #DCDFE6;
    width: 350px;
    margin: 180px auto;
    padding: 35px 35px 15px 35px;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 25px #909399;
  }
   .title{
      text-align: center;
      margin: 0 auto 40px auto;
      color: #303133;
    }
  .remember {
      margin: 0px 0px 35px 0px;
    }
     .identifybox{
  display: flex;
  justify-content: space-between;
  margin-top:7px;
}
</style>