import request from '@/utils/request'

// 查询法币配置列表
export function listMemberCurrencyConfig(query) {
  return request({
    url: '/system/memberCurrencyConfig/list',
    method: 'get',
    params: query
  })
}

// 查询法币配置详细
export function getMemberCurrencyConfig(id) {
  return request({
    url: '/system/memberCurrencyConfig/' + id,
    method: 'get'
  })
}

// 新增法币配置
export function addMemberCurrencyConfig(data) {
  return request({
    url: '/system/memberCurrencyConfig',
    method: 'post',
    data: data
  })
}

// 修改法币配置
export function updateMemberCurrencyConfig(data) {
  return request({
    url: '/system/memberCurrencyConfig',
    method: 'put',
    data: data
  })
}

// 删除法币配置
export function delMemberCurrencyConfig(id) {
  return request({
    url: '/system/memberCurrencyConfig/' + id,
    method: 'delete'
  })
}
