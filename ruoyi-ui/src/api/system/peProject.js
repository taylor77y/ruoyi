import request from '@/utils/request'

// 查询私募项目列表
export function listPeProject(query) {
  return request({
    url: '/system/peProject/list',
    method: 'get',
    params: query
  })
}

// 查询私募项目详细
export function getPeProject(id) {
  return request({
    url: '/system/peProject/' + id,
    method: 'get'
  })
}

// 新增私募项目
export function addPeProject(data) {
  return request({
    url: '/system/peProject',
    method: 'post',
    data: data
  })
}

// 修改私募项目
export function updatePeProject(data) {
  return request({
    url: '/system/peProject',
    method: 'put',
    data: data
  })
}

// 删除私募项目
export function delPeProject(id) {
  return request({
    url: '/system/peProject/' + id,
    method: 'delete'
  })
}
