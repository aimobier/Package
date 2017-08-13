package com.aimobier.controller;

import com.aimobier.entity.OdditySetObject;
import com.aimobier.util.PathUtil;
import com.dd.plist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@RestController
public class PackageController extends TextWebSocketHandler{


    @Autowired
    private SimpMessagingTemplate webSocket;

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



    @GetMapping("/make")
    @ResponseBody
    String Make(){

        try {
            //Creating the root object
            NSDictionary root = new NSDictionary();

            NSArray people = new NSArray(2);

            NSDictionary person1 = new NSDictionary();

            person1.put("Name", "Peter");

            Calendar cal = Calendar.getInstance();
            cal.set(2011, 1, 13, 9, 28);
            person1.put("RegistrationDate", cal.getTime()); //This will become a NSDate
            person1.put("Age", 23); //This will become a NSNumber
//            person1.put("Photo", new NSData(new File("peter.jpg")));

            NSDictionary person2 = new NSDictionary();
            person2.put("Name", "Lisa");
            person2.put("Age", 42);
            person2.put("RegistrationDate", new NSDate("2010-09-23T12:32:42Z"));
//            person2.put("Photo", new NSData(new File("lisa.jpg")));

            people.setValue(0, person1);
            people.setValue(1, person2);

            root.put("People", people);

            PropertyListParser.saveAsXML(root, new File("/Users/jingwenzheng/Desktop/people.plist"));

        } catch (IOException e) {

            e.printStackTrace();
        } catch (ParseException e) {

            e.printStackTrace();
        }


        return "ssss??";

    }


}