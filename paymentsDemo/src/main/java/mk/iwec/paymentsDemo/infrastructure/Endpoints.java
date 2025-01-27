package mk.iwec.paymentsDemo.infrastructure;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints {
    public static final String BASE = "/api";
    public static final String USER = BASE + "/users";//we'll see ab this
    public static final String PAYMENT = BASE + "/payments";
    public static final String CUSTOMER = BASE + "/customers";
    public static final String LOCATION = BASE + "/locations";
    public static final String BANK = BASE + "/banks";
    public static final String LOG = BASE + "/logs";
    public static final String TYPE = BASE + "/type";
    public static final String ROLE = BASE + "/role";

}
