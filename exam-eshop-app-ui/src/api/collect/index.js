import request from '@/utils/request'

export function getAllcollect(params) {
    return request({
        url: '/collect/getCollects',
        data: params,
        method: 'post'
    })
}
export function addcollect(params) {
    return request({
        url: '/collect/add',
        data: params,
        method: 'post'
    })
}

export function delcollect(params) {
    return request({
        url: '/collect/del',
        data: params,
        method: 'post'
    })
}
export function delallcollect(params) {
    return request({
        url: `/collect/dels/${params.productId}`,
        data: params,
        method: 'post'
    })
}
