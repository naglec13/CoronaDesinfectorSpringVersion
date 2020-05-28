package com.coronagoaway;

@Singleton
public class RecommemndatorImpl implements Recommendator {
    @InjectProperty("tea")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-19 drink " + alcohol);
    }
}
