<template>
  <div id="chat">
    <div class="box">
      <div class="box-left">
        <div class="box-header">聊天列表</div>
        <div class="box-user">
          <div :class="index === current?'userinfo':'userinfo2'" v-for="(item,index) in userList" :key="index"
            @click="setIndex(index,item)">
            <div class="avatar">
              <el-avatar size="medium" :src="circleUrl"></el-avatar>
            </div>
            <div class="text">
              <div>{{ item.uname || item.uuid}}</div>
              <div>{{item.body}}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="box-right">
        <div class="box-header">xxxxx</div>
        <div class="box-content">
          <div :class="item.source == sender ? 'msg2':'msg'" v-for="(item,index) in msgList" :key="index">
            <el-image v-if="item.type == 2" style="width: 200px; height: 100px" :src="src+item.body"></el-image>
            <span v-if="item.type == 1">{{item.body}}</span>
          </div>
        </div>
        <div class="box-chat">
          <el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="textarea">
          </el-input>
          <el-button type="success" size="mini" @click="send()">发送</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {
    chatSeven,
    getChatList,
    chatRecords
  } from "@/api/seve/chat";
  export default {
    name: "chat",
    data() {
      return {
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png", //用户头像
        src: "https://oss.mbtcpro.com/", //图片前缀
        userList: [], //聊天列表
        current: 0, //聊天列表样式
        sender: 1, //发送方
        receiver: null, //接收方
        list: null, //客服人员列表
        msgList: [], //消息记录
        textarea: "" //发送内容
      }
    },
    created() {
      /**
       * 建立连接
       */
      this.init();
    },
    mounted() {
      window.onbeforeunload = function() {
        this.close();
      };
      //获取客服列表
      this.getRecrods();
      // setInterval(() => {

      // }, 1000);
    },
    methods: {
      getRecrods() {
        getChatList().then(res => {
          console.log(res.data)
          this.userList = res.data
        })
      },
      setIndex(e, item) {
        this.current = e;
        this.receiver = item.id
        chatRecords(item.hash).then(res => {
          console.log("聊天记录", JSON.parse(res.data))
          this.msgList = JSON.parse(res.data)
        })
      },
      init() {
        if ("WebSocket" in window) {
          this.websocket = new WebSocket("ws://192.168.2.9:16080/service/message/1");
        } else {
          this.$message.error("该浏览器不支持连接s");
        }
        this.websocket.onopen = () => {
          let body = {
            "cmd": 1,
            "body": ''
          }
          this.websocket.send(JSON.stringify(body));
        };
        this.websocket.onerror = () => {
          this.$message.error("连接发生了异常");
        };
        this.websocket.onmessage = (e) => {
          console.log("接收消息", e.data);
          if (e.data == "true") {
            return;
          }
          const res = JSON.parse(e.data)
          console.log("接收后得data", res)
          if (this.msgList.length > 0) {
            this.msgList.push(res.body)
          } else {
            this.msgList = res.body || []
          }
          console.log("连接之后得数据", this.msgList)
        };
        this.websocket.onclose = () => {};
      },
      close() {
        this.websocket.close();
      },
      send() {
        if (this.textarea === '') {
          this.$message.error("发送内容不能为空");
          return;
        }
        if (this.websocket == undefined || this.websocket == null) {
          this.$message.error("连接已断开");
        } else {
          let body = {
            "flag": 1,
            "cmd": 2,
            "source": 1,
            "body": {
              "id": this.receiver,
              "body": this.textarea,
              "type": 1
            }
          }
          this.websocket.send(JSON.stringify(body));
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .box {
    height: 500px;
    width: 700px;
    border: 1px solid;
    box-sizing: border-box;
    // margin: 60px 0 0 100px;
  }

  .box-left {
    height: 100%;
    width: 20%;
    float: left;
  }

  .box-right {
    height: 100%;
    width: 80%;
    border-left: 1px solid;
    float: left;
  }

  .box-header {
    height: 40px;
    border-bottom: 1px solid;
    display: flex;
    justify-content: center;
    align-content: center;
    line-height: 40px;
  }

  .box-content {
    height: 360px;
    overflow-y: scroll;
  }

  .box-chat {
    height: 100px;
    overflow: hidden;
    position: relative;
  }

  .el-button {
    position: absolute;
    bottom: 20px;
    right: 20px;
    z-index: 9999;
  }

  .box-user {
    height: 460px;
    overflow-y: scroll;
  }

  ::-webkit-scrollbar {
    width: 0;
    height: 0;
    color: transparent;
  }

  .userinfo {
    height: 40px;
    box-sizing: border-box;
    background: #DCDFE6;
  }

  .userinfo2 {
    height: 40px;
    box-sizing: border-box;
    background: #FFFFFF;
  }

  .avatar {
    width: 35%;
    display: flex;
    justify-content: center;
    align-content: center;
    float: left;
  }

  .text {
    width: 65%;
    height: 100%;
    float: left;
  }

  .msg {
    box-sizing: border-box;
    padding: 10px 0 0 10px;
  }

  .msg2 {
    box-sizing: border-box;
    padding: 10px 10px 0 0;
    text-align: right;
  }
</style>
