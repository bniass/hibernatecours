package cours.lpgl;

import cours.lpgl.model.Service;
import cours.lpgl.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSession();
        Transaction t = session.getTransaction();
        Service s = new Service();
        s.setLibelle("ORL");
        try {
            t.begin();
            session.save(s);
            t.commit();
        }catch (Exception e){
            t.rollback();
            e.printStackTrace();
        }
    }
}
