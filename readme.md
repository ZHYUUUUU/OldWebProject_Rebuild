# 专家学员教育系统Web项目——旧项目代码优化

## 优化项目的方向
- 项目目录结构合理
- 代码编写规范
- 对移动端的适配（响应式布局）
 
> 注：原项目由小组成员余广文、岑泉林、梁俭宾、张瑜（is me）、白杰荣五人合作的成果，我与另一名成员负责Web前端的设计开发，所以本次优化仅针对前端代码，我将指出旧项目中不规范的地方，并对其进行规范化，同时完善原项目不足之处。（借鉴后面新学习的项目开发经验去优化）

## 1. 搭建页面骨架及项目目录结构

#### 旧结构
```
├─ /code_old/ ····················· 项目所在目录
└─┬─ /css/ ························ 我们自己的CSS文件以及第三方库css文件
  ├─ /fonts/ ······················ 使用到的字体文件
  ├─ /images/ ····················· 使用到的图片文件
  ├─ /js/ ························· 自己写的JS脚步文件以及第三方库js文件
  ├─ /lib/ ························ 从第三方下载回来的库
  ├─ /ui/ ························· 图标
  └─ /xxxxx.html ·················· HTML文件
```

#### 新结构
```
├─ /code_new/ ···················· 项目所在目录
└─┬─ /css/ ······················· 我们自己的CSS文件
  ├─ /font/ ······················ 使用到的字体文件
  ├─ /img/ ······················· 使用到的图片文件
  ├─ /js/ ························ 自己写的JS脚步
  ├─ /lib/ ······················· 从第三方下载回来的库【只用不改】
  ├─ /favicon.ico ················ 站点图标
  └─ /xxxxx.html ················· HTML文件
```

### 1.1.约定编码规范

> 在原合作开发项目时，我们并没有统一的书面的编码规范约定，只是更多的在口头方面的沟通，以至于代码结构比较混乱没有规范，与另一个前端成员在项目合并时也出现很多问题，所以在血的教训的之后，我尤其关注的是编码规范化的问题。

#### 1.1.1.HTML约定

- 在head中引入必要的CSS文件，优先引用第三方的CSS，方便我们自己的样式覆盖
- 在body末尾引入必要的JS文件，优先引用第三方的JS，注意JS文件之间的依赖关系，比如bootstrap.js依赖jQuery，那就应该先引用jquery.js 然后引用bootstrap.js

#### 1.1.2.CSS约定

- 除了公共级别样式，其余样式全部由 模块前缀
- 尽量使用 直接子代选择器， 少用间接子代 避免错杀

### 1.2.HTML5文档结构

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>页面标题</title>
</head>
<body>
  
</body>
</html>
```

### 1.3.Viewport设置

```html
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
```

> html中插入视口设置，可以通过emmet __meta:vp__ 插入

### 1.4.浏览器兼容模式

```html
<meta http-equiv="X-UA-Compatible" content="IE=edge">
```

> html中插入兼容模式设置，可以通过emmet __meta:compat__ 插入

### 1.5.favicon（站点图标）

```html
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
```

> html中插入图标链接，可以通过emmet __link:favicon__ 插入

### 1.6.引入相应的第三方文件

```html
<link rel="stylesheet" href="bootstrap.css">
<link rel="stylesheet" href="my.css">
...
<script src="jquery.js"></script>
<script src="bootstrap.js"></script>
<script src="my.js"></script>
```

### 1.7.在我们默认的样式表中将默认字体设置为：

```
body{
  font-family: "Helvetica Neue", 
                Helvetica, 
                Microsoft Yahei, 
                Hiragino Sans GB, 
                WenQuanYi Micro Hei, 
                sans-serif;
}
```
