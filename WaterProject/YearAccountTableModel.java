//import static EntityTableModel;

public class YearAccountTableModel extends EntityTableModel<YearAccount> {
	public final Attribute<String> DATE =
			new MutableAttribute<>("Date", String.class, YearAccount::getDate, YearAccount::setDate);

	public final Attribute<Integer> ACCOUNT = 
			new MutableAttribute<>("Account", Integer.class, YearAccount::getAccount, YearAccount::setAccount);

	public final Attribute<Float> GALLONS = 
			new MutableAttribute<>("Gallons", Float.class, YearAccount::getGallons, YearAccount::setGallons);

	public final Attribute<Float> COST = 
			new MutableAttribute<>("Cost", Float.class, YearAccount::getCost, YearAccount::setCost);

	public YearAccountTableModel() {
		setColumns(DATE, ACCOUNT, GALLONS, COST);
	}
}