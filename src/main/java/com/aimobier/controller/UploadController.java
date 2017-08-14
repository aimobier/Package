package com.aimobier.controller;

import com.aimobier.util.PathUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class UploadController {


    @PostMapping(value = "/upload/{path}")
    @ResponseBody
    public void handleFileUpload(HttpServletRequest request, @PathVariable String path) {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");

        MultipartFile file = null;

        BufferedOutputStream stream = null;

        for (int i = 0; i < files.size(); ++i) {

            file = files.get(i);

            if (!file.isEmpty()) {

                try {

                    File cFile = new File(PathUtil.UPLOAD_FILE_PATH(path)+file.getOriginalFilename());

                    stream = new BufferedOutputStream(new FileOutputStream(cFile));

                    byte[] bytes = file.getBytes();

                    stream.write(bytes,0,bytes.length);

                } catch (Exception e) {

                    e.printStackTrace();
                } finally {

                    try {

                        if (stream != null) {

                            stream.close();
                        }

                    } catch (IOException e) {

                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
