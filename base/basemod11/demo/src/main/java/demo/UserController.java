package demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repo.UserRepository;

import java.security.Principal;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String showUserPage(Principal principal, Model model) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email);

        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/user/update")
    public String updateUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role,
            RedirectAttributes redirectAttributes
    ) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(password);
            user.setRole(role);
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("message", "Данные пользователя обновлены успешно!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Пользователь не найден");
        }

        return "redirect:/user";
    }
}
