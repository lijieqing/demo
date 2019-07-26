package com.fengmi.demo.service.user;

import com.fengmi.demo.mapper.FMUserMapper;
import com.fengmi.demo.model.FMUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * @author lijie
 * @create 2019-07-25 20:47
 **/
@Component
public class FMUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FMUserMapper userMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("login user = " + s);
        FMUser fmU = userMapper.getUserByName(s);
        if (fmU != null) {
            String pass = passwordEncoder.encode(fmU.getUser_pass());
            logger.info("login pass = " + pass);
            return new User(s, pass, AuthorityUtils.commaSeparatedStringToAuthorityList(fmU.getUser_role().toString()));
        }
        throw new UsernameNotFoundException("用户名:"+s+" 不存在!");
    }
}
