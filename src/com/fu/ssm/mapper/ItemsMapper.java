package com.fu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fu.ssm.po.Items;
import com.fu.ssm.po.ItemsExample;

public interface ItemsMapper {
    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);
}