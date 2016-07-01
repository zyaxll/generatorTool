package generator.core;


import generator.bean.Table;

public abstract class BizAdapt extends GenericBase {

    public BizAdapt(Table table) {
        super(table);
    }

    @Override
    protected void generic(StringBuilder target) throws Exception {

    }

    @Override
    protected String replace(StringBuilder source) {
        return source.toString()
                .replaceAll(RP_TABLE, getTable().getName())
                .replaceAll(RP_TABLE_COMMENT, getTable().getComment())
                .replaceAll(RP_AUTHOR, getAuthor())
                .replaceAll(RP_PRO, getProjectName())
                .replaceAll(RP_DATE, getDate());
    }
}
