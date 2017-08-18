package com.aimobier.util;

import com.aimobier.entity.FILETYPE;

import java.io.*;

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

    /**
     * 创建文件
     * @param fileFullPathString  文件名称
     * @param fileContent   文件内容
     * @return  是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileFullPathString,String fileContent){
        Boolean bool = false;
        File file = new File(fileFullPathString);
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
                bool = true;
            }
            PrintWriter writer = new PrintWriter(fileFullPathString, "UTF-8");
            writer.println(fileContent);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }
}
