package ca.bcit.infosys;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 * Handle CRUD actions for Supplier class.
 *
 * @author blink
 * @version 1.0
 *
 */
@Dependent
@Stateless
public class SupplierController implements Serializable {
    private static final long serialVersionUID = 1L;
    EntityManager em = Resource.getEntityManager();

    /**
     * Find Supplier record from database.
     *
     * @param id primary key of supplier record.
     * @return the Supplier record with key = id, null if not found.
     */
    public Supplier find(int id) {
        return em.find(Supplier.class, id);
    }

    /**
     * Persist Supplier record into database.  id must be unique.
     * @param supplier the record to be persisted.
     */
    public void persist(Supplier supplier) {
        em.persist(supplier);
    }

    /**
     * merge Supplier record fields into existing database record.
     * @param supplier the record to be merged.
     */
    public void merge(Supplier supplier) {
        em.merge(supplier);
    }
    /**
     * Remove supplier from database.
     * @param supplier record to be removed from database
     */
    public void remove(Supplier supplier) {
        //attach supplier
        supplier = find(supplier.getSupplierId());
        em.remove(supplier);
    }

    public void add(Supplier supplier) {
        em.persist(supplier);
    }

    public Supplier get(int id) {
        Query query = em.createNativeQuery("select * from Suppliers where supplierid=:id", Supplier.class);
        query.setParameter("id", id);
        return (Supplier) query.getSingleResult();
    }

    /**
     * Return Suppliers table as array of Supplier.
     * @return Supplier[] of all records in Suppliers table
     */
    public Supplier[] getAll() {
        TypedQuery<Supplier> query = em.createQuery("select s from Supplier s order by supplierid",
                Supplier.class);
        java.util.List<Supplier> suppliers = query.getResultList();
        Supplier[] suparray = new Supplier[suppliers.size()];
        for (int i=0; i < suparray.length; i++) {
            suparray[i] = suppliers.get(i);
        }
        return suparray;
    }

    @SuppressWarnings("unchecked")
    public Supplier[] getSupplierByKeyword(String keyword) {
        Query query = em.createNativeQuery("select * from Suppliers where suppliername like :keyword order by supplierid", Supplier.class);
        query.setParameter("keyword", "%" + keyword + "%");
        List<Supplier> suppliers = query.getResultList();
        Supplier[] suparray = new Supplier[suppliers.size()];
        for (int i = 0; i < suparray.length; i++) {
            suparray[i] = suppliers.get(i);
        }

        return suparray;
    }
}
