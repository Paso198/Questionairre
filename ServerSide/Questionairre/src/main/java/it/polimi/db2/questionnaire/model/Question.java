package it.polimi.db2.questionnaire.model;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String text;		
}