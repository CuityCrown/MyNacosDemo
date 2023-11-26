package org.ryml.service;

import lombok.Data;
import org.ryml.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2023/11/26 21:39
 */
@Service
@Data
public class NacosService {

    @Autowired
    private NacosConfig nacosConfig;

}
