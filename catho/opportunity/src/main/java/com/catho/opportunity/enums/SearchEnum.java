package com.catho.opportunity.enums;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public enum SearchEnum {

    Q("q"),
    PAGE("page"),
    LIMIT("limit"),
    ORDERBY("orderby"),
    SORTED("sorted"),
    FIELDS("fields");
    
    SearchEnum(String field) {
        this.field = field;
    }

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public static boolean isValidField(String field) {
        for (SearchEnum fieldList : SearchEnum.values()) {
            if (field.equals(fieldList.getField())) return true;
        }
        return false;
    }
}
