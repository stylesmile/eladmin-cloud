package sunny.stylesmile.common.service;

import sunny.stylesmile.common.domain.VerificationCode;
import sunny.stylesmile.common.domain.vo.EmailVo;

/**
 * @author Stylesmile
 * @date 2019-12-26
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code 验证码
     * @return EmailVo
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code 验证码
     */
    void validated(VerificationCode code);
}
