import request from '@/utils/request'

// 查询三方接口列表
export function listThirdPart(query) {
  return request({
    url: '/system/thirdPart/list',
    method: 'get',
    params: query
  })
}

// 查询三方接口详细
export function getThirdPart(id) {
  return request({
    url: '/system/thirdPart/' + id,
    method: 'get'
  })
}

// 新增三方接口
export function addThirdPart(data) {
  return request({
    url: '/system/thirdPart',
    method: 'post',
    data: data
  })
}

// 修改三方接口
export function updateThirdPart(data) {
  return request({
    url: '/system/thirdPart',
    method: 'put',
    data: data
  })
}

// 删除三方接口
export function delThirdPart(id) {
  return request({
    url: '/system/thirdPart/' + id,
    method: 'delete'
  })
}
