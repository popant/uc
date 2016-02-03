package com.channelsoft.usercenter.consumable.mapper;

import com.channelsoft.usercenter.consumable.po.ConsumableOrder;
import com.channelsoft.usercenter.consumable.po.ConsumableOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsumableOrderMapper {
    int countByExample(ConsumableOrderExample example);

    int deleteByExample(ConsumableOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(ConsumableOrder record);

    int insertSelective(ConsumableOrder record);

    List<ConsumableOrder> selectByExample(ConsumableOrderExample example);

    ConsumableOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") ConsumableOrder record, @Param("example") ConsumableOrderExample example);

    int updateByExample(@Param("record") ConsumableOrder record, @Param("example") ConsumableOrderExample example);

    int updateByPrimaryKeySelective(ConsumableOrder record);

    int updateByPrimaryKey(ConsumableOrder record);
    
    public int getInsertPK();
    
    public void deleteOrderOutTime();
}