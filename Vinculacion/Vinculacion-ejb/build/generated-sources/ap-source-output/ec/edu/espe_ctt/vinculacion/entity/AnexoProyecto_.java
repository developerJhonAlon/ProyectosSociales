package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(AnexoProyecto.class)
public class AnexoProyecto_ { 

    public static volatile SingularAttribute<AnexoProyecto, Integer> id;
    public static volatile SingularAttribute<AnexoProyecto, Programa> programa;
    public static volatile SingularAttribute<AnexoProyecto, Date> fechaSubida;
    public static volatile SingularAttribute<AnexoProyecto, SegUsuario> usuario;
    public static volatile SingularAttribute<AnexoProyecto, Integer> tipo;
    public static volatile SingularAttribute<AnexoProyecto, String> archivoUrl;
    public static volatile SingularAttribute<AnexoProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<AnexoProyecto, String> archivoNombre;

}