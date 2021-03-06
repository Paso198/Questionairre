package it.polimi.db2.questionnaire.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DuplicateUniqueValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String field;
	private String message;
}
