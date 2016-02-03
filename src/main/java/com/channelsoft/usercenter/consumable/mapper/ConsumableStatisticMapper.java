package com.channelsoft.usercenter.consumable.mapper;

import com.channelsoft.usercenter.consumable.po.ConsumableStatistic;
import com.channelsoft.usercenter.consumable.po.ConsumableStatisticExample;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConsumableStatisticMapper {
    int countByExample(ConsumableStatisticExample example);

    int deleteByExample(ConsumableStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConsumableStatistic record);

    int insertSelective(ConsumableStatistic record);

    List<ConsumableStatistic> selectByExample(ConsumableStatisticExample example);

    ConsumableStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConsumableStatistic record, @Param("example") ConsumableStatisticExample example);

    int updateByExample(@Param("record") ConsumableStatistic record, @Param("example") ConsumableStatisticExample example);

    int updateByPrimaryKeySelective(ConsumableStatistic record);

    int updateByPrimaryKey(ConsumableStatistic record);
    
    public void addConsumable(ConsumableStatistic consumableStatistic);
    
    public List<ConsumableStatistic> getConsumableStatics(int entId);
    
    public BigDecimal getSumConsumableStatics(int entId);
}