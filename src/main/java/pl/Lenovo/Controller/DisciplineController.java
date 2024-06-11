package pl.Lenovo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.Player;
import pl.Lenovo.Entity.SportDiscipline;
import pl.Lenovo.Entity.Team;
import pl.Lenovo.Repositories.DisciplineRepositories;
import pl.Lenovo.Repositories.TeamRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineRepositories disciplineRepositories;
    private final TeamRepository teamRepository;

    public DisciplineController(DisciplineRepositories disciplineRepositories, TeamRepository teamRepository) {
        this.disciplineRepositories = disciplineRepositories;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("discipline",new SportDiscipline());
        return "Discipline/addDiscipline";
    }
    @PostMapping("/add")
    public String addDiscipline(@ModelAttribute("discipline")@Valid SportDiscipline sportDiscipline, BindingResult result){
        if (result.hasErrors()){
            return "Discipline/addDiscipline";
        }
        disciplineRepositories.save(sportDiscipline);
        return "redirect:/discipline/list";
    }
    @GetMapping("/list")
    public String allDiscipline(Model model){
        model.addAttribute("disciplines",disciplineRepositories.findAll());
        return "Discipline/allDisciplines";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id){
        disciplineRepositories.deleteById(id);
        return "redirect:/discipline/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        Optional<SportDiscipline> sportDiscipline = disciplineRepositories.findById(id);
        model.addAttribute("discipline", sportDiscipline);
        return "Discipline/editDiscipline";
    }
    @PostMapping("/edit")
    public String editDiscipline(SportDiscipline sportDiscipline){
        long id = sportDiscipline.getId();
        String name = sportDiscipline.getName();
        String description = sportDiscipline.getDescription();
        disciplineRepositories.updateById(id,name,description);
        return "redirect:/discipline/list";
    }
    @GetMapping("/addTeam/{disciplineId}")
    public String addTeam(Model model,@PathVariable long disciplineId){
        model.addAttribute("teams",teamRepository.findAll());
        model.addAttribute("teamId", disciplineId);
        return "Discipline/AddTeam";
    }
    @GetMapping("/addToDiscipline/{disciplineId}/{teamId}")
    public String addToTeam(@PathVariable long disciplineId, @PathVariable long teamId){
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Optional<SportDiscipline> disciplineOpt = disciplineRepositories.findById(disciplineId);
        if (teamOpt.isPresent()) {
            Team team = teamOpt.get();
            SportDiscipline discipline = disciplineOpt.get();
            discipline.addTeam(team);
            disciplineRepositories.save(discipline);
        }
        return "redirect:/discipline/list";
    }
    @GetMapping("/showTeams/{id}")
    //@ResponseBody
    public String showTeams(Model model,@PathVariable Long id) {
        Optional<SportDiscipline> disciplineOpt = disciplineRepositories.findByIdWithTeams(id);
        if (disciplineOpt.isPresent()) {
            SportDiscipline discipline = disciplineOpt.get();
            model.addAttribute("teams", discipline.getTeamNames());
        }
        return "Discipline/TeamsForDiscipline";
    }
    @GetMapping("/menu")
    public String menu(){
        return "Discipline/DisciplineMenu";
    }
}
