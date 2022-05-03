# 一、准备工作

## 文档

[Vue3](https://v3.cn.vuejs.org/guide/introduction.html)

[Vue2](https://vuejs.bootcss.com/guide/index.html)

## CDN

### Vue2.x

```html
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- 生产环境版本，优化了尺寸和速度 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14"></script>
```

### Vue3.x

```html
<!--最新版本-->
<script src="https://unpkg.com/vue@next"></script>
```

## [声明式渲染](https://vuejs.bootcss.com/guide/index.html#声明式渲染)

Vue.js 的核心是一个允许采用简洁的模板语法来声明式地将数据渲染进 DOM 的系统：

```html
<div id="app-1">
    {{message}}
</div>
```

```javascript
var app1 = new Vue({
    el: "#app-1",
    data: {
        message: "Hello word!"
    }
});
```

注意我们不再和 HTML 直接交互了。一个 Vue 应用会将其挂载到一个 DOM 元素上 (对于这个例子是 `#app`) 然后对其进行完全控制。那个 HTML 是我们的入口，但其余都会发生在新创建的 Vue 实例内部。

---

# 二、v-bind

 `v-bind` attribute 被称为**指令**。指令带有前缀 `v-`，以表示它们是 Vue 提供的特殊 attribute。它们会在渲染的 DOM 上应用特殊的响应式行为。在这里，该指令的意思是：“将这个元素节点的 `title` attribute 和 Vue 实例的 `message` property 保持一致”。

```html
<div id="app-2">
  <span v-bind:title="message">
    鼠标悬停几秒钟查看此处动态绑定的提示信息！
  </span>
</div>
```

```javascript
var app2 = new Vue({
    el: '#app-2',
    data: {
        message: '页面加载于 ' + new Date().toLocaleString()
    }
});
```



---

# 三、v-if、v-else

控制切换一个元素是否显示也相当简单：

```html
<div id="app-3">
    <span v-if="seen">现在你看到我了</span>
    <span v-else>看不见看不见</span>
</div>
```

```javascript
var app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
});
```

在控制台输入 `app3.seen = false`，你会发现之前显示的消息消失了。



---



# 四、v-for

`v-for` 指令可以绑定数组的数据来渲染一个项目列表：

```html
<div id="app-4">
    <ol>
        <li v-for="todo in todos">
            {{ todo.text }}
        </li>
    </ol>
</div>
```

```javascript
var app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            { text: '学习 JavaScript' },
            { text: '学习 Vue' },
            { text: '整个牛项目' }
        ]
    }
});
```



---



# 五、v-on

为了让用户和你的应用进行交互，我们可以用 `v-on` 指令添加一个事件监听器，通过它调用在 Vue 实例中定义的方法：

```html
<div id="app-5">
    <p>{{ message }}</p>
    <button v-on:click="reverseMessage">反转消息</button>
</div>
```

```javascript
var app5 = new Vue({
    el: '#app-5',
    data: {
        message: 'Hello Vue.js!'
    },
    methods: {
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
});
```

注意在 `reverseMessage` 方法中，我们更新了应用的状态，但没有触碰 DOM——所有的 DOM 操作都由 Vue 来处理，你编写的代码只需要关注逻辑层面即可。



---



# 六、`v-model`双向数据绑定

`v-model` 指令，它能轻松实现表单输入和应用状态之间的双向绑定。

```html
<div id="app-6">
    <p>{{ message }}</p>
    <input v-model="message">
</div>
```

```javascript
var app6 = new Vue({
    el: '#app-6',
    data: {
        message: 'Hello Vue!'
    }
});
```

## 6.1、什么是双向绑定

​    Vue.js是一个MVVM框架，即数据双向绑定,即当数据发生变化的时候,视图也就发生变化，当视图发生变化的时候，数据也会跟着同步变化。这也算是Vue.js的精髓之处了。

​    值得注意的是，我们所说的数据双向绑定，一定是对于UI控件来说的，非UI控件不会涉及到数据双向绑定。单向数据绑定是使用状态管理工具的前提。如果我们使用vuex，那么数据流也是单项的，这时就会和双向数据绑定有冲突。

## 6.2、为什么要实现数据的双向绑定

​    在Vue.js 中，如果使用vuex ，实际上数据还是单向的，之所以说是数据双向绑定，这是用的UI控件来说，对于我们处理表单，Vue.js的双向数据绑定用起来就特别舒服了。即两者并不互斥，在全局性数据流使用单项,方便跟踪;局部性数据流使用双向，简单易操作。

## 6.3在表单中使用双向数据绑定

​    你可以用`v-model`指令在表单 `<input>`、`<textarea>` 及`<select>` 元素上创建双向数据绑定。它会根据控件类型自动选取正确的方法来更新元素。尽管有些神奇，但`v-model`本质上不过是语法糖。它负责监听户的输入事件以更新数据，并对一些极端场景进行一些特殊处理。

##  **注意：**

**v-model会忽略所有元素的value、checked、selected特性的初始值而总是将Vue实例的数据作为数据来源，你应该通过JavaScript在组件的data选项中声明。**



---



# 七、组件

+ 组件系统是 Vue 的另一个重要概念，因为它是一种抽象，允许我们使用小型、独立和通常可复用的组件构建大型应用。仔细想想，几乎任意类型的应用界面都可以抽象为一个组件树。

+  组件是可复用的`Vue`实例，说白了就是一组可以重复使用的模板，跟JSTL的自定义标签、Thymeleaf的`th:fragment` 等框架有着异曲同工之妙。通常一个应用会以一棵嵌套的组件树的形式来组织。

![树](../NotesImg/components.png)

```html
<div id="app-7">
    <ol>
        <!--
          现在我们为每个 todo-item 提供 todo 对象
          todo 对象是变量，即其内容可以是动态的。
        -->

        <todo-item
                v-for="item in items"
                v-bind:todo="item">
        </todo-item>
    </ol>
</div>
```

```javascript
//定义一个Vue组件
Vue.component('todo-item', {
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})
var app7 = new Vue({
    el: '#app-7',
    data: {
        items: [
            {id: 0, text: '蔬菜'},
            {id: 1, text: '奶酪'},
            {id: 2, text: '随便其它什么人吃的东西'}
        ]
    }
});
```

`v-for="item in items"` : 遍历Vue 实例中定义的名为items 的数组,并创建同等数量的组件

`v-bind:item="item"` : 将遍历的item项定到组件中props定义的名为item属性上；=号左边的todo为props定义的属性名，右边的为item in items中遍历的item项的值



---



# 八、Axios通信

1. 什么是Axios
Axios是一个开源的可以用在浏览器端和NodeJS 的异步通信框架，她的主要作用就是实现AJAX异步通信，其功能特点如下:

2. 从浏览器中创建XMLHttpRequests

3. 从node.js创建http请求

4. 支持Promise API [JS中链式编程]

5. 拦截请求和响应

6. 转换请求数据和响应数据

7. 取消请求

8. 自动转换JSON数据

9. 客户端支持防御XSRF (跨站请求伪造)

GitHub:https://github.com/axios/axios
中文文档: http://www.axios-js.com/

