import request from '@/utils/request'

// 查询Otc申诉列表
export function listOtcOrderAppeal(query) {
  return request({
    url: '/system/otcOrderAppeal/list',
    method: 'get',
    params: query
  })
}

// 查询Otc申诉详细
export function getOtcOrderAppeal(id) {
  return request({
    url: '/system/otcOrderAppeal/' + id,
    method: 'get'
  })
}

// 新增Otc申诉
export function addOtcOrderAppeal(data) {
  return request({
    url: '/system/otcOrderAppeal',
    method: 'post',
    data: data
  })
}

// 修改Otc申诉
export function updateOtcOrderAppeal(data) {
  return request({
    url: '/system/otcOrderAppeal',
    method: 'put',
    data: data
  })
}

// 删除Otc申诉
export function delOtcOrderAppeal(id) {
  return request({
    url: '/system/otcOrderAppeal/' + id,
    method: 'delete'
  })
}
