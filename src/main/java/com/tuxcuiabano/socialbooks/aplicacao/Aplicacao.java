package com.tuxcuiabano.socialbooks.aplicacao;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.tuxcuiabano.socialbooks.client.LivrosClient;
import com.tuxcuiabano.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) throws ParseException {
		
LivrosClient cliente = new LivrosClient("http://localhost:8080", "tux", "tux");

List<Livro> listaLivros = cliente.listar();
		
		for(Livro livro : listaLivros) {
			System.out.println("Livro: "+ livro.getNome());
			
			
		}
		
		Livro livro = new Livro();
		livro.setNome("Novo Pega Pega");
		livro.setEditora("Tux Records");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("19/09/1999"));
		livro.setResumo("Livro Maravilindo");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do Livro: " + localizacao);
		
		
		Livro livroBuscado = cliente.buscar(localizacao);
		
		System.out.println("Livro buscado: " + livroBuscado.getNome());
		
		
	}
	
	


}
