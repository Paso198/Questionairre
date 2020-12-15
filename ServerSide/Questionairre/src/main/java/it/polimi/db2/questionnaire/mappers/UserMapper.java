package it.polimi.db2.questionnaire.mappers;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.polimi.db2.questionnaire.dto.requests.UserRequest;
import it.polimi.db2.questionnaire.dto.responses.UserResponse;
import it.polimi.db2.questionnaire.enumerations.Role;
import it.polimi.db2.questionnaire.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Mapper(componentModel = "spring", uses = PasswordEncoder.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {
	
	protected PasswordEncoder passwordEncoder;

	@Mapping(target="id", ignore=true)
	@Mapping(target="username", expression="java(userRequest.getUsername())")
	@Mapping(target="email", expression="java(userRequest.getEmail())")
	@Mapping(target="password", expression="java(passwordEncoder.encode(userRequest.getPassword()))")
	@Mapping(target="points", source="points")
	@Mapping(target="blocked", source="blocked")
	@Mapping(target="roles", expression="java(getRole(role))")
	public abstract User mapToUser(UserRequest userRequest, Role role, Boolean blocked, Integer points);
	
	String getRole(Role role) {
		return "ROLE_"+role.name();
	}
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder=passwordEncoder;
	}
	
	public abstract UserResponse toUserResponse(User user);
	
	public abstract List<UserResponse> toUserResponse(Stream <User> user);
}
