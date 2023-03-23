import request from '@/utils/request'

// 查询自发币时间阶段价格列表
export function listStagePrice(query) {
  return request({
    url: '/system/stagePrice/list',
    method: 'get',
    params: query
  })
}

// 查询自发币时间阶段价格详细
export function getStagePrice(id) {
  return request({
    url: '/system/stagePrice/' + id,
    method: 'get'
  })
}

// 新增自发币时间阶段价格
export function addStagePrice(data) {
  return request({
    url: '/system/stagePrice',
    method: 'post',
    data: data
  })
}

// 修改自发币时间阶段价格
export function updateStagePrice(data) {
  return request({
    url: '/system/stagePrice',
    method: 'put',
    data: data
  })
}

// 删除自发币时间阶段价格
export function delStagePrice(id) {
  return request({
    url: '/system/stagePrice/' + id,
    method: 'delete'
  })
}

// 批量修改
export function batchStagePrice(data) {
  return request({
    url: '/system/stagePrice/batch',
    method: 'post',
    data: data
  })
}