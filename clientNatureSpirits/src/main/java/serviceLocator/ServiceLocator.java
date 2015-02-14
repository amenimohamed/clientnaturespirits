package serviceLocator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ServiceLocator {

	private Context context;
	/**
	 *  le cache sous forme de map, on va récupérer l'objet et le string le nom
	 */
	private Map<String,Object> cache;
	/**
	 * implémenter un design patter singleton, instanciation du service locator, 
	 * on le met static parce qu'on va 	l'utiliser dans une méthode statique
	 */
	private static ServiceLocator instance;
	/**
	 * constructeur privé
	 */
	private ServiceLocator() {
		
		cache = new HashMap<String, Object>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * méthode permet de récupérer l'instance
	 */
	public static ServiceLocator getInstance(){
		if (instance==null)
			instance = new ServiceLocator();
		return instance;
	}
	
	/**
	 * le service locator va retourner l'objet " le chemin récupéré du serveur", on le met synchronisé 
	 */
	/**
	 * pour un seul accès avec "synchronized" pour
	 */
	/**
	 * 
	 * @param jndi
	 * @return object
	 */
	public synchronized Object getProxy(String jndi){
		Object object=null;
		if(cache.get(jndi) != null){
			return cache.get(jndi);
		} 
		else {
			try {
				object = context.lookup(jndi);
				if (object != null) {
					cache.put(jndi, object);
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}
