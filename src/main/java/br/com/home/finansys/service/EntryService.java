package br.com.home.finansys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.home.finansys.entities.Entry;
import br.com.home.finansys.repositories.EntryRepository;

@Service
public class EntryService {

    @Autowired
    private EntryRepository repository;

    public List<Entry> findAll() {

        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Entry findById(Long id) {

        Optional<Entry> opt = repository.findById(id);
        return opt.orElseThrow(() -> new RuntimeException("Lançamento não encontrada"));
    }

    public Entry create(Entry Entry) {
        validateEntry(Entry);
        return repository.save(Entry);
    }

    /**
     * 
     * Realiza validação da Lançamento 
     * 
    */
    private void validateEntry(Entry Entry) {
        if (Entry == null)
            throw new RuntimeException("Lançamento não pode ser nula");
        if (Entry.getName().equals("") || Entry.getName() == null)
            throw new RuntimeException("O nome da cateogria não pode ser nula");
            
        Optional<Entry> opt = repository.findEntryByName(Entry.getName());
        if (opt.isPresent() && Entry.getId() == null )
            throw new RuntimeException("Lançamento já existe");
            // se presente e os id's forem diferentes, não inserir
        if (opt.isPresent()   && ( Entry.getId() != null &&  !Entry.getId().equals(opt.get().getId())) )
            throw new RuntimeException("O identificador já existe para outra Lançamento");
    }

    public void update(Entry Entry, Long id) {
            validateEntryUpdate(Entry, id);
            repository.save(Entry);
    }

    private void validateEntryUpdate(Entry Entry, Long id) {
        if (Entry.getId() == null || id == null)
            throw new RuntimeException("Lançamento não pode ser nula");
 
        Entry EntryFind = findById(id);
        //copiar tudo exceto name e description
        BeanUtils.copyProperties(Entry, EntryFind, "id");

    }

}
