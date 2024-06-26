package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import pl.Lenovo.Dao.PlayerDao;
//import pl.Lenovo.Dao.UserDao;
import pl.Lenovo.Entity.Role;
import pl.Lenovo.Entity.User;
import pl.Lenovo.Repositories.DisciplineRepositories;
import pl.Lenovo.Repositories.RoleRepository;
import pl.Lenovo.Repositories.TeamRepository;
import pl.Lenovo.Repositories.UserRepository;
import pl.Lenovo.Services.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    public UserController(UserRepository userRepository, TeamRepository teamRepository, DisciplineRepositories disciplineRepositories, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "User/addUser";
    }
    @PostMapping("/add")
    @Transactional
    public String add(@ModelAttribute("user")@Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return "User/addUser";
        }
        userService.saveUser(user);
        return "redirect:/login";
//        try {
//            userService.saveUser(user);
//            return "User saved successfully: ";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error saving user: " + e.getMessage();
//        }
    }
    @GetMapping("/list")
    public String all(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "User/allUsers";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id){
        //Optional<Player> player = playerRepository.findById(id);
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }
//    @GetMapping("/edit/{id}")
//    public String editForm(@PathVariable long id, Model model){
//        Optional<User> user = userRepository.findById(id);
//        model.addAttribute("user", user);
//        return "User/editUser";
//    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("user")@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "User/editUser";
        }
//        long id = user.getId();
//        String name = user.getName();
//        String surname= user.getSurname();
//        String password = user.getPassword();
//        userRepository.updateById(id,name,surname,password);
        userService.saveUser(user);
        return "Page/home";
    }
    @GetMapping("/edit")
    public String editForm(Model model, Principal principal){
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("user",user);
        return "User/editUser";
    }
}
