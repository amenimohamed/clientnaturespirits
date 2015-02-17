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
		public static List<User> findAll() {
			return getRemote().findAll();
		}

		public List<User> findBYval(boolean validation_j) {
			return getRemote().findBYval(validation_j);
		}

		public void disableUser(boolean validation_j){
			getRemote().disableUser(validation_j);
			
		}
		public void validateUser(boolean validation_j){
			getRemote().validateUser(validation_j);
		}


}
