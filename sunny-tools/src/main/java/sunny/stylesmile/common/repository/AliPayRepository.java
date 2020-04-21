package sunny.stylesmile.common.repository;

import sunny.stylesmile.common.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Stylesmile
 * @date 2019-12-31
 */
public interface AliPayRepository extends JpaRepository<AlipayConfig,Long> {
}
