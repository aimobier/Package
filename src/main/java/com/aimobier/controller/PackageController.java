package com.aimobier.controller;

import com.aimobier.entity.FILETYPE;
import com.aimobier.entity.IMAGETYPE;
import com.aimobier.entity.OdditySetObject;
import com.aimobier.util.PathUtil;
import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.xml.sax.SAXException;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.ParseException;

@RestController
public class PackageController extends TextWebSocketHandler{

    @Autowired
    private SimpMessagingTemplate webSocket;

    @PostMapping(value = "/config")
    @ResponseBody
    public String handleFormUploadMethod(@Valid OdditySetObject setObject,BindingResult result) {

        /// 清空以前的 文件
        String[] clearOldFiles = { PathUtil.FILEString(FILETYPE.SHELL,"clear.sh"), PathUtil.FILEString(FILETYPE.CONFIG,"*"), PathUtil.FILEString(FILETYPE.UPLOAD,"*")};
        sehll(clearOldFiles);

        /// 上传 ICON 和 LAUNCH
        this.makeIconAndLaunch(setObject);

        /// 裁剪ICON
        String[] makeICON = { PathUtil.FILEString(FILETYPE.SHELL,"iconshear.sh"), PathUtil.FILEString(FILETYPE.UPLOAD,"icon.png"), PathUtil.FILEString(FILETYPE.CONFIG,"AppIcon.appiconset/")};
        sehll(makeICON);

        /// 复制 ICON 配置文件
        String[] configICON = { "cp","-rf", PathUtil.FILEString(FILETYPE.SHELL,"icon/Contents.json"), PathUtil.FILEString(FILETYPE.CONFIG,"AppIcon.appiconset/")};
        sehll(configICON);

        return setObject.getStatusstyleni()+"---"+setObject.getStatusstyleno()+"--"+setObject.getIcon().getSize();
    }


    public void send(String message){

        webSocket.convertAndSend("/topic/greetings",message);
    }

    public void sehll(String[] command){

        try {

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;

            while ((s = reader.readLine()) != null) {

                send(s);
            }
        } catch (IOException e) {

            send(e.getLocalizedMessage());
        }
    }

    public void makeIconAndLaunch(OdditySetObject setObject) {

        try {

            setObject.makeImage(IMAGETYPE.ICON);

            send("上传 ICON 完成");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }

        try {

            setObject.makeImage(IMAGETYPE.LAUNCH);

            send("上传 LAUNCH 完成");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }

        try {

            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(PathUtil.FILE(FILETYPE.ROOT,"info.plist"));

            rootDict = setObject.fuseNSDictionary(rootDict);

            PropertyListParser.saveAsXML(rootDict,PathUtil.FILE(FILETYPE.CONFIG,"info.plist"));

            send("配置 info.plst 文件 成功");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }
    }
}