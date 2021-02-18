import com.example.demothymeleaf.DemoThymeleafApplication;
import com.example.demothymeleaf.services.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoThymeleafApplication.class)
@JsonTest
public class TestApplication {
    @Autowired
    HelloService helloService;
    @Autowired
    JacksonTester jacksonTester;
    @Before
    public void before(){
        System.out.println("===我是单元测试的before");
    }
    @Test
    public void contextLoads(){
        System.out.println("----test----");
        helloService.sayHello();
    }
    @Test
    public void testJsoin() throws IOException {
        String str ="{\"name\":\"wyd\"}";
        Object o = jacksonTester.parseObject(str);
        System.out.println("===="+o);
    }
}
