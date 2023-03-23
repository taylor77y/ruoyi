<template>
  <div class="wrap">
    <!-- 头部 -->
    <el-row>
      <div class="titleBox">
        <el-button type="primary" size="mini" @click="shuaxin">刷新页面</el-button>
        <div v-if="act !== null">
          <span class="head-name">
            {{ oneList ? oneList.uname: `游客` }}
          </span>
          <span class="head-title">Uid: {{ oneList ? oneList.uuid: '' }} </span>
          <span class="head-title">电话: {{ oneList ? oneList.phone: '' }} </span>
          <span class="head-title" v-if="oneList">账户类型: {{oneList.useType == 1?'正式用户':'测试用户'}}</span>
          <span class="head-title">推荐人: {{oneList ? oneList.welMemberPhone:''}}</span>
          <span class="head-title">登录IP: {{ oneList ? oneList.lastLoginIp ? oneList.lastLoginIp.split(",")[0]:'': '' }}
          </span>
          <span class="head-title">注册时间: {{ oneList ? oneList.createTime: '' }}</span>
        </div>
      </div>
    </el-row>

    <!-- 底部 -->
    <div class="infoBox">
      <!-- 左边用户列表 -->
      <div class="userList">
        <div class="searchBox">
          <el-input placeholder="请输入内容" v-model="search" class="input-with-select" size="mini">
            <i class="el-icon-search el-input__icon" slot="suffix" @click="handleIconClick">
            </i>
          </el-input>
          <!--  <el-button
              icon="el-icon-plus"
              size="mini"
              type="primary"
              @click="dialogVisible = true"
            ></el-button> -->
        </div>
        <div class="userListBox">
          <div v-for="(item, index) in userListData" :key="index" @click="getAct(item, index)"
            :class="index === act ? 'userFlexAct' : 'userFlex'">
            <el-badge
              :is-dot="[null, '3', 'service'].includes(item.session.lastId) || receiver === item.session.target ? false:true"
              class="item">
              <img src="../../assets/images/1.webp"
                alt="头像" class="head_portrait2" style="margin-right: 10px" />
