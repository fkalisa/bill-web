package com.jb.bill.web.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {
   /*
    //authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("admin_role")
                .antMatchers("/student/**").hasAnyRole("admin_role", "student_role")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();


    }
    //authentification
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles("admin_role")
                .and()
                .withUser("student")
                .password("password")
                .roles("student_role");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    */
}
