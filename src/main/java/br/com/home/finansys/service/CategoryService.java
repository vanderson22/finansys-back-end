package br.com.home.finansys.service;

import java.util.List;
import java.util.Optional;

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

    public Category findById(Long id) {

        Optional<Category> opt = repository.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Category create(Category category) {
        validateCategory(category);
        return repository.save(category);
    }

    /**
     * 
     * Realiza validação da categoria 
     * 
    */
    private void validateCategory(Category category) {
        if (category == null)
            throw new RuntimeException("Categoria não pode ser nula");
        if (category.getName().equals("") || category.getName() == null)
            throw new RuntimeException("O nome da cateogria não pode ser nula");
            
        Optional<Category> opt = repository.findCategoryByName(category.getName());
        if (opt.isPresent() && category.getId() == null )
            throw new RuntimeException("Categoria já existe");
            // se presente e os id's forem diferentes, não inserir
        if (opt.isPresent()   && ( category.getId() != null &&  !category.getId().equals(opt.get().getId())) )
            throw new RuntimeException("O identificador já existe para outra categoria");
    }

}
