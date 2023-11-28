package demo;

import models.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repo.ReviewsRepository;

@Controller
public class HomeController {

    @Autowired
    private ReviewsRepository reviewsRepository;

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

    @GetMapping("/reviews")
    public String reviews() {
        Iterable<Reviews> reviews = reviewsRepository.findAll();
        return "reviews";
    }
}
