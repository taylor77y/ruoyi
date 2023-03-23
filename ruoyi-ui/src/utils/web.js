import socket from "@/utils/socket.js"
import {getId} from "@/utils/auth";
class web{
    sok(){
        let s = new socket(`${localStorage.getItem('socketPath')}` + getId())
        if (s.connState !== 2) {
            try {
            this.socket.doOpen();
            } catch (ex) {
            this.created()
            }
            this.socket.on('open', (evt) => {
            this.getList(1)
            })
        }
        s.on('message', (evt) => {
            const res = JSON.parse(evt)
            // 商户
            if (res.flag === 1 && res.cmd === 30) {
              stopClick('',2000).then(() => {
                // 获取元素标签
                let warningAudioDom = document.getElementById('warningAudio3')
                // 触发交互
                warningAudioDom.pause()
                fbFn('warningAudio3')
              })
              return
            }
            // 平台
            if (res.flag ===1 && res.cmd === 2) {
              stopClick('',2000).then(() => {
                // 获取元素标签
                let warningAudioDom = document.getElementById('warningAudio2')
                // 触发交互
                warningAudioDom.pause()
                fbFn('warningAudio2')
              })
              return
            }
    
        })
    }
    fbFn(name) {
        // 预警声音播放
         // 获取元素
        let warningAudioDom = document.getElementById(name)
        // 触发播放
        warningAudioDom.play()
     }
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
     }
     // 获取记录
       getList(cmd, body) {
         // cmd 1 登陆 3 记录
         const temp = {
           cmd,
           body
         }
         this.socket.send(temp)
       }
    
}