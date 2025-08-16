package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Especificação dos tipos utilizados para CRUD com os métodos de CrudRepository
 */
public interface ThemeRepository extends CrudRepository<Tema, Long> { }
