import request from '@/utils/request'

// 查询机器人配置列表
export function listRobotConfig(query) {
  return request({
    url: '/system/robotConfig/list',
    method: 'get',
    params: query
  })
}

// 查询机器人配置详细
export function getRobotConfig(id) {
  return request({
    url: '/system/robotConfig/' + id,
    method: 'get'
  })
}

// 新增机器人配置
export function addRobotConfig(data) {
  return request({
    url: '/system/robotConfig',
    method: 'post',
    data: data
  })
}

// 修改机器人配置
export function updateRobotConfig(data) {
  return request({
    url: '/system/robotConfig',
    method: 'put',
    data: data
  })
}

// 删除机器人配置
export function delRobotConfig(id) {
  return request({
    url: '/system/robotConfig/' + id,
    method: 'delete'
  })
}
