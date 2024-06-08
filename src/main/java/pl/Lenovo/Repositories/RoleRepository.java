package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.Lenovo.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
