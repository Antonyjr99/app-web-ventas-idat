package pe.edu.idat.appwebventasidat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.edu.idat.appwebventasidat.model.bd.Category;
import pe.edu.idat.appwebventasidat.repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> listarcategorias(){
        return categoryRepository.findAll();
    }
    
}
