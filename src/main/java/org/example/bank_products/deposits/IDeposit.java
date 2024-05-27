package org.example.bank_products.deposits;

import org.example.bank_products.IBankProduct;

public interface IDeposit  extends IBankProduct {
    Long closeDeposit();
}
