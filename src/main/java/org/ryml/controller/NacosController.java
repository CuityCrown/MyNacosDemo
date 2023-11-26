package org.ryml.controller;

import com.alibaba.fastjson.JSONObject;
import org.ryml.service.NacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2023/11/26 21:52
 */
@Controller
public class NacosController {

    @Autowired
    private NacosService nacosService;

    @RequestMapping("/testNacoseService")
    @ResponseBody
    public String testNacoseService() {
        return JSONObject.toJSONString(nacosService);
    }


}
