/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio.service;

import com.mycompany.servicio.Asistencia;
import com.mycompany.servicio.AsistenciaPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author rodrigo
 * @author LuisMaldonado
 */
@Stateless
@Path("asistencia")
public class AsistenciaFacadeREST extends AbstractFacade<Asistencia> {

    @PersistenceContext(unitName = "com.mycompany_Servicio_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private AsistenciaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;fecha=fechaValue;cIEmpleado=cIEmpleadoValue;iDEstado=iDEstadoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.servicio.AsistenciaPK key = new com.mycompany.servicio.AsistenciaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> fecha = map.get("fecha");
        if (fecha != null && !fecha.isEmpty()) {
            key.setFecha(new java.util.Date(fecha.get(0)));
        }
        java.util.List<String> cIEmpleado = map.get("cIEmpleado");
        if (cIEmpleado != null && !cIEmpleado.isEmpty()) {
            key.setCIEmpleado(new java.lang.Integer(cIEmpleado.get(0)));
        }
        java.util.List<String> iDEstado = map.get("iDEstado");
        if (iDEstado != null && !iDEstado.isEmpty()) {
            key.setIDEstado(new java.lang.Integer(iDEstado.get(0)));
        }
        return key;
    }

    public AsistenciaFacadeREST() {
        super(Asistencia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Asistencia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Asistencia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.servicio.AsistenciaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Asistencia find(@PathParam("id") PathSegment id) {
        com.mycompany.servicio.AsistenciaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Asistencia> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Asistencia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
