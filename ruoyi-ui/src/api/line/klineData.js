import request from '@/utils/request'

// 查询自发币K线数据列表
export function listKlineData(query) {
  return request({
    url: '/system/klineData/list',
    method: 'get',
    params: query
  })
}

// 查询自发币K线数据详细
export function getKlineData(id) {
  return request({
    url: '/system/klineData/' + id,
    method: 'get'
  })
}

// 新增自发币K线数据
export function addKlineData(data) {
  return request({
    url: '/system/klineData',
    method: 'post',
    data: data
  })
}

// 修改自发币K线数据
export function updateKlineData(data) {
  return request({
    url: '/system/klineData',
    method: 'put',
    data: data
  })
}

// 删除自发币K线数据
export function delKlineData(id) {
  return request({
    url: '/system/klineData/' + id,
    method: 'delete'
  })
}

//批量修改
export function batchKlineData(data) {
  return request({
    url: '/system/klineData/batch',
    method: 'post',
    data: data
  })
}