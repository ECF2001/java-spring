package com.project.demo.logic.entity.categoria;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.demo.logic.entity.producto.Producto;
import jakarta.persistence.*;
import java.util.List;

@Table(name = "categoria")
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripción;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Producto> productos;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripción() { return descripción; }

    public void setDescripción(String descripción) { this.descripción = descripción; }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }
}
