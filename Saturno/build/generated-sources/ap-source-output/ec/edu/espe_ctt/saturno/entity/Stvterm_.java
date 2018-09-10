package ec.edu.espe_ctt.saturno.entity;

import ec.edu.espe_ctt.saturno.entity.Sfrstcr;
import ec.edu.espe_ctt.saturno.entity.Sobterm;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:18:56")
@StaticMetamodel(Stvterm.class)
public class Stvterm_ { 

    public static volatile SingularAttribute<Stvterm, String> stvtermCode;
    public static volatile SingularAttribute<Stvterm, String> stvtermDesc;
    public static volatile SingularAttribute<Stvterm, Date> stvtermHousingEndDate;
    public static volatile SingularAttribute<Stvterm, Short> stvtermFaEndPeriod;
    public static volatile SingularAttribute<Stvterm, String> stvtermAcyrCode;
    public static volatile SingularAttribute<Stvterm, String> stvtermTrmtCode;
    public static volatile SingularAttribute<Stvterm, Short> stvtermFaPeriod;
    public static volatile SingularAttribute<Stvterm, Date> stvtermStartDate;
    public static volatile SingularAttribute<Stvterm, String> stvtermFaProcYr;
    public static volatile ListAttribute<Stvterm, Sfrstcr> sfrstcrList;
    public static volatile SingularAttribute<Stvterm, Sobterm> sobterm;
    public static volatile SingularAttribute<Stvterm, Date> stvtermEndDate;
    public static volatile SingularAttribute<Stvterm, Date> stvtermHousingStartDate;
    public static volatile SingularAttribute<Stvterm, String> stvtermFaTerm;
    public static volatile SingularAttribute<Stvterm, Date> stvtermActivityDate;
    public static volatile SingularAttribute<Stvterm, String> stvtermSystemReqInd;

}