package org.example.minio_java;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Filename: MinIOProperties
 * @Auther: Cloud
 * @Create: 2020 - 08 - 19
 * @Description:
 **/

@Data
@ConfigurationProperties(prefix = "min.io")
public class MinIOProperties {

    private String endpoint;

    private String accessKey;

    private String secreteKey;

    @Value("${my.storagetype}")
    private String storageType;
}
