package lk.acpt.notecollectorapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateNoteDTO {
    private Integer id;
    private String title;
    private String description;
    private String dateTime;
}
