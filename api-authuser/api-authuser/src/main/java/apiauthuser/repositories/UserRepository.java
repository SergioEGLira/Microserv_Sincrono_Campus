package apiauthuser.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiauthuser.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
	
	boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    
}