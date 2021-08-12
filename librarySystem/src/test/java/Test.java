import com.library.pojo.Book;
import com.library.pojo.Borrow;
import com.library.pojo.Student;
import com.library.service.BookService;
import com.library.service.BookServiceImpl;
import com.library.service.BorrowServiceImpl;
import com.library.service.StudentServiceImpl;
import com.library.utils.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/3/25 19:54
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentServiceImpl studentServiceImpl = context.getBean("studentServiceImpl",StudentServiceImpl.class);
        Student student = studentServiceImpl.getStudentByID("123");
        System.out.println(student);
    }

    @org.junit.jupiter.api.Test
    public void getBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl service = context.getBean("bookServiceImpl", BookServiceImpl.class);
        Book book = service.getBookByID("5");
        System.out.println(book);
    }

    @org.junit.jupiter.api.Test
    public void testCalendar() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(new Date()));
        Date date1 = df.parse("2021-3-25");
        int day = Util.getDaysTtilNow(date1);
        System.out.println(day);
    }
    @org.junit.jupiter.api.Test
    public void getBorrow(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl service = context.getBean("borrowServiceImpl", BorrowServiceImpl.class);
        List<Borrow> borrow = service.getBorrowBooksByStudentID("6");
        System.out.println(borrow.isEmpty());
        for (Borrow borrow1 : borrow) {
            System.out.println(borrow1);
        }
    }

    @org.junit.jupiter.api.Test
    public void getBookRecord(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl service = context.getBean("borrowServiceImpl", BorrowServiceImpl.class);
        Borrow borrow = service.getBorrowRecordByBook(2);
        System.out.println(borrow);
    }

    @org.junit.jupiter.api.Test
    public void getlastDate() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse("2021-3-25");
        System.out.println(Util.getDeadline("2021-3-25", 60));
    }

    @org.junit.jupiter.api.Test
    public void testDate(){
        Date date = new Date();
        List<Integer> list = new ArrayList<>();
        System.out.println(date);
    }
}
