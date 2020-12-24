package zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zyq.pojo.Books;
import zyq.pojo.Users;
import zyq.service.book.BookService;
import zyq.service.user.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bs;

    @Autowired
    private UserService us;

    //查询所有的书籍信息
    @RequestMapping(value="list",method= RequestMethod.GET)
    public String list(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){

            List<Books> books = bs.selectBooks();
            Users user = us.selectByPrimaryKey(uid);
            model.addAttribute("user",user);
            model.addAttribute("books",books);
            return "list";


    }


    //查询所有的书籍信息
    @RequestMapping("/bookList")
    public String bookList(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            @RequestParam(value = "bauthor",defaultValue = "")String bauthor,
            @RequestParam(value = "bname",defaultValue = "")String bname,
            @RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum,
            Model model
    ){
        int pageSize=5;
        int size = bs.selectBookByTjlike(bauthor, bname).size();
        int total = size%pageSize==0?size/pageSize:size/pageSize+1;
        List<Books> books = bs.selectBookByTjlikePage(bname, bauthor, pageNum, pageSize);

        Users user = us.selectByPrimaryKey(uid);
        model.addAttribute("user",user);
        model.addAttribute("books",books);

        model.addAttribute("pageNum",pageNum);
        model.addAttribute("total",total);

        model.addAttribute("bauthor",bauthor);
        model.addAttribute("bname",bname);
        return "list";


    }

    //用户点击借书时对应书籍数目减一
    @RequestMapping(value="jieshu",method= RequestMethod.GET)
    public String jieshu(
            @RequestParam(value = "bid",defaultValue = "")Integer bid,
            @RequestParam(value = "bnum",defaultValue = "")Integer bnum,
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){

            bnum--;
            bs.updateBookNum(bid, bnum);
            model.addAttribute("uid",uid);
            model.addAttribute("bid",bid);
            return "redirect:addRecord.do";


    }

    //用户点击借书时对应书籍数目加一
    @RequestMapping(value="huanshu",method= RequestMethod.GET)
    public String huashu(
            @RequestParam(value = "rbid",defaultValue = "")Integer rbid,
            @RequestParam(value = "bid",defaultValue = "")Integer bid,
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){
        bs.huanshu(bid);
        model.addAttribute("uid",uid);
        model.addAttribute("rbid",rbid);
        return "redirect:delRecord.do";
    }



}
