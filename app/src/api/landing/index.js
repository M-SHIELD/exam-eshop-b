import request from '@/utils/request'

export function postlanding(params) {
    return request({
        url: '/user/register',
        data: params,
        method: 'post'
    })
}
