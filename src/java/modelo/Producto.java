
package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Producto {
    private int IdProducto;
    private String NombreProducto;
    private int Cantidad;
    private double Precio;
    private Date fechaRegistro;
    private String Categoria;
    
    public Producto(int id)
    {
        this.IdProducto = id;
    }
    
    public void setIdProducto(int idProducto)
    {
        this.IdProducto = idProducto;
    }
    
    public int getIdProducto()
    {
        return IdProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getPrecio() {
        return Precio;
    }        
    
}
