# “LOHAS in Actions"后端

## 项目使用

```properties

# 在resource文件夹下新建application.properties文件

#运行端口
server.port=

#每次应用启动根据实体建立表的方式,可选值:create,create-drop,update,validate
spring.jpa.hibernate.ddl-auto=

#数据库URL
spring.datasource.url=

#数据库账户名
spring.datasource.username=

#数据库密码
spring.datasource.password=

#查看sql
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#JWT签名
com.lohas.SIGNATURE=

#小程序的AppID，在微信后台获取
com.lohas.WXAPPID=

#小程序的App Sercet，在微信后台获取
com.lohas.WXSECRET=

#授权形式
com.lohas.WXGRANTTYPE=

#OSS相关
aliyun.oss.endpoint=
aliyun.oss.accessKeyId=
aliyun.oss.accessKeySecret=
aliyun.oss.bucketName=
aliyun.oss.folder=
aliyun.oss.webUrl=
```

