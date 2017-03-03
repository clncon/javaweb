package com.dream.dao;
import java.util.List;
import com.dream.entity.Repertory;
import com.dream.entity.view.Regost;

/**
 * 库存接口
 * 
 * @author 葛睿 2016-3-4上午10:42:38
 */
public interface RepertoryDao {
	/**
	 * 多表查詢信息
	 * 
	 * @return
	 */
	public List<Regost> search();

	/**
	 * 多表条件查询
	 */
	public List<Regost> search(Regost regost);

	/**
	 * 陈霞 分页查询
	 */
	public List<Regost> searchPage_Repertory(Regost regost, Integer pageNo,
			Integer pageSize);

	/**
	 * 陈霞 记录总数
	 */
	public Integer searchRepertoryCount(Regost regost);

	/**
	 * 查询礼品的数量
	 * @param regost
	 * @return
	 */
	public Integer searchGiftCount(Regost regost);

	/**
	 * 林兴鹏 根据商品id进行联表查询
	 * 
	 * @param gid
	 * @return
	 */
	public Regost searchBygId(Integer gid);

	/**
	 * 小平 多表查询礼品
	 * 
	 * @param regost
	 * @return
	 */
	public List<Regost> searchGift(Regost regost);

	/**
	 * 陈霞 多表分页查询礼品
	 * 
	 * @param regost
	 * @return
	 */
	public List<Regost> searchGift(Regost regost, Integer pageNo,
			Integer pageSize);

	/**
	 * 陈霞 添加库存
	 */
	public void addRepertory(Repertory re);

	/**
	 * 陈霞 删除库存
	 */
	public void deletRepertory(Repertory re);

}
