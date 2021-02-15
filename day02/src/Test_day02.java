import com.atgui.spring.SpringConfiguration;
import com.atgui.spring.beans.User;
import com.atgui.spring.dao.UserDao;
import com.atgui.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = "classpath:beans.xml" )
@RunWith(SpringJUnit4ClassRunner.class)

public class Test_day02 {
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

//   @Test
//   public void test01(){
//       Book myFactoryBean = (Book) ioc.getBean("myFactoryBean");
//       System.out.println(myFactoryBean);
//   }
//   @Test
//   public void test02(){
//       Book book01 = (Book) ioc.getBean("book01");
//       Book book02 = (Book) ioc.getBean("book01");
//       System.out.println(book01);
//       System.out.println(book02);
//   }
//   @Test
//   public void test03(){
//       Book book01 = (Book) ioc.getBean("book01");
//       System.out.println("对象可以被使用了");
//       ConfigurableApplicationContext coc = (ConfigurableApplicationContext)ioc;
//       coc.close();
//
//   }
//   @Test
//   public void test04(){
//       User user = (User) ioc.getBean("user");
//       System.out.println(user);
//   }
//   @Test
//   public void test05(){
//       UserDao userDao = (UserDao) ioc.getBean("userDao");
//       System.out.println(userDao);
//   }
//   @Test
//   public void test06(){
//       UserService userService;
//       userService = (UserService) ioc.getBean("userService");
//      userService.addUser();
//   }
//   @Test
//   public void test07(){
//       ApplicationContext ioc2 = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//       UserService userService = (UserService) ioc2.getBean("userService");
//       userService.addUser();
//
//   }
    @Autowired
    UserService userService;

    @Test
    public void test08(){
       userService.addUser();
    }
}
