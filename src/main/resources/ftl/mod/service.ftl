package com.fb.service;

import com.fb.bir.dao.businessdao.PageEntity;
import com.fb.bir.dao.businessdao.PagingResult;
import com.fb.bir.pojo.${domain};

import java.util.List;
import java.util.Map;

/**
 * ${comment}业务Service
 */
public interface ${domain}Service {
    /**
     * 保存
     *
     * @param p
     */
    void save(${domain} p);

    /**
     * 分页查询
     *
     * @param pageEntity
     * @return
     */
    PagingResult<${domain}> selectPagination(PageEntity pageEntity);

    /**
    * 按实体类修改
    * @param entity
    * @return
    */
    int update(${domain} entity);

    /**
    * 按参数修改
    * @param map
    * @return
    */
    int update(Map<String, Object> map);

    /**
    * 删除
    * @param primaryKey
    * @return
    */
    int delete(Long primaryKey);

    /**
    * id查询
    * @param id
    * @return
    */
    ${domain} findById(long id);

    /**
    * 查询全部
    * @return
    */
    List<${domain}> selectAll();
}
