
package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ArticuloServiceImpl implements ArticuloService{
     @Autowired
    private ArticuloDao articuloDao;
    @Override
    public List<Articulo> getAllArticulos(boolean activos) {
      var lista= (List<Articulo>)articuloDao.findAll();
      if(activos){
      lista.removeIf(e->!e.isActivo());
      }
      return lista;
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
    return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    public void save(Articulo articulo) {
      articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
       articuloDao.delete(articulo);
    }
    
}
