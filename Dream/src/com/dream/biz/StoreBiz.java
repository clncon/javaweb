package com.dream.biz;

import java.util.List;

import com.dream.entity.Store;

/**
 * 
 * @author 晓风 2016-3-8下午2:12:53
 */
public interface StoreBiz {

	/**
	 * 增加店面
	 */
	public void add(Store store);

	/**
	 * 删除店面
	 */
	public void delete(int sid);

	/**
	 * 更改店面信息
	 * 
	 * @param store
	 */
	public void update(Store store);

	/**
	 * ' 查询所有店面信息
	 * 
	 * @return
	 */
	public List<Store> search();

	/**
	 * 查询一个店面里面的所有信息
	 * 
	 * @return
	 */
	public Store searchStore(int sid);

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Store> searchPage_Store(Integer pageNo, Integer pageSize);

	/**
	 * 记录总数
	 * 
	 * @return
	 */
	public Integer searchStoreCount();

	/**
	 * 汪晓风 根据店主ID查询店面信息
	 * 
	 * @param sUid
	 * @return
	 */
	public Store searchStoreBySuid(Integer sUid);
}
