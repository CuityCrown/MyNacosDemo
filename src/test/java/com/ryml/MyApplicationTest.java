package com.ryml;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ryml.NacosDemoApplication;
import org.ryml.service.NacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2019/6/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NacosDemoApplication.class)
public class MyApplicationTest {

    /**
     * description:
     *
     * @author yibo.liu
     * @date 2023/11/26 21:42
     * @Param
     * @Return
     */
    @Autowired
    private NacosService nacosService;

    /**
     * description:测试配置获取
     *
     * @author yibo.liu
     * @date 2023/11/26 21:27
     * @Param
     * @Return
     */
    @Test
    public void testProperties() {
        try {
            String serverAddr = "localhost:8848";
            String dataId = "Test";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("namespace", "5dd71f31-4e21-4ef3-8bb1-aff259f208ef");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }


    /**
     * description:测试监听器机制
     *
     * @author yibo.liu
     * @date 2023/11/26 21:28
     * @Param
     * @Return
     */
    @Test
    public void testListener() {
        try {
            String serverAddr = "localhost:8848";
            String dataId = "Test";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            properties.put("namespace", "5dd71f31-4e21-4ef3-8bb1-aff259f208ef");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("recieve1:" + configInfo);
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });

            // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出。 正式代码中无需下面代码
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }


    /**
     * description:spring-boot集成nacos
     *
     * @author yibo.liu
     * @date 2023/11/26 21:35
     * @Param
     * @Return
     */
    @Test
    public void test() {
        System.out.println(JSONObject.toJSONString(nacosService));
    }

}

