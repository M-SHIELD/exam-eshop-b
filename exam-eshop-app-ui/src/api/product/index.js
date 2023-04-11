import request from '@/utils/request'

export function getAllProduct(params) {
    return request({
        url: '/product/getAllProduct',
        data: params,
        method: 'post'
    })
}
export function getdetails(id) {
    return request({
        url: `/product/details/${id}`,
        method: 'post'
    })
}


