package org.utility.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.utility.model.EmailConfig;

/**
 * 邮件配置 Mapper 接口
 *
 * @author Li Yanfeng
 * @since 2021-06-29
 */
@Repository
public interface EmailMapper extends BaseMapper<EmailConfig> {
}
