import request from '@/utils/request'

export function postregister(params) {
    return request({
        url: '/user/register',
        data: params,
        method: 'post'
    })
}
