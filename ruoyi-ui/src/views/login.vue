<template>
  <div class="login">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <h3 class="title">WBEX后台管理系统</h3>
      <el-form-item prop="username">
        <el-input
          v-model="loginForm.username"
          type="text"
          auto-complete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          v-model="loginForm.code"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
        <div class="login-code">
          <img :src="codeUrl" @click="getCode" class="login-code-img"/>
        </div>
      </el-form-item>
      <!-- <el-form-item prop="googleCode">
        <el-input
          v-model="loginForm.googleCode"
          auto-complete="off"
          placeholder="谷歌验证码"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item>
        <div id="qca" class="qcto" ref="qcto" @click="getGoogleCode()"></div>
          @click.native.prevent="subm"
      </el-form-item> -->
      <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading2">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right;" v-if="register">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>
    <el-dialog title="谷歌验证器" width="400px" :visible.sync="dialogTableVisible">
      <el-form ref="loginForm" :model="loginForm" :rules="loginForm">
        <el-form-item prop="googleCode">
          <el-input v-model="loginForm.googleCode" placeholder="请输入谷歌验证码" />
        </el-form-item>
        <el-form-item>
          <div id="qca" class="qcto" ref="qcto"></div>
        </el-form-item>
        <el-form-item style="width:100%;">
          <el-button
            size="medium"
            type="primary"
            style="width:100%;"
            @click.native.prevent="subm"
          >验  证
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--  底部  -->
    <div class="el-login-footer">
      <span>Copyright © 2018-2022 ruoyi.vip All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { getCodeImg,getGoogle } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from '@/utils/jsencrypt'
import axios from 'axios'
import QRCode from 'qrcodejs2'
import yearVue from '../components/Crontab/year.vue';
import { setToken,setId } from '@/utils/auth'
import { checkGoogleCode } from '@/api/login'
export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      dialogTableVisible:false,
      token:"",
      id:"",
      loginForm: {
        username: "",
        password: "",
        rememberMe: false,
        code: "",
        uuid: "",
        secret: "",
        googleCode: "",
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }],
        googleCode: [{ required: true, trigger: "change", message: "请输入谷歌验证码" }]
      },
      loading: false,
      loading2: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined,

    };
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true
    }
  },
  created() {
    this.getCode();
    this.getCookie();
  },
  mounted(){

  },
  methods: {
    getGoogleCode(e){
      getGoogle(e).then(res=>{
        if(res.check){
          this.creatQrCode(res.qrCode)
        }
        this.loginForm.secret = res.secret;
      })
    },
    creatQrCode(e){
       document.getElementById("qca").innerHTML = "";
      let qrcode = new QRCode(this.$refs.qcto,{
        text:e,
        width:120,
        height:120,
        colorDark: '#000000',
        colorLight: '#ffffff',
        correctLevel: QRCode.CorrectLevel.H
      })
    },
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    getCookie() {
      const username = Cookies.get("username");
      const password = Cookies.get("password");
      const rememberMe = Cookies.get('rememberMe')
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password: password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
      };
    },
    subm(){

      if(this.loginForm.googleCode == '' || this.loginForm.googleCode == undefined){
            this.$message.error("谷歌码不能为空");
      }else{
        checkGoogleCode(this.loginForm).then(res=>{
          setToken(this.token)
          setId(this.id)
          this.$modal.msgSuccess("验证成功");
          this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
        })
      }
      // this.$refs.loginForm.validate(valid => {
      //   if (valid) {
      //     this.loading2 = true;
      //     this.dialogTableVisible = true;
      //     this.getGoogleCode(this.loginForm.username);
      //   }
      // })
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          // if(this.loginForm.googleCode == '' || this.loginForm.googleCode == undefined){
          //   this.$message.error("谷歌码不能为空");
          // }else{
            this.loading = true;
            // 获取元素标签
              let warningAudioDom = document.getElementById('warningAudio')
                // 触发交互
              warningAudioDom.pause()

              let warningAudioDom2 = document.getElementById('warningAudio2')
                // 触发交互
              warningAudioDom2.pause()

              let warningAudioDom3 = document.getElementById('warningAudio3')
                // 触发交互
              warningAudioDom3.pause()
            if (this.loginForm.rememberMe) {
              Cookies.set("username", this.loginForm.username, { expires: 30 });
              Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
              Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
            } else {
              Cookies.remove("username");
              Cookies.remove("password");
              Cookies.remove('rememberMe');
            }
            this.$store.dispatch("Login", this.loginForm).then((res) => {
              if(res.isUse){
                this.getGoogleCode(this.loginForm.username);
                this.dialogTableVisible = true;
                this.token = res.token;
                this.id = res.id
                this.$modal.msgSuccess("账号密码正确");
                // this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
              }else{
                setToken(res.token)
                setId(res.id)
                this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
              }
              console.log("登陆后的",res)
              // this.dialogTableVisible = false;
              // this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
            }).catch(() => {
              this.loading = false;
              this.dialogTableVisible = false
              this.loginForm.googleCode = ''
              if (this.captchaEnabled) {
                this.getCode();
              }
            });
          // }

        }
      });
    }
  }
};
</script>

<style rel="stylesheet/scss" lang="scss">
.qcto{
  background: #ffffff;
}
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 400px;
  padding: 25px 25px 5px 25px;
  .el-input {
    height: 38px;
    input {
      height: 38px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}
.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}
.login-code {
  width: 33%;
  height: 38px;
  float: right;
  img {
    width: 100%;
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.login-code-img {
  height: 38px;
}
</style>
