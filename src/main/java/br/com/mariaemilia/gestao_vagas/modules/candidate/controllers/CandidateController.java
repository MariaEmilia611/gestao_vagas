package br.com.mariaemilia.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mariaemilia.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.mariaemilia.gestao_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            // 1. Salve a entidade E capture o resultado na variável 'result'
            var result = this.candidateRepository.save(candidateEntity);

            // 2. Retorne a variável 'result'. O Spring irá convertê-la para JSON automaticamente.
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            // É uma boa prática retornar o erro caso algo dê errado na validação
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
