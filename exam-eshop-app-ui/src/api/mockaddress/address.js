import mockrequest from "../../utils/mockrequest";

export const addressList= () =>
    mockrequest({
        url: '/address',
        method: 'get'
    })

export const orderList= () =>
    mockrequest({
        url: '/order',
        method: 'get'
    })

