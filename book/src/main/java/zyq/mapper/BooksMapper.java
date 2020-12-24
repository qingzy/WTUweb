package zyq.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zyq.pojo.Books;
import zyq.pojo.BooksExample;

public interface BooksMapper {
    long countByExample(BooksExample example);

    int deleteByExample(BooksExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Books record);

    int insertSelective(Books record);

    List<Books> selectBooks();

    Books selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByExample(@Param("record") Books record, @Param("example") BooksExample example);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);

    int updateBookNum(@Param("bid")Integer bid, @Param("bnum")Integer bnum);

    int huanshu(Integer bid);



    List<Books> selectBookByTjlike(@Param("bauthor") String bauthor, @Param("bname") String bname);


    List<Books> selectBookByTjlikePage(@Param("bname")String bname, @Param("bauthor")String bauthor, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);
}