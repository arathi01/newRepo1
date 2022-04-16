package edu.ait.OnlineShopping.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.ait.OnlineShopping.repository.UserRepository;
import edu.ait.OnlineShopping.service.UserService;
import edu.ait.OnlineShopping.user.User;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

	private UserService userService = new UserService(null);
	
	@Autowired
	UserRepository userRepo;
	public UserController(UserService userService) {
		this.userService = userService;
	}




//	@GetMapping("/userid")
//	public String get() {
//		return "Hello World";
//	}

	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> getUserId(@PathVariable Long id)
	{
		return userService.getUserById(id);
	}

	@PostMapping(value = "/users")
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}

	@DeleteMapping(path = "{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

	@PutMapping(path = "{userId}")
	public void updateUser(@PathVariable("userId") Long userId,@RequestBody User user)
	{

		userService.updateUser(userId, user);
	}	
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	ResponseEntity<User> insertUser(@RequestBody User user){
		User savedUser = userRepo.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	
//	@RequestMapping(value ="/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<User> updateUser(@Validated @PathVariable Long id, @RequestBody User user)
//	{
//		User updateUser = userService.updateUser(id, user);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateUser.getId()).toUri();
//		new ResponseEntity<User>(updateUser,HttpStatus.OK);
//		return ResponseEntity.created(location).build();
//	}

}





/*
 * @RestController
 * 
 * @RequestMapping(path = "api/v1/user")
 * 
 * public class UserController {
 * 
 * private final UserService userService;
 * 
 * @Autowired public UserController(UserService userService) { this.userService
 * = userService; }
 */
//	private UserService userService() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/*
	 * @GetMapping public List<User> getUsers(){ return userService.getUsers(); }
	 */
    
//	public UserService getUserService() {
//		return userService;
//	}
     
	
	
	
	
	
//	
//	
//	
//	{
//		List<User> users = new ArrayList<>();
//		
//		User a1 = new User(null, null, null, null);
//		a1.setId(1);
//		a1.setName("Arathi");
//		a1.setAddress("Athlone");
//		a1.setEmail("arathik@gmail.com");
//		
//		users.add(a1);
//		User a2 = null;
//		users.add(a2);
//		
//		return users;
//		
//	}
//	@GetMapping("/getAll")
//	public ResponseEntity<List<User>> queryStudent(){
//	List<User> list ;
//	list = UserRepository.findAll();
//	return ResponseEntity.ok(list);
//	}
//	
//	@PostMapping("/user")
//	public void addUser(@Valid @RequestBody User users) {
//		
		
		//		@SuppressWarnings("unused")
//		User savedUser = UserRepository.save(users);
//	    List<User> user = users.getContacts();
//	    for (User user1 : user) {
//	        UserRepository.save(user1);
//	    }
//
//	}
	

//}

