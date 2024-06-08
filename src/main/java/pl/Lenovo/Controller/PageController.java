package pl.Lenovo.Controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.User;
import pl.Lenovo.Repositories.UserRepository;

import java.util.Optional;

@Controller
public class PageController {
    private final UserRepository userRepository;

    public PageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "Page/login";
    }
    @PostMapping("/login")
    public String loginPost() {
        // Obsluga zalogowania
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home() {
        return "Page/home";
    }
//    @PostMapping("/home")
//    @ResponseBody
//    public String homePage(@RequestParam String name,@RequestParam String password) {
//        Optional<User> user = userRepository.findByName(name, password);
//        if (user.isPresent()) {
//
//            return "Page/home";
//        }
//        return "User nie istnieje" + "\n" +
//                "Spróbuj ponownie lub zarejestruj się";
//    }

}
