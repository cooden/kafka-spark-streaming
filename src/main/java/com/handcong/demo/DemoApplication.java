package com.handcong.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    //consumer接收消息
    @KafkaListener(topics = "result")
    public void onMessage(String message) throws Exception {
        int typeA = 0, typeB = 0;
        JSONArray jsonArray = JSON.parseArray(message);
        JSONObject jsonObject;
        for (int i = 0; i < 3; i++) {
            jsonObject = JSON.parseObject(jsonArray.get(i).toString());
            if (jsonObject.containsKey("0"))
                typeA = jsonObject.getIntValue("0");
            else if (jsonObject.containsKey("1"))
                typeB = jsonObject.getIntValue("1");
        }
        String res = typeA + "," + typeB;
        System.out.println(res);
        //socketio.emit('test_message', {'data':result})
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        socket.getOutputStream().write(res.getBytes());
        socket.getOutputStream().flush();
    }

    //创建socket
//    Configuration config = new Configuration();
//    config.setHostname("localHost");
//    config.setPort();
//    config.setUpgradeTimeout(10000);
//    config.setPingTimeout(180000);
//    config.setPingInterval(60000);

//    final SocketIOServer server = new SocketIOServer(config);
//    server.addConnectListener();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}


