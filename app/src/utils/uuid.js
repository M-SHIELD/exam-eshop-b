import { v4 as uuidv4 } from 'uuid';//创建一个uuid
//要生成一个随机字符串，且每次执行都不能发生变化，游客身份持久存储
export const getUUID = () =>{
    //先从本地存储获取uuid（看一下本地存储里面是否有）
    let uuid_token = localStorage.getItem('UUIDTOKEN');
    //如果没有就生成游客临时身份，并且本地存储一次
    if(!uuid_token){
        uuid_token = uuidv4();
        localStorage.setItem('UUIDTOKEN',uuid_token)
    }
    //切记有返回值
    return uuid_token;
}
