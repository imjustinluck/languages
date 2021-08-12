package com.jda.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jda.languages.models.LanguageModel;

public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {

	List<LanguageModel> findAll();
	
}
