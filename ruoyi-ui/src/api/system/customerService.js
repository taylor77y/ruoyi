import request from '@/utils/request'

// 查询客服链接配置列表
export function listCustomerService(query) {
  return request({
    url: '/system/customerService/list',
    method: 'get',
    params: query
  })
}

// 查询客服链接配置详细
export function getCustomerService(id) {
  return request({
    url: '/system/customerService/' + id,
    method: 'get'
  })
}

// 新增客服链接配置
export function addCustomerService(data) {
  return request({
    url: '/system/customerService',
    method: 'post',
    data: data
  })
}

// 修改客服链接配置
export function updateCustomerService(data) {
  return request({
    url: '/system/customerService',
    method: 'put',
    data: data
  })
}

// 删除客服链接配置
export function delCustomerService(id) {
  return request({
    url: '/system/customerService/' + id,
    method: 'delete'
  })
}
