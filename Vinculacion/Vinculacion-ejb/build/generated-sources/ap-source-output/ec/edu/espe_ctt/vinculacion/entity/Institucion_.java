package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> representanteApellidos;
    public static volatile SingularAttribute<Institucion, String> nombre;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile SingularAttribute<Institucion, String> direccion;
    public static volatile SingularAttribute<Institucion, String> estado;
    public static volatile SingularAttribute<Institucion, SeaParroquia> parroquia;
    public static volatile SingularAttribute<Institucion, String> telefono;
    public static volatile SingularAttribute<Institucion, String> representanteNombres;
    public static volatile SingularAttribute<Institucion, String> representanteCargo;
    public static volatile SingularAttribute<Institucion, String> representanteTelefono;
    public static volatile SingularAttribute<Institucion, String> representanteEmail;

}