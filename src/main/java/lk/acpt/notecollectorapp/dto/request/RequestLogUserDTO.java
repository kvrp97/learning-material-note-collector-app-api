package lk.acpt.notecollectorapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestLogUserDTO {
    private String emailAddress;
    private String password;
}
