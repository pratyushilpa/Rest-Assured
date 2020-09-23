package apiConfigs;

public class APIPath {
	public static final class Api_Path{
		// CRUD of Users
		// GET method
		//public static final String GET_LIST_OF_USERS ="/api/users?page=2";
		//public static final String GET_SINGLE_USER ="/api/users/2";
		// POST method
		//public static final String CREATE_USER ="/api/users";
		// DELETE Method
		//public static final String DELETE_USER ="/api/users/2";
		// GET
		public static final String GET_LIST_OF_POSTS ="posts";
		public static final String GET_SINGLE_POSTS ="posts/";
		
		//POST
		public static final String CREATE_POSTS ="posts";
		// Update Post
		public static final String UPDATE_POSTS ="posts";
	}
	public static void main(String[] args) {
		//System.out.println(APIPath.Api_Path.CREATE_USER);
	}

}
