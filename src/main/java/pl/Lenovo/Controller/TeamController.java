package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.Player;
import pl.Lenovo.Entity.Team;
import pl.Lenovo.Repositories.PlayerRepository;
import pl.Lenovo.Repositories.TeamRepository;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/add")
    public String addTeam(Model model){
        model.addAttribute("team", new Team());
        return "Team/AddTeam";
    }
    @PostMapping("/add")
    @ResponseBody
    public String addTeam(Team team){
        teamRepository.save(team);
        return team.toString();
    }
    @GetMapping("/list")
    public String all(Model model){
        model.addAttribute("teams", teamRepository.findAll());
        return "Team/AllTeams";
    }

    @GetMapping("/addPlayer")
    public String addPlayer(Model model){
        model.addAttribute("players", playerRepository.findAll());
        return "Team/AddPlayer";
    }
    @GetMapping("/addToTeam")
    public String addToTeam(Player player){
        return null;
    }
}
