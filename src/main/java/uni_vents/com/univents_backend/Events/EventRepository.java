package uni_vents.com.univents_backend.Events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Provides database transactions
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = "select * from events s where s.event_name like %?1% ", nativeQuery = true)
    List<Event> getEventsByName(String eventName);

    @Query(value = "select * from events s where s.event_date = ?1 ", nativeQuery = true)
    List<Event> getEventsByDate(Date eventDate);

    @Query(value = "SELECT * FROM events s where s.event_location LIKE %?1%", nativeQuery = true)
    List<Event> getEventsByLocation(String eventLocation);

    @Query(value = "SELECT * FROM events s where s.creator_id = ?1", nativeQuery = true)
    List<Event> getEventsByCreator(int creatorId);




}
