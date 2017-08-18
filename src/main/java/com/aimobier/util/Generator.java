package com.aimobier.util;

import com.aimobier.entity.FILETYPE;
import com.aimobier.entity.OdditySetObject;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Generator {


    /*
    * 配置应用的 信息 以及 ICON 等图片资源
    * */
    public static void makeAppInfoAndOtherMethod(SimpMessagingTemplate webSocket){

        // 生成 应用所需要的所有的图片文件
        makeImageMagicMethod(webSocket,"image/iconshear.sh","icon.png",PathUtil.FILEString(FILETYPE.CONFIG,"AppIcon.appiconset/"),"contentjson/icon.json");
        makeImageMagicMethod(webSocket,"image/launchshear.sh","launch.png",PathUtil.FILEString(FILETYPE.CONFIG,"LaunchImage.launchimage/"),"contentjson/launch.json");
        makeImageMagicMethod(webSocket,"image/launchstoryboard.sh","launch.png",PathUtil.FILEString(FILETYPE.CONFIG,"launch.imageset/"),"contentjson/launchStoryBoard.json");

        // 配置应用的 信息 复制粘贴的操作
        String shellFileStr = PathUtil.FILEString(FILETYPE.SHELL,"appInfoConfig.sh");

        String sourceIosProjectPath = "/Users/jingwenzheng/Desktop/OddityUI";
        String toProjectPath = PathUtil.FILEString(FILETYPE.CONFIG,"");

        String infoPath = PathUtil.FILEString(FILETYPE.CONFIG,"/info.plist");

        String iconPath = PathUtil.FILEString(FILETYPE.CONFIG,"/AppIcon.appiconset");
        String launchPath = PathUtil.FILEString(FILETYPE.CONFIG,"/LaunchImage.launchimage");
        String launchStoryBoardPath = PathUtil.FILEString(FILETYPE.CONFIG,"/launch.imageset");

        String[] shellParams = {shellFileStr,sourceIosProjectPath,toProjectPath,infoPath,iconPath,launchPath,launchStoryBoardPath};
        Shell.shell(webSocket,shellParams);
    }

    /// 创建 图片的操作
    private static void makeImageMagicMethod(SimpMessagingTemplate webSocket, String shellFilString, String SourceImageFileString, String outImagePathString, String contentJsonFileString){

        send(webSocket,"开始 "+shellFilString+" 文件的配置");
        /// 裁剪ICON
        String[] makeLaunch = { PathUtil.FILEString(FILETYPE.SHELL,shellFilString), PathUtil.FILEString(FILETYPE.UPLOAD,SourceImageFileString), outImagePathString};
        Shell.shell(webSocket,makeLaunch);
        String[] configLaunch = { "cp","-rf", PathUtil.FILEString(FILETYPE.SHELL,contentJsonFileString), outImagePathString+"/Contents.json"};
        Shell.shell(webSocket,configLaunch);

        send(webSocket,"完成 "+shellFilString+" 文件的配置");
    }

    private static void send(SimpMessagingTemplate webSocket,String message){
        if (message != null){
            webSocket.convertAndSend("/topic/greetings",message);
        }
    }


    /*
    * 配置 IOS 内容
    * */
    public static void FastLaneConfigreMethod(SimpMessagingTemplate webSocket,OdditySetObject setObject,String iconPathString){

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/copyright.txt"),setObject.getCopyright());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/primary_category.txt"),"MZGenre.News");
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/primary_first_sub_category.txt"),setObject.getCopyright());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/primary_second_sub_category.txt"),setObject.getCopyright());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/secondary_category.txt"),"MZGenre.Apps.Newsstand");
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/secondary_first_sub_category.txt"),"MZGenre.Apps.History");
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/secondary_second_sub_category.txt"),"MZGenre.Apps.Fashion_Style");

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/description.txt"),setObject.getDescription());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/keywords.txt"),setObject.getKeywords());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/marketing_url.txt"),setObject.getMarketing());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/name.txt"),setObject.getAppname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/privacy_url.txt"),setObject.getPrivacyurl());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/promotional_text.txt"),setObject.getPromotional());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/release_notes.txt"),setObject.getReleasenote());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/subtitle.txt"),setObject.getSubtitle());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/zh-Hands/getSubtitle.txt"),setObject.getSupporturl());

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/demo_password.txt"),setObject.getLoginpass());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/demo_user.txt"),setObject.getLoginname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/email_address.txt"),setObject.getEmail());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/first_name.txt"),setObject.getFirstname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/last_name.txt"),setObject.getLastname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/notes.txt"),setObject.getReviewnote());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/review_information/phone_number.txt"),setObject.getPhonenumber());

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/address_line1.txt"),setObject.getAdress());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/city_name.txt"),setObject.getCity());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/country.txt"),setObject.getCountry());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/email_address.txt"),setObject.getSwemail());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/first_name.txt"),setObject.getSwfirstname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/is_displayed_on_app_store.txt"),"false");
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/last_name.txt"),setObject.getSwlastname());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/phone_number.txt"),setObject.getSwphonenumber());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/postal_code.txt"),setObject.getPostalcode());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/state.txt"),setObject.getState());
        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/trade_representative_contact_information/trade_name.txt"),"Ying Yang ");

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/Appfile"),"app_identifier \""+setObject.getBundleidentifier()+"\" # The bundle identifier of your app\n" +
                "apple_id \""+setObject.getAppleid()+"\" # Your Apple email address\n" +
                "team_id \""+setObject.getTeamcode()+"\" # Developer Portal Team ID");

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/Deliverfile"),"app_identifier \""+setObject.getBundleidentifier()+"\" # The bundle identifier of your app\n" +
                "username \""+setObject.getAppleid()+"\" # your Apple ID user");

        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/Pluginfile"),"");

        try {
            Files.copy(new File(iconPathString).toPath(), PathUtil.FILE(FILETYPE.CONFIG,"OddityUI/fastlane/metadata/app_icon.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


        PathUtil.createFile(PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/Fastfile"),"fastlane_version \"2.53.1\"\n" +
                "default_platform :ios\n" +
                "platform :ios do\n" +
                "  before_all do\n" +
                "  end\n" +
                "\n" +
                "  # 当前任务的描述\n" +
                "    desc \"Creating a code signing certificate and provisioning profile\"\n" +
                "    # 任务名称\n" +
                "    lane :appstore do\n" +
                "      # 创建 ITC 中的 App 信息\n" +
                "      produce(\n" +
                "        app_name: '"+setObject.getAppname()+"',\n" +
                "        language: 'Simplified Chinese',\n" +
                "        app_version: '"+setObject.getVersion()+"',\n" +
                "        sku: '"+setObject.getSkuvalue()+"'\n" +
                "      )\n" +
                "      # 使用证书创建私钥及签名\n" +
                "      cert\n" +
                "      # 每次运行时创建新的配置文件\n" +
                "      sigh(force: true)\n" +
                "      # 创建 push p12 文件\n" +
                "            pem(\n" +
                "                  generate_p12: true,\n" +
                "                  development: true,\n" +
                "                  p12_password: ENV['123456789']\n" +
                "                )\n" +
                "\n" +
                "            pem(\n" +
                "                  generate_p12: true,\n" +
                "                  development: false,\n" +
                "                  p12_password: ENV['123456789']\n" +
                "                )" +
                "      # 打包\n" +
                "      gym(scheme: \"Example\",\n" +
                "          include_bitcode: true,\n" +
                "          build_path: \"Out/xcarchive/\",\n" +
                "          output_name: \"OddityOcUI\",\n" +
                "          output_directory: \"Out/outipa/\",\n" +
                "          # export_method: \"ad-hoc\"\n" +
                "          export_method: \"app-store\"\n" +
                "          )\n" +
                "      # 上传到Itunes Connection\n" +
                "      deliver(force: true)\n" +
                "    end\n" +
                "\n" +
                "\n" +
                "  desc \"Deploy a new version to the App Store\"\n" +
                "  lane :release do\n" +
                "\n" +
                "    gym(scheme: \"Example\",\n" +
                "        include_bitcode: true,\n" +
                "        build_path: \"Out/xcarchive/\",\n" +
                "        output_name: \"OddityOcUI\",\n" +
                "        output_directory: \"Out/outipa/\",\n" +
                "        # export_method: \"ad-hoc\"\n" +
                "        export_method: \"app-store\"\n" +
                "        )\n" +
                "    deliver(force: true)\n" +
                "  end\n" +
                "\n" +
                "  after_all do |lane|\n" +
                "\n" +
                "  end\n" +
                "\n" +
                "  error do |lane, exception|\n" +
                "\n" +
                "  end\n" +
                "end\n");

        String[] shellParams = {PathUtil.FILEString(FILETYPE.SHELL,"build.sh"),PathUtil.FILEString(FILETYPE.CONFIG,"OddityUI/fastlane/")};
        Shell.shell(webSocket,shellParams);

        System.out.println("打包完成 📦📦📦📦");
    }
}
