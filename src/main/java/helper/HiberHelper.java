package helper;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HiberHelper {
	Configuration cfg;
	SessionFactory sf;
	Session s;
	Transaction tx;
	public void hiberConfigure() {
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf= cfg.buildSessionFactory();
	}
	public void insertData(Object o) {
		s=sf.openSession();
		tx=s.beginTransaction();
		s.save(o);
		tx.commit();
	}
	public void updateData(Object o) {
		s= sf.openSession();
		tx=s.beginTransaction();
		s.update(o);
		tx.commit();
	}
	public void deleteData(Class c,String id) {
		s= sf.openSession();
		tx=s.beginTransaction();
		s.delete(findData(c,id));
		tx.commit();
		s.close();
	}
	public List getData(String query)
	   {
		   s = sf.openSession();
		   return s.createQuery(query).list();
		  
	   }
	
	   public Object findData(Class c,String u)
	   {
		   s = sf.openSession();
		   return s.get(c,u);  
	   }
	   
	public List loginData(String sq,String u,int p) {
		s=sf.openSession();
		Query q=s.createQuery(sq);
		q.setString(0,u);
		q.setInteger(1,p);
		return q.list();
		
	}
	public List loginData1(String sq,String u,int p,int ss) {
		s=sf.openSession();
		Query q=s.createQuery(sq);
		q.setString(0,u);
		q.setInteger(1,p);
		q.setInteger(2, ss);
		return q.list();
		
	}



}
