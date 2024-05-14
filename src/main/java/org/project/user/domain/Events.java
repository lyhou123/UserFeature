package org.project.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "al_events")
@Setter
@Getter
@NoArgsConstructor
public class Events{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Date sheduledDate;
    private String eventName;
    private String eventPoster;
    @Column(columnDefinition = "TEXT")
    private String eventDescription;

    private Date createdDate;
    private Date updatedDate;

    //posttype relatioship

    @ManyToOne
    @JoinColumn(name = "post_type")
    private PostType postType;


    //donations relationship
    @ManyToOne
    @JoinColumn(name = "event_type")
    private Donations donations;


}