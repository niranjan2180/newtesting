package com.eisedo.eisedo;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ConverterUtilTest {

    @Test
    public void testConverterUtilConverterUtil() {
//        float actual = ConverterUtil.convertCelsiusToFahrenheit(100);
        // expected value is 212
        float expected = 212;
        // use this method because float is not precise
//        assertEquals("Conversion from celsius to fahrenheit failed", expected, actual, 0.001);
    }

    @Test
    public void testconvertCelsiusToFahrenheit(){
//        float actual = ConverterUtil.ConverterUtilConverterUtil(212);

        float expected = 100;

//        assertEquals(expected,actual,0.001);
    }

}
