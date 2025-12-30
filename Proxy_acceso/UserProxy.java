package P2_E23;

import java.util.List;

public class UserProxy implements PersistableUser {
	private String username;
	private String email;
	private List<Post> posts; // inicialmente null
	private PostRepository postRepository;

	public UserProxy(String username, String email, PostRepository postRepository) {
		this.username = username;
		this.email = email;
		this.postRepository = postRepository;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public List<Post> getPosts() {
		if (posts == null) {
			this.posts = postRepository.findPostsByUsername(this.username); // carga perezosa
		}
		return posts;
	}

	@Override
	public String toString() {
		return this.username + " - " + this.email;
	}
}
