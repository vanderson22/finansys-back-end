package br.com.home.finansys.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.finansys.entities.Entry;

public interface EntryRepository  extends   JpaRepository<Entry , Long>  {

   public Optional<Entry> findEntryByName(String string);

    
}
