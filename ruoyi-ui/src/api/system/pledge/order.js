import request from '@/utils/request'

// 查询质押借币订单列表
export function listOrder(query) {
  return request({
    url: '/system/pledge/order/list',
    method: 'get',
    params: query
  })
}

// 查询质押借币订单详细
export function getOrder(id) {
  return request({
    url: '/system/pledge/order/' + id,
    method: 'get'
  })
}

// 新增质押借币订单
export function addOrder(data) {
  return request({
    url: '/system/pledge/order',
    method: 'post',
    data: data
  })
}

// 修改质押借币订单
export function updateOrder(data) {
  return request({
    url: '/system/pledge/order',
    method: 'put',
    data: data
  })
}

// 删除质押借币订单
export function delOrder(id) {
  return request({
    url: '/system/pledge/order/' + id,
    method: 'delete'
  })
}
