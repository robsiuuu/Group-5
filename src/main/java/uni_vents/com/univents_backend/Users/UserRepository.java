package uni_vents.com.univents_backend.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uni_vents.com.univents_backend.Events.Event;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users s WHERE s.username = ?1", nativeQuery = true)
    User getUserByUsername(String username);


}