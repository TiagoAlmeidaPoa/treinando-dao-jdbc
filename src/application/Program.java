package application;

import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: Department findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(dep);
		for (Seller seller2 : listSeller) {
			System.out.println(seller2.getName()+","+seller2.getDepartment().getName());
		}
		
		DB.closeConnection();

	}
}
