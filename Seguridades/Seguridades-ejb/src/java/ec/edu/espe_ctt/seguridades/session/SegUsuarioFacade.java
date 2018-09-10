/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.context.RequestContext;


/**
 *
 * @author PC1
 */
@Stateless
public class SegUsuarioFacade extends AbstractFacade<SegUsuario> {

    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuarioFacade() {
        super(SegUsuario.class);
    }

    public String validaUsuario(String codCC, String clave) {
        System.out.println(" valida usuario " + codCC + clave);
        BigDecimal cont;
        cont = (BigDecimal) em.createNativeQuery("select count(*) from SEG_USUARIO where USU_CC = ?").setParameter(1, codCC).getSingleResult();
        if (cont.equals(BigDecimal.ZERO)) {
            cont = null;
            System.out.println(" Usuario no autorizado para ingresar al sistema. Antes debe obtener una Cuenta.");
            RequestContext.getCurrentInstance().execute("alert('Usuario no autorizado para ingresar al sistema. Antes debe obtener una Cuenta.')");
            return "Usuario no autorizado para ingresar al sistema. Antes debe obtener una Cuenta.";
        } else {
            Query q = em.createNativeQuery("select count(*) from SEG_USUARIO where USU_CC = ? and USU_CLAVE = (select pack_seguridades.encrypt_ssn (?) from dual)"); 
            q.setParameter(1, codCC);
            q.setParameter(2, clave);
            cont = (BigDecimal) q.getSingleResult();
            if (cont.equals(BigDecimal.ZERO)) {
                cont = null;
                System.out.println("Clave Incorrecta. Verifique si esta utilizando mayúsculas o minúsculas en su teclado !");
                RequestContext.getCurrentInstance().execute("alert('Clave Incorrecta. Verifique si esta utilizando mayúsculas o minúsculas en su teclado !')");
                return "Clave Incorrecta. Verifique si esta utilizando mayúsculas o minúsculas en su teclado !";
            }
            cont = null;
            return null;
        }
    }
    private String mensajeError;

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    public SegUsuario validarUsuario(String codCC, String clave) {
        System.out.println("valida usuario " + codCC + clave);
        SegUsuario usr= findByCedula(codCC);
        if (usr==null) {
            System.out.println("Usuario/Clave incorrectos");
            mensajeError= "Usuario/Clave incorrectos";
            return null;
        } else {
//            Query q = em.createNativeQuery("select count(*) from SEG_USUARIO where USU_CC = ? and USU_CLAVE = (select pack_seguridades.encrypt_ssn (?) from dual)"); 
          Query q = em.createNativeQuery("select count(*) from SISEAC.SEG_USUARIO where USU_CC = ?"); 
            q.setParameter(1, codCC);
//            q.setParameter(2, clave);
            BigDecimal cont = (BigDecimal) q.getSingleResult();
            if (cont.equals(BigDecimal.ZERO)) {
                System.out.println("Usuario/Clave incorrectos");
                mensajeError= "Usuario/Clave incorrectos";
                return null;
            }
            return usr;
        }
    }
    public SegUsuario findByCedula(String cedula) {
        System.out.println(" la ceduala es ssss " + cedula);
        List<SegUsuario> l = em.createQuery("select object(o) from SegUsuario as o where o.usuCc =:cedula").setParameter("cedula", cedula).setHint("eclipselink.refresh", true).getResultList();
        if (!l.isEmpty()) {
            System.out.println("Encontro segUsuario");
            return (SegUsuario) l.get(0);
        } else {
            System.out.println("No Encontro segUsuario");
            return null;
        }
    }
    
    
    public List<SegUsuario> findPepito(String apellido){
        Query pepito;
        List<SegUsuario> pepinList;
        
        pepito = em.createQuery("select u from SegUsuario as u where u.usuApellidos like :x")
                .setHint("eclipselink.refresh", true)
                .setParameter("x","%" + apellido + "%");
        
        pepinList =pepito.getResultList();
        
        
        
        return pepinList;
        
    }

    public String findEstadoByCedula(String cedula) {
        return (String) em.createQuery("select o.usuEstado from SegUsuario as o where o.usuCc =:cedula").setParameter("cedula", cedula).setHint("eclipselink.refresh", true).getSingleResult();
    }

