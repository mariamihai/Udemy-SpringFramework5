package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

public enum CategoryType {
    Payment("Payment"), Income("Income");

    private String type;

    private CategoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
