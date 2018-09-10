package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ObjetivoEstrategico.class)
public class ObjetivoEstrategico_ { 

    public static volatile SingularAttribute<ObjetivoEstrategico, Integer> id;
    public static volatile ListAttribute<ObjetivoEstrategico, ObjetivoEstrategico> objetivoEstrategicoHijoList;
    public static volatile SingularAttribute<ObjetivoEstrategico, Integer> tipo;
    public static volatile SingularAttribute<ObjetivoEstrategico, String> descripcion;
    public static volatile SingularAttribute<ObjetivoEstrategico, ObjetivoEstrategico> objetivoEstrategicoPadre;

}