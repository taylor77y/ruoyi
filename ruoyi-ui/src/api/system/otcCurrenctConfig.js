import request from '@/utils/request'

// 查询法币币种配置列表
export function listOtcCurrenctConfig(query) {
  return request({
    url: '/system/otcCurrenctConfig/list',
    method: 'get',
    params: query
  })
}

// 查询法币币种配置详细
export function getOtcCurrenctConfig(id) {
  return request({
    url: '/system/otcCurrenctConfig/' + id,
    method: 'get'
  })
}

// 新增法币币种配置
export function addOtcCurrenctConfig(data) {
  return request({
    url: '/system/otcCurrenctConfig',
    method: 'post',
    data: data
  })
}

// 修改法币币种配置
export function updateOtcCurrenctConfig(data) {
  return request({
    url: '/system/otcCurrenctConfig',
    method: 'put',
    data: data
  })
}

// 删除法币币种配置
export function delOtcCurrenctConfig(id) {
  return request({
    url: '/system/otcCurrenctConfig/' + id,
    method: 'delete'
  })
}
