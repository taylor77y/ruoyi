<template>
  <div class="app-container home">
    <el-row>
      <el-col :span="12" v-for="(item,index) in hy" :key="index">
        <el-card class="box-card">
          {{item.name}}
          <el-divider></el-divider>
          {{item.count}}
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8" v-for="(item,index) in tz" :key="index">
        <el-card class="box-card">
          {{item.name}}【<el-link type="primary" @click="toForm(item)">点击跳转</el-link>】
          <el-divider></el-divider>
          {{item.count}}
        </el-card>
      </el-col>
    </el-row>
    <!-- <div class="link"></div> -->
    <el-row>
      <el-col :span="8">
        <el-card class="box-card">
          {{fb.name}}【<el-link type="primary" @click="toForm(fb)">点击跳转</el-link>】
          <el-divider></el-divider>
          <div>{{fb.count}}</div>
          <br/>
        </el-card>
      </el-col>
      <el-col :span="8" v-for="(item,index) in fbAmount" :key="index">
        <el-card class="box-card">
          {{item.name}}
          <el-divider></el-divider>
          <div v-for="(item,index) in item.items" :key="index">
            {{item.name}}{{item.amount+'USDT'}}
          </div>

        </el-card>
      </el-col>
    </el-row>

    <el-row>

      <el-col :span="8" v-for="(item,index) in ct" :key="index">
        <el-card class="box-card" v-if="index == 2">
          {{item.name}}
          <el-divider></el-divider>
          <div v-for="(item,index) in item.items" :key="index">
            {{item.name}}{{item.amount+'USDT'}}
          </div>
          <br/>
        </el-card>
        <el-card class="box-card" v-if="index != 2">
          {{item.name}}
          <el-divider></el-divider>
          <div v-for="(item,index) in item.items" :key="index">
            {{item.name}}{{item.amount+'USDT'}}
          </div>
        </el-card>
      </el-col>
    </el-row>
    <!-- <div class="link"></div>43饿过头还9+
    <el-row>

    </el-row> -->
    <audio id="ad" src="../utils/y913.mp3"></audio>
    <!-- <el-button @click="on" id="ons"></el-button> -->
  </div>
</template>

<script>
import { getCtData,getFbData,getTzData,getFbAmountData,getSay,getHyData,ChatTs} from "@/api/census";
  // import socket from "@/utils/socket.js"
  import { getUserProfile } from "@/api/system/user";
  import {
    getId
  } from "@/utils/auth";
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      speech:null,
      version: "3.8.3",
      ct:[],
      fb:[],
      tz:[],
      hy:[],
      fbAmount:[],
      socket: this.mStock,
      useMap:{},
      src:"../assets/images/1.webp",
    };
  },
  created(){
    
  },
  mounted(){
      
    this.getHyList();
    this.getCtList();
    this.getFbList();
    this.getTzList();
    this.getFbAmount();
    getUserProfile().then(response => {
        console.log("用户信息",response)
        if(response.data.deptId === 100){
          this.getInit();
        }
      });
  },
  destroyed(){
      this.socket.destroy();
    },
  methods: {
    getInit(){
      /**
       * 建立连接
       */
      this.socket.handleUrl(getId() || '') 
      if (this.socket.connState !== 2) {
        try {
          this.socket.doOpen();
        } catch (ex) {
          this.created()
        }
        this.socket.on('open', (evt) => {
          this.getList(1)
        })
      }
      this.socket.on('message', (evt) => {
        const res = evt
        console.log("接收消息", res)
        // 商户
        if (res.flag === 1 && res.cmd === 30) {

          this.stopClick('',2000).then(() => {
            // 获取元素标签
            let warningAudioDom = document.getElementById('warningAudio3')
            // 触发交互
            warningAudioDom.pause()
            this.fbFn('warningAudio3')
          })
          let s = res.body.source
          let u = this.useMap[s]
          let obj = res.body.transparent.split("&");
          let json = {};
          for (let index = 0; index < obj.length; index++) {
            var element = obj[index].split("=");
            var key = element[0];
            var val = element[1];
            json[key] = val;
          }
          if(u){
            u.message = res.body.body
          }else{
            let a = this.$notify({
                // title: '法币消息提示',
                dangerouslyUseHTMLString: true,
                message:"<div style='overflow: hidden;'><div style='box-sizing: border-box;padding: 4px;height: 45px;width: 45px;float: left;'>"
                        +"<img src='"+require("../assets/images/1.webp")+"'style='height:100%; width:100% '/>"
                        +"</div><div style='float: left;height: 45px;font-size: 9px;'><div>"+json.uid+"</div><div>"+res.body.body+"</div></div></div>",
                duration: 0,
                onClick:()=>{
                  a.close()
                  delete this.useMap[s]
                  this.$router.push({ path: "/fack/otcOrderPrice/index/chat?"+res.body.transparent }).catch(()=>{});
                },
                onClose:()=>{
                  delete this.useMap[s]
                }
              });
            this.useMap[s] = a
          }
          // console.log("提示返回值",a)
          return
        }
        // 平台
        if (res.flag ===1 && res.cmd === 2) {
          this.stopClick('',2000).then(() => {
            // 获取元素标签
            let warningAudioDom = document.getElementById('warningAudio2')
            // 触发交互
            warningAudioDom.pause()
            this.fbFn('warningAudio2')
          })
          return
        }

      })
    },
    fbFn(name) {
       // 预警声音播放
        // 获取元素
       let warningAudioDom = document.getElementById(name)
       // 触发播放
       warningAudioDom.play()
    },
    stopClick(name,time){
      let that = this;
       return new Promise((resolve,reject)=>{
           if(that[name]){
           return false
           }
           that[name]=true
           setTimeout(()=>{
               that[name]=false
           },time)
           resolve()
       })
    },
    // 获取记录
      getList(cmd, body) {
        // cmd 1 登陆 3 记录
        const temp = {
          cmd,
          body
        }
        this.socket.send(temp)
      },
    getHyList(){
      getHyData().then(res=>{
        this.hy = res.data
      })
    },
    getCtList(){
      getCtData().then(res=>{
        this.ct = res.data;

      })
    },
    getFbList(){
      getFbData().then(res=>{
        this.fb = res.data;
      })
    },
    getTzList(){
      getTzData().then(res=>{
        this.tz = res.data;
      })
    },
    getFbAmount(){
      getFbAmountData().then(res=>{
        this.fbAmount = res.data;
      })
    },
    toForm(e){
      this.$router.push({ path: e.path });
    },
    on(){
      document.getElementById('ad').play();
    }
  },
};
</script>

<style scoped lang="scss">
.ts-box{
  border: 1px solid;
  overflow: hidden;
}
.ts-avatar{
  box-sizing: border-box;
  padding: 4px;
  height: 45px;
  width: 45px;
  float: left;
}
.ts-content{
  float: left;
  height: 45px;
  font-size: 9px;
}
.el-col{
  color: rgb(134, 128, 128);
  font-weight: bold;
  margin: 10px 0 0 0;
}
.link{
  height: 20px;
}
</style>
