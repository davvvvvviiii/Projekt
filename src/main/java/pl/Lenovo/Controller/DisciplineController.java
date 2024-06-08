package pl.Lenovo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.Lenovo.Entity.SportDiscipline;
import pl.Lenovo.Repositories.DisciplineRepositories;

import java.util.Optional;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineRepositories disciplineRepositories;

    public DisciplineController(DisciplineRepositories disciplineRepositories) {
        this.disciplineRepositories = disciplineRepositories;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("discipline",new SportDiscipline());
        return "Discipline/addDiscipline";
    }
    @PostMapping("/add")
    @ResponseBody
    public String addDiscipline(SportDiscipline sportDiscipline){
        disciplineRepositories.save(sportDiscipline);
        return sportDiscipline.toString();
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
    @ResponseBody
    public String editDiscipline(SportDiscipline sportDiscipline){
        long id = sportDiscipline.getId();
        String name = sportDiscipline.getName();
        String description = sportDiscipline.getDescription();
        disciplineRepositories.updateById(id,name,description);
        return sportDiscipline.toString();
    }

}
