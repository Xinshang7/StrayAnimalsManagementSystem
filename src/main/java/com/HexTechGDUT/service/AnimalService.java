package com.HexTechGDUT.service;

import com.HexTechGDUT.po.animal.AnimalRecord;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface AnimalService {

    /**
     * 动物登记;
     * @param animal 要登记的动物
     * @return 是否登记成功
     */
     boolean register(AnimalRecord animal);

    /**
     * 动物信息更新;
     * @param animal 要更新信息的动物
     * @return 是否更新成功
     */
    boolean update(AnimalRecord animal);

    /**
     * 通过动物id查询动物;
     * @param animalId animalId
     * @return animal
     */
    AnimalRecord queryAnimalByAnimalId(String animalId);

    /**
     * 通过上传者id查询动物list;
     * @param uid userId
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByUid(String uid);

    /**
     * 根据动物状态查询动物list;
     * @param status String -> AnimalStatus
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByStatus(String status);

    /**
     * 根据地区查询动物list;
     * @param zone String -> Zone
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByZone(String zone);
}
