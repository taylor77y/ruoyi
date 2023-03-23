// import {
// 	createHash
// } from "crypto";
// import config from "@/config"
import md5 from 'js-md5';
import {
    getId
  } from "@/utils/auth";
import pako from '@/utils/pako.min.js'
import store from '@/store'
const A_KEY = "dslkh2394lafl;341g@.,_"
class socket {
	// constructor(url = 'ws://192.168.101.53/', options) {
    // url 外面传递
	constructor(url = 'ws://bbim.mbtcpro.top/service/message/'+getId(), options) {
		this.heartBeatTimer = null
		this.options = options
		this.messageMap = {}
		this.connState = 0
		this.socket = null
		this.url = null
	}

  handleUrl(id) {

    // this.id = id
	// this.url = 'ws://192.168.138.95.16080/service/message/' + id
	// //MBTC IM
    // this.url = 'ws://bbim.mbtcpro.top/service/message/' + id
	//测试IM
	// this.url = 'ws://qcim.m1ob.com/service/message/' + id
	this.url = 'ws://wap.adbaa3011.cc/socket/im/' + id
	//FDEX IM
	// this.url = 'wss://im.fdexapi.com/service/message/' + id
	//WBEX
	// this.url = 'ws://im.wbexapi.com/service/message/'+id
	//新的B
	// this.url = 'ws://im.lrrqxl.top/service/message/' + id
	//新的B(第二套)
	// this.url = 'ws://im.bwangcc.top/service/message/' + id
	//测试
	// this.url = 'ws://192.168.131.77:16080/service/message/' + id
  }
  doOpen() {
		if (this.connState) return
		this.connState = 1
		this.afterOpenEmit = []
		const BrowserWebSocket = window.WebSocket || window.MozWebSocket
		const socket = new BrowserWebSocket(this.url)
		// socket.binaryType = 'arraybuffer'
		socket.onopen = evt => this.onOpen(evt)
		socket.onclose = evt => this.onClose(evt)
		socket.onmessage = evt => this.onMessage(evt.data)
		socket.onerror = err => this.onError(err)
		this.socket = socket
	}
	// 主动断掉scoket
	toClose() {
		console.log('断开')
		this.destroy()

	}
	onOpen(evt) {
		this.connState = 2
		this.heartBeatTimer = setInterval(this.checkHeartbeat.bind(this), 10000)
		this.handlerCallback('open',evt)
	}
	checkOpen() {
		return this.connState === 2
	}
	onClose(evt) {
		this.connState = 0
		if (this.connState) {
			this.handlerCallback('close',evt)
		}
	}
	keyFn(arr) {
		let str = ''
		Object.keys(arr).sort().map(key => {
		 if (arr[key]) {
		  str += key + '=' + arr[key] + '&'
		 }
		})
		str += 'key=dslkh2394lafl;341g@.,_'
		// str += this.dateTimeStr('ymdhi');
		// str += parseInt( Date.now() / 1000)-30;
		console.log("排序明文："+str)
		return md5(str)
	}
	dateTimeStr(str) {
		var date = new Date(),
		 year = date.getFullYear(), //年
		 month = date.getMonth() + 1, //月
		 day = date.getDate(), //
		 hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours(), //时
		 minute = date.getMinutes() < 10 ? date.getMinutes() : date.getMinutes(), //分
		 second = date.getSeconds() < 10 ? date.getSeconds() : date.getSeconds(); //秒
		month >= 1 && month <= 9 ? (month = "0" + month) : "";
		day >= 0 && day <= 9 ? (day = "0" + day) : "";
		hour >= 0 && hour <= 9 ? hour : "";
		minute >= 0 && minute <= 9 ? (minute = "0" + minute) : "";
		second >= 0 && second <= 9 ? (second = "0" + second) : "";
		if (str.indexOf('y') != -1) {
		 str = str.replace('y', year)
		}
		if (str.indexOf('m') != -1) {
		 str = str.replace('m', month)
		}
		if (str.indexOf('d') != -1) {
		 str = str.replace('d', day)
		}
		if (str.indexOf('h') != -1) {
		 str = str.replace('h', hour)
		}
		if (str.indexOf('i') != -1) {
		 str = str.replace('i', minute)
		}
		if (str.indexOf('s') != -1) {
		 str = str.replace('s', second)
		}
		return str;
	   }
	send(data) {
		const roles = store.getters && store.getters.roles
		let s = roles[0] == 'admin'?12:2;
		const { cmd, body, id } = data
    // id 当为admin 的时候需要传
		let sign = body ? this.keyFn(body):''
		const temp = {
			flag: 1,
			cmd,
			source:14,
      		id,
			body,
			sign
		}
		// temp.sign = md5Str;
		const msg = JSON.stringify(temp)
		console.log("发送明文",msg)
		const text = this.stringToByte(this.zip(msg)) // 转压缩
		let bytes = new Uint8Array(text.length);
		for (var i = 0; i < bytes.length; i++) {
		bytes[i] = text[i];
		}
		// console.log(this.zip(bytes))
		// console.log(btoa(this.zip(bytes)))
				// console.log() 
		this.socket.send(bytes)
		// this.socket.send(JSON.stringify(temp))
	}
	// 压缩成gzip
	zip(str) {
		var binaryString = pako.gzip(str, {
		 to: 'string'
		});
		return btoa(binaryString);
	   }
	//js解压gzip
	unzip(key) {
		key = atob(key)
		console.log(key)
		// 将二进制字符串转换为字符数组
		var charData = key.split('').map(function(x) {
		 return x.charCodeAt(0);
		});
		// 将数字数组转换成字节数组
		var binData = new Uint8Array(charData);
		// 解压
		var data = pako.inflate(binData);
		// key = String.fromCharCode.apply(null, new Uint16Array(data));
		var res = '';
		var chunk = 16 * 1024;
		var i;
		for (i = 0; i < data.length / chunk; i++) {
		 res += String.fromCharCode.apply(null, data.slice(i * chunk, (i + 1) * chunk));
		}
		res += String.fromCharCode.apply(null, data.slice(i * chunk));
		// 将GunZip ByTAREAR转换回ASCII字符串
		return decodeURIComponent(escape(res));
	  
	   }
	// 压缩
	stringToByte(str) {
		var bytes = new Array();
		var len, c;
		len = str.length;
		for (var i = 0; i < len; i++) {
		 c = str.charCodeAt(i);
		 if (c >= 0x010000 && c <= 0x10FFFF) {
		  bytes.push(((c >> 18) & 0x07) | 0xF0);
		  bytes.push(((c >> 12) & 0x3F) | 0x80);
		  bytes.push(((c >> 6) & 0x3F) | 0x80);
		  bytes.push((c & 0x3F) | 0x80);
		 } else if (c >= 0x000800 && c <= 0x00FFFF) {
		  bytes.push(((c >> 12) & 0x0F) | 0xE0);
		  bytes.push(((c >> 6) & 0x3F) | 0x80);
		  bytes.push((c & 0x3F) | 0x80);
		 } else if (c >= 0x000080 && c <= 0x0007FF) {
		  bytes.push(((c >> 6) & 0x1F) | 0xC0);
		  bytes.push((c & 0x3F) | 0x80);
		 } else {
		  bytes.push(c & 0xFF);
		 }
		}
		return bytes;
	   }
	// onMessage(message) {
	// 	let temp = JSON.parse(message)
	// 	if (temp.code === 200) {
	// 		if (temp.cmd === 2 || temp.cmd === 3 || temp.cmd === 30 || temp.cmd === 4) {
	// 			return this.handlerCallback('message',message)
	// 		}
	// 		// if () {
	// 		// 	return this.handlerCallback('message',message)
	// 		// }
	// 		// if (temp.cmd == 2) {
	// 		// 	// return this.handlerCallback('msg-result',message)
	// 		// }
	// 	} else {
	// 		if (temp.cmd === 1) {
	// 			return this.handlerCallback('login-err',message)
	// 		} else {
	// 			return this.handlerCallback('msg-err',message)
	// 		}
	// 	}

