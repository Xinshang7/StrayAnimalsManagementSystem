package com.HexTechGDUT.po.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 动物状态
 * 待领养/已被领养
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AnimalStatus {

    /**
     * 已被管理人员接收，等待领养
     * 或者已经在指定地点，等待领养
     */
    STRAY("待领养"),

    /**
     * 已被领养
     */
    ADOPTED("已被领养"),

    /**
     * 走失的，下落不明的
     */
    LOST("走失"),

    /**
     * 动物（状态异常，生病）等
     * 动物不可被申请
     */
    RETAIN("不可被申请");

    private String info;
}
