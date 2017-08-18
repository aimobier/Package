package com.aimobier.entity;

import com.aimobier.util.PathUtil;
import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSNumber;
import com.dd.plist.PropertyListParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class OdditySetObject {

    private String displayname;
    private String bundleidentifier;
    private String version;
    private String build;
    private String indep;

    private String umengappkey;
    private String umessageappkey;

    private String wechatappkey;
    private String wechatsecret;
    private String wechatredirecturl;

    private String sinaappkey;
    private String sinasecret;
    private String sinaredirecturl;

    private String qqappkey;
    private String qqappsecret;
    private String qqredirecturl;


    private String tintcolorno;
    private String tintcolorni;

    private String titlecolorno;
    private String titlecolorni;

    private String backcolorno;
    private String backcolorni;

    private String bordercolorno;
    private String bordercolorni;

    private String statusstyleno;
    private String statusstyleni;

    private MultipartFile icon;
    private MultipartFile launch;


    private String appleid;
    private String teamcode;
    private String appname;
    private String subtitle;
    private String marketing; // 营销地址
    private String privacyurl;
    private String supporturl;
    private String skuvalue;
    private String keywords;
    private String releasenote; // 更新说明
    private String promotional; // 宣传文本
    private String description;

    private String loginname;
    private String loginpass;
    private String lastname;
    private String firstname;
    private String phonenumber;
    private String email;
    private String reviewnote; // 审核 备注

    private String copyright;
    private String swlastname;
    private String swfirstname;
    private String country;
    private String state;
    private String city;
    private String adress;
    private String swemail;
    private String swphonenumber;
    private String postalcode;

    public String getAppleid() {
        return appleid;
    }

    public void setAppleid(String appleid) {
        this.appleid = appleid;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }

    public String getReviewnote() {
        return reviewnote;
    }

    public void setReviewnote(String reviewnote) {
        this.reviewnote = reviewnote;
    }

    public String getSupporturl() {
        return supporturl;
    }

    public void setSupporturl(String supporturl) {
        this.supporturl = supporturl;
    }

    public String getReleasenote() {
        return releasenote;
    }

    public void setReleasenote(String releasenote) {
        this.releasenote = releasenote;
    }

    public String getMarketing() {
        return marketing;
    }

    public void setMarketing(String marketing) {
        this.marketing = marketing;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrivacyurl() {
        return privacyurl;
    }

    public void setPrivacyurl(String privacyurl) {
        this.privacyurl = privacyurl;
    }

    public String getSkuvalue() {
        return skuvalue;
    }

    public void setSkuvalue(String skuvalue) {
        this.skuvalue = skuvalue;
    }

    public String getPromotional() {
        return promotional;
    }

    public void setPromotional(String promotional) {
        this.promotional = promotional;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getSwlastname() {
        return swlastname;
    }

    public void setSwlastname(String swlastname) {
        this.swlastname = swlastname;
    }

    public String getSwfirstname() {
        return swfirstname;
    }

    public void setSwfirstname(String swfirstname) {
        this.swfirstname = swfirstname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSwemail() {
        return swemail;
    }

    public void setSwemail(String swemail) {
        this.swemail = swemail;
    }

    public String getSwphonenumber() {
        return swphonenumber;
    }

    public void setSwphonenumber(String swphonenumber) {
        this.swphonenumber = swphonenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public SimpMessagingTemplate getWebSocket() {
        return webSocket;
    }

    public void setWebSocket(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    public String getIndep() {
        return indep;
    }

    public void setIndep(String indep) {
        this.indep = indep;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getBundleidentifier() {
        return bundleidentifier;
    }

    public void setBundleidentifier(String bundleidentifier) {
        this.bundleidentifier = bundleidentifier;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getUmengappkey() {
        return umengappkey;
    }

    public void setUmengappkey(String umengappkey) {
        this.umengappkey = umengappkey;
    }

    public String getUmessageappkey() {
        return umessageappkey;
    }

    public void setUmessageappkey(String umessageappkey) {
        this.umessageappkey = umessageappkey;
    }

    public String getWechatappkey() {
        return wechatappkey;
    }

    public void setWechatappkey(String wechatappkey) {
        this.wechatappkey = wechatappkey;
    }

    public String getWechatsecret() {
        return wechatsecret;
    }

    public void setWechatsecret(String wechatsecret) {
        this.wechatsecret = wechatsecret;
    }

    public String getWechatredirecturl() {
        return wechatredirecturl;
    }

    public void setWechatredirecturl(String wechatredirecturl) {
        this.wechatredirecturl = wechatredirecturl;
    }

    public String getSinaappkey() {
        return sinaappkey;
    }

    public void setSinaappkey(String sinaappkey) {
        this.sinaappkey = sinaappkey;
    }

    public String getSinasecret() {
        return sinasecret;
    }

    public void setSinasecret(String sinasecret) {
        this.sinasecret = sinasecret;
    }

    public String getSinaredirecturl() {
        return sinaredirecturl;
    }

    public void setSinaredirecturl(String sinaredirecturl) {
        this.sinaredirecturl = sinaredirecturl;
    }

    public String getQqappkey() {
        return qqappkey;
    }

    public void setQqappkey(String qqappkey) {
        this.qqappkey = qqappkey;
    }

    public String getQqappsecret() {
        return qqappsecret;
    }

    public void setQqappsecret(String qqappsecret) {
        this.qqappsecret = qqappsecret;
    }

    public String getQqredirecturl() {
        return qqredirecturl;
    }

    public void setQqredirecturl(String qqredirecturl) {
        this.qqredirecturl = qqredirecturl;
    }

    public String getTintcolorno() {
        return tintcolorno;
    }

    public void setTintcolorno(String tintcolorno) {
        this.tintcolorno = tintcolorno;
    }

    public String getTintcolorni() {
        return tintcolorni;
    }

    public void setTintcolorni(String tintcolorni) {
        this.tintcolorni = tintcolorni;
    }

    public String getTitlecolorno() {
        return titlecolorno;
    }

    public void setTitlecolorno(String titlecolorno) {
        this.titlecolorno = titlecolorno;
    }

    public String getTitlecolorni() {
        return titlecolorni;
    }

    public void setTitlecolorni(String titlecolorni) {
        this.titlecolorni = titlecolorni;
    }

    public String getBackcolorno() {
        return backcolorno;
    }

    public void setBackcolorno(String backcolorno) {
        this.backcolorno = backcolorno;
    }

    public String getBackcolorni() {
        return backcolorni;
    }

    public void setBackcolorni(String backcolorni) {
        this.backcolorni = backcolorni;
    }

    public String getBordercolorno() {
        return bordercolorno;
    }

    public void setBordercolorno(String bordercolorno) {
        this.bordercolorno = bordercolorno;
    }

    public String getBordercolorni() {
        return bordercolorni;
    }

    public void setBordercolorni(String bordercolorni) {
        this.bordercolorni = bordercolorni;
    }

    public String getStatusstyleno() {
        return statusstyleno;
    }

    public void setStatusstyleno(String statusstyleno) {
        this.statusstyleno = statusstyleno;
    }

    public String getStatusstyleni() {
        return statusstyleni;
    }

    public void setStatusstyleni(String statusstyleni) {
        this.statusstyleni = statusstyleni;
    }

    public MultipartFile getIcon() {
        return icon;
    }

    public void setIcon(MultipartFile icon) {
        this.icon = icon;
    }

    public MultipartFile getLaunch() {
        return launch;
    }

    public void setLaunch(MultipartFile launch) {
        this.launch = launch;
    }


    public NSDictionary fuseNSDictionary(NSDictionary dictionary){

        dictionary.put("CFBundleDisplayName",this.getDisplayname());
        dictionary.put("CFBundleIdentifier",this.getBundleidentifier());

        dictionary.put("CFBundleVersion",this.getBuild());
        dictionary.put("CFBundleShortVersionString",this.getVersion());


        NSArray bundleURLSchemes = new NSArray(4);
        bundleURLSchemes.setValue(0,this.urlTypeFactory("wechat",this.wechatappkey));
        bundleURLSchemes.setValue(1,this.urlTypeFactory("sina","wb"+this.sinaappkey));
        bundleURLSchemes.setValue(2,this.urlTypeFactory("tencent","tencent"+this.qqappkey));
        bundleURLSchemes.setValue(3,this.urlTypeFactory("qq","QQ"+Integer.toString(Integer.parseInt(this.qqappkey), 16)));

        dictionary.put("CFBundleURLTypes",bundleURLSchemes);


        NSDictionary jingCustom = new NSDictionary();

        jingCustom.put("UMengAppKey",this.umengappkey);
        jingCustom.put("UMessageAppKey",this.umessageappkey);

        jingCustom.put("WeChatAppKey",this.wechatappkey);
        jingCustom.put("WeChatSecret",this.wechatsecret);
        jingCustom.put("WeChatRedirecturl",this.wechatappkey);

        jingCustom.put("SinaAppKey",this.sinaappkey);
        jingCustom.put("SinaSecret",this.sinasecret);
        jingCustom.put("SinaRedirecturl",this.sinaredirecturl);

        jingCustom.put("QQAppKey",this.qqappkey);
        jingCustom.put("QQSecret",this.qqappsecret);
        jingCustom.put("QQRedirecturl",this.qqredirecturl);

        jingCustom.put("TintColorNo",this.tintcolorno);
        jingCustom.put("TintColorNi",this.tintcolorni);

        jingCustom.put("TitleColorNo",this.titlecolorno);
        jingCustom.put("TitleColorNi",this.titlecolorni);

        jingCustom.put("BackColorNo",this.backcolorno);
        jingCustom.put("BackColorNi",this.backcolorni);

        jingCustom.put("BorderColorNo",this.bordercolorno);
        jingCustom.put("BorderColorNi",this.bordercolorni);

        jingCustom.put("StatusStyleNo",this.statusstyleno != null);
        jingCustom.put("StatusStyleNi",this.statusstyleni != null);
        jingCustom.put("IndepAppMode",this.indep != null);

        dictionary.put("JCSetting",jingCustom);

        return dictionary;
    }

    private NSDictionary urlTypeFactory(String name,String url){

        NSArray bundleURLSchemes = new NSArray(1);
        bundleURLSchemes.setValue(0,url);

        NSDictionary bundleURLType = new NSDictionary();
        bundleURLType.put("CFBundleTypeRole","Editor");
        bundleURLType.put("CFBundleURLName",name);
        bundleURLType.put("CFBundleURLSchemes",bundleURLSchemes);

        return bundleURLType;
    }

    public void makeImage(IMAGETYPE type) throws Exception{

        String path = "";
        MultipartFile file = null;

        switch (type){
            case ICON:
                path = "icon";
                file = this.icon;
                break;
            case LAUNCH:
                path = "launch";
                file = this.launch;
                break;
        }

        File filePath = new File(PathUtil.FILEString(FILETYPE.UPLOAD,path+".png"));

        BufferedOutputStream stream = null;

        if (!file.isEmpty()) {

            try {

                stream = new BufferedOutputStream(new FileOutputStream(filePath));

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

    private SimpMessagingTemplate webSocket;

    public void makeIconAndLaunch(SimpMessagingTemplate webSocket) {

        this.webSocket = webSocket;

        try {

            this.makeImage(IMAGETYPE.ICON);

            send("上传 ICON 完成");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }

        try {

            this.makeImage(IMAGETYPE.LAUNCH);

            send("上传 LAUNCH 完成");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }

        try {

            NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(PathUtil.FILE(FILETYPE.ROOT,"info.plist"));

            rootDict = this.fuseNSDictionary(rootDict);

            PropertyListParser.saveAsXML(rootDict,PathUtil.FILE(FILETYPE.CONFIG,"info.plist"));

            send("配置 info.plst 文件 成功");

        } catch (Exception e) {

            send(e.getLocalizedMessage());
        }
    }


    public void send(String message){

        if (message != null){

            webSocket.convertAndSend("/topic/greetings",message);
        }
    }
}
