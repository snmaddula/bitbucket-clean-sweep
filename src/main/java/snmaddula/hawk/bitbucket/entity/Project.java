package snmaddula.hawk.bitbucket.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

/**
 * 
 * @author snmaddula
 *
 */
@Data
@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	private Long id;
	private String key;
	private String name;
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Repo> repos = new ArrayList<Repo>();
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
