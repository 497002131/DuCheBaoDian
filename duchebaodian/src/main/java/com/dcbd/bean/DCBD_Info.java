package com.dcbd.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 堵车宝典当前登录的用户信息
 */
public class DCBD_Info {

    private static SharedPreferences dcbdInformation;
    private static Editor editor;
    public DCBD_Info(Context context) {
        dcbdInformation = context.getSharedPreferences("dcbdInformation",
                Context.MODE_PRIVATE);
        editor = dcbdInformation.edit();
    }

    /**
     * 用户ID
     */
    private static String userId;

    /**
     * 登陆账号
     */
    private static String loginName;

    /**
     * 登陆密码
     */
    private static String loginPassword;


    /**
     * 用户头像
     */
    private static String userAvatar;

    /**
     * 当前用户姓名
     */
    private static String userName;

    public static String getUserId() {
        return dcbdInformation.getString("userId","");
    }

    public static void setUserId(String userId) {
        editor.putString("userId", userId).commit();
    }

    public static String getLoginName() {
        return dcbdInformation.getString("loginName","");
    }

    public static void setLoginName(String loginName) {
        editor.putString("loginName", loginName).commit();
    }

    public static String getLoginPassword() {
        return dcbdInformation.getString("loginPassword","");
    }

    public static void setLoginPassword(String loginPassword) {
        editor.putString("loginPassword", loginPassword).commit();
    }

    public static String getUserAvatar() {
        return dcbdInformation.getString("userAvatar","");
    }

    public static void setUserAvatar(String userAvatar) {
        editor.putString("userAvatar", userAvatar).commit();
    }

    public static String getUserName() {
        return dcbdInformation.getString("userName","");
    }

    public static void setUserName(String userName) {
        editor.putString("userName", userName).commit();
    }
}