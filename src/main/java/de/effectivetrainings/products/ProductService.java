package de.effectivetrainings.products;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

/**
 * @author Martin Dilger
 * @since: 27.04.13
 */
@ApplicationScoped
public class ProductService {

    public void order(@Observes Product product){
        System.out.println("Produkt " + product.getName() + " bestellt");
    }
}
