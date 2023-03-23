import request from '@/utils/request'

// 查询订单持续总时长列表
export function listOtcTypeConfig(query) {
  return request({
    url: '/system/otcTypeConfig/list',
    method: 'get',
    params: query
  })
}

// 查询订单持续总时长详细
export function getOtcTypeConfig(id) {
  return request({
    url: '/system/otcTypeConfig/' + id,
    method: 'get'
  })
}

// 新增订单持续总时长
export function addOtcTypeConfig(data) {
  return request({
    url: '/system/otcTypeConfig',
    method: 'post',
    data: data
  })
}

// 修改订单持续总时长
export function updateOtcTypeConfig(data) {
  return request({
    url: '/system/otcTypeConfig',
    method: 'put',
    data: data
  })
}

// 删除订单持续总时长
export function delOtcTypeConfig(id) {
  return request({
    url: '/system/otcTypeConfig/' + id,
    method: 'delete'
  })
}
