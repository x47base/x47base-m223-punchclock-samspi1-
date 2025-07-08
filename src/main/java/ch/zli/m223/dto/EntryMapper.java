package ch.zli.m223.dto;

import ch.zli.m223.model.Entry;

public class EntryMapper {
    public static Entry toEntity(EntryDto dto) {
        Entry entry = new Entry();
        entry.setId(dto.id);
        entry.setCheckIn(dto.checkIn);
        entry.setCheckOut(dto.checkOut);
        entry.setDescription(dto.description);
        return entry;
    }

    public static EntryDto toDto(Entry entry) {
        return new EntryDto(
            entry.getId(),
            entry.getCheckIn(),
            entry.getCheckOut(),
            entry.getDescription()
        );
    }
}
