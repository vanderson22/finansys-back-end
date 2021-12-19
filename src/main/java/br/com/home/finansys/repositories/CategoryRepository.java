package br.com.home.finansys.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.finansys.entities.Category;

public interface CategoryRepository  extends   JpaRepository<Category , Long>  {

   public Optional<Category> findCategoryByName(String string);

    
}
