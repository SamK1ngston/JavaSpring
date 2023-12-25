package org.example.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.sql.DataSource;

/**
 * Конфигурационный класс для настройки безопасности веб-приложения.
 */
@EnableWebSecurity
public class SecConf extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * Настраивает AuthenticationManagerBuilder для аутентификации через базу данных.
     *
     * @param auth AuthenticationManagerBuilder для настройки аутентификации.
     * @throws Exception возможные исключения при настройке аутентификации.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    /**
     * Настраивает HttpSecurity для определения прав доступа к различным URL-адресам.
     *
     * @param http HttpSecurity объект для настройки прав доступа.
     * @throws Exception возможные исключения при настройке прав доступа.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("MANAGER", "HR", "EMPLOYEE")
                .antMatchers("/hr_info/**").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and()
                .formLogin()
                .permitAll();
    }
}
