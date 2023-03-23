import request from '@/utils/request'

// 查询法币交易统计列表
export function listFabiDayRecord(query) {
  return request({
    url: '/system/fabiDayRecord/list',
    method: 'get',
    params: query
  })
}

// 查询法币交易统计详细
export function getFabiDayRecord(id) {
  return request({
    url: '/system/fabiDayRecord/' + id,
    method: 'get'
  })
}

// 新增法币交易统计
export function addFabiDayRecord(data) {
  return request({
    url: '/system/fabiDayRecord',
    method: 'post',
    data: data
  })
}

// 修改法币交易统计
export function updateFabiDayRecord(data) {
  return request({
    url: '/system/fabiDayRecord',
    method: 'put',
    data: data
  })
}

// 删除法币交易统计
export function delFabiDayRecord(id) {
  return request({
    url: '/system/fabiDayRecord/' + id,
    method: 'delete'
  })
}
