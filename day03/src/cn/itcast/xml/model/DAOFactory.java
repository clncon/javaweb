package cn.itcast.xml.model;

public class DAOFactory {
	//单利设计模式
	private static DAOFactory daofactory;
	private DAOFactory(){}
	public static DAOFactory getDAOFactory(){
		if(daofactory == null){
			daofactory = new DAOFactory(); 
			
		}
		return daofactory;
	}
	public IDAO getDAO(String name){
		if(name.equals("DAOJdbc")){
			return (IDAO) new DAOJdbc();
		}
		else if(name.equals("DAOHelibernate")){
			return (IDAO) new DAOHelibernate();
		}
		else
			return null;
	}

}
