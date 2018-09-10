package ec.edu.espe_ctt.saturno.entity;

import ec.edu.espe_ctt.saturno.entity.Sfrstcr;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:18:56")
@StaticMetamodel(Stvrsts.class)
public class Stvrsts_ { 

    public static volatile SingularAttribute<Stvrsts, String> stvrstsSystemReqInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsVoiceType;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsAttemptHrInd;
    public static volatile SingularAttribute<Stvrsts, Date> stvrstsActivityDate;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsInclSectEnrl;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsExtensionInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsCode;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsSbPrintInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsInclTmstInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsWaitInd;
    public static volatile ListAttribute<Stvrsts, Sfrstcr> sfrstcrList;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsEnterableInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsDesc;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsGradableInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsWithdrawInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsInclAssess;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsWebInd;
    public static volatile SingularAttribute<Stvrsts, String> stvrstsAutoGrade;

}