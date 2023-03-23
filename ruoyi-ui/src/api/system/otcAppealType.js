import request from '@/utils/request'

// 查询OTC申诉类型列表
export function listOtcAppealType(query) {
  return request({
    url: '/system/otcAppealType/list',
    method: 'get',
    params: query
  })
}

// 查询OTC申诉类型详细
export function getOtcAppealType(id) {
  return request({
    url: '/system/otcAppealType/' + id,
    method: 'get'
  })
}

// 新增OTC申诉类型
export function addOtcAppealType(data) {
  return request({
    url: '/system/otcAppealType',
    method: 'post',
    data: data
  })
}

// 修改OTC申诉类型
export function updateOtcAppealType(data) {
  return request({
    url: '/system/otcAppealType',
    method: 'put',
    data: data
  })
}

// 删除OTC申诉类型
export function delOtcAppealType(id) {
  return request({
    url: '/system/otcAppealType/' + id,
    method: 'delete'
  })
}
