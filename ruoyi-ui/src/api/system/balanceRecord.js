import request from '@/utils/request'

// 查询资金记录列表
export function listBalanceRecord(query) {
  return request({
    url: '/system/balanceRecord/list',
    method: 'get',
    params: query
  })
}

// 查询资金记录详细
export function getBalanceRecord(id) {
  return request({
    url: '/system/balanceRecord/' + id,
    method: 'get'
  })
}

// 新增资金记录
export function addBalanceRecord(data) {
  return request({
    url: '/system/balanceRecord',
    method: 'post',
    data: data
  })
}

// 修改资金记录
export function updateBalanceRecord(data) {
  return request({
    url: '/system/balanceRecord',
    method: 'put',
    data: data
  })
}

// 删除资金记录
export function delBalanceRecord(id) {
  return request({
    url: '/system/balanceRecord/' + id,
    method: 'delete'
  })
}
