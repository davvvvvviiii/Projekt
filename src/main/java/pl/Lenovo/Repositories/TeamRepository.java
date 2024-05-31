package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.Team;
@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Team p SET p.name = :name WHERE p.id = :id")
    void updateById(@Param("id") Long id, @Param("name") String name);

    //void updateAndAddPlayer()
}
