import request from '@/utils/request'

// 查询 充提配置列表
export function listDictionaries(query) {
  return request({
    url: '/system/dictionaries/list',
    method: 'get',
    params: query
  })
}

// 查询 充提配置详细
export function getDictionaries(id) {
  return request({
    url: '/system/dictionaries/' + id,
    method: 'get'
  })
}

// 新增 充提配置
export function addDictionaries(data) {
  return request({
    url: '/system/dictionaries',
    method: 'post',
    data: data
  })
}

// 修改 充提配置
export function updateDictionaries(data) {
  return request({
    url: '/system/dictionaries',
    method: 'put',
    data: data
  })
}

// 删除 充提配置
export function delDictionaries(id) {
  return request({
    url: '/system/dictionaries/' + id,
    method: 'delete'
  })
}
