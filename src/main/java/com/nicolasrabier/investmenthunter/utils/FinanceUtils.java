package com.nicolasrabier.investmenthunter.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class FinanceUtils {

	public BigDecimal getEMI(BigDecimal principal, BigDecimal rate, int years) {
		
		rate = rate.divide(new BigDecimal(1200));
		int months = years * 12;
		
		BigDecimal a = principal.multiply(rate).multiply(rate.add(new BigDecimal(1)).pow(months));
		BigDecimal b = rate.add(new BigDecimal(1)).pow(months).subtract(new BigDecimal(1));

		return a.divide(b, 5, RoundingMode.HALF_UP);
	}

}
