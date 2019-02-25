package com.ordinaryyzh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;

/**
 * @author OrdinaryYZH
 * @date 2018/8/5 15:24
 */
@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("test")
    public String test() {
        ((FlashMap) ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE)).put("name", "张三");
        return "";
    }

}
