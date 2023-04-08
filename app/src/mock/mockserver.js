import Mock from  'mockjs'
import address from './address.json'

Mock.mock('/mock/address',{code:200,data:address})

