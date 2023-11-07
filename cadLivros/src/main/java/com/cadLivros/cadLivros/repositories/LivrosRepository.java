package com.cadLivros.cadLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadLivros.cadLivros.entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long> {

}
