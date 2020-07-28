package cn.samnya.arcadedbserver.dao;

import cn.samnya.arcadedbserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sam_nya (samnya@outlook.com)
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
