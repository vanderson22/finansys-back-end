package br.com.home.finansys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.home.finansys.entities.Category;
import br.com.home.finansys.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
