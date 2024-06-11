package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportDiscipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank(message = "Nazwa nie może być pusta")
    private String name;
    @NotNull
    @NotBlank(message = "Opis nie może być pusty")
    private String description;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="team_id")
    private List<Team> teamList;

    public void addTeam(Team team) {
        this.teamList.add(team);
    }

    public List<String> getTeamNames() {
        List<String> teamNames = new ArrayList<>();
        for (Team team : teamList) {
            teamNames.add(team.getName());
        }
        return teamNames;
    }

    @Override
    public String toString() {
        return "SportDiscipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teamList=" + teamList +
                '}';
    }
}
