import request from '@/utils/request'

export function postorderlist(params) {
    return request({
        url: '/order/getAllOrders',
        data: params,
        method: 'post'
    })
}
