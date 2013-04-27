package de.effectivetrainings;

import de.effectivetrainings.products.Product;
import de.effectivetrainings.products.ProductsLoadableDetachableModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    @Inject
    private Event<Product> productEvent;

	public HomePage(final PageParameters parameters) {
		super(parameters);


        ListView<Product> listView = new ListView<Product>("productsList", new ProductsLoadableDetachableModel()) {
            @Override
            protected void populateItem(ListItem<Product> item) {
                Form<Product> form = new Form<Product>("form", item.getModel()){
                    @Override
                    protected void onSubmit() {
                        super.onSubmit();
                        productEvent.fire(getModelObject());
                    }
                };
                item.add(form);
                form.add(new Label("name", new PropertyModel<String>(item.getModel(), "name")));
                form.add(new Label("prize", new PropertyModel<Double>(item.getModel(), "prize")));
            }
        };
        listView.setReuseItems(true);
        add(listView);
    }
}
