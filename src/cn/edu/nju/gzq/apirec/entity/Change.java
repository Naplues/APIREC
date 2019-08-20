package cn.edu.nju.gzq.apirec.entity;

/**
 * Change Entity Class
 * The predicted change c is in the form of <Insert, MethodInvocation, methodName>
 * 实体类
 */
public class Change {
    private String operator;
    private String ASTNodeType;
    private String label;

    public Change() {

    }

    public Change(String operator, String ASTNodeType, String label) {
        this.operator = operator;
        this.ASTNodeType = ASTNodeType;
        this.label = label;
    }

    public Change(String changeString) {
        String[] temp = changeString.split("\t");
        this.operator = temp[0];
        this.ASTNodeType = temp[1];
        this.label = temp[2];
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getASTNodeType() {
        return ASTNodeType;
    }

    public void setASTNodeType(String ASTNodeType) {
        this.ASTNodeType = ASTNodeType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
