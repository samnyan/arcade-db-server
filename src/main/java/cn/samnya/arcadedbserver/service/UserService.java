package cn.samnya.arcadedbserver.service;

import cn.samnya.arcadedbserver.dao.RoleRepository;
import cn.samnya.arcadedbserver.dao.UserRepository;
import cn.samnya.arcadedbserver.model.Role;
import cn.samnya.arcadedbserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Optional<Role> userRole = roleRepository.findById((long) 1);
        userRole.ifPresent(role -> {
            Set<Role> roleSet = new HashSet<Role>();
            roleSet.add(role);
            user.setRoles(roleSet);
        });
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
