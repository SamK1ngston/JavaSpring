package spring_introduction;
//Java-Code(2)
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("spring_introduction")
public class MyConfig1 {
    @Bean
    public Pet dogBean(){
        return new Dog();
    }
    @Bean
    public Person personBean(){
        return new Person(dogBean());
    }
}
