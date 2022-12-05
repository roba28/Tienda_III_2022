
package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaServiceImpl implements CategoriaService{
     @Autowired
    private CategoriaDao categoriaDao;
    @Override
    public List<Categoria> getAllCategorias(boolean activos) {
      var lista= (List<Categoria>)categoriaDao.findAll();
      if(activos){
      lista.removeIf(e->!e.isActivo());
      }
      return lista;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
    return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
      categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
       categoriaDao.delete(categoria);
    }
    
}
