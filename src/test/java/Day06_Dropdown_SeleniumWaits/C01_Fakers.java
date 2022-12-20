package Day06_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Fakers {

    //Faker değerler üretmek için Faker Class dan obje üretilir ve var olan metotlar kullanılırız


    @Test
    public void fakerExample (){

        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.address().fullAddress());


    }

}
