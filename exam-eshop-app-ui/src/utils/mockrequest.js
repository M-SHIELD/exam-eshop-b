import axios from 'axios'
import {Toast} from 'vant'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
const service = axios.create({
    baseURL: '/mock',
    withCredentials: true,
    timeout: 50000
})

/** 请求拦截器 */
service.interceptors.request.use(
    config => {
        return config
    },
    error => {
        return Promise.reject(error)
    }
)

/** 响应拦截器 */
service.interceptors.response.use(
    res => {
        return res.data
    }, (error) => {
        return Promise.reject(new Error(error))
    }
)
export default service
