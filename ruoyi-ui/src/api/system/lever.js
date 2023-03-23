import request from '@/utils/request'

// 查询合约杠杆列表
export function listLever(query) {
  return request({
    url: '/system/lever/list',
    method: 'get',
    params: query
  })
}

// 查询合约杠杆详细
export function getLever(id) {
  return request({
    url: '/system/lever/' + id,
    method: 'get'
  })
}

// 新增合约杠杆
export function addLever(data) {
  return request({
    url: '/system/lever',
    method: 'post',
    data: data
  })
}

// 修改合约杠杆
export function updateLever(data) {
  return request({
    url: '/system/lever',
    method: 'put',
    data: data
  })
}

// 删除合约杠杆
export function delLever(id) {
  return request({
    url: '/system/lever/' + id,
    method: 'delete'
  })
}
