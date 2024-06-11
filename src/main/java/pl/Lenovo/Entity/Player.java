package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank(message = "Nazwa nie może być pusta")
    private String name;
    @NotNull
    @NotBlank(message = "Nazwisko nie może być puste")
    private String surname;
    @ManyToOne
   // @JoinColumn(name = "team_id")
    private Team team;
}
