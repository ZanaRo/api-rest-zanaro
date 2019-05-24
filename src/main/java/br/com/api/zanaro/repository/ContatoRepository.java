package br.com.api.zanaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.zanaro.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	Contato findByNome(String nome);
	Contato findBySobrenome(String sobrenome);
	Contato findByTel(String tel);
	
}
