package it.polimi.db2.questionnaire.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.security.crypto.password.PasswordEncoder;

import it.polimi.db2.questionnaire.dto.requests.UserRequest;
import it.polimi.db2.questionnaire.dto.responses.LeaderboardUserResponse;
import it.polimi.db2.questionnaire.dto.responses.UserResponse;
import it.polimi.db2.questionnaire.enumerations.Role;
import it.polimi.db2.questionnaire.model.Response;
import it.polimi.db2.questionnaire.model.User;

@Mapper(componentModel = "spring", uses = PasswordEncoder.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

	@Mapping(target="id", ignore=true)
	@Mapping(target="username", expression="java(userRequest.getUsername())")
	@Mapping(target="email", expression="java(userRequest.getEmail())")
	@Mapping(target="password", source="userRequest.password")
	@Mapping(target="blocked", source="blocked")
	@Mapping(target="logs", ignore=true)
	@Mapping(target="questionnairesCreated", ignore=true)
	@Mapping(target="responses", ignore=true)
	@Mapping(target="reviews", ignore=true)
	@Mapping(target="roles", expression="java(getRole(role))")
	public abstract User toUser(UserRequest userRequest, Role role, Boolean blocked, Integer points);
	
	String getRole(Role role) {
		return "ROLE_"+role.name();
	}
	
	@Mapping(target="id", source="id")
	@Mapping(target="username", expression="java(user.getUsername())")
	@Mapping(target="email", expression="java(user.getEmail())")
	public abstract UserResponse toUserResponse(User user);
	
	public abstract List<UserResponse> toUsersResponse(List<User> users);

	@Mapping(target="id", source="user.id")
	@Mapping(target="username", expression="java(response.getUser().getUsername())")
	@Mapping(target="dailyPoints", source="points")
	@Mapping(target="totalPoints", expression="java(response.getUser().getPoints())")
	public abstract LeaderboardUserResponse toLeaderboardUserResponse(Response response);
	
	public abstract List<LeaderboardUserResponse> toLeaderboardUsersResponse(List<Response> responses);
}
