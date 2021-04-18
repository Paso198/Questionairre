package it.polimi.db2.questionnaire.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Exception thrown when user sends an invalid response
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvalidResponseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

}
