package org.ryml;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
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
@EnableDubbo
public class NacosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDemoApplication.class, args);
    }


}