package com.moontwon.demo.springboot.controller;

import com.google.common.collect.Maps;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 18-3-17
 */
@Controller
public class RootController {
    @RequestMapping({"/", ""})
    @ResponseBody
    public String index() {
        return "Hello";
    }

    @RequestMapping("/form")
    @ResponseBody
    public String form(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        Map<String, String> map = Maps.newHashMap();
        for (Iterator<String> iterator = params.keySet().iterator(); iterator.hasNext(); ) {
            String name = iterator.next();
            String[] values = params.get(name);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                stringBuilder.append(values[0]).append(",");
            }
            String value = StringUtils.substring(stringBuilder.toString(),0,-1);
            map.put(name, value);
        }
        String string = Json.encode(map);
        System.err.println(string);
        return string;
    }
}
