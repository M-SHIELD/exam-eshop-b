import request from '@/utils/request'


// 订单提交
export function orderSubmit(data) {
    return request({
        url:'/oms/api.app/v1/orders',
        method:'post',
        data:data
    })
}

// 随机生成页面token
export function orderToken() {
    return request({
        url:'/oms/api.app/v1/orders/token',
        method:'post'
    })
}



// 用户订单
export function getOrderList(data) {
    return request({
        url:'/%E5%95%86%E5%93%81%E8%AE%A2%E5%8D%95/getAllOrPart',
        method:'post',
        data:data
    })
}
