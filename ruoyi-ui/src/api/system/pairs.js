import request from '@/utils/request'

// 查询交易对配置列表
export function listPairs(query) {
  return request({
    url: '/system/pairs/list',
    method: 'get',
    params: query
  })
}

// 查询交易对配置详细
export function getPairs(id) {
  return request({
    url: '/system/pairs/' + id,
    method: 'get'
  })
}

// 新增交易对配置
export function addPairs(data) {
  return request({
    url: '/system/pairs',
    method: 'post',
    data: data
  })
}

// 修改交易对配置
export function updatePairs(data) {
  return request({
    url: '/system/pairs',
    method: 'put',
    data: data
  })
}

// 删除交易对配置
export function delPairs(id) {
  return request({
    url: '/system/pairs/' + id,
    method: 'delete'
  })
}


// 全部
export function tokenCurList() {
  return request({
    url: '/system/pairs/tokenCurList',
    method: 'get'
  })
}

// 查询K线数据
export function getKineCurs(query) {
  return request({
    url: '/system/pairs/kline',
    method: 'get',
    params: query
  })
}
/**
 * 控盘
 */
export function batchSubPas(data) {
  return request({
    url: '/system/pairs/batchSub',
    method: 'post',
    data: data
  })
}