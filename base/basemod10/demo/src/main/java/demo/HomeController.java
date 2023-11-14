package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    //при открытии страницы услуг выдает ошибку
    //исправить не получилось, информацию продублировал на главную страницу
    //также весь html код для услуг имеется в папке templates
    @GetMapping("/uslugi")
    public String uslugi() {
        return "uslugi";
    }
}
