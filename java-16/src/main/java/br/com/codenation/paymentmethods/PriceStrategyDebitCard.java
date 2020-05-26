package br.com.codenation.paymentmethods;

public class PriceStrategyDebitCard implements PriceStrategy{

	public PriceStrategyDebitCard() {
		
	}
	@Override
	public Double calculate(Double price) {
		return price * 0.95;
	}

}
