import request from '@/utils/request'

// 查询币种信息列表
export function listCoinToken(query) {
  return request({
    url: '/system/coinToken/list',
    method: 'get',
    params: query
  })
}

// 查询币种信息详细
export function getCoinToken(id) {
  return request({
    url: '/system/coinToken/' + id,
    method: 'get'
  })
}

// 新增币种信息
export function addCoinToken(data) {
  return request({
    url: '/system/coinToken',
    method: 'post',
    data: data
  })
}

// 修改币种信息
export function updateCoinToken(data) {
  return request({
    url: '/system/coinToken',
    method: 'put',
    data: data
  })
}

// 删除币种信息
export function delCoinToken(id) {
  return request({
    url: '/system/coinToken/' + id,
    method: 'delete'
  })
}
