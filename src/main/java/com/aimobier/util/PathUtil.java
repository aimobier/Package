package com.aimobier.util;

import java.io.File;

public class PathUtil {

    public final static String UPLOAD_TMP_FILE_PATH(){
        return new File("").getAbsolutePath()+"/tmp/";
    }

    public final static String UPLOAD_FILE_PATH(String path){

        String filePathStr = new File("").getAbsolutePath()+"/upload/"+path+"/";
        File file =new File(filePathStr);
        if  (!file .exists()  && !file .isDirectory()){
            file .mkdir();
        }

        return filePathStr;
    }




    public final static String RootPathString(){

        return new File("").getAbsolutePath();
    }


    /// 老的 配置文件
    public final static File OLD_INFO_PLIST_FILE(){

        return new File(PathUtil.RootPathString()+"/info.plist");
    }

    /// 新的配置文件
    public final static File NEW_INFO_PLIST_FILE(){

        return new File(PathUtil.RootPathString()+"/config/info.plist");
    }


    /// Sehll 文件 执行命令字符串
    public final static String SHELL_FILE_PATH_STRING(String fileName){

        return PathUtil.RootPathString()+"/shell/"+fileName;
    }

    /// 配置文件夹
    public final static String CLEAR_CONFIG_PATH_STRING(){

        return PathUtil.RootPathString()+"/config/*";
    }

    /// 上传文件夹
    public final static String CLEAR_UPLOAD_PATH_STRING(){

        return PathUtil.RootPathString()+"/upload/*";
    }
}
