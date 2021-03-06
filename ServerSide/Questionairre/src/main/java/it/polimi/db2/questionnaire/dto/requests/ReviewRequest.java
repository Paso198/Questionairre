package it.polimi.db2.questionnaire.dto.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
	
	@NotNull
	private Long productId;
	
	@NotBlank //TODO add regex and size contraints
	private String review;
}
