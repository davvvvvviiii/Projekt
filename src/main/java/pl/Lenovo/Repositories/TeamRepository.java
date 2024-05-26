package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.Team;
@Repository
@Transactional
public interface TeamRepository extends JpaRepository<Team,Long> {
}
