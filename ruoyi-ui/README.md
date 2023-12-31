## 开发

```bash
# 克隆项目
git clone https://gitee.com/y_project/RuoYi-Vue

# 进入项目目录
cd ruoyi-ui

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npmmirror.com

# 启动服务
npm run dev
```

浏览器访问 http://localhost:80

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```


## 后端ruoyi-admin.jar 部署说明：
### 1、application.yml 图片上传路径修改 profile: /www/wwwroot/image1.bityou.cc/ruoyi
### 2、logback.xml 日志路径修改 value="/www/wwwlogs/ruoyi/logs"
### 3、CommonController 加载图片路径的修改 http://image1.bityou.cc/ruoyi