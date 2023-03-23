import request from '@/utils/request'

// 查询提币审核列表
export function listExtractCoin(query) {
  return request({
    url: '/system/extractCoin/list',
    method: 'get',
    params: query
  })
}

// 查询提币审核详细
export function getExtractCoin(id) {
  return request({
    url: '/system/extractCoin/' + id,
    method: 'get'
  })
}

// 新增提币审核
export function addExtractCoin(data) {
  return request({
    url: '/system/extractCoin',
    method: 'post',
    data: data
  })
}

// 修改提币审核
export function updateExtractCoin(data) {
  return request({
    url: '/system/extractCoin',
    method: 'put',
    data: data
  })
}

// 删除提币审核
export function delExtractCoin(id) {
  return request({
    url: '/system/extractCoin/' + id,
    method: 'delete'
  })
}

// 同意
export function Agree(id) {
  return request({
    url: '/system/extractCoin/agree/'+id,
    method: 'post',
  })
}
// 驳回
export function Reject(id) {
  return request({
    url: '/system/extractCoin/reject/'+id,
    method: 'post',
  })
}