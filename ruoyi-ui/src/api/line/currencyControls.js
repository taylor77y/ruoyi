import request from '@/utils/request'

// 查询自发币控制列表
export function listCurrencyControls(query) {
  return request({
    url: '/system/currencyControls/list',
    method: 'get',
    params: query
  })
}

// 查询自发币控制详细
export function getCurrencyControls(id) {
  return request({
    url: '/system/currencyControls/' + id,
    method: 'get'
  })
}

// 新增自发币控制
export function addCurrencyControls(data) {
  return request({
    url: '/system/currencyControls',
    method: 'post',
    data: data
  })
}

// 修改自发币控制
export function updateCurrencyControls(data) {
  return request({
    url: '/system/currencyControls',
    method: 'put',
    data: data
  })
}

// 删除自发币控制
export function delCurrencyControls(id) {
  return request({
    url: '/system/currencyControls/' + id,
    method: 'delete'
  })
}

// 自发币
export function getCurs() {
  return request({
    url: '/system/currencyControls/getCurs',
    method: 'get'
  })
}

