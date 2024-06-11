package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.SportDiscipline;

import java.util.Optional;

@Repository
@Transactional
public interface DisciplineRepositories extends JpaRepository<SportDiscipline,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE SportDiscipline p SET p.name = :name, p.description = :description WHERE p.id = :id")
    void updateById(@Param("id") Long id, @Param("name") String name, @Param("description") String description);
    @Query("SELECT d, t FROM SportDiscipline d LEFT JOIN FETCH d.teamList t WHERE d.id = :id")
    Optional<SportDiscipline> findByIdWithTeams(@Param("id") Long id);

}
