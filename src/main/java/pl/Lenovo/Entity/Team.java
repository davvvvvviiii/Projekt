package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
//@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank(message = "Nazwa nie może być pusta")
    private String name;
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    //@JoinColumn(name = "id_players")
    private List<Player> players;

    public void addPlayer(Player player){
        players.add(player);
    }

    public List<String> getPlyersNames() {
        List<String> teamNames = new ArrayList<>();
        for (Player player : players) {
            teamNames.add(player.getName());
        }
        return teamNames;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

