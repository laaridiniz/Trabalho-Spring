package br.gov.sp.fatec.anttrabalho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.anttrabalho.entity.Trabalho;
import br.gov.sp.fatec.anttrabalho.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho == null ||
            trabalho.getTitulo() == null ||
            trabalho.getData() == null ||
            trabalho.getGrupo() == null) {
            throw new IllegalArgumentException("Conferir dados obrigatórios!");
        }
            return trabalhoRepo.save(trabalho);
        }
    
    public List<Trabalho> buscarTodos() {
        return trabalhoRepo.findAll();
        }

    public Trabalho buscarPorId(Long id) {
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isPresent()) {
            return trabalhoOp.get();
        }
        throw new IllegalArgumentException("Trabalho não encontrado!");
    }

}
