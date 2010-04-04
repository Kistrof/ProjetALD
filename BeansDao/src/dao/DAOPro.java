package dao;

import java.util.ArrayList;

import metier.Pro;

public interface DAOPro
{
	public Pro get(int id);
	public ArrayList<Pro> loadAll();
	public void save(Pro p);
	public void delete(Pro p);
	public void update(Pro p);
	public void saveOrUpdate(Pro p);
}
