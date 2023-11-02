package pe.edu.idat.appwebventasidat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.repository.SupplierRepository;

@Service
@AllArgsConstructor
public class SupplierService {
    
    private SupplierRepository supplierRepository;

    public List<Supplier> listarProvedores(){
        return supplierRepository.findAll();
    }
}
