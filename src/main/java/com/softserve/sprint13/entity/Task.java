package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "task")
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created")
    private LocalDate created;

    @NotNull
    @Column(name = "title")
    private String title;

    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDate updated;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "task")
    private List<Progress> progresses;

    public Task() {
    }
}
