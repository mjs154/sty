package com.mjs.study.entity.mapper;

import com.mjs.study.entity.pojo.RefundInfo;
import com.mjs.study.entity.pojo.RefundInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundInfoMapper {
    int countByExample(RefundInfoExample example);

    int deleteByExample(RefundInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundInfo record);

    int insertSelective(RefundInfo record);

    List<RefundInfo> selectByExample(RefundInfoExample example);

    RefundInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundInfo record, @Param("example") RefundInfoExample example);

    int updateByExample(@Param("record") RefundInfo record, @Param("example") RefundInfoExample example);

    int updateByPrimaryKeySelective(RefundInfo record);

    int updateByPrimaryKey(RefundInfo record);
}