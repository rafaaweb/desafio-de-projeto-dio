package one.digitalinnovation.gof.controller;



import one.digitalinnovation.gof.model.Categoria;
import one.digitalinnovation.gof.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("categoria")
public class CategoriaRestController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Iterable<Categoria>> buscarTodos() {
        return ResponseEntity.ok(categoriaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
        categoriaService.inserir(categoria);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoriaService.atualizar(id, categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
