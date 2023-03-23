import request from '@/utils/request'

// 查询商家列表
export function listMember(query) {
  return request({
    url: '/system/store/list',
    method: 'get',
    params: query
  })
}

// 查询商家详细
export function getMember(id) {
  return request({
    url: '/system/store/' + id,
    method: 'get'
  })
}

// 新增商家
export function addMember(data) {
  return request({
    url: '/system/store',
    method: 'post',
    data: data
  })
}

// 修改商家
export function updateMember(data) {
  return request({
    url: '/system/store',
    method: 'put',
    data: data
  })
}

// 删除商家
export function delMember(id) {
  return request({
    url: '/system/store/' + id,
    method: 'delete'
  })
}

// 法币List
export function oucList() {
  return request({
    url: '/system/store/oucList',
    method: 'get'
  })
}

// 充值法币
export function fbAmount(data) {
  return request({
    url: '/system/store/fbAmount',
    method: 'post',
    data: data
  })
}