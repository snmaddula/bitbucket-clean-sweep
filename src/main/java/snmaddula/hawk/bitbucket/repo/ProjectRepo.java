package snmaddula.hawk.bitbucket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snmaddula.hawk.bitbucket.entity.Project;

/**
 * 
 * @author snmaddula
 *
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

	Project findByKey(String name);

}
