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

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository, TeamRepository teamRepository, DisciplineRepositories disciplineRepositories) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "User/addUser";
    }
    @PostMapping("/add")
    @ResponseBody
    public String add(User user){
        userRepository.save(user);
        return user.toString();
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
        userRepository.updateById(id,name,surname);
        return user.toString();
    }
}
