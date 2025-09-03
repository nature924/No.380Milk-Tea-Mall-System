package com.rabbiter.em.constants;

import com.rabbiter.em.utils.PathUtils;

public class Constants {
    public static final String CODE_200 = "200";//成功
    public static final String CODE_500 = "500";//系统错误
    public static final String NO_RESULT = "510";//未找到结果
    public static final String CODE_401 = "401";//无权限
    public static final String TOKEN_ERROR = "401";//token无效
    public static final String CODE_403 = "403";//拒绝执行
    //文件存储位置
    public static final String fileFolderPath = PathUtils.getClassLoadRootPath() + "/file/";
    public static final String avatarFolderPath =  PathUtils.getClassLoadRootPath() + "/avatar/";
}
