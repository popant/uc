package com.channelsoft.usercenter.consumable.mapper;

import com.channelsoft.usercenter.consumable.po.ConsumableSubOrder;
import com.channelsoft.usercenter.consumable.po.ConsumableSubOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumableSubOrderMapper {
    int countByExample(ConsumableSubOrderExample example);

    int deleteByExample(ConsumableSubOrderExample example);

    int deleteByPrimaryKey(Integer subOrderId);

    int insert(ConsumableSubOrder record);

    int insertSelective(ConsumableSubOrder record);

    List<ConsumableSubOrder> selectByExample(ConsumableSubOrderExample example);

    ConsumableSubOrder selectByPrimaryKey(Integer subOrderId);

    int updateByExampleSelective(@Param("record") ConsumableSubOrder record, @Param("example") ConsumableSubOrderExample example);

    int updateByExample(@Param("record") ConsumableSubOrder record, @Param("example") ConsumableSubOrderExample example);

    int updateByPrimaryKeySelective(ConsumableSubOrder record);

    int updateByPrimaryKey(ConsumableSubOrder record);
}