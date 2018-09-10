package ec.edu.espe_ctt.saturno.entity;

import ec.edu.espe_ctt.saturno.entity.Sfrstcr;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:18:56")
@StaticMetamodel(Stvcamp.class)
public class Stvcamp_ { 

    public static volatile SingularAttribute<Stvcamp, String> stvcampDicdCode;
    public static volatile ListAttribute<Stvcamp, Sfrstcr> sfrstcrList;
    public static volatile SingularAttribute<Stvcamp, Date> stvcampActivityDate;
    public static volatile SingularAttribute<Stvcamp, String> stvcampDesc;
    public static volatile SingularAttribute<Stvcamp, String> stvcampCode;

}