package br.com.digital_wallet.app.user.service;

import br.com.digital_wallet.app.user.handler.exceptions.UserNotFoundException;
import br.com.digital_wallet.app.user.model.entity.UserEntity;
import br.com.digital_wallet.app.user.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =  userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }
}
