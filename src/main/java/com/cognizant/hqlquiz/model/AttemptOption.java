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
@Entity(name = "attempt_option")
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    Options option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ao_aq_id")
    AttemptQuestion attemptQuestion;

    @Column(name = "ao_selected", columnDefinition = "BIT")
    boolean selected;

}
