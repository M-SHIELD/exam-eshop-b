import request from '@/utils/request'


export function categoryList() {
    return request({
        url:'/category/select',
        method:'get'
    })
}
