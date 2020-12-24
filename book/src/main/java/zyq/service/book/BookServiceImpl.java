package zyq.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zyq.mapper.BooksMapper;
import zyq.mapper.UsersMapper;
import zyq.pojo.Books;
import zyq.pojo.Users;

import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksMapper bm;

    @Override
    public List<Books> selectBooks() {
        List<Books> books = bm.selectBooks();
        return books;
    }

    @Override
    public int updateBookNum(Integer bid, Integer bnum) {
        int rows = bm.updateBookNum(bid, bnum);
        return rows;
    }

    @Override
    public int huanshu(Integer bid) {
        int rows = bm.huanshu(bid);
        return rows;
    }

    @Override
    public List<Books> selectBookByTjlike(String bauthor, String bname) {
        List<Books> books = bm.selectBookByTjlike(bauthor, bname);
        return books;
    }

    @Override
    public List<Books> selectBookByTjlikePage(String bname, String bauthor, Integer pageNum, Integer pageSize) {
        List<Books> books = bm.selectBookByTjlikePage(bname, bauthor,pageNum,pageSize);
        return books;
    }
}
