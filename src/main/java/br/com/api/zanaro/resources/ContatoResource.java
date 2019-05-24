package br.com.api.zanaro.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.zanaro.domain.Contato;
import br.com.api.zanaro.dto.ContatoDTO;
import br.com.api.zanaro.service.ContatoService;

@RestController
@RequestMapping(value="/contato")
public class ContatoResource {

		@Autowired
		private ContatoService service;
	
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Contato> find(@PathVariable Integer id){
			Contato obj = service.find(id);
			return ResponseEntity.ok().body(obj);	
		}
		
		@RequestMapping(value = "/nome", method = RequestMethod.GET)
		public ResponseEntity<Contato> findNome(@RequestParam(value = "value") String nome){
			Contato obj = service.findByNome(nome);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(value = "/sobrenome", method = RequestMethod.GET)
		public ResponseEntity<Contato> findSobrenome(@RequestParam(value = "value") String sobrenome){
			Contato obj = service.findBySobrenome(sobrenome);
			return ResponseEntity.ok().body(obj);
		}
		
		@RequestMapping(value = "/telefone", method = RequestMethod.GET)
		public ResponseEntity<Contato> findTel(@RequestParam(value = "value") String tel){
			Contato obj = service.findByTel(tel);
			return ResponseEntity.ok().body(obj);
		}
	
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody ContatoDTO objDto) {
			Contato obj = service.fromDTO(objDto);
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Void> update(@Valid @RequestBody ContatoDTO objDto, @PathVariable Integer id){
			Contato obj = service.fromDTO(objDto);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<ContatoDTO>> findAll(){
			List<Contato> list = service.findAll();
			List<ContatoDTO> listDto = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);
		}
		
		@RequestMapping(value = "/page", method = RequestMethod.GET)
		public ResponseEntity<Page<ContatoDTO>> findPage(
				@RequestParam(value = "page", defaultValue = "0") Integer page, 
				@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
				@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
				@RequestParam(value = "direction", defaultValue = "ASC")String direction){
			Page<Contato> list = service.findPage(page, linesPerPage, orderBy, direction);
			Page<ContatoDTO> listDto = list.map(obj -> new ContatoDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}
	
}
