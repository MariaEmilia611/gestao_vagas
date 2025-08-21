package br.com.mariaemilia.gestao_vagas.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    
    private String field;
    private String message;     

}
