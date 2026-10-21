package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.Customizer;

@Configuration // 스프링설정클래스등록
@EnableWebSecurity // 스프링시큐리티활성화
@EnableMethodSecurity
public class SecurityConfig {
    @Bean // 비밀번호암호화객체등록(BCrypt 해시)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean // 보안필터체인등록
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth // 1. URL 접근규칙(인가)
            .requestMatchers("/", "/hello", "/detailed_web.html",
                            "/login", "/signup", "/error").permitAll()
            .requestMatchers("/css/**", "/js/**", "/images/**", "/fonts/**").permitAll()
            //.requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/admin/**",
                "/api/admin/**")
                .hasRole("ADMIN")
            .requestMatchers("/api/hello").permitAll()
            .anyRequest().authenticated())
        .formLogin(form -> form // 2. 폼로그인설정(인증)
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error")
            .permitAll())
            
        .logout(logout -> logout // 3. 로그아웃 설정
            .logoutUrl("/logout") // 로그아웃 처리 URL (POST)
            .logoutSuccessUrl("/login?logout") // 로그아웃 후 이동
            .invalidateHttpSession(true) // 세션 삭제
            .deleteCookies("JSESSIONID", "remember-me")) // 쿠키 삭제

                .httpBasic(Customizer.withDefaults()) // Postman : 요청마다 아이디·비밀번호 (Basic 인증)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")) // JSON API 는 CSRF 토큰 검사 제외
                .exceptionHandling(ex -> ex.defaultAuthenticationEntryPointFor( // 로그인 안 한 API 요청 :
                    new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),           // 로그인 화면(302) 대신 401
                    request -> request.getRequestURI().startsWith("/api/")));
        return http.build();
    }
}
