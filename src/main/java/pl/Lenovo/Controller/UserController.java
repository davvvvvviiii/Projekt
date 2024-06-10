package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
    @ResponseBody
    @Transactional
    public String add(User user) {
//        userService.saveUser(user);
//        return user.toString();
//    }
        try {
            userService.saveUser(user);
            return "User saved successfully: " + user.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving user: " + e.getMessage();
        }
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
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "User/editUser";
    }
    @PostMapping("/edit")
    @ResponseBody
    public String edit(User user){
        long id = user.getId();
        String name = user.getName();
        String surname= user.getSurname();
        String password = user.getPassword();
        userRepository.updateById(id,name,surname,password);
        return user.toString();
    }
}
