import request from '@/utils/request'

// 查询提币记录列表
export function listWithdrawHistory(query) {
  return request({
    url: '/system/withdrawHistory/list',
    method: 'get',
    params: query
  })
}

// 查询提币记录详细
export function getWithdrawHistory(id) {
  return request({
    url: '/system/withdrawHistory/' + id,
    method: 'get'
  })
}

// 新增提币记录
export function addWithdrawHistory(data) {
  return request({
    url: '/system/withdrawHistory',
    method: 'post',
    data: data
  })
}

// 修改提币记录
export function updateWithdrawHistory(data) {
  return request({
    url: '/system/withdrawHistory',
    method: 'put',
    data: data
  })
}

// 删除提币记录
export function delWithdrawHistory(id) {
  return request({
    url: '/system/withdrawHistory/' + id,
    method: 'delete'
  })
}
