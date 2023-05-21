package com.telcotec.eagleye.service.classes;


import com.telcotec.eagleye.dao.entities.Technicien;
import com.telcotec.eagleye.dao.entities.User;
import com.telcotec.eagleye.dao.repository.TechnicienRepository;
import com.telcotec.eagleye.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRep;

    @Autowired
    TechnicienRepository techRep;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User findUserByUserName(String unserName) {
        return this.userRep.findByUserName(unserName);
    }

    public Technicien saveUser(Technicien e) {
        User u = new User();
        u.setEmail(e.getEmail());
        u.setUserName(e.getUsername());
        u.setRole("TECHNICIEN");
        u.setPassword(bCryptPasswordEncoder.encode(e.getPassword()));
        e.setPassword(bCryptPasswordEncoder.encode(e.getPassword()));
        u.setActive(true);
        User uu = this.userRep.save(u);
        e.setUser(uu);
        return this.techRep.save(e);
    }
}
