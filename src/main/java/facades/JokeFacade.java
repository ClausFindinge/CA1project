package facades;

import dto.CarDTO;
import dto.JokeDTO;
import entities.Joke;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class JokeFacade
{

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade()
    {
    }

    public static JokeFacade getCarFacade(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public long getCarCount()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            long carCount = (long) em.createQuery("SELECT COUNT(c) FROM Car c").getSingleResult();
            return carCount;
        }
        finally
        {
            em.close();
        }

    }

    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }}

//    List<JokeDTO> getAllJokes(){
//        TypedQuery<JokeDTO> query = emf.createQuery("SELECT p FROM Point p", JokeDTO.class);
//        List<JokeDTO> results = query.getResultList();
//        for (JokeDTO j : results) {
//          results.add(new JokeDTO(j));
//        }
//             return results;
//        }
//        catch (Exception ex)
//        {
//            System.out.println("getAllJokes not found");
//            return null;
//        }
//        finally
//        {
//            emf.close();
//        }
//       
//
//    }

