package com.aimobier.controller;

import com.aimobier.entity.FILETYPE;
import com.aimobier.entity.OdditySetObject;
import com.aimobier.util.Generator;
import com.aimobier.util.PathUtil;
import com.aimobier.util.Shell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.validation.Valid;
import java.util.concurrent.Future;

@RestController
public class PackageController extends TextWebSocketHandler{

    @Autowired
    private SimpMessagingTemplate webSocket;

    @PostMapping(value = "/config")
    public ModelAndView handleFormUploadMethod(@Valid OdditySetObject setObject) {

        String[] clearOldFiles = { PathUtil.FILEString(FILETYPE.SHELL,"clear.sh"), PathUtil.FILEString(FILETYPE.CONFIG,"*"), PathUtil.FILEString(FILETYPE.UPLOAD,"*")};
        Shell.shell(this.webSocket,clearOldFiles);

        setObject.makeIconAndLaunch(webSocket);

        Generator.makeAppInfoAndOtherMethod(this.webSocket);

        Generator.FastLaneConfigreMethod(this.webSocket,setObject,PathUtil.FILEString(FILETYPE.UPLOAD,"icon.png"));

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/test")
    public String shellGo(){

        PathUtil.createFile("/Users/jingwenzheng/Desktop/SSTest/test.text","a\nb\nc\n小妹妹");


        return "sss";
    }
}