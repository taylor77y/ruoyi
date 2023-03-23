import request from '@/utils/request'

// 查询秒合约配置列表
export function listSecondsConfig(query) {
  return request({
    url: '/system/secondsConfig/list',
    method: 'get',
    params: query
  })
}

// 查询秒合约配置详细
export function getSecondsConfig(id) {
  return request({
    url: '/system/secondsConfig/' + id,
    method: 'get'
  })
}

// 新增秒合约配置
export function addSecondsConfig(data) {
  return request({
    url: '/system/secondsConfig',
    method: 'post',
    data: data
  })
}

// 修改秒合约配置
export function updateSecondsConfig(data) {
  return request({
    url: '/system/secondsConfig',
    method: 'put',
    data: data
  })
}

// 删除秒合约配置
export function delSecondsConfig(id) {
  return request({
    url: '/system/secondsConfig/' + id,
    method: 'delete'
  })
}
