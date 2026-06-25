Blog Server Backend
基于 Spring Boot 的博客系统后端服务，提供文章管理、分类管理、用户管理等核心 API 接口。

技术栈
Java 17+

Spring Boot 2.x

MyBatis / MyBatis-Plus

MySQL

Maven

快速开始
1. 克隆项目
bash
git clone https://github.com/sunwencheng5/blog-server-Backend.git
cd blog-server-Backend
2. 导入数据库
bash
# 创建数据库（名称请参考 db_blog_manage.sql 中的配置）
mysql -u root -p < sql/db_blog_manage.sql
3. 修改配置文件
编辑 src/main/resources/application.yml，配置数据库连接信息：

yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/你的数据库名?useSSL=false&serverTimezone=UTC
    username: 你的用户名
    password: 你的密码
4. 启动项目
bash
# 使用 Maven 启动
mvn spring-boot:run

# 或打包运行
mvn clean package
java -jar target/blog-server-Backend-*.jar
5. 测试接口
项目启动后默认端口为 8080，可使用以下方式测试：

使用 generated-requests.http 文件（需安装 REST Client 插件）

使用 Postman 或 curl 工具

API 接口概览
模块	说明
文章管理	增删改查、分页列表
分类管理	增删改查
用户管理	登录、注册、信息管理
具体接口路径请参考 controller 包下的代码注释。

贡献
欢迎提交 Issue 和 Pull Request。

License
暂无
