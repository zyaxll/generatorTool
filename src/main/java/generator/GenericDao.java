package generator;


import generator.bean.Table;
import generator.core.BizAdapt;
import generator.utils.Constant;

/**
 * @description: {TODO}
 * Copyright 2011-2015 B5M.COM. All rights reserved
 * @author: Leo.li
 * @version: 1.0
 * @createdate: ${Date}
 */
public class GenericDao extends BizAdapt {

    private static final String NAME = "Mapper";

    public GenericDao(Table table) {
        super(table);
    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    public void setFilePath(String filePath) {
        super.setFilePath(filePath + "/" +  "cms_dao");
    }

    @Override
    protected void init() {
        setSourceName(getSourcePath() + "template/" + getName());

        String targetName = Constant.DAO_PATH;
        if (null == targetName || "".equals(targetName.trim())) {
            targetName = "/src/main/java/com/" + getProjectName() + "/dao/";
        }
        setTargetName(targetName + getTable().getName() + getName() + ".java");
    }

}
