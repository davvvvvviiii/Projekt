package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long>{
}
