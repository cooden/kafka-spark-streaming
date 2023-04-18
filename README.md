
## Kafka引入

配置application.properties
这里要在application里配置Kafka的ip，端口等； 

直接在SpringbootApplication下启动KafkaListener

## 启动Kafka
使用nohup命令启动
项目路径：
  cd /usr/local/
  
nohup bin/zookeeper-server-start.sh config/zookeeper.properties
nohup bin/kafka-server-start.sh config/server.properties

关于
java.lang.IllegalArgumentException: requirement failed: Corrupt index found, index file (/tmp/kafka-logs/__consumer_offsets-23/00000000000000000000.index) has non-zero size but the last offset is 0 and the base offset is 0


StreamingExamples.scala

## 发布到yarn集群后
杀死命令
yarn application -kill application_id


#Maven打包SpringBoot
mvn package，我通过IntelliIj直接打包；打包前可以mvn clean下；
