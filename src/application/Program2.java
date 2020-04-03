package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test: 1, Department insert ===");

		Department dep = new Department(null, "Estoque");
		departmentDao.insert(dep);

		System.out.println("done! create department id :" + dep.getId());

		System.out.println("=== Test: 2, Department update ===");

		Department obj = new Department(null, null);
		obj.setId(10);
		obj.setName("Drugstore");
		departmentDao.update(obj);

		System.out.println("ok update department! ");

		System.out.println("=== Test: 3, Department findById ===");
		obj = departmentDao.findById(3);
		System.out.println(obj);

		System.out.println("=== Test: 4, Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}

		System.out.println("=== Test: 5, Department deleteById ===");
		departmentDao.deletebyId(9);
		System.out.println("Deleted !");

	}
}
