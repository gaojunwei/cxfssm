package com.wlsq.oauth.dao;

import java.util.List;

import com.wlsq.oauth.entity.User;

public interface IUserDao {
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param user
	 */
	void insert(User user);
	
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param users
	 */
	void insertAll(List<User> users);
	
	/**
	 * ɾ��,����id, ���������ֵΪnull,ɾ����ʧ��
	 * <br>------------------------------<br>
	 * @param id
	 */
	void deleteById(String id);
	
	/**
	 * ������ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 */
	void delete(User criteriaUser);
	
	/**
	 * ɾ��ȫ��
	 * <br>------------------------------<br>
	 */
	void deleteAll();
	
	/**
	 * �޸�
	 * <br>------------------------------<br>
	 * @param user
	 */
	void updateById(User user);
	
	/**
	 * ���¶���
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @param user
	 */
	void update(User criteriaUser, User user);
	
	/**
	 * ����������ѯ
	 * <br>------------------------------<br>
	 * @param id
	 * @return
	 */
	User findById(String id);
	
	/**
	 * ��ѯȫ��
	 * <br>------------------------------<br>
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * ��������ѯ
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @param skip
	 * @param limit
	 * @return
	 */
	List<User> find(User criteriaUser, int skip, int limit);
	
	/**
	 * ����������ѯ������ ��ȥ�޸�
	 * <br>------------------------------<br>
	 * @param criteriaUser  ��ѯ����
	 * @param updateUser    �޸ĵ�ֵ����
	 * @return
	 */
	User findAndModify(User criteriaUser, User updateUser);
	
	/**
	 * ��ѯ������ ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @return
	 */
	User findAndRemove(User criteriaUser);
	
	/**
	 * count
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @return
	 */
	long count(User criteriaUser);

}
