package com.tiant.springboot;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {


    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/send")
    public void sendMsg() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "luoqinzhong");

        String tojsono = JSONObject.toJSONString(map);

        amqpTemplate.convertAndSend("name" + UUID.randomUUID().toString(), tojsono);
    }

}
