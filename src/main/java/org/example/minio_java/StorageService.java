package org.example.minio_java;

import java.io.InputStream;

/**
 * @Filename: AdvancedStorageService
 * @Auther: Cloud
 * @Create: 2020 - 08 - 19
 * @Description:
 **/

public interface StorageService {

    void put(InputStream stream, String location, String fileName); // storing the uploaded to the storage

    InputStream get(String location, String fileName);

    void delete(String location, String fileName);
}
