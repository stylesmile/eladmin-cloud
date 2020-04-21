package sunny.stylesmile.common.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author Stylesmile
* @date 2019-09-05
*/
@Data
public class LocalStorageDto implements Serializable {

    private Long id;

    private String realName;

    private String name;

    private String suffix;

    private String type;

    private String size;

    private String operate;

    private Timestamp createTime;
}