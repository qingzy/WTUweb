package zyq.service.record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyq.mapper.RecordsMapper;
import zyq.mapper.UsersMapper;
import zyq.pojo.Records;

import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordsMapper rm;


    @Override
    public void insert(Records records) {
        rm.insert(records);
    }

    @Override
    public List<Records> selectRecords() {
        List<Records> records = rm.selectRecords();
        return records;
    }

    @Override
    public List<Records> selectByPrimaryKey(Integer uid) {
        List<Records> records = rm.selectByPrimaryKey(uid);
        return records;
    }

    @Override
    public void deleteByPrimaryKey(Integer rbid) {
        rm.deleteByPrimaryKey(rbid);
    }
}
