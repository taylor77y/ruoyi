import request from '@/utils/request'

// 查询商家列表
export function listMember(query) {
  return request({
    url: '/system/approve/list',
    method: 'get',
    params: query
  })
}

// 查询商家详细
export function getMember(id) {
  return request({
    url: '/system/approve/' + id,
    method: 'get'
  })
}

// 新增商家
export function addMember(data) {
  return request({
    url: '/system/approve',
    method: 'post',
    data: data
  })
}

// 修改商家
export function updateMember(data) {
  return request({
    url: '/system/approve',
    method: 'put',
    data: data
  })
}

// 删除商家
export function delMember(id) {
  return request({
    url: '/system/approve/' + id,
    method: 'delete'
  })
}