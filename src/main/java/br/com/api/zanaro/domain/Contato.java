package br.com.api.zanaro.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String tel;
	private String twt;
	private String skp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	
	public Contato() {
		
	}
	
	public Contato(int id, String nome, String sobrenome, String email, String tel, String twt, String skp) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.tel = tel;
		this.twt = twt;
		this.skp = skp;
	}
	
	
}
