import request from '@/utils/request'

// 跳转
export function getTzData() {
  return request({
    url: '/system/census/tzData',
    method: 'get',
  })
}

// 重提
export function getCtData() {
  return request({
    url: '/system/census/ctData' ,
    method: 'get'
  })
}

// 法币
export function getFbData() {
  return request({
    url: '/system/census/fbData' ,
    method: 'get'
  })
}
//法币Amount
export function getFbAmountData() {
  return request({
    url: '/system/census/fbAmountData' ,
    method: 'get'
  })
}
//提示
export function getSay() {
  return request({
    url: '/system/census/chongzhi' ,
    method: 'get'
  })
}
export function gettixian() {
  return request({
    url: '/system/census/tixian' ,
    method: 'get'
  })
}
export function getrenzheng() {
  return request({
    url: '/system/census/renzheng' ,
    method: 'get'
  })
}

export function getHyData() {
  return request({
    url: '/system/census/hyData' ,
    method: 'get'
  })
}

export function getfbHint() {
  return request({
    url: '/system/census/fbHint',
    method: 'get'
  })
}

export function getbbHint() {
  return request({
    url: '/system/census/bbHint',
    method: 'get'
  })
}

export function getmhyHint() {
  return request({
    url: '/system/census/mhyHint',
    method: 'get'
  })
}

export function ChatTs(){
  return request({
    url: '/system/census/chatTs/1',
    method: 'get'
  })
}


export function checkOperPwd(pwd){
  return request({
    url: '/system/census/checkOperPwd/'+pwd,
    method: 'post'
  })
}