package br.com.home.finansys.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.finansys.entities.Entry;
import br.com.home.finansys.service.EntryService;

@RestController()
@RequestMapping("/api/entries")
@CrossOrigin()
/*
 * @Api(tags = "Entry")
 */
public class EntryController {
	//
	// @Autowired
	// private EntryServico service;

	@Autowired
	private EntryService service;

	// @ApiOperation(code = 200, value = "Listar-Entry", notes = "Lista todas as
	// Entrys existentes na aplicação Gestão Vendas", consumes =
	// "application/json", produces = "application/json", httpMethod = "GET", tags =
	// "Entry")
	@GetMapping
	public List<Entry> listarTodas() {
		return service.findAll();

	}

	@PostMapping
	public ResponseEntity<Entry> criar(@RequestBody(required = true) Entry entry) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entry));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody(required = true) Entry entry,
			@PathVariable(name = "id") Long id) {

		service.update(entry, id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Entry> findById(@PathVariable(name = "id") Long id) {

		Entry entry = service.findById(id);
		return ResponseEntity.ok().body(entry);
	}
}
