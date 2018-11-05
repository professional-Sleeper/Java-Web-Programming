package com.scsa.jadv.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class EmpMgrImpl implements IEmpMgr {

	private ArrayList<Employee> emps = new ArrayList<Employee>();

	private static EmpMgrImpl instance = new EmpMgrImpl();

	public static EmpMgrImpl getInstance() {
		return instance;
	}

	public EmpMgrImpl() {

	}

	@Override
	public Employee search(int empNo) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		for (Employee e : emps) {
			if (e.getEmpNo() == empNo) {
				return e;
			}
		}
		throw new RecordNotFoundException(empNo + "는 없는 번호입니다.");
	}

	@Override
	public void add(Employee e) throws DuplicateException {
		// TODO Auto-generated method stub
		for (Employee temp : emps) {
			if (temp.getEmpNo() == e.getEmpNo()) {
				return;
			}
		}
		emps.add(e);
	}

	@Override
	public ArrayList<Employee> getList() {
		// TODO Auto-generated method stub
		return emps;
	}

	@Override
	public void update(Employee e) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		for (Employee emp : emps) {
			if (emp.getEmpNo() == e.getEmpNo()) {
				emp.setName(e.getName());
				emp.setDivision(e.getDivision());
				emp.setPosition(e.getPosition());
				return;
			}
		}
		throw new RecordNotFoundException(e.getEmpNo() + "는 없는 번호입니다.");
	}

	@Override
	public boolean delete(int empNo) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		for (Employee e : emps) {
			if (e.getEmpNo() == empNo) {
				emps.remove(e);
				return true;
			}
		}
		throw new RecordNotFoundException(empNo + "는 없는 번호입니다.");
	}

	@Override
	public ArrayList<Employee> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream in = new FileInputStream(new File(filename));
		ObjectInputStream ois = new ObjectInputStream(in);
		
		int size = ois.readInt();
		for (int i=0; i<size; i++) {
			emps.add((Employee)ois.readObject());
		}
	}

	@Override
	public void save(String filename) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream out = new FileOutputStream(new File(filename));
		ObjectOutputStream oos = new ObjectOutputStream(out);

		oos.writeInt(emps.size());
		for (Employee employee : emps) {
			oos.writeObject(employee);
		}

	}
	
	public void upload() throws UnknownHostException, IOException {
		Socket s = null;
		s = new Socket("70.12.60.53",7777);
		EmpClient ec = new EmpClient(s);
		ec.start();
	}

	@Override
	public void allList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Employee> NameList(String name){
		ArrayList<Employee> temp = new ArrayList<Employee>();
		for (Employee employee : emps) {
			if(employee.getName().equals(name)) {
				temp.add(employee);
			}
		}
		return temp;
	}

}
