package com.finance.productms.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;

    private Boolean commissionMaintenance;
    private Integer amountCommissionMaintenance;

    private Boolean maximumLimitMonthlyMovements;
    private Integer quantityMaximumLimitMonthlyMovements;

    private Boolean allowDeposit;
    private Boolean allowWithdrawal;

    private Integer maximumQuantityCredit;
    private Integer maximumQuantityDebit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    public Product(String name, String type, Boolean commissionMaintenance, Integer amountCommissionMaintenance, Boolean maximumLimitMonthlyMovements, Integer quantityMaximumLimitMonthlyMovements, Boolean allowDeposit, Boolean allowWithdrawal, Integer maximumQuantityCredit, Integer maximumQuantityDebit, Date createAt) {
        this.name = name;
        this.type = type;
        this.commissionMaintenance = commissionMaintenance;
        this.amountCommissionMaintenance = amountCommissionMaintenance;
        this.maximumLimitMonthlyMovements = maximumLimitMonthlyMovements;
        this.quantityMaximumLimitMonthlyMovements = quantityMaximumLimitMonthlyMovements;
        this.allowDeposit = allowDeposit;
        this.allowWithdrawal = allowWithdrawal;
        this.maximumQuantityCredit = maximumQuantityCredit;
        this.maximumQuantityDebit = maximumQuantityDebit;
        this.createAt = createAt;
    }
}
