package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @Pattern(regexp = "[a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "Pole może zawierać tylko litery i cyfry")
    private String name;
    @NotNull
    @NotBlank(message = "Nazwisko nie może być puste")
    @Pattern(regexp = "[a-zA-Z0-9ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]+", message = "Pole może zawierać tylko litery i cyfry")
    private String surname;
    @ManyToOne
   // @JoinColumn(name = "team_id")
    private Team team;
}
