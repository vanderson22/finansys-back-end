package br.com.home.finansys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.finansys.entities.Category;
import br.com.home.finansys.service.CategoryService;

@RestController()
@RequestMapping("/api/categories")
@CrossOrigin()
/*
 * @Api(tags = "Categoria")
 */
public class CategoriaControlador {
	//
	// @Autowired
	// private CategoriaServico service;

	@Autowired
	private CategoryService service;

	// @ApiOperation(code = 200, value = "Listar-Categoria", notes = "Lista todas as
	// categorias existentes na aplicação Gestão Vendas", consumes =
	// "application/json", produces = "application/json", httpMethod = "GET", tags =
	// "Categoria")
	@GetMapping
	public List<Category> listarTodas() {
		return service.findAll();

	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);

	}
}
