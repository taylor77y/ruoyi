import request from '@/utils/request'

// 查询币币-banner图列表
export function listBanner(query) {
  return request({
    url: '/system/banner/list',
    method: 'get',
    params: query
  })
}

// 查询币币-banner图详细
export function getBanner(id) {
  return request({
    url: '/system/banner/' + id,
    method: 'get'
  })
}

// 新增币币-banner图
export function addBanner(data) {
  return request({
    url: '/system/banner',
    method: 'post',
    data: data
  })
}

// 修改币币-banner图
export function updateBanner(data) {
  return request({
    url: '/system/banner',
    method: 'put',
    data: data
  })
}

// 删除币币-banner图
export function delBanner(id) {
  return request({
    url: '/system/banner/' + id,
    method: 'delete'
  })
}
