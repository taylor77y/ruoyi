import request from '@/utils/request'

// 查询用户提款账单地址列表
export function listBillingAddress(query) {
  return request({
    url: '/system/billingAddress/list',
    method: 'get',
    params: query
  })
}

// 查询用户提款账单地址详细
export function getBillingAddress(id) {
  return request({
    url: '/system/billingAddress/' + id,
    method: 'get'
  })
}

// 新增用户提款账单地址
export function addBillingAddress(data) {
  return request({
    url: '/system/billingAddress',
    method: 'post',
    data: data
  })
}

// 修改用户提款账单地址
export function updateBillingAddress(data) {
  return request({
    url: '/system/billingAddress',
    method: 'put',
    data: data
  })
}

// 删除用户提款账单地址
export function delBillingAddress(id) {
  return request({
    url: '/system/billingAddress/' + id,
    method: 'delete'
  })
}
