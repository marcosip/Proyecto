package services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * http://localhost:8080/Proyecto/webservice/<entidad>
 *
 * @author usuario0305
 */
@javax.ws.rs.ApplicationPath("webservice")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.AlumnosResource.class);
        resources.add(services.EjerciciosResource.class);
        resources.add(services.MonitoresResource.class);
        resources.add(services.TablasResource.class);
    }

}
