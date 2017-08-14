package com.aimobier.util;

import com.aimobier.entity.FILETYPE;

import java.io.File;

public class PathUtil {

    public static String PATH(FILETYPE type){
        switch (type){
            case ROOT:return new File("").getAbsolutePath()+"/";
            case TMP:return new File("").getAbsolutePath()+"/tmp/";
            case SHELL:return new File("").getAbsolutePath()+"/shell/";
            case CONFIG:return new File("").getAbsolutePath()+"/config/";
            case UPLOAD:return new File("").getAbsolutePath()+"/upload/";
        }
        return "";
    }

    public static File FILE(FILETYPE type,String fileName){
        return new File(PathUtil.PATH(type)+fileName);
    }

    public static String FILEString(FILETYPE type,String fileName){
        return PathUtil.FILE(type,fileName).getAbsolutePath();
    }
}
