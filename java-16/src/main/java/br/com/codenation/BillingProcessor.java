package br.com.codenation;



import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

	private PriceStrategy priceStrategy;

	public BillingProcessor(PriceStrategy priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

	public BillingProcessor() {
	}

	public Double calculate(Order order) {
		return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
	}


}