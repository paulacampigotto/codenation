package br.com.codenation.paymentmethods;

public class PriceStrategyTransfer implements PriceStrategy{

	public PriceStrategyTransfer() {
		
	}
	@Override
	public Double calculate(Double price) {
		return price * 0.92;
	}

}
