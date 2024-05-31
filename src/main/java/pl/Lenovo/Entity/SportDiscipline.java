package pl.Lenovo.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "disciplines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SportDiscipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    //ogólne zasady oraz opis wymagań
    String description;
}
