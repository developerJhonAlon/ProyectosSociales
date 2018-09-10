/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaDepcenproyFacade extends AbstractFacade<SeaDepcenproy> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaDepcenproyFacade() {
        super(SeaDepcenproy.class);
    }
    public List<SeaDepcenproy> findDepartCentroProy(BigDecimal codPro){
       List<SeaDepcenproy> result = null;
       Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.datgeproyId.datgeproyId =:codPro");
       query.setParameter("codPro", codPro);
       query.setHint("eclipselink.refresh",true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
    }
    public SeaDepcenproy findDeptCentProy(BigDecimal codPro){
       List<SeaDepcenproy> result = null;
       Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.datgeproyId.datgeproyId =:codPro");
       query.setParameter("codPro", codPro);
       query.setHint("eclipselink.refresh",true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaDepcenproy> findDepartCentProyByCodPro(BigDecimal codPro){
       List<SeaDepcenproy> result = null;
       Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.datgeproyId.datgeproyId =:codPro");
       query.setParameter("codPro", codPro);
       query.setHint("eclipselink.refresh",true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
    }
//     public List<SeaDepcenproy> findDepartCentProyByCodPro(BigDecimal codPro){
//       Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.datgeproyId.datgeproyId =:codPro");
//       query.setParameter("codPro", codPro);
//       query.setHint("eclipselink.refresh",true);
//       List<SeaDepcenproy> list = new ArrayList<SeaDepcenproy>();
//       for(int i =0; i< list.size(); i++){
//           list.add(new SeaDepcenproy("Departamento",list[]) );
//       }
//       return  list;

//    }
    public List<SeaDepcenproy> findDepartamentoByCodDep(String codDep){
        List<SeaDepcenproy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.stvsubjCode.stvsubjCode =:codDep AND o.datgeproyId.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_INGRESO_PERFIL + "' AND o.datgeproyId.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ELIMINADO + "'");
        query.setParameter("codDep", codDep);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaDepcenproy> findByCampusDepartamento(String codCampus, String codDepartamento){
        Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.stvcampCode.stvcampCode =:codCampus AND o.stvsubjCode.stvsubjCode =:codDepartamento AND o.datgeproyId.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_INGRESO_PERFIL 
                + "' AND o.datgeproyId.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ELIMINADO 
                + "'");
        query.setParameter("codCampus", codCampus);
        query.setParameter("codDepartamento", codDepartamento);
        query.setHint("eclipselink.refresh",true);
        return (query.getResultList());
    }    
    public SeaDepcenproy findCodigoProyectoByCodResp(BigDecimal codDep){
        List<SeaDepcenproy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDepcenproy o WHERE o.depceId =:codDep");
        query.setParameter("codDep", codDep);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result.get(0);
    }
    public List<SeaSeguimientoFormato> findSeguimientoDepartamentoByCodDep(String codDep){
        List<SeaSeguimientoFormato> result = null;
        Query query = em.createQuery("SELECT s FROM SeaDepcenproy o, SeaFormatoLargo f, SeaSeguimientoFormato s WHERE o.stvsubjCode.stvsubjCode =:codDep AND o.datgeproyId.datgeproyId = f.datgeproyId.datgeproyId AND s.sflId.sflId = f.sflId AND s.ssfeEstado ='T'");
        query.setParameter("codDep", codDep);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
