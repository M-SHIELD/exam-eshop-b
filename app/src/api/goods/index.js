import request from '@/utils/request'

export function goodsList(params) {
    return request({
        url: '/goods/getGoods',
        data: params,
        method: 'post'
    })
}

export function goodsDetail(id) {
    return request({
        url:'/pms/api.app/v1/goods/'+id,
        method:'get'
    })
}

