
package controlador;

import conexion.Conexion;
import dao.ProductosDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class ProductoController
{
    static Scanner scn = new Scanner(System.in); 
    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        Producto product = new Producto(0);
        ProductosDAO prodDao  = new ProductosDAO(con);
        
        int option = 0;                
        
        do
        {
            System.out.println("Seleccionar opción a realizar: ");
            System.out.println("1- Agregar Producto");
            System.out.println("2- Editar Producto");
            System.out.println("3- Eliminar Producto");
            System.out.println("4- Mostrar Producto");
            System.out.println("5- Mostrar Producto por Id");
            System.out.println("6- Sair del programa");
            System.out.println("");
            option = scn.nextInt();
            switch(option)
            {
                case 1:
                    Producto modelo = RegistrarProductos();
                    if(prodDao.InsertProducto(modelo))
                    {
                        System.out.println("El producto se agrego correctamente");
                    }
                    else
                    {
                        System.out.println("El producto no pudo ser agregado");
                    }                    
                break;
                case 2:
                    
                    System.out.println("Ingresar id del producto a editar");
                    int IdProd = scn.nextInt();
                    Producto modelo2 = RegistrarProductos();
                    modelo2.setIdProducto(IdProd);
                    if(prodDao.UpdateProducto(modelo2))
                    {
                        System.out.println("El producto se edito correctamente");
                    }
                    else
                    {
                        System.out.println("El producto no pudo ser editado");
                    }   
                break;
                case 3:
                    
                    System.out.println("Ingresar id del producto a eliminar");
                    product.setIdProducto(scn.nextInt());
                    if(prodDao.DeleteProductos(product.getIdProducto()))
                    {
                        System.out.println("El producto se elimino correctamente");
                    }
                    else
                    {
                        System.out.println("El producto no pudo ser eliminado");
                    }   
                break;
                case 4:
                    List<Producto> listaprod =  prodDao.ShowAllProductos();
                    ImprimirProducto(listaprod);
                break;
                case 5:
                    System.out.println("Insertar Id del producto para  filtrar");
                    int IdProducto = scn.nextInt();
                    List<Producto> lista = prodDao.ShowProductosById(IdProducto);
                    ImprimirProducto(lista);
                break;
                case 6:
                    break;
            }
        }while(option != 6);        
        
        System.out.println("Saliendo del sistema....");
        
    }
    
    static Producto RegistrarProductos()
    {
        Producto prod = new Producto(0);
        
        System.out.println("Ingresar nombre del producto: ");
        prod.setNombreProducto(scn.next());
        System.out.println("Ingresar cantidad de producto: ");
        prod.setCantidad(scn.nextInt());
        System.out.println("Ingresar precio de producto");
        prod.setPrecio(scn.nextDouble());
        System.out.println("Ingresar categoria de producto");
        prod.setCategoria(scn.next());
        
        prod.setFechaRegistro(Date.valueOf(LocalDate.now()));
        
        return prod;
    }
    
    static void ImprimirProducto(List<Producto> lista)
    {
        System.out.println("Listado de produtos: \n");
        for(Producto pr : lista)
        {
            System.out.println("Nombre : "+pr.getNombreProducto());
            System.out.println("Cantidad: "+pr.getCantidad());
            System.out.println("Precio: "+pr.getPrecio());
            System.out.println("Fecha de registro: "+pr.getFechaRegistro().toString());
            System.out.println("Categoria: "+pr.getCategoria());
        }
    }
           
}

