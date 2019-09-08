package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;

@Repository
public class CommentsRepository {
	
	@PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;
	
	 public Comment createComment(Comment comment) {
	        EntityManager emC = emf.createEntityManager();
	        EntityTransaction transaction = emC.getTransaction();

	        try {
	            transaction.begin();
	            emC.merge(comment);
	            transaction.commit();
	        } catch (Exception e) {
	            transaction.rollback();
	        }
	        return comment;
	    }
	 
	    public List<Comment> getAllComments(int imageId) {
	        EntityManager em = emf.createEntityManager();
	        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.Image.id =" + imageId, Comment.class);
	        List<Comment> resultList = query.getResultList();

	        return resultList;
	    }
	 
	 
	 

}
