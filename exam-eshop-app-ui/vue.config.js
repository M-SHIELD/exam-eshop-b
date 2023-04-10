const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: false,
    devServer: {
        port: 8080,
        proxy: {
            "/api/": {
                target: "http://localhost:8001/api/",  //请求目标服务器的url
                changeOrigin: true,        //是否跨域（选为true）
                pathRewrite: {
                    "^/api/": ""   //将axios请求url中的/a进行重写
                }
            }
        }
    },
})
