package com.fu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fu.ssm.po.Orderdetail;
import com.fu.ssm.po.OrderdetailExample;

public interface OrderdetailMapper {
    int countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);
}