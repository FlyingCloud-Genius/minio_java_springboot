package org.example.minio_java;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;

import java.io.InputStream;

/**
 * @Filename: MinIOService
 * @Auther: Cloud
 * @Create: 2020 - 08 - 19
 * @Description:
 **/

@Slf4j
@Conditional(value = MinIOAutoConfig.class)
public class MinIOService implements StorageService {

    @Autowired
    private MinioClient minioClient;

    /**
     * @param stream input to the object
     * @param fileName the object name in the bucket
     * @param location bucket name
     **/
    public void put(InputStream stream, String location, String fileName) {
        if (!bucketExists(location)) {
            makeBucket(location);
        }
        try {
            PutObjectOptions options = new PutObjectOptions(stream.available(), -1);
            minioClient.putObject(location, fileName, stream, options);
        } catch (Exception e) {
            log.error("failed in putting object into OSS...");
            e.printStackTrace();
        }
    }

    public InputStream get(String location, String fileName) {
        if (!bucketExists(location))
        try {
            return minioClient.getObject(location, fileName);
        } catch (Exception e) {
            log.error("error in getting object from minio...");
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String location, String fileName) {
        try {
            minioClient.removeObject(location, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean bucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void makeBucket(String bucketName) {
        boolean existed = bucketExists(bucketName);
        if (!existed) {
            try {
                minioClient.makeBucket(bucketName);
            } catch (Exception e) {
                log.error("error in building bucket...");
                e.printStackTrace();
            }
        }
    }

}
