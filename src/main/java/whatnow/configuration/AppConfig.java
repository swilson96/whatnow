package whatnow.configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class AppConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {
            @Override
            protected void configureServlets() {

                ResourceConfig rc = new PackagesResourceConfig("whatnow.rest");
                for (Class<?> resource : rc.getClasses()) {
                    bind(resource);
                }

                serve("/services/*").with(GuiceContainer.class);

                bind(JacksonJsonProvider.class).in(Singleton.class);
            }
        });
    }
}