/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servicio.service;

import com.mycompany.servicio.EmpleadoCargo;
import com.mycompany.servicio.EmpleadoCargoPK;
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
@Path("empleadocargo")
public class EmpleadoCargoFacadeREST extends AbstractFacade<EmpleadoCargo> {

    @PersistenceContext(unitName = "com.mycompany_Servicio_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private EmpleadoCargoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;fecha=fechaValue;cIEmpleado=cIEmpleadoValue;iDCargo=iDCargoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.mycompany.servicio.EmpleadoCargoPK key = new com.mycompany.servicio.EmpleadoCargoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> fecha = map.get("fecha");
        if (fecha != null && !fecha.isEmpty()) {
            key.setFecha(new java.util.Date(fecha.get(0)));
        }
        java.util.List<String> cIEmpleado = map.get("cIEmpleado");
        if (cIEmpleado != null && !cIEmpleado.isEmpty()) {
            key.setCIEmpleado(new java.lang.Integer(cIEmpleado.get(0)));
        }
        java.util.List<String> iDCargo = map.get("iDCargo");
        if (iDCargo != null && !iDCargo.isEmpty()) {
            key.setIDCargo(new java.lang.Integer(iDCargo.get(0)));
        }
        return key;
    }

    public EmpleadoCargoFacadeREST() {
        super(EmpleadoCargo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EmpleadoCargo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, EmpleadoCargo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.mycompany.servicio.EmpleadoCargoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EmpleadoCargo find(@PathParam("id") PathSegment id) {
        com.mycompany.servicio.EmpleadoCargoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EmpleadoCargo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EmpleadoCargo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
