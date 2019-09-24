import com.sun.org.apache.bcel.internal.classfile.Attribute;

//import static EntityTableModel;

public class MonthTableModel extends EntityTableModel<Month> {
    public final Attribute<String> DATE = 
        new MutableAttribute<>("Service From", String.class, Month::getDate, Month::setDate);
    public final Attribute<Float> GALLONS = 
        new MutableAttribute<>("Gallons", Float.class, Month::getGallons, Month::setGallons);
    public final Attribute<Float> COST = 
        new MutableAttribute<>("Cost", Float.class, Month::getCost, Month::setCost);

    public MonthTableModel() {
        setColumns(DATE, GALLONS, COST);
    }
}