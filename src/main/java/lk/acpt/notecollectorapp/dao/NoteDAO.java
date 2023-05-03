package lk.acpt.notecollectorapp.dao;

import lk.acpt.notecollectorapp.dto.request.RequestSaveNoteDTO;
import lk.acpt.notecollectorapp.dto.request.RequestUpdateNoteDTO;
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

//    public Note addNote(RequestSaveNoteDTO requestSaveNoteDTO) {
//        Note note = modelMapper.map(requestSaveNoteDTO, Note.class);
//        return noteRepo.save(note);
//    }

    public List<Note> getAllNotes() {
        return noteRepo.findAllByOrderByDateTimeDesc();
    }

    public boolean deleteNote(Integer id) {
        if (noteRepo.existsById(id)){
            noteRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Note getNote(Integer id) {
        return noteRepo.getNoteById(id);
    }

    public boolean updateNote(RequestUpdateNoteDTO requestUpdateNoteDTO) {
        if (noteRepo.existsById(requestUpdateNoteDTO.getId())) {
            Note note = noteRepo.getNoteById(requestUpdateNoteDTO.getId());
            note.setTitle(requestUpdateNoteDTO.getTitle());
            note.setDescription(requestUpdateNoteDTO.getDescription());
            note.setDateTime(requestUpdateNoteDTO.getDateTime());
            noteRepo.save(note);
            return true;
        } else {
            return false;
        }
    }
}
