//package facades;
//
//import entities.RenameMe;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class GroupMemberFacade
//{
//
//    private static CarFacade instance;
//    private static EntityManagerFactory emf;
//
//    //Private Constructor to ensure Singleton
//    private GroupMemberFacade()
//    {
//    }
//
//    public static CarFacade getCarFacade(EntityManagerFactory _emf)
//    {
//        if (instance == null)
//        {
//            emf = _emf;
//            instance = new CarFacade();
//        }
//        return instance;
//    }
//
//    private EntityManager getEntityManager()
//    {
//        return emf.createEntityManager();
//    }
//
//    public long getCarCount()
//    {
//        EntityManager em = emf.createEntityManager();
//        try
//        {
//            long carCount = (long) em.createQuery("SELECT COUNT(c) FROM Car c").getSingleResult();
//            return carCount;
//        }
//        finally
//        {
//            em.close();
//        }
//
//    }
//
//    
//    //TODO Remove/Change this before use
//    public long getRenameMeCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{  
//            em.close();
//        }
//        
//    }
//
//}
