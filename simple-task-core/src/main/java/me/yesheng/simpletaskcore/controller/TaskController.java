package me.yesheng.simpletaskcore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chenys
 */
@RestController
public class TaskController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    @ResponseBody
    public String config(@RequestParam(value = "key", defaultValue = "all") String key) {
        return "hi " + key + ", i am from port: " + port;
    }
}
