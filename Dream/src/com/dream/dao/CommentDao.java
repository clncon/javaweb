package com.dream.dao;
import java.util.List;
import com.dream.entity.Comment;

/**
 * ���۵Ľӿ�
 * 
 * @author ��� 2016-3-3����9:42:22
 */
public interface CommentDao {

	/**
	 * �������
	 * 
	 * @param comment
	 * @return ״̬
	 */
	public void add(Comment comment);

	/**
	 * �޸�����
	 * 
	 * @param comment
	 * @return ״̬
	 */
	public void update(Comment comment);

	/**
	 * ɾ������
	 * 
	 * @param comment
	 * @return ״̬
	 */
	public void delete(Comment comment);

	/**
	 * ��ѯ����
	 * 
	 * @return �����б�
	 */
	public List<Comment> search();

	/**
	 * ��ѯ���۶���
	 * 
	 * @param cId
	 * @return ���۶���
	 */
	public Comment search(Integer cId);

	/**
	 * ��ҳ��ѯ���۶��� ��ϼ
	 * 
	 * @param cGname
	 * @param pageNo
	 * @param pageSize
	 * @return ���۶���
	 */
	public List<Comment> searchPage_Comment(Comment comm, Integer pageNo,
			Integer pageSize);

	/**
	 * ��¼���� ��ϼ
	 * 
	 * @return ��¼����
	 */
	public Integer searchCommentCount();

	/**
	 * ���� ������Ʒ���ֲ�ѯ����
	 * 
	 * @return
	 */
	public List<Comment> searchBygName(String cGname);

	/**
	 * ��¼���� ��ϼ
	 * 
	 * @return ��¼����
	 */
	public Integer searchCommentCount(Comment comm);
}
