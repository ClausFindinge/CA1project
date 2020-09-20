package facades;

import entities.Joke;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian
 */
public class JokeFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;

    static private int numberOfDummies = 5;
   Joke joke = new Joke("plat", "Hvorfor kan man ikke købe Zoo? Den er for dyr", 6, "Handler om dyr");
    Joke joke2 = new Joke("fin", "Hvorfor kan man ikke købe Zoo? Den er for dyr", 6, "Handler om dyr");

    public JokeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3306/jokes_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = JokeFacade.getJokeFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = JokeFacade.getJokeFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
    }

  
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();

            
            em.persist(joke);
            em.persist(joke2);

//             what to commit
            em.getTransaction().commit();
        } // must allways close transations. 
        finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    
    }

    @Test
    public void findJokeId() {
        long id = 5;
        System.out.println("FindGroupMemberbyId");
        Joke joken1 = facade.findJoke(numberOfDummies);
        Joke expected = (joken1 == joke) ? joke : joke2;
        assertEquals(expected, facade.findJoke(numberOfDummies), "Expects 2 rows in the database");
        System.out.println("expected: " + expected + " Was: " + facade.findJoke(numberOfDummies));
    }

}