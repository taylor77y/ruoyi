import request from '@/utils/request'

// 查询币种交易量列表
export function listBibiDayRecord(query) {
  return request({
    url: '/system/bibiDayRecord/list',
    method: 'get',
    params: query
  })
}

// 查询币种交易量详细
export function getBibiDayRecord(id) {
  return request({
    url: '/system/bibiDayRecord/' + id,
    method: 'get'
  })
}

// 新增币种交易量
export function addBibiDayRecord(data) {
  return request({
    url: '/system/bibiDayRecord',
    method: 'post',
    data: data
  })
}

// 修改币种交易量
export function updateBibiDayRecord(data) {
  return request({
    url: '/system/bibiDayRecord',
    method: 'put',
    data: data
  })
}

// 删除币种交易量
export function delBibiDayRecord(id) {
  return request({
    url: '/system/bibiDayRecord/' + id,
    method: 'delete'
  })
}
