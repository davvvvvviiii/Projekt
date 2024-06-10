package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.Role;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String name);
}
