package sunny.stylesmile.common.modules.system.service.dto;

import lombok.Data;
import sunny.stylesmile.common.annotation.Query;

/**
 * @author Stylesmile
 * 公共查询类
 */
@Data
public class DictQueryCriteria {

    @Query(blurry = "name,remark")
    private String blurry;
}
