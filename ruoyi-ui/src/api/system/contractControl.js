import request from '@/utils/request'

// 查询分页
export function page(query) {
  return request({
    url: '/system/contractControl/page',
    method: 'get',
    params: query
  })
}

// 查询合约订单详细
export function setWin(id, win) {
  return request({
    url: '/system/contractControl/setWin',
    method: 'put',
    params: {
      id: id,
      win: win
    }
  })
}