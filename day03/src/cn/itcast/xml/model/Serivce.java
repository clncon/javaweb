package cn.itcast.xml.model;

public class Serivce {
    public void create(){
    	DAOFactory DAOFactory = cn.itcast.xml.model.DAOFactory.getDAOFactory();
    	IDAO idao = DAOFactory.getDAO("DAOHelibernate");
        idao.create();
    }
}
