package ca.bcit.infosys;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/suppliers")
public class SupplierService {

    @Inject
    private EntityManager em;
    @javax.annotation.Resource
    private UserTransaction ut;

    public SupplierService() {

    }

    @javax.transaction.Transactional
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Supplier createSupplier(Supplier supplier) {

        System.out.println(supplier);
        em = Resource.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(supplier);
            em.flush();
            em.getTransaction().commit();

        } catch (Throwable e) {
            System.err.println(e);
        }
        System.out.println("Created supplier " + supplier.getSupplierId());
        return supplier;
    }

    @GET
    @Produces("application/json")
    public List<Supplier> getAllSupplier() {
        System.out.println("called");
        List<Supplier> customers = getAll();
        if (customers == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return customers;
    }

//    @GET
//    @Path("{name}")
//    @Produces("application/json")
//    public Supplier[] getSupplier(@PathParam("name") String name) {
////        Supplier[] customers = supplierController.getSupplierByKeyword(name);
//        if (customers == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
//        }
//        return customers;
//    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void updateCustomer(@PathParam("id") int id, Supplier update) {
        em = Resource.getEntityManager();
        Supplier current = em.find(Supplier.class, id);
        if (current == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);

        current.setSupplierName(update.getSupplierName());
        current.setContactName(update.getContactName());
        current.setContactTitle(update.getContactTitle());
        current.setAddress(update.getAddress());
        current.setPostalCode(update.getPostalCode());
        current.setStateOrProvince(update.getStateOrProvince());
        current.setCountry(update.getCountry());
        current.setPhoneNumber(update.getPhoneNumber());
        current.setFaxNumber(update.getFaxNumber());
        current.setPaymentTerms(update.getPaymentTerms());
        current.setEmailAddress(update.getEmailAddress());
        current.setNotes(update.getNotes());

        em.getTransaction().begin();
        em.merge(current);
        em.flush();
        em.getTransaction().commit();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Supplier getOneCustomer(@PathParam("id") int id) {
        em = Resource.getEntityManager();
        Supplier current = em.find(Supplier.class, id);
        return current;
    }

    public List<Supplier> getAll() {
        em = Resource.getEntityManager();
        TypedQuery<Supplier> query = em.createQuery("select s from Supplier s order by supplierid",
                Supplier.class);
        System.out.println("allgood");
        java.util.List<Supplier> suppliers = query.getResultList();
        return suppliers;
    }

    public void add(Supplier supplier) {

    }
}
