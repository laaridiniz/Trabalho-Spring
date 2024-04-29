package br.gov.sp.fatec.anttrabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.anttrabalho.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{
    @Query("select u from Trabalho u where u.titulo like %?1% and u.nota > ?2")
    public List<Trabalho> getByTitulo(String titulo, Integer nota);
}
