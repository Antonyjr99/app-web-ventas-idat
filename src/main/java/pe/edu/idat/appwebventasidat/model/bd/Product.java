package pe.edu.idat.appwebventasidat.model.bd;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "quantityperunit")
    private String quantityperunit;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "unitsinstock")
    private Integer unitsinstock;
    @Column(name = "unitsonnoroder")
    private Integer unitsonnoroder;
    @Column(name = "reorderlevel")
    private Integer reorderlevel;
    @Column(name = "discontinued")
    private Boolean discontinued;

    @ManyToOne
    @JoinColumn(name = "suplierid")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    
}
