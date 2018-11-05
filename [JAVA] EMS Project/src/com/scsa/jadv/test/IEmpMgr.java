package com.scsa.jadv.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public interface IEmpMgr {
	public void load(String filename) throws IOException,ClassNotFoundException;
	public void save(String filename) throws IOException;
	public Employee search(int empNo) throws RecordNotFoundException;
	public void add(Employee e) throws DuplicateException;
	public void allList();
	public ArrayList<Employee> getList();
	public void update(Employee e) throws RecordNotFoundException;
	public boolean delete(int empNo) throws RecordNotFoundException;
	public ArrayList<Employee> search(String name);
	public Employee getEmployee(int index);
	public void upload() throws UnknownHostException, IOException;
	public ArrayList<Employee> NameList(String name);
}
