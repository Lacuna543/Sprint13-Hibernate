package com.softserve.sprint13.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task")
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", created=" + created +
                ", title='" + title + '\'' +
                ", updated=" + updated +
                ", sprintId=" + sprint.getId() +
                '}';
    }

}
