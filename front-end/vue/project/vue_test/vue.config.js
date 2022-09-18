const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  pages:{
    index:{
      //入口文件
      entry:'src/main.js',
    }
  },
  //关闭语法检查
  lintOnSave:false
})
