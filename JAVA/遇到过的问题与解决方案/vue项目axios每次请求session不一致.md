# vue项目axios每次请求session不一致

```js
 axios.create({
   
    // 重要！！！！！！
    // 携带cookie 为保持session的一致性
    withCredentials: true,
    // 跨域状态必须使用
    crossDomain: true
});
```