package com.book_apis.bookdemo.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "/home/coral/Downloads/bookdemo/src/main/resources/static/image";

    public boolean uploadfile(MultipartFile multipartFile) {
        boolean f = false;

        try {

            // input stram in first argument second parameter is path file name and 3 rd is
            // file separation
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(StandardCopyOption.REPLACE_EXISTING+"SURAJ CHAURASIYA");
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;

    }

}
