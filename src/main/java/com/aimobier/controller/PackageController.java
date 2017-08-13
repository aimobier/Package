package com.aimobier.controller;

import com.aimobier.Application;
import com.aimobier.entity.OdditySetObject;
import com.aimobier.util.PathUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PackageController {

    @PostMapping(value = "/upload/{path}")
    @ResponseBody
    public void handleFileUpload(HttpServletRequest request,@PathVariable String path) {

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

    @PostMapping(value = "/config")
    @ResponseBody
    public String handleFormUploadMethod(OdditySetObject setObject) {

        System.out.println(setObject);

        return "测试";
    }

    @GetMapping("/send/{message}")
    @ResponseBody
    public String SendMessage(@PathVariable String message){


        try {
            String[] command = { "./myscript", "key", "ls -t | tail -n 1" };

            Process process = Runtime.getRuntime().exec("ls");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;

            while ((s = reader.readLine()) != null) {

                webSocket.convertAndSend("/topic/greetings",s);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return message;
    }



}