import request from '@/utils/request'

// 查询会员充值列表
export function listMemberRecharge(query) {
  return request({
    url: '/system/memberRecharge/list',
    method: 'get',
    params: query
  })
}

// 查询会员充值详细
export function getMemberRecharge(id) {
  return request({
    url: '/system/memberRecharge/' + id,
    method: 'get'
  })
}

// 新增会员充值
export function addMemberRecharge(data) {
  return request({
    url: '/system/memberRecharge',
    method: 'post',
    data: data
  })
}

// 修改会员充值
export function updateMemberRecharge(data) {
  return request({
    url: '/system/memberRecharge',
    method: 'put',
    data: data
  })
}

// 删除会员充值
export function delMemberRecharge(id) {
  return request({
    url: '/system/memberRecharge/' + id,
    method: 'delete'
  })
}

// 同意
export function Agree(id) {
  return request({
    url: '/system/memberRecharge/agree/'+id,
    method: 'post',
  })
}
// 驳回
export function Reject(id) {
  return request({
    url: '/system/memberRecharge/reject/'+id,
    method: 'post',
  })
}
