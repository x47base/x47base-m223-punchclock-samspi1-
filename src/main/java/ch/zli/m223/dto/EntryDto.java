package ch.zli.m223.dto;

import java.time.LocalDateTime;

public class EntryDto {
    public Long id;
    public LocalDateTime checkIn;
    public LocalDateTime checkOut;
    public String description;

    public EntryDto() {}

    public EntryDto(Long id, LocalDateTime checkIn, LocalDateTime checkOut, String description) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.description = description;
    }
}
