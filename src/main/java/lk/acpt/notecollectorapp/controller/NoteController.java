package lk.acpt.notecollectorapp.controller;

import lk.acpt.notecollectorapp.dao.NoteDAO;
import lk.acpt.notecollectorapp.dto.RequestSaveNoteDTO;
import lk.acpt.notecollectorapp.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteDAO noteDAO;

    @PostMapping(path = "/save")
    public Note saveNote(@RequestBody RequestSaveNoteDTO requestSaveNoteDTO){
        return noteDAO.addNote(requestSaveNoteDTO);
    }

    @GetMapping(path = "/get-all-notes")
    public List<Note> getAllNotes(){
        return noteDAO.getAllNotes();
    }
}