package pe.edu.idat.appwebventasidat.controller.backoffice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import pe.edu.idat.appwebventasidat.model.bd.Product;
import pe.edu.idat.appwebventasidat.model.request.ProductRequest;
import pe.edu.idat.appwebventasidat.model.response.ResultadoResponse;
import pe.edu.idat.appwebventasidat.service.ProductService;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("")
    public String frmMantProducto(Model model){
        model.addAttribute("listarproductos", productService.listarProducts());
        return "/backoffice/product/frmProduct";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Product> listarProductos(){
        return productService.listarProducts();
    }

    @PostMapping
    @ResponseBody
    public ResultadoResponse guardarProducto(@RequestBody ProductRequest productRequest){
        return productService.guardarProducto(productRequest);
    }
    
}
