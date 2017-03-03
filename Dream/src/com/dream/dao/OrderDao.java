package com.dream.dao;
import java.util.List;
import com.dream.entity.Orders;
import com.dream.entity.view.Orpu;
import com.dream.entity.view.Ougp;

/**
 * �����ӿ�
 * 
 * @author ���� 2016-3-4����10:25:16
 */
public interface OrderDao {

	/**
	 * ���ݶ���״̬���û�ID��ѯ����
	 * 
	 * @param oStatus
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByStatus(String oStatus, Integer uId);

	/**
	 * ���ݶ���ID���¶���״̬
	 * 
	 * @param od
	 */
	public void updateostatusByOid(Orders od);

	/**
	 * �����û�ID��ѯ�û�
	 * 
	 * @param uId
	 * @return
	 */
	public List<Ougp> searchOugpByUid(Integer uId);

	/**
	 * �����µ�ID��ѯ����
	 * 
	 * @param oPid
	 * @return
	 */
	public Orders searchOrder(int oPid);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public List<Orders> search();

	/**
	 * ��Ӷ�����Ϣ
	 * 
	 * @param od
	 */
	public void add(Orders od);

	/**
	 * �޸Ķ�����Ϣ
	 * 
	 * @param od
	 */
	public void update(Orders od);

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param oId
	 */
	public void delete(Integer oId);

	// /**
	// * ���򶩵��û�������Ϣ
	// * @return
	// */
	// public List<Orpuusst> searchOrpuusst();
	/**
	 * ��ѯ���򶩵���Ϣ
	 */
	public List<Orpu> searchOrpu();

	/**
	 * ���ݶ�����Ų�ѯ
	 * 
	 * @param oId
	 * @return
	 */
	public Orders searchByOId(Integer oId);

	/**
	 * ��ҳ
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */

	public List<Orders> searchPage_Orders(Integer pageNo, Integer pageSize);

	/**
	 * ��ѯ����ҳ
	 * 
	 * @return
	 */
	public Integer searchOrdersCount();

	/**
	 * ���� ���� ��Ʒ �û� ��ѯid
	 * 
	 * @param oId
	 * @return
	 */
	public Ougp searchByOid(Integer oId);

	/**
	 * ���� ���� ��Ʒ �û� ��ѯ
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp();

	/**
	 * ���� ���� ��Ʒ �û� oid��ѯ
	 * 
	 * @param oId
	 * @return
	 */
	public Ougp searchById(Integer oId);

	// /**
	// * ���� ���� ��Ʒ �û� ��ҳ��ѯ
	// * @return
	// */
	// public List<Ougp> searchOugp(Integer pageNo, Integer pageSize);
	// /**
	// * ��¼��
	// * @return
	// */
	// public Integer searchAllOugpCount() ;
	/**
	 * ���� ���� ��Ʒ �û� ��ҳ��ѯ
	 * 
	 * @return
	 */
	public List<Ougp> searchOugp(Ougp ougp, Integer pageNo, Integer pageSize);

	/**
	 * ��¼��
	 * 
	 * @return
	 */
	public Integer searchAllOugpCount(Ougp ougp);

	/**
	 * ��Ӷ���
	 * 
	 * @param orders
	 */
	public void addOrders(Orders orders);
}
