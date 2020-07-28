package cn.samnya.arcadedbserver.dao;

import cn.samnya.arcadedbserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sam_nya (samnya@outlook.com)
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
