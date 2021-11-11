package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 申请的类型
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApplicationType {

    /**
     * 领养
     * 领养流浪动物
     */
    ADOPT("adopt"),

    /**
     * 弃养
     * 学生毕业或者老师离职
     * 若无法将动物带离校园，可以选择弃养
     */
    ABANDON("abandon"),

    /**
     * 申请动物走失的登记
     */
    LOST("lost"),

    /**
     * 回收
     * 将流浪动物带回一个指定地方等待处理
     */
    RECALL("recall");

    private String typeStr;
}
