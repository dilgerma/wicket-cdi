package de.effectivetrainings;

import org.apache.wicket.cdi.CdiConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.jboss.weld.environment.servlet.Listener;

import javax.enterprise.inject.spi.BeanManager;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see de.effectivetrainings.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
        initCDI();
	}

    private void initCDI(){
        BeanManager manager = (BeanManager)getServletContext().getAttribute(
            Listener.BEAN_MANAGER_ATTRIBUTE_NAME);
        new CdiConfiguration(manager).configure(this);
    }
}
