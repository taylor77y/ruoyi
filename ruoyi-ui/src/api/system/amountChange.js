import request from '@/utils/request'

// 查询资金变更记录列表
export function listAmountChange(query) {
  return request({
    url: '/system/amountChange/list',
    method: 'get',
    params: query
  })
}

// 查询资金变更记录详细
export function getAmountChange(id) {
  return request({
    url: '/system/amountChange/' + id,
    method: 'get'
  })
}

// 新增资金变更记录
export function addAmountChange(data) {
  return request({
    url: '/system/amountChange',
    method: 'post',
    data: data
  })
}

// 修改资金变更记录
export function updateAmountChange(data) {
  return request({
    url: '/system/amountChange',
    method: 'put',
    data: data
  })
}

// 删除资金变更记录
export function delAmountChange(id) {
  return request({
    url: '/system/amountChange/' + id,
    method: 'delete'
  })
}
