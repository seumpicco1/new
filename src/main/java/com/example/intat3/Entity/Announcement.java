package com.example.intat3.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "announcement")


public class Announcement {
    @Id
    @Column(name = "announcementId", nullable = false)
    private Integer id;

    @Column(name = "announcementTitle", nullable = false)
    private String announcementTitle;

    @Column(name = "announcementDescription", nullable = false)
    private String announcementDescription;

    @Column(name = "publishDate", nullable = false)
    private ZonedDateTime publishDate;

    @Column(name = "closeDate", nullable = false)
    private ZonedDateTime closeDate;

    @Column(name = "announcementDisplay", nullable = false)
    private String announcementDisplay ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


}
