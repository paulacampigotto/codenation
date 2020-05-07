package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.getRandomQuote();
		Random rand = new Random();
		return quotes.get(rand.nextInt(quotes.size()));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.getQuoteByActor(actor);
		Random rand = new Random();
		return quotes.get(rand.nextInt(quotes.size()));
	}

}
