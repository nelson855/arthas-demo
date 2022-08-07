package demos.arthas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author nelson
 * @description
 * @date 2022-08-06 4:23 下午
 */
@Controller
@RequestMapping("/inner")
public class InnerController {

    @RequestMapping("/health-check")
    @ResponseBody
    public String healthCheck() {
        return "SUCCESS !";
    }
}
