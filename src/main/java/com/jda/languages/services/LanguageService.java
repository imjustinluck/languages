package com.jda.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jda.languages.models.LanguageModel;
import com.jda.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository repository;
	
	public LanguageService(LanguageRepository repository) {
		this.repository = repository;
	}
	
//	CREATE
	public LanguageModel create(LanguageModel language) {
		return repository.save(language);
	}
	
//	UPDATE
	public LanguageModel update(LanguageModel language) {
		return repository.save(language);
	}
	
//	GET ALL
	public List<LanguageModel> getAll(){
		return repository.findAll();
	}
	
//	READ
	public LanguageModel get(Long id) {
		Optional<LanguageModel> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
//	DELETE
	public void delete(Long id) {
		Optional<LanguageModel> optional = repository.findById(id);
		if(optional.isPresent()) {
            repository.deleteById(id);
        }
	}
}
