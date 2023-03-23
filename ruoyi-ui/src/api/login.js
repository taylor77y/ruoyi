import request from '@/utils/request'

// 登录方法
export function login(username, password, code, uuid,secret,googleCode) {
  const data = {
    username,
    password,
    code,
    uuid,
    secret,
    googleCode
  }
  return request({
    url: '/login',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 注册方法
export function register(data) {
  return request({
    url: '/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}
// 验证谷歌吗
export function checkGoogleCode(data) {
  return request({
    url: '/checkGoogleCode',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}
// 获取用户详细信息
export function getInfo() {
  return request({
    url: '/getInfo',
    method: 'get'
  })
}

// 获取mp3
export function boldmp3() {
  return request({
    url: '/system/census/mp3' ,
    method: 'get'
  })
}

// 退出方法
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

// 获取验证码
export function getCodeImg() {
  return request({
    url: '/captchaImage',
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}

export function getGoogle(data) {
  return request({
    url: '/googleQrcode/'+data,
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}
