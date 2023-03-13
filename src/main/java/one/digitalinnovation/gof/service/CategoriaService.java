package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Categoria;


public interface CategoriaService {

    Iterable<Categoria> buscarTodos();

    Categoria buscarPorId(Long id);

    void inserir(Categoria categoria);

    void atualizar(Long id, Categoria categoria);

    void deletar(Long id);

}
