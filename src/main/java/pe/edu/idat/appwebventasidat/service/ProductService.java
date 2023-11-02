package pe.edu.idat.appwebventasidat.service;


import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.edu.idat.appwebventasidat.model.bd.Category;
import pe.edu.idat.appwebventasidat.model.bd.Product;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.model.request.ProductRequest;
import pe.edu.idat.appwebventasidat.model.response.ResultadoResponse;
import pe.edu.idat.appwebventasidat.repository.ProductRepository;


@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> listarProducts(){
        return productRepository.findAll();
    }

    public ResultadoResponse guardarProducto(ProductRequest productRequest){
        
        String mensaje = "Producto registrado correctacmente";
        Boolean respuesta = true;
        try{

            Product product = new Product();
            if(productRequest.getProductid() > 0){
                product.setProductoid(productRequest.getCategoryid());
            }
            
            product.setProductname(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            Boolean discontinued = false;
            if(productRequest.getDiscontinued() !=null){
                discontinued=true;
            }

        
            product.setDiscontinued(discontinued);
            Category category = new Category();
            category.setCateroryid(productRequest.getCategoryid());
            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());
            product.setCategory(category);
            product.setSupplier(supplier);
            productRepository.save(product);

        }catch(Exception ex){
            mensaje = "Producto no registrado";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
