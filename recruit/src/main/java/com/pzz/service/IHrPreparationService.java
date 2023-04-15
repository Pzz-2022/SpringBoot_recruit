package com.pzz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pzz.pojo.HrPreparation;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 彭政
 * @since 2023-01-13
 */
public interface IHrPreparationService extends IService<HrPreparation> {

    IPage<HrPreparation> getPage(Integer page, Integer size);

    void updateUser(HrPreparation hrPreparation);
}
