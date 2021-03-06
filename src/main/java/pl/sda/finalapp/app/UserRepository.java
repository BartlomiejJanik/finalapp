package pl.sda.finalapp.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE LOWER(u.eMail) = lower(?1)")//to jest JPQL
    Optional<User> findByEmail(String email);

}
