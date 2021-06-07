package com.example.springcalculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
@SpringBootTest
@Import({MarketApi.class, DollarCalculator.class})    // 마켓api를 주입받고있다
public class DollarCalculatorTest {
    @MockBean //마켓api를 모킹처리할것이다.
    private MarketApi marketApi;

    @Autowired
    private DollarCalculator dollarCalculator;
    @Test
    public void dollarCalculatorTest() {
//        dollarCalculator.init();
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();
        int sum = dollarCalculator.sum(10, 10);

        Assertions.assertEquals(60000,sum);
    }
}
