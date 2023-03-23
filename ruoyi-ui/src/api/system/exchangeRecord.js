import request from '@/utils/request'

// 查询币币兑换记录列表
export function listExchangeRecord(query) {
  return request({
    url: '/system/exchangeRecord/list',
    method: 'get',
    params: query
  })
}

// 查询币币兑换记录详细
export function getExchangeRecord(id) {
  return request({
    url: '/system/exchangeRecord/' + id,
    method: 'get'
  })
}

// 新增币币兑换记录
export function addExchangeRecord(data) {
  return request({
    url: '/system/exchangeRecord',
    method: 'post',
    data: data
  })
}

// 修改币币兑换记录
export function updateExchangeRecord(data) {
  return request({
    url: '/system/exchangeRecord',
    method: 'put',
    data: data
  })
}

// 删除币币兑换记录
export function delExchangeRecord(id) {
  return request({
    url: '/system/exchangeRecord/' + id,
    method: 'delete'
  })
}
