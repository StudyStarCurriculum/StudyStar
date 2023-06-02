package com.curriculum.studystar.Config;

public enum RespCode {
    OK, // 请求完成
    ParamInvalid, // 参数不合法
    UserNotExisted, // 登录时用户不存在
    WrongPassword, // 密码错误
    UserHasExisted, //注册时用户已存在
    LoginRequeried, //未登录
}
