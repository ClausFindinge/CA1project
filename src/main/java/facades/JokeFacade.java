package facades;

import dto.CarDTO;
import dto.JokeDTO;
import entities.Joke;
import entities.RenameMe;
import java.util.ArrayList;
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

    public static JokeFacade getJokeFacade(EntityManagerFactory _emf)
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

    public long getJokeCount()
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
        
    }
    
    public Joke addJoke(Joke j) {
EntityManager em = emf.createEntityManager();
try {
      em.getTransaction().begin();
      em.persist(j);
      em.getTransaction().commit();
      return j;
}
        catch (Exception ex)
        {
            System.out.println("Failed to add a joke.");
            return null;
        }
           finally {
            em.close();
        }
    }
    
       public Joke findJoke(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Joke joke = em.find(Joke.class,id);
            return joke;}
            catch (Exception ex)
        {
            System.out.println("No jokes were found.");
            return null;
        
        }finally {
            em.close();
        }}

     
    List<JokeDTO> getAllJokes(){
        EntityManager em = emf.createEntityManager();
        try{
            
        List<JokeDTO> results = new ArrayList<>();
        TypedQuery<Joke> query = em.createQuery("SELECT p FROM Point p", Joke.class);
     
        for (Joke j : query.getResultList()) {
          results.add(new JokeDTO(j));
        }
             return results;
        }
        catch (Exception ex)
        {
            System.out.println("getAllJokes not found");
            return null;
        }
        finally
        {
            emf.close();
        }}   

 public static void main(String[] args) {
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    JokeFacade facade = JokeFacade.getJokeFacade(emf);
    Joke j1 = facade.addJoke(new Joke("sjov", "Hvad er det værste ved at blive fyret fra et jobkontor? Man skal også møde op dagen efter", 9, "Handler om arbejdsmarkedet"));
    Joke j2 = facade.addJoke(new Joke("plat", "Hvorfor kan man ikke købe Zoo? Den er for dyr", 6, "Handler om dyr"));
 

 }


}
       

    

