package com.sunny.common.constant;

/**
 * 定义常见的常量
 *
 * @author chenye
 */
public class RegexpConst {

    /**
     * 国内电话 正则表达式
     */
    public static final String PHONE = "\\d{3}-\\d{8}|\\d{4}-\\{7,8}";
    /**
     * 邮箱 正则表达式
     */
    public static final String MAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    /**
     * 密码正则表达式 密码由数字和字母混合组成，6到20位
     */
    public static final String PASSWD_REGEXP = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";

    /**
     * 至少8-16个字符，至少1个大写字母，1个小写字母和1个数字，其他可以是任意字符
     */
    public static final String PASSWORD = " /^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[^]{8,16}$/";
    /**
     * 中文 正则表达式
     */
    public static final String CHINESE_REGEXP = "[\\u4e00-\\u9fa5]";

    /**
     * 手机号码正则表达式,如果开放其他号段，在次修改
     * (\\+\\d+)?1[34578]\\d{9}$
     */
    public static final String MOBILE_REGEXP = "(\\+\\d+)?1\\d{10}$";

}
