package adminDelegate;



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
}
