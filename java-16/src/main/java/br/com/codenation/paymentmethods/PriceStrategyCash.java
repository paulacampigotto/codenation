package br.com.codenation.paymentmethods;

public class PriceStrategyCash implements PriceStrategy{

	public PriceStrategyCash() {
	}
	
	@Override
	public Double calculate(Double price) {
		PaymentMethod.CASH.getPaymentStrategy();
		return price * 0.9;
	}

}
