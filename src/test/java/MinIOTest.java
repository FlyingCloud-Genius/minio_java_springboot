import org.example.minio_java.StorageService;
import org.example.minio_java.SystemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Filename: MinIOTest
 * @Auther: Cloud
 * @Create: 2020 - 08 - 20
 * @Description:
 **/

@SpringBootTest(classes = SystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MinIOTest {

    @Autowired
    private StorageService storageService;

    @Test
    public void minioPut() {
        String path = "C:\\Users\\Cloud\\Desktop";
        String fileName = "settings.xml";
        File file = new File(path + File.separator + fileName);
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            storageService.put(inputStream, "test", fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void minioGet() {

    }
}
