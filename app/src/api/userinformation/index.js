import request from '@/utils/request'

export function postuserinformation(params) {
    return request({
        url: '/user/get',
        data: params,
        method: 'post'
    })
}
