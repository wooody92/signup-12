package dev.codesquad.java.signup12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiUserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/test")
    public User test() {
        Long id = 1L;
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("NO DATA"));
    }

    @PostMapping("/validate/userId")
    public boolean isValidUserId(@RequestBody String userId) {
        logger.info("userId : {}", userId);
        if (userRepository.findByUserId(userId) == null) {
            return true;
        }
        return false;
    }

    @PostMapping("/validate/email")
    public boolean isValidEmail(@RequestBody String email) {
        if (userRepository.findByEmail(email) == null) {
            return true;
        }
        return false;
    }

    @PostMapping("/validate/phone")
    public boolean isValidPhone(@RequestBody String phone) {
        if (userRepository.findByPhone(phone) == null) {
            return true;
        }
        return false;
    }
}
