package uni_vents.com.univents_backend.Statistics;

import uni_vents.com.univents_backend.Events.Event;
import uni_vents.com.univents_backend.Events.EventRepository;
import uni_vents.com.univents_backend.Users.User;
import uni_vents.com.univents_backend.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Statistic createStatistic(Statistic statistic, int eventId, int userId) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (eventOpt.isEmpty()) {
            throw new RuntimeException("Event not found with ID: " + eventId);
        }
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        statistic.setEvent(eventOpt.get());
        statistic.setUser(userOpt.get());
        return statisticRepository.save(statistic);
    }

    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic getStatisticById(int statisticId) {
        return statisticRepository.findById(statisticId)
                .orElseThrow(() -> new RuntimeException("Statistic not found with ID: " + statisticId));
    }

    public List<Statistic> getStatisticsByEvent(int eventId) {
        return statisticRepository.findByEventEventId(eventId);
    }

    public List<Statistic> getStatisticsByUser(int userId) {
        return statisticRepository.findByUserUserId(userId);
    }

    public Statistic updateStatistic(int statisticId, Statistic updatedStatistic) {
        Statistic existingStatistic = getStatisticById(statisticId);

        existingStatistic.setStatisticTitle(updatedStatistic.getStatisticTitle());
        existingStatistic.setStatisticDescription(updatedStatistic.getStatisticDescription());
        existingStatistic.setStatisticData(updatedStatistic.getStatisticData());
        existingStatistic.setStatisticUpdatedAt(updatedStatistic.getStatisticUpdatedAt());

        return statisticRepository.save(existingStatistic);
    }

    public void deleteStatistic(int statisticId) {
        if (!statisticRepository.existsById(statisticId)) {
            throw new RuntimeException("Statistic not found with id: " + statisticId);
        }
        statisticRepository.deleteById(statisticId);
    }
}
