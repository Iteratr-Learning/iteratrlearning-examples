package com.iteratrlearning.blog_examples.java9_cf;

import java.util.concurrent.*;

import static com.iteratrlearning.blog_examples.java9_cf.Currency.USD;

public class PriceCatalogueExample
{
    private final Catalogue catalogue = new Catalogue();
    private final PriceFinder priceFinder = new PriceFinder();
    private final ExchangeService exchangeService = new ExchangeService();
//    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
//    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);


    public static void main(String[] args)
    {
        new PriceCatalogueExample().findLocalDiscountedPrice(Currency.CHF, "Nexus7");
    }

    private void findLocalDiscountedPrice(final Currency localCurrency, final String productName)
    {
        long time = System.currentTimeMillis();

        Product product = catalogue.productByName(productName);

        Price price = priceFinder.findBestPrice(product);

        double exchangeRate = exchangeService.lookupExchangeRate(USD, localCurrency);

        double localPrice = exchange(price, exchangeRate);

        System.out.printf("A %s will cost us %f %s\n", productName, localPrice, localCurrency);
        System.out.printf("It took us %d ms to calculate this\n", System.currentTimeMillis() - time);
    }

    private double exchange(Price price, double exchangeRate)
    {
        return Utils.round(price.getAmount() * exchangeRate);
    }

//    private CompletableFuture<Product> lookupProductByName(String productName)
//    {
//        return CompletableFuture.supplyAsync(() -> catalogue.productByName(productName), executorService);
//    }
//
//    private CompletableFuture<Price> findBestPrice(Product product)
//    {
//        return CompletableFuture.supplyAsync(() -> priceFinder.findBestPrice(product));
//    }
//
//    private CompletableFuture<Double> lookupExchangeRate(Currency localCurrency)
//    {
//        return CompletableFuture.supplyAsync(() ->
//                exchangeService.lookupExchangeRate(Currency.USD, localCurrency), executorService);
//    }

//    public <T> CompletableFuture<T> timeoutAfter(long timeout, TimeUnit unit) {
//        return null;
//    }

}
