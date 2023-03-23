import request from '@/utils/request'

// 查询合约交易对列表
export function listContractMul(query) {
  return request({
    url: '/system/contractMul/list',
    method: 'get',
    params: query
  })
}

// 查询合约交易对详细
export function getContractMul(id) {
  return request({
    url: '/system/contractMul/' + id,
    method: 'get'
  })
}

// 新增合约交易对
export function addContractMul(data) {
  return request({
    url: '/system/contractMul',
    method: 'post',
    data: data
  })
}

// 修改合约交易对
export function updateContractMul(data) {
  return request({
    url: '/system/contractMul',
    method: 'put',
    data: data
  })
}

// 删除合约交易对
export function delContractMul(id) {
  return request({
    url: '/system/contractMul/' + id,
    method: 'delete'
  })
}
