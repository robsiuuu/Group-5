package uni_vents.com.univents_backend.Statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni_vents.com.univents_backend.Events.Event;
import uni_vents.com.univents_backend.Users.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {

    List<Statistic> findByEventEventId(int eventId);

    List<Statistic> findByUserUserId(int userId);

    Optional<Statistic> findByEventAndUser(Event event, User user);

}
