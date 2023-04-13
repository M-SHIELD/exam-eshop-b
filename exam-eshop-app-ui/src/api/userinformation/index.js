import request from '@/utils/request'

export function postUserInformation(params) {
    return request({
        url: '/user/get',
        data: params,
        method: 'post'
    })
}
