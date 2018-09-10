package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(LocalizacionPrograma.class)
public class LocalizacionPrograma_ { 

    public static volatile SingularAttribute<LocalizacionPrograma, BigDecimal> id;
    public static volatile SingularAttribute<LocalizacionPrograma, Programa> programa;
    public static volatile SingularAttribute<LocalizacionPrograma, String> objetivos;
    public static volatile SingularAttribute<LocalizacionPrograma, SeaParroquia> parroquia;
    public static volatile SingularAttribute<LocalizacionPrograma, SeaCanton> canton;
    public static volatile SingularAttribute<LocalizacionPrograma, Proyecto> proyecto;
    public static volatile SingularAttribute<LocalizacionPrograma, SeaProvincia> provincia;

}