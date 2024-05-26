package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import pl.Lenovo.Dao.PlayerDao;
//import pl.Lenovo.Dao.UserDao;
import pl.Lenovo.Entity.User;
import pl.Lenovo.Repositories.DisciplineRepositories;
import pl.Lenovo.Repositories.TeamRepository;
import pl.Lenovo.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, TeamRepository teamRepository, DisciplineRepositories disciplineRepositories) {
        this.userRepository = userRepository;
    }
    @GetMapping("/UserAddForm")
    public String showUserAddForm(Model model){
        model.addAttribute("user",new User());
        return "User/UserAddForm";
    }
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        userRepository.save(user);
        return user.toString();
    }
    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        return user.toString();
    }
    @GetMapping("/allUsers")
    public String allUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "User/AllUsers";
    }
    @GetMapping("/removeUser/{id}")
    public void removeUser(@PathVariable Long id){
            userRepository.deleteById(id);
    }
}
