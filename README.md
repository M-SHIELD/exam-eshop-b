# 一气化三清 商城(移动端 pc端 后端)

## 介绍
通过springboot+vue 实现商城模板 前后端整合 (移动端 后台)




## 安装教程

1.  导入数据库
2.  修改yml文件(数据库等)
3.  配置环境运行: (mysql java node npm 等)
4.  cd到前端(app目录)
5.  npm i或者cnpm i 下载前端库
6.  执行npm run serve 运行前端(可能存在node版本不兼容,自行百度切换node版本 这里版本为v16.14.2)
7.  通过idea运行后台


- 注释:查看Swagger `后端网址/swagger-ui/index.html`

## 快速使用
1. git bash执行` git clone git@gitee.com:liveablestudio/shoulders-of-giants.git`拉取项目
2. 导入`goods_sql.sql`数据库文件到`mysql`
3. 修改 `goods_example\src\main\resources\application-dev.yml` 数据库账号密码






## 软件架构
```
shoulders-of-giants
 ├── app 前端
 │   ├── app.iml
 │   ├── babel.config.js
 │   ├── dist 
 │   │   ├── css
 │   │   ├── favicon.ico
 │   │   ├── index.html
 │   │   └── js
 │   ├── jsconfig.json
 │   ├── package-lock.json
 │   ├── package.json
 │   ├── public
 │   │   ├── favicon.ico
 │   │   └── index.html
 │   ├── README.md
 │   ├── src
 │   │   ├── App.vue
 │   │   ├── assets
 │   │   ├── components
 │   │   ├── main.js
 │   │   ├── router
 │   │   ├── store
 │   │   └── views
 │   └── vue.config.js
 ├── goods_demo.sql 数据库文件
 ├── goods_example 后端
 │   ├── goods_example.iml
 │   ├── HELP.md
 │   ├── mvnw
 │   ├── mvnw.cmd
 │   ├── pom.xml
 │   ├── README.md
 │   ├── src
 │       ├── main
 │       └── test
 ├── LICENSE
 ├── README.en.md
 └── README.md
```


## 技术栈
- vuex mybatis-plus mysql springboot

## 待实现
- [ ]  windows端商品页面实现 (图片滚动 规格显示
- [ ]  商品分类转商品列表
- [ ]  收藏页面,收藏 批量取消收藏
- [ ]  实现用户登录(token方式)
- [ ]  商品搜索
- [ ]  首页切换一集分类菜单
- [x]  vantui 商品列表实现 分页 (滑动检测/查看更多 )排序
- [x]  根据订单状态查询对应的订单列表 (个人信息的订单五类  订单列表
- [x]  充值方案 我的钱包 充值 
- [x]  我的足迹(vuex) 
- [x] 点击首页菜单栏中的积分商品，
  点击积分商品进入积分商品详情页，显示积分商品详情。
  区别在于按钮 和价格以及积分显示


