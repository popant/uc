package com.channelsoft.usercenter.consumable.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.usercenter.consumable.po.Consumable;
import com.channelsoft.usercenter.consumable.po.ConsumableExample;

public interface ConsumableMapper {
    int countByExample(ConsumableExample example);

    int deleteByExample(ConsumableExample example);

    int deleteByPrimaryKey(Integer consumableId);

    int insert(Consumable record);

    int insertSelective(Consumable record);

    List<Consumable> selectByExample(ConsumableExample example);

    Consumable selectByPrimaryKey(Integer consumableId);

    int updateByExampleSelective(@Param("record") Consumable record, @Param("example") ConsumableExample example);

    int updateByExample(@Param("record") Consumable record, @Param("example") ConsumableExample example);

    int updateByPrimaryKeySelective(Consumable record);

    int updateByPrimaryKey(Consumable record);
    
    public List<Consumable> queryConsumables(int productId);
}