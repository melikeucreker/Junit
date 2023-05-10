package day06_JunitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C04_AssertionMethodlari {
    @Test
    public void test01(){
        /*
        eger testin sonucunu turkce olumlu bir cümle ile sorduysa assertTrue
        eger olumsuz bir cümle kullanıyorsa assertFalse
         */
        int sayi1=20;
        int sayi2=10;
        int sayi3=30;
        //sayi1 in sayi 2 den büyük oldugunu test edin
        Assert.assertTrue(sayi1>sayi2);

        //sayi1'in sayi3 den buyuk olmadigini test edin
        Assert.assertFalse(sayi1<sayi3);

        //sayi1'in sayi 3 den kücük oldugunu
    }
}
