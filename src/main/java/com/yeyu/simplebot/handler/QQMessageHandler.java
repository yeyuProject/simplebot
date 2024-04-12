package com.yeyu.simplebot.handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.yeyu.simplebot.domain.MessageEvent;
import com.yeyu.simplebot.domain.Server2ClientMessage;
import com.yeyu.simplebot.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class QQMessageHandler {

    public static void handleQQMessage(String message) {
        try {
            log.info("接收到QQ消息：{}", message);
            JSONObject jsonObject = JSONObject.parseObject(message);
            String action = jsonObject.getString("post_type");
            if ("message".equals(action)) {
                MessageEvent messageEvent = JSONObject.parseObject(message, MessageEvent.class);
                Server2ClientMessage<Map> server2ClientMessage = new Server2ClientMessage();
                server2ClientMessage.setAction("send_private_msg");
                Map<String, Object> params = new HashMap<>();
                server2ClientMessage.setParams(params);
                params.put("user_id", messageEvent.getUser_id());
//                params.put("message", "hello nihao!");
                Map<String,Object> qqmassage = new HashMap<>();
                qqmassage.put("type","image");

                Map<String,String> filedata = new HashMap<>();
                filedata.put("file","https://pica.zhimg.com/80/v2-5f4f1f410540fd7b2a9a34af8c31829c_720w.webp?source=1def8aca");
                qqmassage.put("data",filedata);
                params.put("message", qqmassage);
                server2ClientMessage.setEcho("123456");
                String jsonString = JSON.toJSONString(server2ClientMessage);
                log.info("发送消息：{}", jsonString);
                WebSocketServer.sendToAll(jsonString);
            }
        } catch (Exception e) {
            log.error("解析QQ消息失败，消息内容：{}", message);
            log.error("解析QQ消息失败，异常信息：", e);
            return;
        }
    }
}
