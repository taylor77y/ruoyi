import request from '@/utils/request'

// 查询分页
export function page(query) {
    return request({
        url: '/system/perpetual/contract/control/page',
        method: 'get',
        params: query
    })
}

// 查询合约订单详细
export function setControlAndWin(id, control, win) {
    return request({
        url: '/system/perpetual/contract/control/setControlAndWin',
        method: 'put',
        params: {
            id: id,
            control: control,
            win: win
        }
    })
}