import request from '@/utils/request'

// 查询合约订单列表
export function listContractOrder(query) {
  return request({
    url: '/system/contractOrder/list',
    method: 'get',
    params: query
  })
}

// 查询合约订单详细
export function getContractOrder(id) {
  return request({
    url: '/system/contractOrder/' + id,
    method: 'get'
  })
}

// 新增合约订单
export function addContractOrder(data) {
  return request({
    url: '/system/contractOrder',
    method: 'post',
    data: data
  })
}

// 修改合约订单
export function updateContractOrder(data) {
  return request({
    url: '/system/contractOrder',
    method: 'put',
    data: data
  })
}

// 删除合约订单
export function delContractOrder(id) {
  return request({
    url: '/system/contractOrder/' + id,
    method: 'delete'
  })
}
