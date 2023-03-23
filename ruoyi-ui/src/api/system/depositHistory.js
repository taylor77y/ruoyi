import request from '@/utils/request'

// 查询充币记录列表
export function listDepositHistory(query) {
  return request({
    url: '/system/depositHistory/list',
    method: 'get',
    params: query
  })
}

// 查询充币记录详细
export function getDepositHistory(id) {
  return request({
    url: '/system/depositHistory/' + id,
    method: 'get'
  })
}

// 新增充币记录
export function addDepositHistory(data) {
  return request({
    url: '/system/depositHistory',
    method: 'post',
    data: data
  })
}

// 修改充币记录
export function updateDepositHistory(data) {
  return request({
    url: '/system/depositHistory',
    method: 'put',
    data: data
  })
}

// 删除充币记录
export function delDepositHistory(id) {
  return request({
    url: '/system/depositHistory/' + id,
    method: 'delete'
  })
}
