package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.Player;

import java.util.List;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player,Long> {


    @Modifying
    @Transactional
    @Query("UPDATE Player p SET p.name = :name, p.surname = :surname WHERE p.id = :id")
    void updateById(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname);
}
