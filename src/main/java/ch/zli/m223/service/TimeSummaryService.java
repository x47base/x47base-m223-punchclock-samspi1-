package ch.zli.m223.service;

import ch.zli.m223.model.Entry;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TimeSummaryService {
    public Map<String, String> calculateSummaryPerDay(List<Entry> entries) {
        Map<LocalDate, Duration> durationPerDay = new HashMap<>();
        for (Entry entry : entries) {
            LocalDate date = entry.getCheckIn().toLocalDate();
            Duration duration = Duration.between(entry.getCheckIn(), entry.getCheckOut());
            durationPerDay.merge(date, duration, Duration::plus);
        }
        Map<String, String> result = new HashMap<>();
        for (var e : durationPerDay.entrySet()) {
            result.put(e.getKey().toString(), formatDuration(e.getValue()));
        }
        return result;
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
