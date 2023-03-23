import request from '@/utils/request'

// 查询分享图片列表
export function listShareImg(query) {
  return request({
    url: '/system/shareImg/list',
    method: 'get',
    params: query
  })
}

// 查询分享图片详细
export function getShareImg(id) {
  return request({
    url: '/system/shareImg/' + id,
    method: 'get'
  })
}

// 新增分享图片
export function addShareImg(data) {
  return request({
    url: '/system/shareImg',
    method: 'post',
    data: data
  })
}

// 修改分享图片
export function updateShareImg(data) {
  return request({
    url: '/system/shareImg',
    method: 'put',
    data: data
  })
}

// 删除分享图片
export function delShareImg(id) {
  return request({
    url: '/system/shareImg/' + id,
    method: 'delete'
  })
}
