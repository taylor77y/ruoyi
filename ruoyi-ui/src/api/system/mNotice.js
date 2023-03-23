import request from '@/utils/request'

// 查询币币-公告列表
export function listMNotice(query) {
  return request({
    url: '/system/mNotice/list',
    method: 'get',
    params: query
  })
}

// 查询币币-公告详细
export function getMNotice(id) {
  return request({
    url: '/system/mNotice/' + id,
    method: 'get'
  })
}

// 新增币币-公告
export function addMNotice(data) {
  return request({
    url: '/system/mNotice',
    method: 'post',
    data: data
  })
}

// 修改币币-公告
export function updateMNotice(data) {
  return request({
    url: '/system/mNotice',
    method: 'put',
    data: data
  })
}

// 删除币币-公告
export function delMNotice(id) {
  return request({
    url: '/system/mNotice/' + id,
    method: 'delete'
  })
}
