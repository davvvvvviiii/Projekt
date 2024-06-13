package pl.Lenovo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.Player;
import pl.Lenovo.Entity.Team;
import pl.Lenovo.Entity.User;
import pl.Lenovo.Repositories.PlayerRepository;
import pl.Lenovo.Repositories.TeamRepository;
import pl.Lenovo.Repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/team")
public class TeamController {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final UserRepository userRepository;

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String addTeam(Model model){
        model.addAttribute("team", new Team());
        return "Team/AddTeam";
    }
    @PostMapping("/add")
    public String addTeam(@ModelAttribute("team")@Valid Team team, BindingResult result){
        if (result.hasErrors()){
            return "Team/AddTeam";
        }
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//        User user = userRepository.findByUsernameWithTeams(userName);
//        user.getTeamList().add(team);
        teamRepository.save(team);
        return "redirect:/team/list";
    }
    @GetMapping("/list")
    public String all(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//        User user = userRepository.findByUsernameWithTeams(userName);
//        List<Team> teamList = user.getTeamList();
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
    public String edit(Team team){
        long id = team.getId();
        String name = team.getName();
        teamRepository.updateById(id,name);
        return "redirect:/team/list";
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
    @GetMapping("/showPlayers/{id}")
    public String showPlayers(Model model, @PathVariable Long id) {
        Optional<Team> teamOpt = teamRepository.findById(id);
        if (teamOpt.isPresent()) {
            Team team = teamOpt.get();
            model.addAttribute("playerNames", team.getPlyersNames());
            //model.addAttribute("playerSurname", team.getPlayersSurname());
        }
        return "Team/PlayersForTeam";
    }
    @GetMapping("/menu")
    public String menu(){
        return "Team/TeamMenu";
    }
}
