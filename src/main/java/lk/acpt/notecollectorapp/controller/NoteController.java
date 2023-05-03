package lk.acpt.notecollectorapp.controller;

import lk.acpt.notecollectorapp.dao.NoteDAO;
import lk.acpt.notecollectorapp.dto.request.RequestSaveNoteDTO;
import lk.acpt.notecollectorapp.dto.request.RequestUpdateNoteDTO;
import lk.acpt.notecollectorapp.model.Note;
import lk.acpt.notecollectorapp.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/note")
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteDAO noteDAO;

//    @PostMapping(path = "/save")
//    public Note saveNote(@RequestBody RequestSaveNoteDTO requestSaveNoteDTO){
//        return noteDAO.addNote(requestSaveNoteDTO);
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveNote(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "dateTime") String dateTime,
            @RequestParam(value = "images", required = false) MultipartFile[] images
    ){
        if (images == null) {
            System.out.println("0000000000000000000000");
        } else {
            System.out.println("1111111111111111111111");
        }
        return null;
    }

    @GetMapping(path = "get-by-id", params = "noteId")
    public Note getNote(@RequestParam(value = "noteId") Integer id){
        return noteDAO.getNote(id);
    }

    @GetMapping(path = "/get-all-notes")
    public List<Note> getAllNotes(){
        return noteDAO.getAllNotes();
    }

    @PutMapping(path = "update")
    public boolean updateNote(@RequestBody RequestUpdateNoteDTO requestUpdateNoteDTO){
        return noteDAO.updateNote(requestUpdateNoteDTO);
    }

    @DeleteMapping(path = "delete", params = "noteId")
    public boolean deleteNote(@RequestParam(value = "noteId") Integer id){
        return noteDAO.deleteNote(id);
    }
}
