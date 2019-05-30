# wechat
基于ssm+netty的在线聊天系统

项目展示:http://106.15.188.67:8080/wechat/  已部署到阿里云Ubuntu系统下

正在接触docker.docker真的非常方便，但是自己没有配置好

Netty 4
WebSocket + HTTP
Spring MVC + Spring +MyBatis
JQuery
Bootstrap 3 + Bootstrap-fileinput
Maven 3.5
Tomcat 8.0
JDK 1.8
IntelliJ IDEA 2017.3.6

前端部分基本套用别人的模板,自己修改了一部分

整个通信系统以Tomcat作为核心服务器运行，其下另开一个线程运行Netty WebSocket服务器，Tomcat服务器主要处理客户登录、个人信息管理等的HTTP类型请求（通常的业务类型），端口为8080，Netty WebSockt服务器主要处理用户消息通信的WebSocket类型请求，端口为3333


单体聊天+文件发送演示 
![Image text](https://github.com/Left-Behind/wechat/blob/master/%E5%8D%95%E4%BD%93%E8%81%8A%E5%A4%A9%2B%E6%96%87%E4%BB%B6%E5%8F%91%E9%80%81.gif)

群组聊天+文件发送演示 
![Image text](https://github.com/Left-Behind/wechat/blob/master/%E7%BE%A4%E7%BB%84%E8%81%8A%E5%A4%A9%2B%E6%96%87%E4%BB%B6%E5%8F%91%E9%80%81.gif)


用户注册+密码找回演示 
![Image text](https://github.com/Left-Behind/wechat/blob/master/%E6%B3%A8%E5%86%8C%2B%E5%AF%86%E7%A0%81%E6%89%BE%E5%9B%9E.gif)


添加好友演示 
![Image text](https://github.com/Left-Behind/wechat/blob/master/%E6%B7%BB%E5%8A%A0%E5%A5%BD%E5%8F%8B.gif)
