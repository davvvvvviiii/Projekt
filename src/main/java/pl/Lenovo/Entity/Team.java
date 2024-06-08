package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
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
    private String name;
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    //@JoinColumn(name = "id_players")
    private List<Player> players;

    public void addPlayer(Player player){
        players.add(player);
    }

}

