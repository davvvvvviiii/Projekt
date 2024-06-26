package pl.Lenovo.Controller;

import org.hibernate.Session;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    @GetMapping("/home")
    public String home() {
        return "Page/home";
    }

    @GetMapping("/error-login")
    public String errorLogin(Model model) {
        model.addAttribute("loginError", true);
        return "Page/login";
    }

}
