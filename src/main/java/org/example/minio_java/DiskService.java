package org.example.minio_java;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

/**
 * @Filename: DiskService
 * @Auther: Cloud
 * @Create: 2020 - 08 - 19
 * @Description:
 **/
@Slf4j
public class DiskService implements StorageService {

    public void put(InputStream stream, String location, String fileName) {
    }

    /**
     * @param location the location of file, need not end with file separator
     * @param fileName the file name saved in the storage
     **/
    public InputStream get(String location, String fileName) {
        try {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.error("error with file...");
        return null;
    }

    /**
     * @param location the location of file, need not end with file separator
     * @param fileName the file name saved in the storage
     **/
    public void delete(String location, String fileName) {
    }
}
