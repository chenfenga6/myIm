package cf.owm.myim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cf.owm.myim.mapper")
public class MyimApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyimApplication.class, args);
    }

}
