package zyq.service.book;

import org.apache.ibatis.annotations.Param;
import zyq.pojo.Books;
import zyq.pojo.Users;

import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
public interface BookService {
    public List<Books> selectBooks();

    public int updateBookNum(Integer bid, Integer bnum);

    int huanshu(Integer bid);

    List<Books> selectBookByTjlike(String bauthor, String bname);

    List<Books> selectBookByTjlikePage(String bname, String bauthor, Integer pageNum, Integer pageSize);

   }
