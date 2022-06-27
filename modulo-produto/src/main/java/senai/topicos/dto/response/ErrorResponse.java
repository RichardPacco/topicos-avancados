package senai.topicos.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown=true) //TODO Arrumar o jackson para não serializar fields nulls
public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = -131346629564018997L;

    private HttpStatus status;
    private String message;

}
