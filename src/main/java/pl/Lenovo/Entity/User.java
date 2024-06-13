package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank(message = "Nazwa nie może być pusta")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Pole może zawierać tylko litery i cyfry")
    private String name;
    @NotNull
    @NotBlank(message = "Nazwisko nie może być puste")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Pole może zawierać tylko litery i cyfry")
    private String surname;
    @NotNull
    @NotBlank(message = "Hasło nie może być puste")
    private String password;
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Team> teamList;
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Player> playerList;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
