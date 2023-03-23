import request from '@/utils/request'

// 查询充币地址列表
export function listWalletPool(query) {
  return request({
    url: '/system/walletPool/list',
    method: 'get',
    params: query
  })
}

// 查询充币地址详细
export function getWalletPool(id) {
  return request({
    url: '/system/walletPool/' + id,
    method: 'get'
  })
}

// 新增充币地址
export function addWalletPool(data) {
  return request({
    url: '/system/walletPool',
    method: 'post',
    data: data
  })
}

// 修改充币地址
export function updateWalletPool(data) {
  return request({
    url: '/system/walletPool',
    method: 'put',
    data: data
  })
}

// 删除充币地址
export function delWalletPool(id) {
  return request({
    url: '/system/walletPool/' + id,
    method: 'delete'
  })
}
