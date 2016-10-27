package com.wlsq.oauth.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.wlsq.oauth.dao.IUserDao;
import com.wlsq.oauth.dao.support.AbstractBaseMongoTemplete;
import com.wlsq.oauth.entity.User;

public class UserDao extends AbstractBaseMongoTemplete implements IUserDao {
	/**
	 * ����
	 * <br>------------------------------<br>
	 * @param user
	 */ 
	public void insert(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(user);
	}
	/**
	 * ��������
	 * <br>------------------------------<br>
	 * @param users
	 */
	public void insertAll(List<User> users) {
		// TODO Auto-generated method stub
		mongoTemplate.insertAll(users);
	}
	/**
	 * ɾ��,������id, ���������ֵΪnull,ɾ����ʧ��
	 * <br>------------------------------<br>
	 * @param id
	 */
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		User user = new User(id, null, 0);
		mongoTemplate.remove(user);
	}
	/**
	 * ������ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 */
	public void delete(User criteriaUser) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());;
		Query query = new Query(criteria);
		mongoTemplate.remove(query, User.class);
	}
	/**
	 * ɾ��ȫ��
	 * <br>------------------------------<br>
	 */
	public void deleteAll() {
		// TODO Auto-generated method stub
		mongoTemplate.dropCollection(User.class);
	}
	/**
	 * �������޸�,
	 * ����ĵ���û�����key ������ ʹ��$set�޸���
	 * <br>------------------------------<br>
	 * @param user
	 */
	public void updateById(User user) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("id").is(user.getId());
		Query query = new Query(criteria);
		Update update = Update.update("age", user.getAge()).set("name", user.getName());
		mongoTemplate.updateFirst(query, update, User.class);
	}
	/**
	 * �޸Ķ���
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @param user
	 */
	public void update(User criteriaUser, User user) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());;
		Query query = new Query(criteria);
		Update update = Update.update("name", user.getName()).set("age", user.getAge());
		mongoTemplate.updateMulti(query, update, User.class);
	}
	/**
	 * ����������ѯ
	 * <br>------------------------------<br>
	 * @param id
	 * @return
	 */
	public User findById(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, User.class);
	}
	/**
	 * ��ѯȫ��
	 * <br>------------------------------<br>
	 * @return
	 */
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class);
	}
	/**
	 * ��������ѯ, ��ҳ
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @param skip
	 * @param limit
	 * @return
	 */
	public List<User> find(User criteriaUser, int skip, int limit) {
		// TODO Auto-generated method stub
		Query query = getQuery(criteriaUser);
		query.skip(skip);
		query.limit(limit);
		return mongoTemplate.find(query, User.class);
	}
	/**
	 * ����������ѯ������ ��ȥ�޸�
	 * <br>------------------------------<br>
	 * @param criteriaUser  ��ѯ����
	 * @param updateUser    �޸ĵ�ֵ����
	 * @return
	 */
	public User findAndModify(User criteriaUser, User updateUser) {
		// TODO Auto-generated method stub
		Query query = getQuery(criteriaUser);
		Update update = Update.update("age", updateUser.getAge()).set("name", updateUser.getName());
		return mongoTemplate.findAndModify(query, update, User.class);
	}
	/**
	 * ��ѯ������ ɾ��
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @return
	 */
	public User findAndRemove(User criteriaUser) {
		// TODO Auto-generated method stub
		Query query = getQuery(criteriaUser);
		return mongoTemplate.findAndRemove(query, User.class);
	}
	/**
	 * count
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @return
	 */
	public long count(User criteriaUser) {
		// TODO Auto-generated method stub
		Query query = getQuery(criteriaUser);
		return mongoTemplate.count(query, User.class);
	}
	/**
	 *
	 * <br>------------------------------<br>
	 * @param criteriaUser
	 * @return
	 */
	private Query getQuery(User criteriaUser) {
		if (criteriaUser == null) {
			criteriaUser = new User();
		}
		Query query = new Query();
		if (criteriaUser.getId() != null) {
			Criteria criteria = Criteria.where("id").is(criteriaUser.getId());
			query.addCriteria(criteria);
		}
		if (criteriaUser.getAge() > 0) {
			Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());
			query.addCriteria(criteria);
		}
		if (criteriaUser.getName() != null) {
			Criteria criteria = Criteria.where("name").regex("^" + criteriaUser.getName());
			query.addCriteria(criteria);
		}
		return query;
	}

}
