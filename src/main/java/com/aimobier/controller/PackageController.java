package com.aimobier.controller;

import com.aimobier.entity.FILETYPE;
import com.aimobier.entity.OdditySetObject;
import com.aimobier.util.PathUtil;
import com.aimobier.util.Shell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
public class PackageController extends TextWebSocketHandler{

    @Autowired
    private SimpMessagingTemplate webSocket;
    private Future<?> taskFuture = null;

    @PostMapping(value = "/config")
    public ModelAndView handleFormUploadMethod(@Valid OdditySetObject setObject, BindingResult result, HttpServletResponse response) {


        String[] clearOldFiles = { PathUtil.FILEString(FILETYPE.SHELL,"clear.sh"), PathUtil.FILEString(FILETYPE.CONFIG,"*"), PathUtil.FILEString(FILETYPE.UPLOAD,"*")};
        Shell.shell(this.webSocket,clearOldFiles);

        setObject.makeIconAndLaunch(webSocket);

        send("开始 ICON 文件的配置");
        /// 裁剪ICON
        String[] makeICON = { PathUtil.FILEString(FILETYPE.SHELL,"iconshear.sh"), PathUtil.FILEString(FILETYPE.UPLOAD,"icon.png"), PathUtil.FILEString(FILETYPE.CONFIG,"AppIcon.appiconset/")};
        Shell.shell(this.webSocket,makeICON);
        String[] configICON = { "cp","-rf", PathUtil.FILEString(FILETYPE.SHELL,"icon/Contents.json"), PathUtil.FILEString(FILETYPE.CONFIG,"AppIcon.appiconset/")};
        Shell.shell(this.webSocket,configICON);
        send("完成 ICON 文件的配置");


        send("开始 LAUNCH 文件的配置");
        /// 裁剪ICON
        String[] makeLaunch = { PathUtil.FILEString(FILETYPE.SHELL,"launchshear.sh"), PathUtil.FILEString(FILETYPE.UPLOAD,"launch.png"), PathUtil.FILEString(FILETYPE.CONFIG,"LaunchImage.launchimage/")};
        Shell.shell(this.webSocket,makeLaunch);
        String[] configLaunch = { "cp","-rf", PathUtil.FILEString(FILETYPE.SHELL,"launch/Contents.json"), PathUtil.FILEString(FILETYPE.CONFIG,"LaunchImage.launchimage/")};
        Shell.shell(this.webSocket,configLaunch);
        send("完成 LAUNCH 文件的配置");

//        new Thread(() -> {
//
//
//
//        }).start();


        return new ModelAndView("redirect:/");
    }

    public void send(String message){

        if (message != null){

            webSocket.convertAndSend("/topic/greetings",message);
        }
    }

}