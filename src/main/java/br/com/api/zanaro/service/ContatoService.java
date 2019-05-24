package br.com.api.zanaro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.api.zanaro.domain.Contato;
import br.com.api.zanaro.dto.ContatoDTO;
import br.com.api.zanaro.repository.ContatoRepository;
import br.com.api.zanaro.service.exception.ObjectNotFoundException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatorepo;
	
	public Contato find(Integer id) {
		Optional<Contato> obj = contatorepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Contato insert(Contato obj) {
		obj.setId(0);
		return contatorepo.save(obj);
	}
	
	public Contato update(Contato obj) {
		find(obj.getId());
		return contatorepo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		contatorepo.deleteById(id);
		}
		catch (Exception e) {
			System.out.println("ERRO ID NÃO ENCONTRADO");
		}
	}
	public List<Contato> findAll() {
		return contatorepo.findAll();
		
	}
	
	public Contato findByNome(String nome) {
		Contato obj = contatorepo.findByNome(nome);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}return obj;
	}
	
	public Contato findBySobrenome(String sobrenome) {
		Contato obj = contatorepo.findBySobrenome(sobrenome);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}return obj;
	}
	
	public Contato findByTel(String tel) {
		Contato obj = contatorepo.findByTel(tel);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}return obj;
	}
	
	public Page<Contato> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return contatorepo.findAll(pageRequest);
	}
	
	public Contato fromDTO(ContatoDTO objDto) {
		return new Contato(0, objDto.getNome(), objDto.getSobrenome(), objDto.getTel(), objDto.getEmail(), objDto.getSkp(), objDto.getTwt());
	}
}
