package org.example.minio_java;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Filename: MinIOConfig
 * @Auther: Cloud
 * @Create: 2020 - 08 - 20
 * @Description:
 **/

@Slf4j
@Configuration
@EnableConfigurationProperties(MinIOProperties.class)
public class MinIOConfig {

    private MinIOProperties minIO;

    public MinIOConfig(MinIOProperties minIO) {
        this.minIO = minIO;
    }

    @Bean
    @Conditional(MinIOAutoConfig.class)
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(minIO.getEndpoint(), minIO.getAccessKey(), minIO.getSecreteKey());
    }

    @Bean
    public StorageService storageService() throws Exception{
        String storageType = minIO.getStorageType();
        if (storageType.toLowerCase().equals("disk")) {
            return new DiskService();
        } else if (storageType.toLowerCase().equals("minio")) {
            return new MinIOService();
        } else {
            String message = "storage type config mistake... storage type not exists...";
            log.error(message);
            throw new Exception(message);
        }
    }

}
