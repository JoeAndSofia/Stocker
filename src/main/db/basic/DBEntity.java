package main.db.basic;

import java.util.List;
import java.util.Map;

public class DBEntity {
	
	public long id; 
	
	public boolean insert() throws Exception{
		
		return false;
	};
	
	public boolean delete() throws Exception{
		
		return false;
	};
	
	public boolean update() throws Exception{
		
		return false;
	};
	
	public static int update(List<DBEntity> list) throws Exception{
		
		return 0;
	}
	
	public DBEntity detail(long id) throws Exception{
		
		return null;
	};
	
	public static List<DBEntity> list() throws Exception{
		
		return null;
	};
	
	public static List<DBEntity> list(Map<String, Object> params) throws Exception{
		
		return null;
	};
}
