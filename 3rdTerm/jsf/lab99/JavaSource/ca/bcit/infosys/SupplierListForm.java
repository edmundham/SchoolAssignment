package ca.bcit.infosys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Helper class for display Product page.
 * @author blink
 *@version 1
 */
@Named
@ConversationScoped
public class SupplierListForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /** Manager from Product objects.*/
    @Inject private SupplierController supplierController;

    @Inject Conversation conversation;

    @Inject private Supplier toBeAddedSupplier;
    private String searchQuery;
    private List<EditableSupplier> list;

    @PreDestroy
    public void preDestroy() {
        if (conversation != null) {
            conversation.end();
        }
    }

    @PostConstruct
    public void postConstruct() {
        conversation.begin();
    }

    /**
     * Returns array of EditableProducts that match the selected category.
     * @return list of editable products
     */
    public List<EditableSupplier> getList() {
        if (list == null) {
            if (searchQuery == null || searchQuery.isEmpty()) {
                list = refreshList();
            } else {
                list = refreshListBySearchKeyword();
            }
        }
        return list;
    }

    private List<EditableSupplier> refreshList() {
        Supplier[] suppliers = supplierController.getAll();
        List<EditableSupplier> tempList = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            tempList.add(new EditableSupplier(supplier));
        }
        return tempList;
    }

    private List<EditableSupplier> refreshListBySearchKeyword() {
        Supplier[] suppliers = supplierController.getSupplierByKeyword(searchQuery);
        List<EditableSupplier> tempList = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            tempList.add(new EditableSupplier(supplier));
        }
        return tempList;
    }

    public  void setList(List<EditableSupplier> ep) {
        list = ep;
    }

    public Supplier getToBeAddedSupplier() {
        return toBeAddedSupplier;
    }

    public void setToBeAddedSupplier(Supplier toBeAddedSupplier) {
        this.toBeAddedSupplier = toBeAddedSupplier;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    /**
     * Delete the product and return to the same page.
     * @param e the product to be deleted
     * @return Navigation string
     */
    public String deleteRow(EditableSupplier e) {
        supplierController.remove(e.getSupplier());
        list.remove(e);
        return "index?faces-redirect=true";
    }

    public String save() {
        for (EditableSupplier e : list) {
            if (e.isEditable()) {
                supplierController.merge(e.getSupplier());
                e.setEditable(false);
            }
        }
        return "index?faces-redirect=true";
    }

    public String add() {
        if (conversation == null) {
            conversation.begin();
        }
        for (EditableSupplier e : list) {
            if (e.getSupplier().getSupplierId() == toBeAddedSupplier.getSupplierId()) {
                return null;
            }
        }

        supplierController.add(toBeAddedSupplier);
        list.add(new EditableSupplier(toBeAddedSupplier));
        toBeAddedSupplier = null;
        if (conversation!= null) {
            conversation.end();
        }
        return "index?faces-redirect=true";
    }

    public String search() {
        if (conversation == null) {
            conversation.begin();
        }
        if (list == null) {
            if (searchQuery == null || searchQuery.isEmpty()) {
                list = refreshList();
            } else {
                list = refreshListBySearchKeyword();
            }
        }
        if (conversation!= null) {
            conversation.end();
        }
        return null;
    }
}
