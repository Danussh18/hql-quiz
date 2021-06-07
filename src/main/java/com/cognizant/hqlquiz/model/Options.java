package com.cognizant.hqlquiz.model;

import lombok.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "op_qt_id")
    private Question question;

    @Column(name = "op_score")
    private double score;

    @Column(name = "op_text")
    private String text;
}
