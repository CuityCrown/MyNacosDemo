package org.ryml.service.impl;

import lombok.Data;
import org.apache.dubbo.config.annotation.DubboService;
import org.ryml.config.NacosConfig;
import org.ryml.service.NacosService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2023/11/26 21:39
 */
@DubboService
@Data
public class NacosServiceImpl implements NacosService {

    @Autowired
    private NacosConfig nacosConfig;

}
