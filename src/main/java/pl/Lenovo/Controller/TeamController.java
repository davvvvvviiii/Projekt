package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.Player;
import pl.Lenovo.Entity.Team;
import pl.Lenovo.Repositories.PlayerRepository;
import pl.Lenovo.Repositories.TeamRepository;

import java.util.Optional;

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
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id){
        teamRepository.deleteById(id);
        return "redirect:/team/list";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model){
        Optional<Team> team = teamRepository.findById(id);
        model.addAttribute("team", team);
        return "Team/EditTeam";
    }
    @PostMapping("/edit")
    @ResponseBody
    public String edit(Team team){
        long id = team.getId();
        String name = team.getName();
        teamRepository.updateById(id,name);
        return team.toString();
    }
    @GetMapping("/addPlayer/{teamId}")
    public String addPlayer(Model model,@PathVariable long teamId){
        model.addAttribute("players", playerRepository.findAll());
        model.addAttribute("teamId",teamId);
        return "Team/AddPlayer";
    }
    @GetMapping("/addToTeam/{teamId}/{playerId}")
    public String addToTeam(@PathVariable long playerId, @PathVariable long teamId){
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        //team.getId();
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            Optional<Team> optionalTeam = teamRepository.findById(teamId);
            player.setTeam(optionalTeam.get());
            player.getId();
            playerRepository.save( player);
        }
        return "redirect:/team/list";
    }
}