    public List<SegUsuario> findEsTudiantesByName(String nombres) {
        System.out.println("nombres " + nombres);
        List<SegUsuario> lstUsu;
//        nombres="";
        StringBuilder sb = new StringBuilder("select u from SegUsuario as u where  ");
//        em.createQuery("select u from SegUsuario as u where concat(u.usuApellidos,' ', u.usuNombres) like :nombres ");

        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 80 ");
        } else {
            sb.append(" CONCAT (UPPER (u.usuApellidos), ' ', UPPER(u.usuNombres)) like :nombres ");
        }

        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString());
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", "%" + nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;
    }

    public List<SegUsuario> findExternosByName(String nombres) {
        System.out.println("nombres " + nombres);
        List<SegUsuario> lstUsu;
        StringBuilder sb = new StringBuilder("select u from SegUsuario as u where ");
        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 80 ");
        } else {
            sb.append(" CONCAT (UPPER(u.usuApellidos), ' ', UPPER(u.usuNombres)) like :nombres AND SUBSTRING(u.spridenId,1,6)='INVEXT' ");
        }
        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", "%" + nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;
    }

    public List<SegUsuario> findMiembrosExternoByName(String nombres) {
        System.out.println("nombres " + nombres);
        List<SegUsuario> lstUsu;
        StringBuilder sb = new StringBuilder("select u from SegUsuario as u where ");
        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 80 ");
        } else {
            sb.append(" CONCAT (UPPER (u.usuApellidos), ' ', UPPER(u.usuNombres)) like :nombres AND SUBSTRING(u.spridenId,1,1)='M' ");
        }

        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        if (!nombres.isEmpty()) {
            result.setParameter("nombres","%" + nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;

    }

    public List<SegUsuario> findParesExternoByName(String nombres) {
        List<SegUsuario> lstUsu;
        StringBuilder sb = new StringBuilder("select u from SegUsuario as u where ");
        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 80 ");
        } else {
            sb.append(" CONCAT (UPPER (u.usuApellidos), ' ', UPPER(u.usuNombres)) like :nombres AND SUBSTRING(u.spridenId,1,1)='P' ");
        }

        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", "%" + nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;

    }

   public SegUsuario findEstudianteByCedula(String cedula){
       System.out.println("cedula "+ cedula);
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario as o WHERE o.usuCc =:cedula");
       query.setParameter("cedula", cedula);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
   }
   public SegUsuario findUsuarioExisteByCedula(String cedula){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario as o WHERE o.usuCc =:cedula");
       query.setParameter("cedula", cedula);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
   }
   public SegUsuario findUsuarioByCodUsu(BigDecimal codUsu){
       System.out.println("codUsu " + codUsu);
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE o.usuId =:codUsu");
       query.setParameter("codUsu", codUsu);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
   }
   public List<SegUsuario> findUsuarioOtros(){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE o.spridenId ='OTROS' ORDER BY o.usuCc");
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public SegUsuario findInvstOtrosByCodId(BigDecimal codId){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario as o WHERE o.usuId =:codId");
       query.setParameter("codId", codId);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
   }
   public List<SegUsuario> findUsuarioExternos(){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE  SUBSTRING(o.spridenId,1,1) IN('M','P','I')");
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public List<SegUsuario> findMiembrosExternos(){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE  SUBSTRING(o.spridenId,1,1) ='M'");
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public List<SegUsuario> findParesExternos(){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE  SUBSTRING(o.spridenId,1,1) ='P'");
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public List<SegUsuario> findInvestigadorExterno(){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario o WHERE  SUBSTRING(o.spridenId,1,1) ='I'");
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public void UpdateClaveByIdUsuCodUsu(String usuCc, BigDecimal usuId){
       String sql ="UPDATE SEG_USUARIO SET USU_CLAVE = pack_seguridades.encrypt_ssn (?) WHERE USU_ID = ?"; 
       Query query = em.createNativeQuery(sql);
       query.setParameter(1, usuCc);
       query.setParameter(2, usuId);
       query.executeUpdate();
   }
   public void InsertUsuarioExterno(String usuCc, String usuClave, String usuNombre, String usuApellido,String usuEmail, String usuFechaRegistro, String usuEstado, String spriden_id){
       System.out.println("cedula " + usuCc);
       System.out.println("clave " + usuClave);
       System.out.println("nombres " + usuNombre);
       System.out.println("apellidos " + usuApellido);
       System.out.println("email " + usuEmail);
       System.out.println("estado " + usuEstado);
       System.out.println("fecha " + usuFechaRegistro);
       System.out.println("spri " + spriden_id);
       String sql = "INSERT INTO SEG_USUARIO(USU_CC, USU_CLAVE, USU_NOMBRES, USU_APELLIDOS, USU_EMAIL, USU_FECHAREGISTRO, USU_ESTADO, SPRIDEN_ID)"
       + " VALUES(?,pack_seguridades.encrypt_ssn (?),?,?,?,SYSDATE,?,?)";
       Query query = em.createNativeQuery(sql);
       query.setParameter(1, usuCc);
       query.setParameter(2, usuClave);
       query.setParameter(3, usuNombre);
       query.setParameter(4, usuApellido);
       query.setParameter(5, usuEmail);
       query.setParameter(6, usuEstado);
       query.setParameter(7, spriden_id);
       query.executeUpdate();
   }
   public List<SegUsuario> findUsuarioByidUsu(BigDecimal idUsu){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario as o WHERE o.usuId =:idUsu");
       query.setParameter("idUsu", idUsu);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public SegUsuario findUsuarioByCodId(BigDecimal codId){
       List<SegUsuario> result = null;
       Query query = em.createQuery("SELECT o FROM SegUsuario as o WHERE o.usuId =:codId");
       query.setParameter("codId", codId);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
   }
   
   
   public SegUsuario findByPidm(String pidm) {
        System.out.println("el piden es  " + pidm);

        if (pidm != null) {
            List<SegUsuario> l = em.createQuery("select object(o) from SegUsuario as o where o.spridenPidm=:pidm").setParameter("pidm", new BigDecimal(pidm)).setHint("eclipselink.refresh", true).getResultList();
            if (!l.isEmpty()) {
                return (SegUsuario) l.get(0);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
