import request from '@/utils/request'

// 查询私募订单列表
export function listPeOrder(query) {
  return request({
    url: '/system/peOrder/list',
    method: 'get',
    params: query
  })
}

// 查询私募订单详细
export function getPeOrder(id) {
  return request({
    url: '/system/peOrder/' + id,
    method: 'get'
  })
}

// 新增私募订单
export function addPeOrder(data) {
  return request({
    url: '/system/peOrder',
    method: 'post',
    data: data
  })
}

// 修改私募订单
export function updatePeOrder(data) {
  return request({
    url: '/system/peOrder',
    method: 'put',
    data: data
  })
}

// 删除私募订单
export function delPeOrder(id) {
  return request({
    url: '/system/peOrder/' + id,
    method: 'delete'
  })
}
