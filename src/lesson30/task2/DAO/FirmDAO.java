package lesson30.task2.DAO;

import lesson30.task2.Firm;

import java.util.Collection;
import java.util.Date;

public class FirmDAO {

    public static void fillFirm() {
        Firm firm = new Firm(new Date(), DepartmentDAO.getDepartments(), CustomerDAO.getCustomers());
    }
}