	// }
	onMessage(message) {
		// console.error('解压前时间戳：' +  new Date().getTime());
	  
		let blob = message
		if (typeof blob == 'string') {
		 return
		} // 如果是字符串，什么操作也不做
		else {
		 try {
	  
		  let newblob = blob.slice(0, blob.size)
		  //js中的blob没有没有直接读出其数据的方法，通过FileReader来读取相关数据
		  let reader = new FileReader();
		  reader.readAsBinaryString(newblob);
		  reader.onload = (evt) => {
		   if (evt.target.readyState == FileReader.DONE) {
			let zipdata = evt.target.result; //base64
			try {
			 let data = this.unzip(zipdata);
			 this.handleRes(JSON.parse(data))
	  
			} catch (err) {
			 console.error(' >> Data parsing error:', err)
			}
		   }
		  }
		 } catch (error) {
		  console.error('解压出错')
		  console.log(error)
		 }
		}
	   }
	   handleRes(temp){
		if (temp.code === 200) {
			if (temp.cmd === 2 || temp.cmd === 3 || temp.cmd === 30 || temp.cmd === 4) {
				return this.handlerCallback('message',temp)
			}
			// if () {
			// 	return this.handlerCallback('message',message)
			// }
			// if (temp.cmd == 2) {
			// 	// return this.handlerCallback('msg-result',message)
			// }
		} else {
			if (temp.cmd === 1) {
				return this.handlerCallback('login-err',temp)
			} else {
				return this.handlerCallback('msg-err',temp)
			}
		}
	   }
	checkHeartbeat() {
		const data = {
			cmd: 100,
			body: "PING"
		}
    if (this.socket.readyState === 3) {
      this.doOpen()
      return
    }
		this.send(data)
	}
	handlerCallback(tag,cb) {
		const callback = this.messageMap[tag]

		if (callback) callback(cb)
	}
	onError(err) {
		this.handlerCallback('error',err)
	}
	// onReceiver(data) {
	// 	const callback = this.messageMap[data.Event]
	// 	if (callback) callback(data.Data)
	// }
	on(name, handler) {

		this.messageMap[name] = handler
	}
	doClose() {
		this.socket.close()

	}
	destroy() {
		if (this.heartBeatTimer) {
			clearInterval(this.heartBeatTimer)
			this.heartBeatTimer = null
		}
		// this.doClose()
		// this.messageMap = {}
		// this.connState = 0
		// this.socket = null
	}

}

export default socket
