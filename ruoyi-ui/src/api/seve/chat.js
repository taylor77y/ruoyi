import request from '@/utils/request'

// 在线聊天
export function chatSeven() {
  return request({
    url: '/system/seve/chat',
    method: 'get',
  })
}

// 在线记录
export function getChatList(data) {
    return request({
      url: '/system/seve/getChatList/'+data,
      method: 'get',
    })
}
// 在线记录
export function chatRecords(id) {
  return request({
    url: '/system/seve/chatRecords/'+id,
    method: 'get',
  })
}

// 查询
export function searchRecords(code) {
  return request({
    url: '/system/seve/search/'+code,
    method: 'get',
  })
}