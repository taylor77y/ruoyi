import request from '@/utils/request'

// 查询质押借币订单详情列表
export function listDetail(query) {
  return request({
    url: '/system/pledge/detail/list',
    method: 'get',
    params: query
  })
}

// 查询质押借币订单详情详细
export function getDetail(id) {
  return request({
    url: '/system/pledge/detail/' + id,
    method: 'get'
  })
}

// 新增质押借币订单详情
export function addDetail(data) {
  return request({
    url: '/system/pledge/detail',
    method: 'post',
    data: data
  })
}

// 修改质押借币订单详情
export function updateDetail(data) {
  return request({
    url: '/system/pledge/detail',
    method: 'put',
    data: data
  })
}

// 删除质押借币订单详情
export function delDetail(id) {
  return request({
    url: '/system/pledge/detail/' + id,
    method: 'delete'
  })
}
