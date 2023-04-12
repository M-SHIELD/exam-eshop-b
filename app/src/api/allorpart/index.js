import request from '@/utils/request'

export function getallorpart(params) {
    return request({
        url:'/order/getAllOrPart',
        data: params,
        method:'post'
    })
}
