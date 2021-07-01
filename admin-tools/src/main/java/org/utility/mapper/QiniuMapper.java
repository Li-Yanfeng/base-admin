package org.utility.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.utility.model.QiniuConfig;

/**
 * 七牛云存储 Mapper 接口
 *
 * @author Li Yanfeng
 * @since 2021-06-29
 */
@Repository
public interface QiniuMapper extends BaseMapper<QiniuConfig> {

    /**
     * 根据 type 选择修改
     *
     * @param type /
     */
    @Select("UPDATE tool_qiniu_config SET type = #{type} WHERE config_id = 1")
    void updateType(@Param("type") String type);
}
