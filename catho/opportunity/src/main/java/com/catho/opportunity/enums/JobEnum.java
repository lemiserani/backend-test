package com.catho.opportunity.enums;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public enum JobEnum {

    TITLE("title"),
    SALARIO("salario"),
    DESCRIPTION("description"),
    CIDADE("cidade"),
    CIDADEFORMATED("cidadeFormated");
    
    JobEnum(String field) {
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
        for (JobEnum fieldList : JobEnum.values()) {
            if (field.equals(fieldList.getField())) return true;
        }
        return false;
    }
}
