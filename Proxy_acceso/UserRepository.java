package P2_E23;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserRepository {

	private PostRepository postRepository;

	public UserRepository() {
		this.postRepository = new PostRepository(); // dependencia para el proxy
	}

	@SuppressWarnings("unchecked")
	public PersistableUser findUserByUsername(String aUsername) {
		JSONParser parser = new JSONParser();
		try {
			List<JSONObject> usersData = (List<JSONObject>) parser.parse(new FileReader("users.json"));
			return usersData.stream()
				.filter(userData -> userData.get("username").equals(aUsername)).findFirst()
				.map(userData -> new UserProxy(
						(String) userData.get("username"),
						(String) userData.get("email"),
						postRepository))
				.orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
}

