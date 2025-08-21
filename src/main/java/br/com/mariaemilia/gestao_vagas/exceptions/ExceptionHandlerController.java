
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import java.util.List;
import br.com.mariaemilia.gestao_vagas.exceptions.dto.ErrorMessageDTO;



@ControllerAdvice
public class ExceptionHandlerController {
   
    
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidExceptio(MethodArgumentNotValidException e) {
        List<ErrorMessageDTO> dto = new ArrayList<>();

      e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDTO error = new ErrorMessageDTO(err.getField(), message);
            dto.add(error);
       });

       return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    
    }    

}
