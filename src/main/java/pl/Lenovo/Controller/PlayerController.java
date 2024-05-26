package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.Player;
import pl.Lenovo.Repositories.PlayerRepository;

import java.util.Optional;

@Controller
@RequestMapping("/player")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("player",new Player());
        return "Player/AddPlayer";
    }
    @  PostMapping("/addPlayer")
    @ResponseBody
    public String add(Player player){
        playerRepository.save(player);
        return player.toString();
    }
    @GetMapping("/list")
    public String all(Model model){
        model.addAttribute("players", playerRepository.findAll());
        return "Player/AllPlayers";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id){
        //Optional<Player> player = playerRepository.findById(id);
        playerRepository.deleteById(id);
        return "redirect:/player/list";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model){
        Optional<Player> player = playerRepository.findById(id);
        model.addAttribute("player", player);
        return "Player/EditPlayer";
    }
    @PostMapping("/edit")
    @ResponseBody
    public String edit(Player player){
        long id = player.getId();
        String name = player.getName();
        String surname= player.getSurname();
        playerRepository.updateById(id,name,surname);
        return player.toString();
    }
}
