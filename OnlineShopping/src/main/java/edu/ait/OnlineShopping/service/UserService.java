package edu.ait.OnlineShopping.service;

/*
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import edu.ait.onlineshopping.repository.UserRepository; import
 * edu.ait.user.User;
 * 
 * @RestController
 * 
 * @Service public class UserService {
 * 
 * @Autowired UserRepository userRepo;
 * 
 * // @RequestMapping("/users/{id}") // Optional<User>
 * getProduct(@PathVariable("id") Long id) { // return userRepo.findAll(); // }
 * 
 * public List<User> getUsers() { // TODO Auto-generated method stub return
 * userRepo.findAll(); }
 * 
 * 
 * 
 * 
 * }
 * 
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import edu.ait.OnlineShopping.repository.UserRepository;
import edu.ait.OnlineShopping.user.User;

@RestController
@Service

public class UserService {

	private UserRepository userRepository = null;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
				
	}
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	 
	public void addNewUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long id) {
		//userRepository.findById(userId);
		//userRepository.existsById(userId);
		//userRepository.deleteById(userId);
		userRepository.deleteById(id);
		
	}

	public User updateUser(Long id, User user)
	{
		Optional<User> optionalUser = userRepository.findById(id);
		
		User existingUser = optionalUser.get();
		existingUser.setName(user.getName());
		existingUser.setEmail1(user.getEmail());
		existingUser.setAddress(user.getAddress());
		
		return userRepository.save(existingUser);
	}

	public void updateUser(Long userId, String name, String email, String address) {
		// TODO Auto-generated method stub
		
	}
	
//	@Transactional
//	public User updateUser(Long userId, String name, String address, String email) {
//		
//		
//	}

}
