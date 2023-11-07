package com.cadLivros.cadLivros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadLivros.cadLivros.entities.Livros;
import com.cadLivros.cadLivros.repositories.LivrosRepository;

@Service
public class LivrosService {
	
	private final LivrosRepository livrosRepository;
	
	@Autowired
	public LivrosService(LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;

	}

	public Livros saveLivros(Livros livros) {
		return livrosRepository.save(livros);
	}

	public List<Livros> getAllLivros() {
		return livrosRepository.findAll();
	}

	public Livros getLivrosById(Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
	
	public void deleteLivros(Long id) {
		livrosRepository.deleteById(id);
	}
	
	public Livros updateLivros(Long id, Livros novoLivros) {
		Optional<Livros> livrosOptional = livrosRepository.findById(id);
		if (livrosOptional.isPresent()) {
			Livros livrosExistente = livrosOptional.get();
			livrosExistente.setDescricao(novoLivros.getDescricao());
			livrosExistente.setIsbn(novoLivros.getIsbn());
			return livrosRepository.save(livrosExistente);
		} else {
			return null;
		}
	}
}
