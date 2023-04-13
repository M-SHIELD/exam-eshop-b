import axios from 'axios'
import {Toast} from 'vant'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
const service = axios.create({
    baseURL: '/api',
    withCredentials: true,
    timeout: 50000
})

/** 请求拦截器 */
service.interceptors.request.use(
    config => {
        if(localStorage.getItem('TOKEN')){
            config.headers.Authorization = localStorage.getItem('TOKEN');
        }
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

/** 响应拦截器 */
service.interceptors.response.use(
    res => {
        if (res.data.code !== undefined) {
            if (res.data.code !== 0 && res.data.code !== 200 && res.data.success !== true) {
                Toast.fail('请求失败:'+res.data.msg)
                //抛出前端错误
                return Promise.reject(res.data.msg || 'error')
            } else {
                return res.data
            }
        } else {
            return res.data
        }
    }
)
export default service
