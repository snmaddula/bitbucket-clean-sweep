package snmaddula.hawk.bitbucket.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author snmaddula
 *
 */
@Data
@Entity
@Table(name = "REPO")
public class Repo {

	@Id
	private Long id;
	private String slug;
	private String name;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp createdTime;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Timestamp lastupdatedTime;
	
	@PrePersist
	public void prePersist() {
		lastupdatedTime = createdTime = new Timestamp(System.currentTimeMillis());
	}

	@PreUpdate
	public void preUpdate() {
		lastupdatedTime = new Timestamp(System.currentTimeMillis());
	}
}
