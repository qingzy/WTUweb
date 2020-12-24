package zyq.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyq.pojo.Records;
import zyq.pojo.RecordsExample;

public interface RecordsMapper {
    long countByExample(RecordsExample example);

    int deleteByExample(RecordsExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Records record);

    int insertSelective(Records record);

    List<Records> selectByExample(RecordsExample example);

    List<Records> selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Records record, @Param("example") RecordsExample example);

    int updateByExample(@Param("record") Records record, @Param("example") RecordsExample example);

    int updateByPrimaryKeySelective(Records record);

    int updateByPrimaryKey(Records record);

    List<Records> selectRecords();
}