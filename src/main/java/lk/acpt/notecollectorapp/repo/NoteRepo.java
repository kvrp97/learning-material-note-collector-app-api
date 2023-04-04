package lk.acpt.notecollectorapp.repo;

import lk.acpt.notecollectorapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface NoteRepo extends JpaRepository<Note,Integer> {

}
