package com.dream.dao;
import java.util.List;
import com.dream.entity.Activity;
import com.dream.entity.view.AcGoods;

/**
 * 活动的接口
 * 
 * @author 小平 2016-3-11上午10:55:44
 */
public interface ActivityDao {
	/**
	 * 增加活动
	 * 
	 * @param ac
	 */
	public void add(Activity ac);

	/**
	 * 删除活动
	 * 
	 * @param aId
	 */
	public void delete(int aId);

	/**
	 * 根据aGid删除活动
	 */
	public void deleteByaGid(int aGid);

	/**
	 * 更改活动
	 * 
	 * @param ac
	 */
	public void update(Activity ac);

	/**
	 * 查询活动
	 * 
	 * @param aId
	 * @return
	 */
	public AcGoods searchById(int aId);

	/**
	 * 查询所有活动
	 * 
	 * @return
	 */
	public List<AcGoods> search();

	/**
	 * 根据活动日期查询
	 * 
	 * @param adata
	 * @return
	 */
	public List<AcGoods> searchByadate(String adate);

	/**
	 * 分页根据日期查询所有活动
	 * 
	 * @return
	 */
	public List<AcGoods> searchPage(String adate, Integer pageNo,
			Integer pageSize);

	/**
	 * 分页根据日期查询所有记录数
	 * 
	 * @return
	 */
	public Integer searchCount(String adate);

}
