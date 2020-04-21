package sunny.stylesmile.common.modules.system.repository;

import sunny.stylesmile.common.modules.system.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Stylesmile
* @date 2019-03-29
*/
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
}