package uitl;

import generate.impl.*;

/**
 * 2018/3/20
 */
public class FreeMarkerFacade {

    private String tableName;

    public FreeMarkerFacade(String tableName) {
        this.tableName = tableName;
    }
    
    

    public void generaterAll()throws Exception {
        ControllerGenerator controllerGenerator = new ControllerGenerator();
        controllerGenerator.setTableName(tableName);
        controllerGenerator.process();

        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.setTableName(tableName);
        daoGenerator.process();

        DaoImplGenerator daoImplGenerator = new DaoImplGenerator();
        daoImplGenerator.setTableName(tableName);
        daoImplGenerator.process();

        DomainGenerator domainGenerator = new DomainGenerator();
        domainGenerator.setTableName(tableName);
        domainGenerator.process();

        ServiceGenerator serviceGenerator = new ServiceGenerator();
        serviceGenerator.setTableName(tableName);
        serviceGenerator.process();

        ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator();
        serviceImplGenerator.setTableName(tableName);
        serviceImplGenerator.process();
        
        
    }
}
