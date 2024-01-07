package fr.poly.eventmanager.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.builder().username("admin").password("{noop}1234").roles("ADMIN","USER").build();
        UserDetails user = User.builder().username("user").password("{noop}1234").roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
            configurer
                    .antMatchers(HttpMethod.GET,"/eventapi/all").hasRole("USER")
                    .antMatchers(HttpMethod.GET,"/sponsorapi/all").hasRole("USER")
                    .antMatchers(HttpMethod.GET,"/themeapi/all").hasRole("USER")
                    .antMatchers(HttpMethod.POST,"/eventapi/addevent").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/saveevent").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/deleteevent/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/api/events/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/api/events/**").hasRole("USER")
                    .antMatchers(HttpMethod.POST,"/eventapi/deletesponsor/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/addsponsor").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/savesponsor").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/savestheme").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/addtheme").hasRole("ADMIN")
                    .antMatchers(HttpMethod.POST,"/eventapi/deletetheme/**").hasRole("ADMIN")

            );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
