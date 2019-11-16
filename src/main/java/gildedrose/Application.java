package gildedrose;

import com.gildedrose.GildedRose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpSession;


@SpringBootApplication
public class Application {
        public static void main(String[] args) {

            SpringApplication.run(Application.class, args);


        }

//        @Bean
//        public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//            return args -> {
//
//                System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//                String[] beanNames = ctx.getBeanDefinitionNames();
//                Arrays.sort(beanNames);
//                for (String beanName : beanNames) {
//                    System.out.println(beanName);
//                }
//
//            };
//        }

    }
