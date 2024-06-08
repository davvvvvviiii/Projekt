package pl.Lenovo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.Lenovo.Entity.User;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long>{
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.surname = :surname, u.password = :password WHERE u.id = :id")
    void updateById(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname, @Param("password") String password);
    //@Query("SELECT u FROM User u WHERE u.name= :name AND u.password = :password")
    //Optional<User> findByName(@Param("name") String name,@Param("password") String password);
    User findByName(String username);
}
