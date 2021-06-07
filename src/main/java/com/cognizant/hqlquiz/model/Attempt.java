package com.cognizant.hqlquiz.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "attempt")
@Getter
@Setter
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @Column(name = "at_score")
    private double score;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER)
    private List<AttemptQuestion> attemptQuestionList;
}
