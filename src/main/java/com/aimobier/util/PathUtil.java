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

    public final static String SHELL_EXAMPLE_PATH(){

        return new File("").getAbsolutePath()+"/shell/";
    }
}
