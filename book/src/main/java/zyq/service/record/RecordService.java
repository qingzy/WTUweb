package zyq.service.record;

import zyq.pojo.Books;
import zyq.pojo.Records;

import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
public interface RecordService {
    void insert(Records records);

    List<Records> selectRecords();

    List<Records> selectByPrimaryKey(Integer uid);

    void deleteByPrimaryKey(Integer rbid);
}
