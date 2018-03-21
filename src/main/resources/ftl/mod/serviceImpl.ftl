package com.fb.service.impl;

import com.fb.bir.dao.businessdao.PageEntity;
import com.fb.bir.dao.businessdao.PagingResult;
import com.fb.bir.dao.businessdao.${domain}Dao;
import com.fb.bir.pojo.${domain};
import com.fb.service.${domain}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class ${domain}ServiceImpl implements ${domain}Service {


    @Autowired
    private ${domain}Dao<${domain}> ${domain_low}DaoImpl;

    @Override
    public void save(${domain} p) {

    if (p.getId() != null) {
    update(p);
    } else {
    ${domain_low}DaoImpl.insert(p);
    }

    }

    @Override
    public PagingResult<${domain}> selectPagination(PageEntity pe) {
        return ${domain_low}DaoImpl.selectPagination(pe);
    }

    @Override
    public int update(${domain} pl) {
    return ${domain_low}DaoImpl.update(pl);
    }

    @Override
    public int update(Map<String , Object> m) {
    return ${domain_low}DaoImpl.updateParam(m);
    }

    @Override
    public int delete(Long primaryKey) {
    return ${domain_low}DaoImpl.delete(primaryKey);
    }

    @Override
    public ${domain} findById(long id) {
    return ${domain_low}DaoImpl.get(id);
    }

    @Override
    public List <${domain}> selectAll() {
        return ${domain_low}DaoImpl.selectParam(Collections.emptyMap());
    }

}
