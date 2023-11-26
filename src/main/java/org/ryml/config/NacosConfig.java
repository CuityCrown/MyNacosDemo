package org.ryml.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2023/11/26 22:08
 */
@Data
@Component
public class NacosConfig {

    @Value("${name}")
    private String name;

    @Value("${passward}")
    private String passward;

    @Value("${age}")
    private Integer age;


}
