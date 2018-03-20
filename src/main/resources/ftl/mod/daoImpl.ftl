package com.fb.bir.dao.businessdaoImpl;

import org.springframework.stereotype.Component;
import com.fb.bir.dao.businessdao.${domain}Dao;
import com.fb.bir.pojo.${domain};

@Component("${domain_low}DaoImpl")
public class ${domain}DaoImpl extends GenericMybatisDao<${domain},Long> implements ${domain}Dao<${domain}> {
    public ${domain}DaoImpl(){
    super.setNamespace("com.fb.bir.dao.${domain}Mapper");
    }
    }
