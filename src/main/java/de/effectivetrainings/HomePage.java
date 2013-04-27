package de.effectivetrainings;

import de.effectivetrainings.products.Product;
import de.effectivetrainings.products.ProductProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.inject.Inject;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    @Inject
    ProductProvider provider;

	public HomePage(final PageParameters parameters) {
		super(parameters);
        add(new ListView<Product>("productsList", provider.productList()) {
            @Override
            protected void populateItem(ListItem<Product> item) {
                item.add(new Label("name", new PropertyModel<String>(item.getModel(),"name")));
                item.add(new Label("prize", new PropertyModel<Double>(item.getModel(),"prize")));
            }
        });
    }
}
