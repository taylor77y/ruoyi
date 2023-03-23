import request from '@/utils/request'

// 查询法币订单列表
export function listOtcOrder(query) {
  return request({
    url: '/system/otcOrder/list',
    method: 'get',
    params: query
  })
}

// 查询法币订单详细
export function getOtcOrder(id) {
  return request({
    url: '/system/otcOrder/' + id,
    method: 'get'
  })
}

// 新增法币订单
export function addOtcOrder(data) {
  return request({
    url: '/system/otcOrder',
    method: 'post',
    data: data
  })
}

// 修改法币订单
export function updateOtcOrder(data) {
  return request({
    url: '/system/otcOrder',
    method: 'put',
    data: data
  })
}

// 删除法币订单
export function delOtcOrder(id) {
  return request({
    url: '/system/otcOrder/' + id,
    method: 'delete'
  })
}


export function getStoreList(){
  return request({
    url: '/system/otcOrder/getStoreList',
    method: 'get'
  })
}

export function getFbList(){
  return request({
    url: '/system/otcOrder/getFbList',
    method: 'get'
  })
}

// 撤销
export function Revoke(id) {
  return request({
    url: '/system/otcOrder/revoke/'+id,
    method: 'post',
  })
}
