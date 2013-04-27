package de.effectivetrainings.products;

import org.apache.wicket.cdi.CdiContainer;
import org.apache.wicket.model.AbstractReadOnlyModel;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Martin Dilger
 * @since: 27.04.13
 */
public class ProductsLoadableDetachableModel extends AbstractReadOnlyModel<List<Product>> {

    @Inject
    List<Product> productList;

    public ProductsLoadableDetachableModel() {
        CdiContainer.get().getNonContextualManager().inject(this);
    }

    @Override
    public List<Product> getObject() {
        return productList;
    }
}