<!-- <img src="https://img1.baidu.com/it/u=592570905,1313515675&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                alt="头像" class="head_portrait2" style="margin-right: 10px" /> -->
            </el-badge>
            <!-- <div>

              </div> -->
            <div style="margin-right: 40px" v-if="item.session">
              <el-tooltip :content="item.user ? item.user.uname || item.user.id : `游客${item.session.target}`"
                placement="bottom" effect="light">
                <div style="color: #565656" class="userName">

                  {{ item.user ? item.user.uname || item.user.id : `游客${item.session.target}` }}
                </div>
              </el-tooltip>
              <div class="userInfo" v-html="item.session.body"></div>
            </div>
            <div v-if="item.session" style="margin-right: 10px; font-size: 14px; color: #ccc">
              {{ parseTime(item.session.lastTime) }}
            </div>
          </div>
        </div>
      </div>
      <!-- 右边输入框和信息展示 -->
      <div class="infoList">
        <!-- 信息 -->
        <!-- <div class="infoTop" ref="scrollBox" id="box">
            <div :class="
                sender !== item.source ? 'chatInfoLeft' : 'chatInfoRight'
              " v-for="(item, index) in userInfoList" :key="index">
              <img src="/static/img/profile.473f5971.jpg" alt="头像" class="head_portrait2" />
              <div :class="sender !== item.source ? 'chatLeft' : 'chatRight'">
                <div class="text" v-text="item.body" v-if="item.type === 1"></div>
                <div class="text" v-else>
                  <el-image style="width: 159px; height: 159px" :src="pathImg + item.body"></el-image>
                </div>
              </div>
            </div>
          </div> -->
        <div class="chat-content" ref="scrollBox" id="box">
          <div v-for="(item, index) in userInfoList" :key="index">
            <!-- 对方 -->
            <div v-if="'service' !== item.source">
              <div class="time">
                {{ item.createDateStr }}
              </div>
              <div class="word">
                <!-- <img src="https://img01.yzcdn.cn/vant/cat.jpeg" /> -->
                <img src="../../assets/images/1.webp" />
                <div class="info">

                  <!-- <p class="time">
                              {{ itemc.nickName }}
                            </p> -->
                  <div class="info-content" v-if="item.type === 1" v-html="item.body">
                    <!-- {{ item.body }} -->
                  </div>
                  <div class="info-content" v-else>
                    <el-image @click="handleClickItem(pathImg + item.body)" :preview-src-list="imgList"
                      style="width: 159px; height: 159px" :src="pathImg + item.body"></el-image>
                  </div>
                </div>
              </div>
            </div>
            <!-- 我的 -->
            <div v-else>
              <div class="time">
                {{ item.createDateStr }}
              </div>
              <div class="word-my">

                <div class="info" @contextmenu.prevent="getRecall(index)">
                  <div class="info-content" v-if="item.type === 1"
                    v-html="item.body"
                  >
                  <!-- {{ item.body }} -->
                    
                  </div>
                  <div class="info-content" v-else>
                    <el-image @click="handleClickItem(pathImg + item.body)" :preview-src-list="imgList"
                      style="width: 159px; height: 159px" :src="pathImg + item.body"></el-image>
                  </div>
                    <div v-show="show === index" class="withdraw" @click="handleRecall(item)">
                      撤回
                    </div>
                </div>
                <img src="/static/img/profile.473f5971.jpg" />
              </div>
            </div>
          </div>
        </div>
        <!-- 输入框 -->
        <div class="infoBottom" :contenteditable="true">
          <div class="infoIcon">
            <el-upload v-show="receiver !== null" class="upload-demo" :action="uploadImgUrl" :on-success="handleSuccess"
              :headers="headers" :multiple="false" :show-file-list="false">
              <i class="el-icon-picture-outline-round">

              </i>
            </el-upload>

            <!-- <i @click="extend('发送商品')" class="el-icon-sell"></i>
              <i @click="extend('设置')" class="el-icon-setting"></i>
              <i @click="extend('聊天记录')" class="el-icon-chat-dot-round"></i>
              <i @click="extend('更多选项')" class="el-icon-more-outline"></i> -->
          </div>
          <textarea type="textarea" class="infoInput" v-model="textarea"
            @keydown.enter.exact="handlePushKeyword($event)" @keyup.ctrl.enter="lineFeed"
            :disabled='isshow==1?false:true' />

          <div class="fasong" @click="setUp" v-show="isshow==1?true:false">发送</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {
    getToken,
    getId
  } from "@/utils/auth";
  import axios from 'axios'
  import {
    chatSeven,
    getChatList,
    chatRecords,
    searchRecords
  } from "@/api/seve/chat";
  // import socket from "@/utils/socket.js"
  export default {
    data() {
      return {
        imgList: [],
        owHash: null,
        show: null,
        uploadImgUrl: axios.defaults.baseURL + "/common/upload", // 上传的图片服务器地址
        headers: {
          Authorization: "Bearer " + getToken(),
        },
        socket: this.mStock,
        // 在线状态
        state: 1,
        //搜索用户
        search: "",
        //用户列表渲染数据
        userListData: [],
        //用户列表筛选数据
        userListDatas: [

        ],
        //用户点击选中变色
        act: Number,
        // 加号弹框
        dialogVisible: false,
        //历史信息
        userInfoList: [],
        //输入框
        textarea: "",
        //滚动条距离顶部距离
        scrollTop: 0,
        //发送和输入显隐
        isshow: 0,
        receiver: null, //接收方
        // service: 'service', //
        oneList: {

        },
        nowHash: "",
        sender: getId(),
        source: '',
        from: {
          pageNo: 1,
          pageSize: 10,
        },
        uid: null,
        useMap:{}
      };
    },
    updated() {
      this.$nextTick(() => {
        this.$refs.scrollBox.scrollTop = this.$refs.scrollBox.scrollHeight
        // this.scrollTop = this.$refs.chatbox.scrollTop > 1200 ? true:false
      })
    },
    mounted() {
      //获取客服列表
      this.uid = getId();
      this.getRecrods(getId());
      // let a = [];
      // let b = [];
      // console.log("1111",a.concat(b))
    },
    created() {
      chatSeven().then(res => {
        console.log("人员列表", res);
      })
      this.socket.handleUrl(getId() || '')
      /**
       * 建立连接
       */
      if (this.socket.connState !== 2) {
        try {
          this.socket.doOpen();
        } catch (ex) {
          // this.created()
        }
        this.socket.on('open', (evt) => {
          this.getList(1)
        })
      }

      this.socket.on('message', (evt) => {
        const res = evt
        console.log("接收消息", res)
        this.getRecrods(getId())

        if (res.flag === 1 && res.cmd === 30) {
          this.stopClick('', 2000).then(() => {
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
                        +"<img src='"+require("../../assets/images/1.webp")+"'style='height:100%; width:100% '/>"
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
        }
        // 平台
        if (res.flag === 1 && res.cmd === 2 && res.body.source !== 'service') {
          this.stopClick('', 2000).then(() => {
            // 获取元素标签
            let warningAudioDom = document.getElementById('warningAudio2')
            // 触发交互
            warningAudioDom.pause()
            this.fbFn('warningAudio2')
          })

        }

        if (this.receiver == null) return;
        if (res.cmd === 4 && res.flag === 1) {
          chatRecords(this.owHash).then(res => {
            this.userInfoList = JSON.parse(res.data)
          })
        }
        // if (res.body.type === 120) {
        //   if (this.receiver == res.body.msg.source) {
        //     res.body = res.body.msg
        //     this.setMsg(res);
        //   }
        //   return;
        // }
        // if (res.body.type === 121) {
        //   if (this.nowHash !== res.body.msg.hash) {
        //     return;
        //   }
        // }
        if (res.body.hash !== this.nowHash) {
          return
        }
        if (res.body.target !== 'service' && res.body.source !== 'service') {
          return
        }
        if (res.body.source === this.receiver ) {
          this.setMsg(res);
        } else {
          // this.setMsg(res);

          if (res.flag === 1) {
            this.setMsg(res);

          }

        }
        // 商户



      })

    },
    computed: {
      // sender() {
      //   return getId()
      // },
      pathImg() {
        return localStorage.getItem('imgPath')
        // return 'https://oss.mbtcpro.com/' //图片前缀
      }
    },
    // destroyed() {
    //   this.socket.destroy();
    // },
    methods: {
      shuaxin(){
        window.location.reload();
      },
      handleClickItem(img) {
        this.imgList = []
        this.imgList.push(img)

      },
      fbFn(name) {
        // 预警声音播放
        // 获取元素
        let warningAudioDom = document.getElementById(name)
        // 触发播放
        warningAudioDom.play()
      },
      stopClick(name, time) {
        let that = this;
        return new Promise((resolve, reject) => {
          if (that[name]) {
            return false
          }
          that[name] = true
          setTimeout(() => {
            that[name] = false
          }, time)
          resolve()
        })
      },
      // 撤回
      handleRecall(item) {
        console.log("请求撤回",item)
        const body = {
          cmd: 4,
          body: {
            msgId: item.id,
            id: item.target
          }
        }
        this.socket.send(body)
        this.show = null
        // chatRecords(this.owHash).then(res => {
        //   this.userInfoList = JSON.parse(res.data)
        // })
      },
      // 选中当前撤销
      getRecall(index) {
        this.show = index
      },
      setMsg(res) {
        if (this.userInfoList.length > 0) {
          this.userInfoList = this.userInfoList.concat(res.body) || []
        } else {
          this.userInfoList.push(res.body)
        }
      },
      handleSuccess(response, file, fileList) {

        if (response.code === 200 && this.receiver !== null) {
          this.handleFilter(2, response.fileName)
        }
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
      setIndex(item) {
        // this.current = e;
        console.log("设置参数", item)
        this.receiver = item.session.target
        const hash = item.session.hash
        this.nowHash = hash;
        chatRecords(hash).then(res => {
          console.log("聊天记录", JSON.parse(res.data))
          this.userInfoList = JSON.parse(res.data)
        })
      },
      chck(id, arr) {
        for (let index = 0; index < arr.length; index++) {
          const element = arr[index];
          console.log("秀", element)
          if (element.user.id === id) {
            return element;
          }
        }
        return null;
      },
      fillterArr(arr) {
        return ([...new Set(arr)]);
      },
      getRecrods(id) {
        let obj = new Object();
        obj.id = this.uid
        obj.from = this.from;
        getChatList(id).then(res => {
          console.log("用户信息", res.data)
          let data = res.data
          data.sort(function(a, b) {
            return a.session.lastTime < b.session.lastTime ? 1 : -1
          });
          let obj = data[0];
          for (let index = 0; index < data.length; index++) {
            const element = data[index];
            if(this.owHash == element.session.hash){
              data[0] = element;
              data[index] = obj;
              this.act = 0;
              break;
            }
          }
          this.userListData = data
          // this.userListData = this.userListData.forEach(item => {
          //    if (item.user === null) {
          //      item.user = {
          //        id: ''
          //      }
          //    }
          // })
          // if (data.length == 0) {
          //   this.userListData = this.userListDatas;
          // } else {
          //   if (this.userListDatas.length == 0) {
          //     this.userListData = data;
          //   }
          //   // let some = this.userListDatas.concat(data)
          //   // this.userListData = fillterArr(some)
          //   // this.some(some)
          // }
          // this.some(this.userListData)
          // if(this.userListDatas.length>0){
          //   this.userListData = this.userListData.concat(this.userListDatas)
          // }
        })
      },
      some(arr) {
        this.userListData = []
        let arr1 = arr.filter((element, index, self) => {
          console.log(self.findIndex(el => el.user.id === element.user.id) === index)
          if (self.findIndex(el => el.user.id === element.user.id) === index) {
            this.userListData.push(element)
          }
          // return self.findIndex(el => el.user.id === element.user.id) === index

          // this.userListData = arr1

        });

      },
      //搜索icon
      handleIconClick() {
        console.log(1);
        if (this.search == '' || this.search == undefined || this.search == null) return;
        for (let index = 0; index < this.userListData.length; index++) {
          const element = this.userListData[index];
          if(element.user != null){
            if (element.user.uuid == this.search) {
              this.getAct(element, index)
              return;
            }
          }
          
        }
        searchRecords(this.search).then(res => {
          console.log("搜索数据", res)
          let user = res.data.user;
          let data = res.data.member;
          user.sender = user.target;
          user.target = data.id;
          if (user.sender == user.target) {
            user.sender = getId();
          }
          this.userListData.push({
            session: user,
            user: data
          })
          this.userListDatas.push({
            session: user,
            user: data
          })

          this.some(this.userListData)
          console.log("搜索1", this.userListData)
          console.log("搜索2", this.userListDatas)
          // this.sender = res.data.user.target
        })
      },
      //点击用户
      getAct(val, index) {
        console.log("点击触发", val)
        this.owHash = val.session.hash;
        if (!val.session.sender) {
          val.session.sender = getId();
        }
        this.source = val
        this.sender = val.session.sender
        this.isshow = 1
        // 点击用户切换数据时先清除监听滚动事件，防止出现没有历史数据的用户，滚动条为0，会触发滚动事件
        this.$refs.scrollBox.removeEventListener("scroll", this.srTop);
        //点击变色
        this.act = index;
        //清空消息数组
        this.userInfoList = [];
        this.oneList = val.user
        this.setIndex(val)
        this.getList(20, val.session.hash)
        // setTimeout(() => {
        //   this.getRecrods(getId());
        // },100)

        console.log(this.oneList)
      },
      // 模糊搜索用户
      inquire() {
        let fuzzy = this.search;
        if (fuzzy) {
          this.userListData = this.userListDatas.filter((item) => {
            return item.username.includes(fuzzy);
          });
        } else {
          this.userListData = this.userListDatas;
        }
      },
      handleFilter(type, name) {
        // type 1 消息 2 图片
        const body = {
          cmd: 2,
          id: 'service',
          body: {
            id: this.source.session.target,
            body: name,
            type
          }
        }
        this.socket.send(body)
        // this.getList()
      },
      //发送
      setUp() {

        if(!this.textarea){
           this.$message.error("不能发送空消息");
          return;
        }
        this.textarea = eval(<div>this.textarea</div>).context.textarea
        this.textarea = this.textarea.replace(/\n/g,'<br>')
        
        this.handleFilter(1, this.textarea)
        this.textarea = "";
        // 页面滚动到底部
        setTimeout((res) => {
          this.setPageScrollTo();
          //页面滚动条距离顶部高度等于这个盒子的高度
          this.$refs.scrollBox.scrollTop = this.$refs.scrollBox.scrollHeight;
        }, 100);
      },
      // 监听键盘回车阻止换行并发送
      handlePushKeyword(event) {
        console.log(event);
        if (event.keyCode === 13) {
          event.preventDefault(); // 阻止浏览器默认换行操作
          this.setUp(); //发送文本
          return false;
        }
      },
      // 监听按的是ctrl + 回车，就换行
      lineFeed() {
        console.log("换行");
        this.textarea = this.textarea + "\n";
      },

      //滚动条默认滚动到最底部
      setPageScrollTo(s, c) {
        //获取中间内容盒子的可见区域高度
        this.scrollTop = document.querySelector("#box").offsetHeight;
        setTimeout((res) => {
          //加个定时器，防止上面高度没获取到，再获取一遍。
          if (this.scrollTop != this.$refs.scrollBox.offsetHeight) {
            this.scrollTop = document.querySelector("#box").offsetHeight;
          }
        }, 100);
        //scrollTop：滚动条距离顶部的距离。
        //把上面获取到的高度座位距离，把滚动条顶到最底部
        this.$refs.scrollBox.scrollTop = this.scrollTop;
        //判断是否有滚动条,有滚动条就创建一个监听滚动事件，滚动到顶部触发srTop方法
        if (this.$refs.scrollBox.scrollTop > 0) {
          this.$refs.scrollBox.addEventListener("scroll", this.srTop);
        }
      },
      //滚动条到达顶部
      srTop() {
        //判断：当滚动条距离顶部为0时代表滚动到顶部了
        if (this.$refs.scrollBox.scrollTop == 0) {
          //逻辑简介：
          //到顶部后请求后端的方法，获取第二页的聊天记录，然后插入到现在的聊天数据前面。
          //如何插入前面：可以先把获取的数据保存在 A 变量内，然后 this.userInfoList=A.concat(this.userInfoList)把数组合并进来就可以了

          //拿聊天记录逻辑:
          //第一次调用一个请求拉历史聊天记录，发请求时参数带上页数 1 传过去，拿到的就是第一页的聊天记录，比如一次拿20条。你显示出来
          //然后向上滚动到顶部时，触发新的请求，在请求中把分页数先 +1 然后再请求，这就拿到了第二页数据，然后通过concat合并数组插入进前面，依次类推，功能完成！
          // alert("已经到顶部了");

        }
      },
    },
  };
</script>
<style lang="scss" scoped>
 .time {
    font-size: 14px;
    color: #000;
    text-align: center;
  }

  .chat-content {
    height: 70%;
    width: 100%;
    border-bottom: 1px solid #ccc;
    padding: 10px;
    box-sizing: border-box;
    overflow: auto;

    .word {
      display: flex;
      margin-bottom: 10px;

      img {
        width: 40px;
        height: 40px;
        border-radius: 50%;
      }

      .info {
        // width: 47%;
        margin-left: 10px;

        .info-content {
          word-break: break-all;
          // max-width: 45%;
          display: inline-block;
          padding: 10px;
          font-size: 13px;
          background: #fff;
          position: relative;
          margin-top: 8px;
          background: #E6E9EE;
          border-radius: 4px;


        }

        //小三角形
        .info-content::before {
          position: absolute;
          left: -8px;
          top: 8px;
          content: "";
          border-right: 10px solid #E6E9EE;
          border-top: 8px solid transparent;
          border-bottom: 8px solid transparent;
        }
      }
    }

    .word-my {
      display: flex;
      justify-content: flex-end;
      margin-bottom: 10px;

      img {
        width: 40px;
        height: 40px;
        border-radius: 50%;
      }

      .info {
        width: 90%;
        // margin-left: 10px;
        text-align: right;
        // position: relative;
        display: flex;
        align-items: flex-end;
        flex-wrap: wrap;
        flex-direction: column;
        position: relative;
        .info-content {
          word-break: break-all;
          // max-width: 45%;
          padding: 10px;
          font-size: 13px;
          // float: right;
          margin-right: 10px;
          position: relative;
          margin-top: 8px;
          background: #E6E9EE;
          text-align: left;
          border-radius: 4px;


        }
        .withdraw {
          position: absolute;
          background: #fff;
          color: #000;
          border-radius: 4px;
          padding: 6px;
          width: 50px;
          text-align: center;
          top: 86%;
          right: 1%;
          font-size: 12px;
          transform:scale(0.83)
        }

        .Sender_time {
          padding-right: 12px;
          padding-top: 5px;
          font-size: 12px;
          color: rgba(51, 51, 51, 0.8);
          margin: 0;
          height: 20px;
        }

        //小三角形
        .info-content::after {
          position: absolute;
          right: -8px;
          top: 8px;
          content: "";
          border-left: 10px solid #E6E9EE;
          border-top: 8px solid transparent;
          border-bottom: 8px solid transparent;
        }
      }
    }
  }
</style>
<style scoped>
  .head-title {
    font-size: 12px;
    color: #fff;
    margin-right: 25px;
  }

  .head-name {
    font-size: 20px;
    color: #fff;
    font-weight: 600;
    margin-right: 30px;
  }

  .wrap {
    height: 84vh;
    width: 98%;
    margin-left: 1%;
    background-color: #f2f2f2;
    /* margin: auto; */
    margin-top: -40px;
    transform: translateY(10%);
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
    border-radius: 10px;
  }

  .titleBox {

    width: 100%;
    background-image: linear-gradient(to right, #1e76bc, #69a3d5);
    display: flex;
    align-items: center;
    border-top-right-radius: 10px;
    border-top-left-radius: 10px;
    padding: 20px;
  }

  .infoBottom {
    height: 60%;
    display: flex;
    flex-direction: column;
  }

  /* 输入框 */
  .infoInput {
    height: 100%;
    width: 100%;
    border: none;
    resize: none;
    padding: 10px;
    box-sizing: border-box;
    background-color: #f2f2f2;
    color: #434343;
    /* margin: 5px; */
  }

  .fasong {
    height: 30px;
    width: 80px;
    background-color: #e8e8e8;
    text-align: center;
    line-height: 30px;
    border-radius: 4px;
    color: #58df4d;
    margin-top: 1%;
    align-self: flex-end;
    margin-right: 20px;
    cursor: pointer;
  }

  .infoIcon {
    height: 40px;
    width: 100%;
    display: flex;
    align-items: center;
  }

  .infoIcon i {
    font-size: 24px;
    color: #676767;
    margin-left: 15px;
    cursor: pointer;
  }

  /* 头像 */
  .head_portrait {
    width: 3rem;
    height: 3rem;
    border-radius: 50%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }

  .head_portrait2 {
    width: 3rem;
    height: 3rem;
    border-radius: 50%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }

  .stateBox {
    margin-left: 20px;
    padding: 1px 8px;
    background-color: #fff;
    border-radius: 10px;
    text-align: center;
    cursor: pointer;
  }

  .stateBox2 {
    margin-left: 20px;
    padding: 1px 8px;
    background-color: #fff;
    border-radius: 10px;
    text-align: center;
    cursor: pointer;
  }

  .stateBox2:hover {
    background-color: #dcdcdc;
  }

  /* 在线 */
  .state1 {
    display: inline-block;
    height: 10px;
    width: 10px;
    border-radius: 50%;
    background-color: #8ee80e;
  }

  /* 离线 */
  .state2 {
    display: inline-block;
    height: 10px;
    width: 10px;
    border-radius: 50%;
    background-color: #cacaca;
  }

  /* 忙碌 */
  .state3 {
    display: inline-block;
    height: 10px;
    width: 10px;
    border-radius: 50%;
    background-color: #ff8c1e;
  }

  /* 退出登录 */
  .state4 {
    display: inline-block;
    height: 10px;
    width: 10px;
    border-radius: 50%;
    background-color: #7e7e7e;
  }

  .stateText {
    font-size: 14px;
    margin-left: 5px;
  }

  /* 列表和信息 */
  .infoBox {
    height: 90%;
    width: 100%;
    display: flex;
  }

  /* 用户列表大盒子 */
  .userList {
    height: 97%;
    width: 300px;
    border-right: 1px solid #ccc;
    display: flex;
    flex-direction: column;
  }

  /* 用户列表 */
  .userListBox {
    flex: 1;
    width: 100%;
    overflow: auto;
    height: 72%;
  }

  /* 信息外层盒子 */
  .infoList {
    height: 72%;
    width: 72%;
  }

  /* 信息列表 */
  .infoTop {
    height: 70%;
    width: 100%;
    border-bottom: 1px solid #ccc;
    padding: 10px;
    box-sizing: border-box;
    overflow: auto;
  }

  /* 对方发的信息样式 */
  .chatInfoLeft {
    min-height: 70px;
    margin-left: 10px;
    margin-top: 10px;
    display: flex;
  }

  .chatLeft {
    margin-left: 15px;
    flex: 1;
  }

  .chatLeft .text {
    color: #434343;
    margin-top: 8px;
    background-color: #e3e3e3;
    display: inline-block;
    padding: 6px 10px;
    border-radius: 10px;
    max-width: 50%;
    /* 忽略多余的空白，只保留一个空白 */
    white-space: normal;
    /* 换行显示全部字符 */
    word-break: break-all;
    white-space: pre-wrap;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }

  /* 自己发的信息样式 */
  .chatInfoRight {
    height: 70px;
    margin-left: 10px;
    margin-top: 10px;
    display: flex;
    flex-direction: row-reverse;
  }

  .chatRight {
    margin-right: 15px;
    flex: 1;
    /* 用align-items把元素靠右对齐 */
    display: flex;
    flex-direction: column;
    align-items: flex-end;
  }

  .chatRight .text {
    color: #434343;
    margin-top: 8px;
    background-color: #95ec69;
    display: inline-block;
    padding: 6px 10px;
    border-radius: 10px;
    max-width: 50%;
    /* 忽略多余的空白，只保留一个空白 */
    white-space: normal;
    /* 换行显示全部字符 */
    word-break: break-all;
    white-space: pre-wrap;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }

  .searchBox {
    padding: 4px 2px;
    border-bottom: 1px solid #ededed;
  }

  .input-with-select {
    /* width: 98%; */
    /* margin-right: 2%; */
  }

  /* 点击用户变色 */
  .userFlexAct {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 70px;
    border-bottom: 1px solid #DCDFE6;
    cursor: pointer;
    background-color: #DCDFE6;
  }

  /* 用户默认颜色 */
  .userFlex {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 70px;
    border-bottom: 1px solid #e8e8e8;
    /* background: #fff; */
    cursor: pointer;
  }

  /* 用户名 */
  .userName {
    width: 100px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }

  /* 简略信息 */
  .userInfo {
    width: 100px;
    font-size: 14px;
    color: #ccc;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    margin-top: 3px;
  }

  /* 滚动条样式 */
  ::-webkit-scrollbar {
    width: 5px;
    height: 10px;
  }

  ::-webkit-scrollbar-thumb {
    background-color: #dbd9d9;
    border-radius: 3px;
  }
</style>
