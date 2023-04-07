import request from '@/utils/request'

export function collectList(params) {
    return request({
        url: '/collection/All',
        data: params,
        method: 'post'
    })
}


