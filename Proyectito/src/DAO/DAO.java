package DAO;

public interface DAO<T> {
	//CRUD CASERO
	public boolean insertCSV(T t);
	public boolean deleteCSV(String header1,String value1, String Header2, String Value2);
	public boolean updateCSV(T t);
	public void createCSV();
	public T getFromCSV(String header1,String value1, String Header2, String Value2);
} 
