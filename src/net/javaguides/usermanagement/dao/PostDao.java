package net.javaguides.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.usermanagement.model.Post;
import net.javaguides.usermanagement.utl.HibernateUtil;

public class PostDao {
	
	/**
	 * Save Post
	 * @param post
	 */
	public void savePost(Post post) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(post);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Post
	 * @param post
	 */
	public void updatePost(Post post) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(post);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Post
	 * @param id
	 */
	public void deletePost(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Post post = session.get(Post.class, id);
			if (post != null) {
				session.delete(post);
				System.out.println("post is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Post By ID
	 * @param id
	 * @return
	 */
	public Post getPost(int id) {

		Transaction transaction = null;
		Post post = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			post = session.get(Post.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return post;
	}
	
	/**
	 * Get all Users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts() {

		Transaction transaction = null;
		List<Post> listOfPost = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfPost = session.createQuery("from Post").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfPost;
	}
}
