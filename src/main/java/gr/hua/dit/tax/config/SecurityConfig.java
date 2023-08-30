package gr.hua.dit.tax.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

 
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;
    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/registersb").permitAll()
            .antMatchers("/registern").permitAll()

            .antMatchers("/actors/**", "/notaries/**").hasAuthority("ROLE_ADMIN")
            .antMatchers("/contracts/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_ACTOR", "ROLE_NOTARY")
            .antMatchers("/users/**", "/settings/**").hasAuthority("ROLE_ADMIN")  //Den uparxoun controllers gia auta

            .antMatchers("/publishedcontracts/**", "/publishedcontractslist/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_NOTARY", "ROLE_ACTOR")

            .antMatchers("/actorlist/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_NOTARY")
            .antMatchers("/contractlist/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_NOTARY", "ROLE_ACTOR")
            .antMatchers("/notarylist/**").hasAuthority("ROLE_ADMIN")


            .antMatchers("/actorform/**", "/notaryform/**").hasAuthority("ROLE_ADMIN")
            .antMatchers("/contractform/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_NOTARY")

            .antMatchers("/css/**", "/js/**", "/images/**").permitAll()  //Gia to koumpi (einai san to WebSecurityCustomizer)
            .anyRequest().authenticated()
            .and().formLogin().defaultSuccessUrl("/", true).permitAll()
            .and().logout().logoutSuccessUrl("/").permitAll()
            .and().httpBasic()
            .and().cors().disable().csrf().disable();

        http.headers().frameOptions().sameOrigin();

        return http.build();

    }
                        
    @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

}