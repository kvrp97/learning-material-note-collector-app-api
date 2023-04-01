package lk.acpt.notecollectorapp.dao;

import lk.acpt.notecollectorapp.dto.RequestSaveNoteDTO;
import lk.acpt.notecollectorapp.model.Note;
import lk.acpt.notecollectorapp.repo.NoteRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteDAO {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Note addNote(RequestSaveNoteDTO requestSaveNoteDTO) {
        Note note = modelMapper.map(requestSaveNoteDTO, Note.class);
        return noteRepo.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }
}
