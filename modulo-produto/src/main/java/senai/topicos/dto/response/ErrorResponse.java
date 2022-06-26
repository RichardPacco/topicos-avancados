package senai.topicos.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -131346629564018997L;

    private HttpStatus status;
    private String message;

}
