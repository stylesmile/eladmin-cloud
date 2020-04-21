package sunny.stylesmile.common.repository;

import sunny.stylesmile.common.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stylesmile
 * @date 2019-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
