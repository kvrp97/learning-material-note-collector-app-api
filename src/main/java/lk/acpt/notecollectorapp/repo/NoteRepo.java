package lk.acpt.notecollectorapp.repo;

import lk.acpt.notecollectorapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Integer> {
}
