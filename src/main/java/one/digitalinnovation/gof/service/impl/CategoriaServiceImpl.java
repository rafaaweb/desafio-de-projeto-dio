package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;

import one.digitalinnovation.gof.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoriaServiceImpl implements CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public Iterable<Categoria> buscarTodos() {

        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        categoria.orElseThrow(() -> new RuntimeException("Categoria Inválida"));
        return categoria.get();
    }

    @Override
    public void inserir(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void atualizar(Long id, Categoria categoria) {

        Optional<Categoria> categoriaBd = categoriaRepository.findById(id);
        if (categoriaBd.isPresent()) {
            categoriaRepository.save(categoria);
        }
    }

    @Override
    public void deletar(Long id) {

        categoriaRepository.deleteById(id);
    }


}
