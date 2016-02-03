package com.channelsoft.usercenter.common.mapper;

public interface IGenericMapper<Po, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Po model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Po model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Po selectByPrimaryKey(PK id);

}
