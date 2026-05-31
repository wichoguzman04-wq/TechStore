package com.TechStore.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.TechStore.models.TechStore;

@Service
public class TechStoreServiceImpl implements ITechStoreService {

    private List<TechStore> lista = null;

    public TechStoreServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<TechStore>();

        try {
            TechStore prod1 = new TechStore();
            prod1.setId(1);
            prod1.setNombre("Laptop Gamer");
            prod1.setDescripcion("Laptop con procesador de última generación");
            prod1.setFecha(sdf.parse("10-05-2026"));
            prod1.setPrecio(1200.0);
            prod1.setDestacado(1);
            prod1.setImagen("laptop.png");

            TechStore prod2 = new TechStore();
            prod2.setId(2);
            prod2.setNombre("Teclado Mecánico");
            prod2.setDescripcion("Teclado RGB con switches azules");
            prod2.setFecha(sdf.parse("10-05-2026"));
            prod2.setPrecio(85.0);
            prod2.setDestacado(1);
            prod2.setImagen("teclado.png");

            TechStore prod3 = new TechStore();
            prod3.setId(3);
            prod3.setNombre("Mouse Inalámbrico");
            prod3.setDescripcion("Mouse ergonómico de alta precisión");
            prod3.setFecha(sdf.parse("10-05-2026"));
            prod3.setPrecio(25.0);
            prod3.setDestacado(0);
            prod3.setImagen("mouse.png");

            lista.add(prod1);
            lista.add(prod2);
            lista.add(prod3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TechStore> buscarTodo() {
        return lista;
    }

    @Override
    public TechStore buscarPorId(Integer id) {
        for (TechStore producto : lista) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public void guardar(TechStore producto) {
        producto.setId(lista.size() + 1);
        lista.add(producto);
    }
}