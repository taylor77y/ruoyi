import request from '@/utils/request'

// 查询历史委托记录列表
export function listEntrustHistory(query) {
  return request({
    url: '/system/entrustHistory/list',
    method: 'get',
    params: query
  })
}

// 查询历史委托记录详细
export function getEntrustHistory(id) {
  return request({
    url: '/system/entrustHistory/' + id,
    method: 'get'
  })
}

// 新增历史委托记录
export function addEntrustHistory(data) {
  return request({
    url: '/system/entrustHistory',
    method: 'post',
    data: data
  })
}

// 修改历史委托记录
export function updateEntrustHistory(data) {
  return request({
    url: '/system/entrustHistory',
    method: 'put',
    data: data
  })
}

// 删除历史委托记录
export function delEntrustHistory(id) {
  return request({
    url: '/system/entrustHistory/' + id,
    method: 'delete'
  })
}
