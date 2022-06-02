package com.tutoedu.lmsadmin.common.config;

import com.tutoedu.lmsadmin.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * SecurityConfig class
 * Spring Security 설정 관련 class 파일
 *
 * @EnableWebSecurity
 *   @Configuration에 @EnableWebSecurity를 추가해 Spring Security 설정 클래스임을 알려준다.
 * @EnableGlobalMethodSecurity
 *   특정 주소로 접근하면 권한 및 인증을 미리 체크하기 위해 사용
 *
 * */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService customUserDetailService;

    /*비밀번호 암호화 객체*/
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(encoder());
    }

    /*Spring security filter Exclude path 설정*/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/cms/**");
    }

    /*사용자 권한 설정*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll();
                    /*.authorizeRequests()
                    .antMatchers("/", "/auth/**", "/posts/read/**", "/posts/search/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/auth/login")
                    .loginProcessingUrl("loginProc")
                    .defaultSuccessUrl("/")
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .invalidateHttpSession(true);*/

    }
}
