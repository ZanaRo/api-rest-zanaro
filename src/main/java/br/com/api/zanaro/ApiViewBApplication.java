package br.com.api.zanaro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.api.zanaro.domain.Contato;
import br.com.api.zanaro.repository.ContatoRepository;

@SpringBootApplication
public class ApiViewBApplication implements CommandLineRunner {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiViewBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Contato contato1 = new Contato(0, "Leonardo", "Zanaro", "leonardo.zanaro@live.com", "(14) 99857-9284", "N/C", "leonardo.zanaro");
		Contato contato2 = new Contato(0, "Danilo", "Avante", "danilo.avante@viewb.com", "(14) 3245-1246", "N/C", "N/C");
		Contato contato3 = new Contato(0, "José", "Silva", "N/C", "", "N/C", "N/C");
		Contato contato4 = new Contato(0, "Ruan", "Danilo", "rruandanilodacosta@br.inter.net", "(61) 3912-4012", "N/C", "N/C");
		Contato contato5 = new Contato(0, "Daniela", "Fatima", "danielafatimadeborajesus_@superig.com.br", "(61) 3702-6292", "N/C", "N/C");
	
		contatoRepository.saveAll(Arrays.asList(contato1,contato2, contato3, contato4, contato5));
	}

}
