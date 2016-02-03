package com.channelsoft.usercenter.common.service;

import java.util.List;

public interface IGenericService<Po, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insert(Po model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int update(Po model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int delete(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Po selectById(PK id);


    /**
     * 查询单个对象
     *
     * @return 对象
     */
    Po selectOne();


    /**
     * 查询多个对象
     *
     * @return 对象集合
     */
    List<Po> selectList();

}
