import request from '@/utils/request'

// 查询用户财务分析列表
export function listUserBlanceCollect(query) {
  return request({
    url: '/system/userBlanceCollect/list',
    method: 'get',
    params: query
  })
}

// 查询用户财务分析详细
export function getUserBlanceCollect(id) {
  return request({
    url: '/system/userBlanceCollect/' + id,
    method: 'get'
  })
}

// 新增用户财务分析
export function addUserBlanceCollect(data) {
  return request({
    url: '/system/userBlanceCollect',
    method: 'post',
    data: data
  })
}

// 修改用户财务分析
export function updateUserBlanceCollect(data) {
  return request({
    url: '/system/userBlanceCollect',
    method: 'put',
    data: data
  })
}

// 删除用户财务分析
export function delUserBlanceCollect(id) {
  return request({
    url: '/system/userBlanceCollect/' + id,
    method: 'delete'
  })
}
