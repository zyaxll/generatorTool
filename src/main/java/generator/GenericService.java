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
public class GenericService extends BizAdapt {

    private static final String NAME = "Service";

    public GenericService(Table table) {
        super(table);
    }

    @Override
    protected String getName() {
        return NAME;
    }

    @Override
    public void setFilePath(String filePath) {
        super.setFilePath(filePath + "/" + getProjectName() + "-core");
    }

    @Override
    protected void init() {
        setSourceName(getSourcePath() + "template/" + getName());

        String targetName = Constant.SERVICE_PATH;
        if (null == targetName || "".equals(targetName.trim())) {
            targetName = "/src/main/java/com/b5m/" + getProjectName() + "/service/";
        }
        setTargetName(targetName + "I" + getTable().getName() + getName() + ".java");
    }

}
