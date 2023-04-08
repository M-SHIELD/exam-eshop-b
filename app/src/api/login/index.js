import request from '@/utils/request'

export function postlogin(params) {
    return request({
        url: '/user/login',
        data: params,
        method: 'post'
    })
}
