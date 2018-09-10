package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.DocumentoCompromisoParticipacion;
import ec.edu.espe_ctt.vinculacion.entity.Institucion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(CompromisoParticipacionProyecto.class)
public class CompromisoParticipacionProyecto_ { 

    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> nroBeneficiariosDirectosNinios;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> nroBeneficiariosDirectosMujeres;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, String> tipoOrganizacionOtrosDesc;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> nroBeneficiariosDirectosHombres;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> nroBeneficiariosIndirectos;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, String> descripcionBeneficiarios;
    public static volatile ListAttribute<CompromisoParticipacionProyecto, DocumentoCompromisoParticipacion> documentoList;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> id;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, SeaParametrosDet> tipoOrganizacion;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Institucion> institucion;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, Integer> nroBeneficiariosDirectosDiscapacidad;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, SeaParametrosDet> tipoParticipacion;
    public static volatile SingularAttribute<CompromisoParticipacionProyecto, String> declaracionRepresentante;

}