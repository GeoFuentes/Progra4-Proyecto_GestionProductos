
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Producto;

public class ProductosDAO 
{
    Conexion con;
    
    public ProductosDAO(Conexion con)
    {
        this.con = con;
    }
    
    public boolean InsertProducto(Producto prod)
    {
        String sql = "insert into productos values (?,?,?,?,?,?)";
        try
        {
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ps.setInt(1, prod.getIdProducto());
            ps.setString(2, prod.getNombreProducto());
            ps.setInt(3, prod.getCantidad());
            ps.setDouble(4, prod.getPrecio());
            ps.setDate(5, prod.getFechaRegistro());
            ps.setString(6, prod.getCategoria());
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public List<Producto> ShowAllProductos()
    {
        String sql = "select * from productos";
        try
        {
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Producto> lista = new LinkedList<>();
            Producto prod;
            
            while(rs.next())
            {
                prod = new Producto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setFechaRegistro(rs.getDate("fechaRegistro"));
                prod.setCategoria(rs.getString("categoria"));                
                lista.add(prod);                
            }
            
            return lista;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean UpdateProducto(Producto prod)
    {
        String sql = "update productos set nombreProducto=?, cantidad=?,precio =?,fechaRegistro=?,categoria=? where idProducto=? ";
        try
        {
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ps.setString(1, prod.getNombreProducto());
            ps.setInt(2, prod.getCantidad());
            ps.setDouble(3, prod.getPrecio());
            ps.setDate(4, prod.getFechaRegistro());
            ps.setString(5, prod.getCategoria());
            ps.setInt(6, prod.getIdProducto());
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean DeleteProductos(int IdProducto)
    {
        String sql = "delete from productos where idProducto=?";
        try
        {
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ps.setInt(1, IdProducto);
            ps.executeUpdate();
            
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public List<Producto> ShowProductosById(int IdPersona)
    {
        String sql = "select * from productos where idProducto=?";
        try
        {
            
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ps.setInt(1, IdPersona);
            ResultSet rs = ps.executeQuery();
            List<Producto> lista = new LinkedList<>();
            Producto prod;
            
            while(rs.next())
            {
                prod = new Producto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setCantidad(rs.getInt("cantidad"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setFechaRegistro(rs.getDate("fechaRegistro"));
                prod.setCategoria(rs.getString("categoria"));                
                lista.add(prod);                
            }
            
            return lista;
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
