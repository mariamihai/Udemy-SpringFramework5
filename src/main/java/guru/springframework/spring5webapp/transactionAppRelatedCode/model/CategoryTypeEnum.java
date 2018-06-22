package guru.springframework.spring5webapp.transactionAppRelatedCode.model;

public enum CategoryTypeEnum {
    Payment("Payment"),
    Income("Income")
    ;

    private final String type;

    CategoryTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}