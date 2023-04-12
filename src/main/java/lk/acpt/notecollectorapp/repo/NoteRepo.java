package lk.acpt.notecollectorapp.repo;

import lk.acpt.notecollectorapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface NoteRepo extends JpaRepository<Note,Integer> {

    Note getNoteById(Integer id);

    List<Note> findAllByOrderByDateTimeDesc();
}
