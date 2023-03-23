import request from '@/utils/request'

// 查询币币撮合列表
export function listEntrust(query) {
  return request({
    url: '/system/entrust/list',
    method: 'get',
    params: query
  })
}

// 查询币币撮合详细
export function getEntrust(id) {
  return request({
    url: '/system/entrust/' + id,
    method: 'get'
  })
}

// 新增币币撮合
export function addEntrust(data) {
  return request({
    url: '/system/entrust',
    method: 'post',
    data: data
  })
}

// 修改币币撮合
export function updateEntrust(data) {
  return request({
    url: '/system/entrust',
    method: 'put',
    data: data
  })
}

// 删除币币撮合
export function delEntrust(id) {
  return request({
    url: '/system/entrust/' + id,
    method: 'delete'
  })
}

// 币币撮合撤销
export function cancelEntrust(id) {
  return request({
    url: '/system/entrust/cancel/'+id,
    method: 'post',
  })
}
// 币币撮合同意
export function agreeEntrust(id) {
  return request({
    url: '/system/entrust/agree/'+id,
    method: 'post',
  })
}
