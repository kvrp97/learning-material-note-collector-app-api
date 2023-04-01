package lk.acpt.notecollectorapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "note")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {
    @Id
    @Column(name = "note_id", length = 25)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "note_title", length = 400, nullable = false)
    private String title;

    @Column(name = "note_description")
    private String description;

}