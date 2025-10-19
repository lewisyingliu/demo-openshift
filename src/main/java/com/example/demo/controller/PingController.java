package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PingController {

    @GetMapping("/ping")
    public Map<String, Object> ping(@RequestParam String ip) {
        Map<String, Object> result = new HashMap<>();
        try {
            InetAddress inet = InetAddress.getByName(ip);
            boolean reachable = inet.isReachable(3000); // 3 seconds timeout
            result.put("ip", ip);
            result.put("reachable", reachable);
        } catch (Exception e) {
            result.put("ip", ip);
            result.put("reachable", false);
            result.put("error", e.getMessage());
        }
        return result;
    }
}
