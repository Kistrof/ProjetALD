package dao;

import java.util.ArrayList;

import metier.PersonneTemp;

public interface DAOPersonneTemp
{
	public PersonneTemp get(int id);
	public ArrayList<PersonneTemp> loadAll();
	public void save(PersonneTemp obj);
	public void delete(PersonneTemp obj);
	public void update(PersonneTemp obj);
	public void saveOrUpdate(PersonneTemp obj);
}
