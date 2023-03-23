import request from '@/utils/request'

// 查询会员列表
export function listMember(query) {
  return request({
    url: '/system/member/list',
    method: 'get',
    params: query
  })
}

// 查询会员详细
export function getMember(id) {
  return request({
    url: '/system/member/' + id,
    method: 'get'
  })
}

// 新增会员
export function addMember(data) {
  return request({
    url: '/system/member',
    method: 'post',
    data: data
  })
}

// 修改会员
export function updateMember(data) {
  return request({
    url: '/system/member',
    method: 'put',
    data: data
  })
}

// 删除会员
export function delMember(id) {
  return request({
    url: '/system/member/' + id,
    method: 'delete'
  })
}

// 上分
export function Above(data) {
  return request({
    url: '/system/member/above',
    method: 'post',
    data: data
  })
}
// 下分
export function Lower(data) {
  return request({
    url: '/system/member/lower',
    method: 'post',
    data: data
  })
}
// 重置密码
export function RsetPwd(data) {
  return request({
    url: '/system/member/restPwd',
    method: 'post',
    data: data
  })
}

// 资产查看
export function getZCMS(query) {
  return request({
    url: '/system/member/zcm',
    method: 'get',
    params: query
  })
}

//修改邀请人
export function upWelMember(data){
  return request({
    url: '/system/member/wel',
    method: 'post',
    data: data
  })
}
// 修改归属员工
export function upVested(data){
  return request({
    url: '/system/member/vested',
    method: 'post',
    data: data
  })
}
//查询下级
export function finPList(id){
  return request({
    url: '/system/member/lookDown/'+id,
    method: 'get',
  })
}
// 重置支付密码
export function RsetPayPwd(data) {
  return request({
    url: '/system/member/restPayPwd',
    method: 'post',
    data: data
  })
}