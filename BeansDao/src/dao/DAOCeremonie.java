package dao;

import java.util.ArrayList;

import metier.Ceremonie;

public interface DAOCeremonie
{
	public Ceremonie get(int id);
	public ArrayList<Ceremonie> loadAll();
	public void save(Ceremonie c);
	public void delete(Ceremonie c);
	public void update(Ceremonie c);
	public void saveOrUpdate(Ceremonie c);
}
