package adminDelegate;



import java.util.List;
import org.esprit.naturespirits.domain.User;
import org.esprit.naturespirits.service.NatureSpiritsRemote;

import serviceLocator.ServiceLocator;



public class UsersManagementDelegate {
	
		private static NatureSpiritsRemote getRemote() {
			return (NatureSpiritsRemote) ServiceLocator.getInstance().getProxy("/NatureSpirits/"
					+ "NatureSpirits!org.esprit"
					+ ".naturespirits.service.NatureSpiritsRemote");

		}
		/**
		 * This method is to add an agent
		 * @param agent
		 */
		public static void addUser(User user)
		{
			getRemote().addUser(user);
		}
		public static void updateUser(User user){
			getRemote().updateUser(user);
		}
		public static List<User> findAll() {
			return getRemote().findAll();
		}
        public static User findBYid(int id_user){
        	return getRemote().findBYid(id_user);
        }
		public List<User> findBYval(boolean validation_j) {
			return getRemote().findBYval(validation_j);
		}

		public static void disableUser(User user){
			getRemote().disableUser(user);
			
		}
		public static void validateUser(User user){
			getRemote().validateUser(user);
		}


}
