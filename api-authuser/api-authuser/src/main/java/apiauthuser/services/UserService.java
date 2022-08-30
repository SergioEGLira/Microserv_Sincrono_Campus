package apiauthuser.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import apiauthuser.models.UserModel;

public interface UserService {

	List<UserModel> findAll();

	Optional<UserModel> findById(UUID userId);

	void delete(UserModel userModel);

	void save(UserModel userModel);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
}
