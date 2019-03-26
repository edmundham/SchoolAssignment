package ca.bcit.infosys;


/**
 * Product which has fields indicating it is editable or to be deleted.
 * @author blink
 * @version 1
 */
public class EditableSupplier {
    /** Indicates associated product can be edited on a form.*/
    private boolean editable = false;

    /** Holds product to be displayed, edited or deleted.*/
    private Supplier supplier;

    /**
     * Convenience constructor.
     * @param supplier product to be displayed, edited or deleted.
     */
    public EditableSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Returns true if associated product is editable.
     * @return the editable state
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Set whether associated product is editable.
     * @param editable the state of editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the product
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the product to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
