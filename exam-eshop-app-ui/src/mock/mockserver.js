import Mock from  'mockjs'
import address from './address.json'
import orderlist from './orderList.json'

Mock.mock('/mock/address','get',{code:200,data:address})
Mock.mock('/mock/order','get',{code:200,data:orderlist})

