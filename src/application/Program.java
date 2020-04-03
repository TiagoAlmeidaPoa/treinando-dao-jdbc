package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Test 2: Seler findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep);
		for (Seller seller2 : listSeller) {
			System.out.println("Seller: " + seller2.getName() + ", Department: " + seller2.getDepartment().getId());
		}

		System.out.println("\n=== Test 3: Seller findAll ===");
		List<Seller> listSellerAll = sellerDao.findAll();
		for (Seller seller2 : listSellerAll) {
			System.out.println("Seller: " + seller2.getName() + ", Department: " + seller2.getDepartment().getId());
		}

		System.out.println("\n=== Test 4: Seller insert ===");
		Department NewDep = new Department(1, null);
		Seller sellerInsert = new Seller(null, "Douglas", "doug@gmail.com", sdf.parse("09/07/1990"), 1500.0, NewDep);
		sellerDao.insert(sellerInsert);

		if (sellerInsert.getId() == null) {
			System.out.println("fall seller no inserted !");
		} else {
			System.out.println("done! inserted id: " + sellerInsert.getId());
		}

		DB.closeConnection();
	}
}
