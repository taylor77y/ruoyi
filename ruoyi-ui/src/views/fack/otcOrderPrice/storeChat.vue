<template>
  <div id="chat">
    <el-row :gutter="20">
      <el-col :span="15">

        <div class="box-card">
          <el-row>
            <el-col :span="20">
              <div class="f-title">
                用户({{ form.userUuid }})向商家({{ form.storeMail }})
                {{form.storeDirection === 'BUY' ? '卖出':'买入'}}{{form.num}}USDT
              </div>
            </el-col>
            <el-col :span="4">
              <div style="margin: 0 auto;">
                <el-button type="primary" size="small" @click="sxdd">刷新订单</el-button>
              </div>
            </el-col>
          </el-row>
          <div class="f-crude">
            单价：{{form.price }}{{form.memberCurrencyConfig ? form.memberCurrencyConfig.mark:''}}
          </div>
          <div class="f-crude">
            总价：<span
              class="c-color">{{form.price * form.num }}{{form.memberCurrencyConfig ? form.memberCurrencyConfig.mark:''}}</span>
          </div>
          <div class="f-999">
            <div class="f-left"> 收款信息</div>
            <div class="f-line"></div>
          </div>
          <div class="f-bank">
            <dict-tag :options="dict.type.otc_pay_type" :value="form.payType" />
          </div>
          <div class="f-crude c-color">
            <dict-tag :options="dict.type.otc_order_price" :value="form.status" />
          </div>
          <div class="f-999">
            <div class="f-left"> 时间</div>
            <div class="f-line"></div>
          </div>
          <div class="f-time">
            下单时间 {{ parseTime(form.createTime) }}
          </div>
          <div class="f-time">
            更新时间 {{ parseTime(form.updateTime) }}
          </div>
          <div class="f-999">
            <div class="f-left"> 订单ID</div>
            <div class="f-line"></div>
          </div>
          <div class="f-time">
            {{ form.orderId }}
          </div>
          <!-- 用户UUID:{{form.userUuid}}<br/>
            用户手机:{{form.userPhone}}<br/>
            商家手机:{{form.storePhone}}<br/>
            买家方向:{{form.storeDirection}}<br/>
            卖家方向:{{form.userDirection}}<br/>
            USDT数量:{{form.num}}<br/>
            币种单价:{{form.price}}<br/>
            货币:{{form.memberCurrencyConfig.currencyName}}<br/>
            货币符号:{{form.memberCurrencyConfig.mark}}<br/>
            货币单价:{{form.memberCurrencyConfig.rate}}<br/>
            支付金额:{{form.totalPrice}}<br/>
            付款类型:{{form.payType}}<br/>
            订单状态:{{form.status}}<br/>
            币种:{{form.currency}}<br/>
            申诉状态:{{form.appealStatus}}<br/>
            申诉手机:{{form.appealUserPhone}}<br/>
            申诉邮箱:{{form.appealUserMail}}<br/>
            创建时间 {{parseTime(form.createTime) }}<br/>
            更新时间{{ parseTime(form.updateTime) }}<br/> -->
        </div>
      </el-col>
      <el-col :span="9">
        <div class="wrap">
          <!-- 头部 -->
          <el-row>
            <div class="titleBox">
              <!-- 用户({{ form.userUuid }}) -->
              <div>
                <span class="head-title">Uid: {{ form ? form.userUuid: '' }} </span>
                <span class="head-title">电话: {{ form ? form.userPhone: '' }} </span>
                <span class="head-title" v-if="form.useType == 1">账户类型: 正式用户</span>
                <span class="head-title" v-if="form.useType == 2">账户类型: 测试用户</span>
                <span class="head-title">推荐人: {{ form ? form.lastUserPhone: '' }} </span>
              </div>
            </div>
          </el-row>

          <!-- 底部 -->
          <div class="infoBox">
            <!-- 左边用户列表 -->
            <!-- <div class="userList">
                   <div class="searchBox">
                     <el-input placeholder="请输入内容" v-model="search" class="input-with-select" size="mini" @input="inquire">
                       <i class="el-icon-search el-input__icon" slot="suffix" @click="handleIconClick">
                       </i>
                     </el-input>

                   </div>
                   <div class="userListBox">
                     <div v-for="(item, index) in userListData" :key="index" @click="getAct(item, index)"
                       :class="index === act ? 'userFlexAct' : 'userFlex'">
                       <div>
                         <img src="https://img1.baidu.com/it/u=592570905,1313515675&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
                           alt="头像" class="head_portrait2" style="margin-right: 10px" />
                       </div>
                       <div style="margin-right: 40px" v-if="item.session">
                         <el-tooltip :content="item.user ? item.user.uname || item.ueser.id : `游客${item.session.target}`"
                           placement="bottom" effect="light">
                           <div style="color: #565656" class="userName">
                             {{ item.user ? item.user.uname || item.ueser.id : `游客${item.session.target}` }}
                           </div>
                         </el-tooltip>
                         <div class="userInfo">{{ item.session.body }}</div>
                       </div>
                       <div v-if="item.session" style="margin-right: 10px; font-size: 14px; color: #ccc">
                         {{ parseTime(item.session.lastTime) }}
                       </div>
                     </div>
                   </div>
                 </div> -->
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
                  <div v-if="sender !== item.source">
                    <div class="time">
                      {{ item.createDateStr }}
                    </div>
                    <div class="word">
                       <img src="../../../assets/images/1.webp" />
                      <div class="info">
                        <!-- <p class="time">
                                       {{ itemc.nickName }}
                                     </p> -->
                        <div class="info-content" v-html="item.body" v-if="item.type === 1"></div>
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
                        <div class="info-content" v-html="item.body" v-if="item.type === 1">
                          
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
              <div class="infoBottom">
                <div class="infoIcon">
                  <el-upload v-show="receiver !== null" class="upload-demo" :action="uploadImgUrl"
                    :on-success="handleSuccess" :headers="headers" :multiple="false" :show-file-list="false">
                    <i class="el-icon-picture-outline-round">

                    </i>
                  </el-upload>

                  <!-- <i @click="extend('发送商品')" class="el-icon-sell"></i>
                       <i @click="extend('设置')" class="el-icon-setting"></i>
                       <i @click="extend('聊天记录')" class="el-icon-chat-dot-round"></i>
                       <i @click="extend('更多选项')" class="el-icon-more-outline"></i> -->
                </div>
                <textarea type="textarea" class="infoInput" v-model="textarea"
                  @keydown.enter.exact="handlePushKeyword($event)" @keyup.ctrl.enter="lineFeed" />
                <div class="fasong" @click="setUp">发送</div>
              </div>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  import {
    chatSeven,
    getChatList,
    chatRecords
  } from "@/api/seve/chat";
  import {
    getOtcOrderPrice
  } from "@/api/system/otcOrderPrice";
  import {
    getId
  } from "@/utils/auth";
  // import socket from "@/utils/socket.js"
  import {
    getToken
  } from "@/utils/auth";
  import axios from 'axios'
  export default {
    name: "storeChat",
    dicts: ['otc_shensu_status', 'otc_pay_type', 'otc_order_price', 'otc_fx'],
    // dicts: ['otc_shensu_status', 'otc_pay_type', 'otc_order_price', 'otc_fx'],
    data() {
      return {
        imgList: [],
        owHash: null,
        circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png", //用户头像
        uploadImgUrl: axios.defaults.baseURL + "/common/upload", // 上传的图片服务器地址
        headers: {
          Authorization: "Bearer " + getToken(),
        },
        socket: this.mStock,
        receiver: null, //接收方
        //用户列表渲染数据
        userListData: [],
        //历史信息
        userInfoList: [],
        //输入框
        textarea: "",
        //滚动条距离顶部距离
        scrollTop: 0,
        form: {},
        oid: null,
        sid: null,
        show: null,
        useMap:{}
      }
    },
    created(e) {
      const dictId = this.$route.query.id
      // this.socket = new socket(`${localStorage.getItem('socketPath')}` + getId()),
      this.sid = this.$route.query.sid
      this.oid = dictId;
      this.getOne(dictId)
      this.socket.handleUrl(getId() || '')
      /**
       * 建立连接
       */
      if (this.socket.connState !== 2) {
        this.socket.doOpen();
        this.socket.on('open', (evt) => {
          this.getList(1)
        })
      }
      this.socket.on('message', (evt) => {
         const res = evt
        this.setIndex(this.owHash)
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
                        +"<img src='"+require("../../../assets/images/1.webp")+"'style='height:100%; width:100% '/>"
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
        if (res.flag === 1 && res.cmd === 2) {
          this.stopClick('', 2000).then(() => {
            // 获取元素标签
            let warningAudioDom = document.getElementById('warningAudio2')
            // 触发交互
            warningAudioDom.pause()
            this.fbFn('warningAudio2')
          })

        }
        // if (res.body.type === 120) {
        //   if (this.receiver == res.body.msg.source) {
        //     res.body = res.body.msg
        //     this.setMsg(res);
        //   }
        //   return;
        // }
        if (res.body.source === this.receiver) {
          if (this.userInfoList.length > 0) {
            this.userInfoList = this.userInfoList.concat(res.body) || []
          } else {
            this.userInfoList.push(res.body)
          };
        } else {
          // this.setMsg(res);
          if (res.flag === 2) {
            if (this.userInfoList.length > 0) {
              this.userInfoList = this.userInfoList.concat(res.body) || []
            } else {
              this.userInfoList.push(res.body)
            }
          }
        }



      })

    },
    setMsg(res) {
      if (this.userInfoList.length > 0) {
        this.userInfoList = this.userInfoList.concat(res.body) || []
      } else {
        this.userInfoList.push(res.body)
      }
    },
    updated() {
      this.$nextTick(() => {
        this.$refs.scrollBox.scrollTop = this.$refs.scrollBox.scrollHeight
        // this.scrollTop = this.$refs.chatbox.scrollTop > 1200 ? true:false
      })
    },
    computed: {
      sender() {
        return this.sid
      },
      pathImg() {
        return localStorage.getItem('imgPath') //图片前缀
      }
    },
    mounted() {

    },
    // destroyed() {
    //   this.socket.destroy();
    // },
    methods: {
      handleClickItem(img) {
        this.imgList = []
        this.imgList.push(img)

      },
      // 撤回
      handleRecall(item) {

        const body = {
          cmd: 4,
          body: {
            msgId: item.id,
            id: item.target,
            sysId: item.sysId
          }
        }
        this.socket.send(body)
        this.show = null
        chatRecords(this.owHash).then(res => {
          this.userInfoList = JSON.parse(res.data)
        })
      },
      // 选中当前撤销
      getRecall(index) {
        this.show = index
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
      sxdd() {
        this.getOne(this.oid)
        let warningAudioDom2 = document.getElementById('warningAudio2')
        // 触发交互
        warningAudioDom2.pause()

        let warningAudioDom3 = document.getElementById('warningAudio3')
        // 触发交互
        warningAudioDom3.pause()
      },
      handleSuccess(response, file, fileList) {

        if (response.code === 200 && this.receiver !== null) {
          this.handleFilter(2, response.fileName)
        }
      },
      // 获取记录
      getList(cmd) {
        // cmd 1 登陆 3 记录
        const body = {
          cmd,
          body: ''
        }
        this.socket.send(body)
      },
      handleFilter(type, name) {
        // type 1 消息 2 图片
        const body = {
          cmd: 2,
          id: this.form.storeId,
          body: {
            id: this.form.userId,
            body: name,
            type
          }
        }
        this.socket.send(body)
        // this.getList()
      },
      /** 详情数据 */
      getOne(id) {
        getOtcOrderPrice(id, this.sender).then(response => {
          console.log("11111", response)
          this.form = response.data;
          this.owHash = response.hash;
          this.receiver = response.data.userId
          this.setIndex(response.hash)
        });
      },
      setIndex(hash) {
        chatRecords(hash).then(res => {
          console.log("聊天记录", JSON.parse(res.data))
          this.userInfoList = JSON.parse(res.data)
        })
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

    }
  }
</script>

<style lang="scss" scoped>
  .f-time {
    margin-bottom: 20px;
    font-size: 14px;
  }

  .c-color {
    color: #67C23A;
  }

  .f-bank {
    display: flex;
    align-items: center;
    font-size: 14px;
    color: #000;

    .item {
      margin-right: 30px;
    }
  }

  .f-999 {
    color: #999;
    font-size: 14px;
    padding: 20px 0;
    display: flex;
    align-items: center;

    .f-left {
      width: 8%;
    }

    .f-line {
      width: 92%;
      height: 1px;
      background: #999;
    }
  }

  .box-card {
    margin-top: -40px;
    transform: translateY(10%);
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
    border-radius: 10px;
    padding: 20px;
  }

  .f-crude {
    font-size: 14px;
    color: #000;
    font-weight: bold;
  }

  .f-title {
    font-size: 20px;
    margin-bottom: 20px;

  }

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
    height: 80vh;
    width: 98%;
    margin-top: -40px;
    background-color: #f2f2f2;
    /* margin: auto; */
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
    height: 30%;
    display: flex;
    flex-direction: column;
  }

  /* 输入框 */
  .infoInput {
    height: 44%;
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
    height: 100%;
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
  }

  /* 信息外层盒子 */
  .infoList {
    height: 100%;
    width: 100%;
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
    border-bottom: 1px solid #e8e8e8;
    cursor: pointer;
    background-color: #e8e8e8;
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
