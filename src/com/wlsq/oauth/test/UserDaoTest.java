package com.wlsq.oauth.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wlsq.oauth.dao.IUserDao;
import com.wlsq.oauth.entity.User;

public class UserDaoTest {
	/**
	 * ���� 
	 * <br>------------------------------<br>
	 */
	@Test
	public void testInsert() {
		getUserDao().insert(new User(null, "testUser", 21));
	}
	
	/**
	 * �������� 
	 * <br>------------------------------<br>
	 */
	@Test
	public void testInsertAll() {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			list.add(new User(null, "testUser" + i, 21 + i));
		}
		getUserDao().insertAll(list);
	}
	
	/**
	 * ��������ɾ�� 
	 * <br>------------------------------<br>
	 */
	@Test
	public void testDeleteById() {
		String id = "5058184ec85607e42c4bfad8";
		getUserDao().deleteById(id);
	}
	
	/**
	 * ����ɾ�� 
	 * <br>------------------------------<br>
	 */
	@Test
	public void testDelete() {
		//ɾ���������25��
		getUserDao().delete(new User(null, null, 25));
	}
	
	/**
	 * ɾ��ȫ��
	 * <br>------------------------------<br>
	 */
	@Test
	public void testDeleteAll() {
		getUserDao().deleteAll();
	}
	
	/**
	 * �޸�  ����id�޸�
	 * <br>------------------------------<br>
	 */
	@Test
	public void testUpdateById() {
		getUserDao().updateById(new User("50581c08c856346f02e9842c", "����", 100));
	}
	
	/**
	 * �޸Ķ��
	 * <br>------------------------------<br>
	 */
	@Test
	public void update() {
		//�޸��������29��� ����Ϊ�����塰
		User criteriaUser = new User(null, null, 29);
		User user = new User(null, "����", 39);
		getUserDao().update(criteriaUser, user);
	}
	
	/**
	 * ��������ѯ, ��������� ����null
	 * <br>------------------------------<br>
	 */
	@Test
	public void testFindById() {
		User user = getUserDao().findById("50581c08c856346f02e98425");
		print(user);
	}
	
	/**
	 * ��ѯȫ��
	 * <br>------------------------------<br>
	 */
	@Test
	public void testFindAll() {
		List<User> list = getUserDao().findAll();
		print(list);
	}
	
	/**
	 * ��������ѯ
	 * <br>------------------------------<br>
	 */
	@Test
	public void testFind() {
		//��ѯ25�����ϵ�, ��ҳ
		User criteriaUser = new User(null, null, 20);
		List<User> list = getUserDao().find(criteriaUser, 1, 10);
		print(list);
	}
	
	/**
	 * ��ѯ������  �޸�
	 * <br>------------------------------<br>
	 */
	@Test
	public void testFindAndModify() {
		User criteriaUser = new User("50581c08c856346f02e9842d", null, 0);
		User updateUser = new User(null, "����", 100);
		updateUser = getUserDao().findAndModify(criteriaUser, updateUser);
		print(updateUser);
	}
	
	/**
	 * ��ѯ������ ɾ��
	 * <br>------------------------------<br>
	 */
	@Test
	public void testFindAndRemove() {
		User criteriaUser = new User("50581c08c856346f02e9842d", null, 0);
		criteriaUser = getUserDao().findAndRemove(criteriaUser);
		print(criteriaUser);
	}
	
	/**
	 * count
	 * <br>------------------------------<br>
	 */
	@Test
	public void testCount() {
		User criteriaUser = new User(null, "test", 0);
		long count = getUserDao().count(criteriaUser);
		print(count);
	}
	
	public void print(Object object) {
		if (object == null || !(object instanceof Collection)) {
			System.out.println(object);
			return;
		}
		List<?> list = (List<?>) object;
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	
	public IUserDao getUserDao() {
		String configLocations = "spring/spring-mongodb.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocations);
		IUserDao userDao = applicationContext.getBean("userDao", IUserDao.class);
		return userDao;
	}

}
