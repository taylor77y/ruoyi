import request from '@/utils/request'

// 查询收款账户列表
export function listMoneyAccount(query) {
  return request({
    url: '/system/moneyAccount/list',
    method: 'get',
    params: query
  })
}

// 查询收款账户详细
export function getMoneyAccount(id) {
  return request({
    url: '/system/moneyAccount/' + id,
    method: 'get'
  })
}

// 新增收款账户
export function addMoneyAccount(data) {
  return request({
    url: '/system/moneyAccount',
    method: 'post',
    data: data
  })
}

// 修改收款账户
export function updateMoneyAccount(data) {
  return request({
    url: '/system/moneyAccount',
    method: 'put',
    data: data
  })
}

// 删除收款账户
export function delMoneyAccount(id) {
  return request({
    url: '/system/moneyAccount/' + id,
    method: 'delete'
  })
}
