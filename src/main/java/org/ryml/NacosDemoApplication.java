package org.ryml;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description:项目启动类
 *
 * @author 刘一博
 * @version V1.0
 * @date 2023-11-26 19:33:29
 */
@SpringBootApplication
@NacosPropertySource(dataId = "test", autoRefreshed = true)
@EnableNacosConfig(globalProperties = @NacosProperties(namespace = "5dd71f31-4e21-4ef3-8bb1-aff259f208ef", serverAddr = "127.0.0.1:8848"))
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }
}