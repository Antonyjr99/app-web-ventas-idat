package pe.edu.idat.appwebventasidat.controller.backoffice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.service.SupplierService;

@Controller
@RequestMapping("/backoffice/supplier")
public class SupplierController {

    private SupplierService supplierService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Supplier> listarProvedores(){
        return supplierService.listarProvedores();
    }
    
}
