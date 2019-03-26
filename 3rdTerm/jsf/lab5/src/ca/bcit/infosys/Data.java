package ca.bcit.infosys;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Named
@ApplicationScoped
public class Data {

    private static final AtomicLong counter = new AtomicLong();
    private static final Logger LOGGER = Logger.getLogger(Data.class.getName());

    private Customer customerToBeEdited;

    private List<Customer> customerList = addCustomerList();

    private List<Customer> addCustomerList() {
        List<Customer> tempCustomerList = new ArrayList<>();
        tempCustomerList.add(new Customer(counter.incrementAndGet(), "Rajiv", "Pauli","","213 Erstwild Court", "Apt 30", "Sunnyvale", "CA","94086", "408-789-8075", "rp@rpuli.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(), "Carole", "Sandler","S","785 Geary St","", "San Francisco", "CA","94117", "415-822-1289", "cs@sandler.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(), "Philip", "Currie","","654 Poplar", "Apt 50", "Wahsington", "CA","94303", "415-328-4543", "pc@pCurrie.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(), "Tony", "Higgins", "H","East Shopping Cntr.", "422 Bay Road", "Altanta","GA", "94026", "415-368-1100", "th@tHiggins.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(), "Rio","Vector","","1899 La Loma Drive","","Los Altos","CA","94022","415-776-3249","rv@rvictor.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Erick","Watson","","1143 Carver Place","","Mountain View","CA","94063","415-389-8789","ew@ewaston.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Charles","Ream","","41 Jordan Avenue","","Palo Alto","CA","94304","415-356-9876","cr@cReam.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Donald","Duck","","587 Alvarado","","Redwood City","CA","94063","415-544-8729","dd@dDuck.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Ray","Miller","","Mayfair Mart","7345 Ross Blvd.","San Diego","CA","94086","408-723-8789","rm@rmiller.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Ray","Jaguar","F","520 Topaz Way","","Redwood City","CA","94062","415-743-3611","rj@rjaguar.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Francis","Keyes","","3199 Sterling Court","","Sunnyvale","CA","94085","408-277-7245","fk@fKeyes.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Margaret","Rosenthal","","234 Wyandotte Way","","Los Altos","CA","94022","415-887-7235","mr@mRosenthal.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Betty","Beatty","","654 Oak Grove","","Menlo Park","CA","94025","415-356-9982","bb@bbeatty.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Frank","Albertson","","947 Waverly Place","","Cleveland","OH","94062","415-886-6677","fa@Albertson.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Alfred","Greenspan","G","776 Gary Avenue","","Denver","CO","94025","415-356-1123","ag@agreenspan.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Ariana","Parmelee","","1104 Spinosa Drive","","Mountain View","CA","94040","415-534-8822","ap@Parmelee.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Arnold","Ken","","850 Lytton Court","","Dulles","VA","94063","415-245-4578","ak@aKen.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Richard","Baxter","","5427 College","","Oakland","CA","94609","415-655-0011","rb@rBaxter.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Bob","Shorter","","2405 Kings Highway","","Cherry Hill","NJ","08002","609-663-6079","rw@rShorter.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Robert","Willcock","","6627 N. 17th Way","","Milwaukee","WI","85016","602-265-8754","rw@rWillcock.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Jay","Wallack","","Lake Biltmore Mall","","Newark","DE","19898","302-366-7511","jw@jwallack.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Catherine","Jones","","543 Nassau Street","","Princeton","NJ","08540","609-342-0054","cb@cbrian.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Mario","Hanion","","10100 Bay Meadows Ro","Suite 120","Jacksonville","FL","32256","904-823-4239","mh@mHanion.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Chris","Patania","D","4715 S.E. Adams Blvd","Apt T1","Bartlesville","OK","74006","918-355-2074","cp@cpatania.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Johney","Henry","","1450 Commonwealth Av","","Brighton","MA","02135","617-232-4159","jh@jHenry.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Eleen","Neelie","","2539 South Utica Str","","Denver","CO","80219","303-936-7731","en@eNeelie.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Kid","Satifer","","Blue Island Square","","Hampton","VA","60406","312-944-5691","ks@kSatifer.com"));
        tempCustomerList.add(new Customer(counter.incrementAndGet(),"Frank","Little","","Athletic Department","","Baltimore","MD","85008","602-533-1817","fk@fLittle.com"));
        return tempCustomerList;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public String addOneCustomer(Customer customer) {
        try {
            this.customerList.add(new Customer(counter.incrementAndGet(), customer.getFirstName(), customer.getLastName(),
                    customer.getMiddleName(), customer.getFirstAddress(), customer.getSecondAddress(), customer.getCity(),
                    customer.getState(), customer.getZipCode(), customer.getPhone(), customer.getEmail()));
        } catch (Exception e) {
            LOGGER.warning(e.toString());
        }
        return "index?faces-redirect=true";
    }

    public String editOneCustomer() {
        return "index?faces-redirect=true";
    }

    public String editButton(Customer customer) {
        setCustomerToBeEdited(customer);
        return "editCustomer?faces-redirect=true";
    }

    public Customer getCustomerToBeEdited() {
        return customerToBeEdited;
    }

    public void setCustomerToBeEdited(Customer customerToBeEdited) {
        this.customerToBeEdited = customerToBeEdited;
    }
}
