package br.com.api.zanaro.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import br.com.api.zanaro.domain.Contato;

public class ContatoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private String sobrenome;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@NumberFormat
	@Length(max=10, message="O Tamanho pode ser no máximo 10 digitos")
	private String tel;
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTwt() {
		return twt;
	}
	public void setTwt(String twt) {
		this.twt = twt;
	}
	public String getSkp() {
		return skp;
	}
	public void setSkp(String skp) {
		this.skp = skp;
	}

	private String twt;
	private String skp;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public ContatoDTO() {
		
	}
	
	public ContatoDTO(Contato obj) {
		nome = obj.getNome();
		sobrenome = obj.getSobrenome();
		tel = obj.getTel();
		email = obj.getEmail();
		skp = obj.getSkp();
		twt = obj.getTwt();
	}
}
