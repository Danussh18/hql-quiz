package com.cognizant.hqlquiz.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qt_id")
    private int id;

    @Column(name = "qt_text")
    private String text;
}
