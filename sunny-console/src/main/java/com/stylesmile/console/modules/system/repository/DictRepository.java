package com.stylesmile.console.modules.system.repository;

import com.stylesmile.console.modules.system.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author Stylesmile
* @date 2019-04-10
*/
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor<Dict> {
}