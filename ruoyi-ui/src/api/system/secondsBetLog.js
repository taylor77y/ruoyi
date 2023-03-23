import request from '@/utils/request'

// 查询秒合约记录列表
export function listSecondsBetLog(query) {
  return request({
    url: '/system/secondsBetLog/list',
    method: 'get',
    params: query
  })
}

// 查询秒合约记录详细
export function getSecondsBetLog(id) {
  return request({
    url: '/system/secondsBetLog/' + id,
    method: 'get'
  })
}

// 新增秒合约记录
export function addSecondsBetLog(data) {
  return request({
    url: '/system/secondsBetLog',
    method: 'post',
    data: data
  })
}

// 修改秒合约记录
export function updateSecondsBetLog(data) {
  return request({
    url: '/system/secondsBetLog',
    method: 'put',
    data: data
  })
}

// 删除秒合约记录
export function delSecondsBetLog(id) {
  return request({
    url: '/system/secondsBetLog/' + id,
    method: 'delete'
  })
}
