import request from '@/utils/request'

// 查询下单列表
export function listOtcOrderPrice(query) {
  return request({
    url: '/system/otcOrderPrice/list',
    method: 'get',
    params: query
  })
}

// 查询下单详细
export function getOtcOrderPrice(id, sender) {
  return request({
    url: '/system/otcOrderPrice/' + id+'?sender=' + sender,
    method: 'get'
  })
}

// 新增下单
export function addOtcOrderPrice(data) {
  return request({
    url: '/system/otcOrderPrice',
    method: 'post',
    data: data
  })
}

// 修改下单
export function updateOtcOrderPrice(data) {
  return request({
    url: '/system/otcOrderPrice',
    method: 'put',
    data: data
  })
}

// 删除下单
export function delOtcOrderPrice(id) {
  return request({
    url: '/system/otcOrderPrice/' + id,
    method: 'delete'
  })
}


//放行
export function Release(id) {
  return request({
    url: '/system/otcOrderPrice/release/'+id,
    method: 'post',
  })
}
//确定
export function sureOrder(id) {
  return request({
    url: '/system/otcOrderPrice/sure/'+id,
    method: 'post',
  })
}
//取消
export function cancelOrder(id) {
  return request({
    url: '/system/otcOrderPrice/cancel/'+id,
    method: 'post',
  })
}