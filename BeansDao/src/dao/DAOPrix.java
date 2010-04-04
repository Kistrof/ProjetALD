package dao;

import java.util.ArrayList;

import metier.Prix;

public interface DAOPrix
{
	public Prix get(int id);
	public ArrayList<Prix> loadAll();
	public void save(Prix obj);
	public void delete(Prix obj);
	public void update(Prix obj);
	public void saveOrUpdate(Prix obj);
}
