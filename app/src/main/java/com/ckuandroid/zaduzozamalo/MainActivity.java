package com.ckuandroid.zaduzozamalo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int liczba = 0;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liczba = (int) (Math.random() * 100 + 1);
    }

    public void sprawdz(View view) {
        String probyStr = "";
        //do zmiennej wprowadzona przypisuję kontrolkę o identyfikatorze wprowadzona
        EditText wprowadzona = (EditText) findViewById(R.id.wprowadzona);
        //odczytuję napis znajdujący się w kontrolce wprowadzona
        String wprowadzonaStr = wprowadzona.getText().toString();
        //sprawdzam czy wprowadzonono jakąkolwiek liczbę
        if(wprowadzonaStr.length()>0) {
            licznik++;
            probyStr = "Liczba prób: " + licznik;
            //zamieniam napis na liczbę całkowitą
            int wprowadzonaInt = Integer.parseInt(wprowadzonaStr);
            String wynikStr = "";
            if (wprowadzonaInt > liczba) wynikStr = "Za dużo";
            else if (wprowadzonaInt < liczba) wynikStr = "Za mało";
            else {
                wynikStr = "Zgadłeś!!!";
                liczba = (int) (Math.random() * 100 + 1);
                licznik = 0;
            }

            //do zmiennej wynik przypisuję kontrolkę o identyfikatorze wynik
            TextView wynik = (TextView) findViewById(R.id.wynik);
            wynik.setText(wynikStr);

            //do zmiennej proby przypisuję kontrolkę o identyfikatorze proby
            TextView proby = (TextView) findViewById(R.id.proby);
            proby.setText(probyStr);
        }
    }
}