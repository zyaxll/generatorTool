package generator.core;


import generator.bean.Column;
import generator.bean.Table;
import generator.utils.Constant;


public abstract class ColumnAdapt extends GenericBase {

    public ColumnAdapt(Table table) {
        super(table);
    }

    protected void getComment(StringBuilder target, String comment) {
        target.append(Constant.FILE_SPACE)
                .append("/**")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append(" * ")
                .append(comment)
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append(" */")
                .append(Constant.FILE_LINE);
    }

    protected abstract void getAnno(StringBuilder target, Column column);

    protected void getProperty(StringBuilder target, Column column) {
        target.append("private ")
                .append(getType(column.getDataType()))
                .append(" ")
                .append(column.getName())
                .append(";")
                .append(Constant.FILE_LINE);
    }

    protected void getter(StringBuilder target, Column column) {
        target.append(Constant.FILE_SPACE)
                .append("public ")
                .append(getType(column.getDataType()))
                .append(" get")
                .append(column.getuName())
                .append("() {")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append(Constant.FILE_SPACE)
                .append("return this.")
                .append(column.getName())
                .append(";")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append("}")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_LINE);
    }

    protected void setter(StringBuilder target, Column column) {
        target.append(Constant.FILE_SPACE)
                .append("public void ")
                .append("set")
                .append(column.getuName())
                .append("(")
                .append(getType(column.getDataType()))
                .append(" ")
                .append(column.getName())
                .append(") {")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append(Constant.FILE_SPACE)
                .append("this.")
                .append(column.getName())
                .append(" = ")
                .append(column.getName())
                .append(";")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_SPACE)
                .append("}")
                .append(Constant.FILE_LINE)
                .append(Constant.FILE_LINE);
    }

    protected String getType(String dataType) {
        dataType = dataType.toUpperCase();
        if ("BIGINT".equals(dataType)) {
            return "Long";
        } else if ("INT".equals(dataType)
                || "TINYINT".equals(dataType)) {
            return "Integer";
        } else if ("DATETIME".equals(dataType)
                || "DATE".equals(dataType)
                || "TIMESTAMP".equals(dataType)) {
            return "Date";
        } else if ("DECIMAL".equals(dataType)) {
            return "Double";
        } else {
            return "String";
        }
    }

}
