package main.controller;

import main.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HiController {

    @Autowired
    private HiService hiService;

    @ResponseBody
    @RequestMapping("/hi")
    public String hi() {
        return hiService.hi();
    }

}
