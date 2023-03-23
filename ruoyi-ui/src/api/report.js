import request from '@/utils/request'

// 新增用户统计
export function getAddUserData(data) {
    return request({
      url: '/report/getAddUserData',
      method: 'post',
      data:data
    })
}
// 用户存库金额汇总
export function getLiveAmountData() {
    return request({
      url: '/report/getLiveAmountData',
      method: 'get',
    })
}
//用户报表
export function getUserData(query) {
  return request({
    url: '/report/getUserData',
    method: 'post',
    data: query
  })
}
//总报表
export function getIncomeData(query) {
  return request({
    url: '/report/getIncomeData',
    method: 'post',
    data: query
  })
}
//信息统计
export function getInfoData(query) {
  return request({
    url: '/report/getInfoData',
    method: 'post',
    data: query
  })
}

