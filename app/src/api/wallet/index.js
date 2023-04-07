import request from '@/utils/request'

export function walletInfo(params) {
    return request({
        url: '/wallet/getSelectWallet',
        data: params,
        method: 'post'
    })
}


