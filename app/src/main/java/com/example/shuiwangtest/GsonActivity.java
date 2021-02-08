package com.example.shuiwangtest;

import android.graphics.LinearGradient;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuiwangtest.gson.AmountWithCurrency;
import com.example.shuiwangtest.gson.Founder;
import com.example.shuiwangtest.gson.GeneralInfo;
import com.example.shuiwangtest.gson.Restaurant;
import com.example.shuiwangtest.gson.RestaurantMenuItem;
import com.example.shuiwangtest.gson.RestaurantWithMenu;
import com.example.shuiwangtest.gson.UserAddress;
import com.example.shuiwangtest.gson.UserNested;
import com.example.shuiwangtest.gson.UserSimple;
import com.example.shuiwangtest.okhtp.CancelCall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import java.lang.reflect.Type;
import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        UserSimple userObject = new UserSimple(
                "Norman",
                "norman@futurestud.io",
                26,
                true
        );
        Gson gson = new Gson();
        String userJson = gson.toJson(userObject);
        Logger.json(userJson);

//        String userJson2 = "{'age':26,'email':'norman@futurestud.io','isDeveloper':true,'name':'Norman'}";
//        UserSimple userObject2 = gson.fromJson(userJson2, UserSimple.class);
//        Logger.d(userObject2);
//
//        UserAddress userAddress = new UserAddress(
//                "Main Street",
//                "42A",
//                "Magdeburg",
//                ""
//        );
//
//        UserNested userObject3 = new UserNested(
//                "Norman",
//                "norman@futurestud.io",
//                0,
//                true,
//                userAddress
//        );
//        String userWithAddressJson = gson.toJson(userObject3);
//        Logger.json(userWithAddressJson);

//        String restaurantJson = "{ 'name':'Future Studio Steak House', 'owner':{ 'name':'Christian', " +
//                "'address':{ 'city':'Magdeburg', 'country':'Germany', 'houseNumber':'42', 'street':'Main Street'}}," +
//                "'cook':{ 'age':18, 'name': 'Marcus', 'salary': 1500 }, 'waiter':{ 'age':18, 'name': 'Norman', 'salary': 1000}}";
//        Restaurant restaurantObject = gson.fromJson(restaurantJson, Restaurant.class);
//        Logger.d(restaurantObject);

//        List<RestaurantMenuItem> menu = new ArrayList<>();
//        menu.add(new RestaurantMenuItem("Spaghetti", 7.99f));
//        menu.add(new RestaurantMenuItem("Steak", 12.99f));
//        menu.add(new RestaurantMenuItem("Salad", 5.99f));
//        RestaurantWithMenu restaurant =
//                new RestaurantWithMenu("Future Studio Steak House", menu);
//        String restaurantJson = gson.toJson(restaurant);
//        String menuJson = gson.toJson(menu);
//        Logger.json(menuJson);

//        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";
//        Founder[] founderArray = gson.fromJson(founderJson, Founder[].class);
//        Type founderListType = new TypeToken<ArrayList<Founder>>(){}.getType();
//        List<Founder> founderList = gson.fromJson(founderJson, founderListType);
//        Logger.d(founderList);

//        String generalInfoJson = "{'name': 'Future Studio Dev Team', 'website': 'https://futurestud.io', 'founders': [{'name': 'Christian', 'flowerCount': 1 }, {'name': 'Marcus','flowerCount': 3 }, {'name': 'Norman','flowerCount': 2 }]}";
//        GeneralInfo generalInfoObject = gson.fromJson(generalInfoJson, GeneralInfo.class);
//        Logger.d(generalInfoObject);

//        HashMap<String, List<String>> employees = new HashMap<>();
//        employees.put("A", Arrays.asList("Andreas", "Arnold", "Aden"));
//        employees.put("C", Arrays.asList("Christian", "Carter"));
//        employees.put("M", Arrays.asList("Marcus", "Mary"));
//        String employeeJson = gson.toJson(employees);
//        Logger.json(employeeJson);

//        String dollarJson = "{ '1$': { 'amount': 1, 'currency': 'Dollar'}, '2$': { 'amount': 2, 'currency': 'Dollar'}, '3€': { 'amount': 3, 'currency': 'Euro'} }";
//        Logger.json(dollarJson);
//        Type amountCurrencyType =
//                new TypeToken<HashMap<String, AmountWithCurrency>>(){}.getType();
//
//        HashMap<String, AmountWithCurrency> amountCurrency =
//                gson.fromJson(dollarJson, amountCurrencyType);
//        Logger.d(amountCurrency);

//        HashSet<String> users = new HashSet<>();
//        users.add("Christian");
//        users.add("Marcus");
//        users.add("Norman");
////        users.add("Marcus");
//        String usersJson = gson.toJson(users);
//        Logger.json(usersJson);
//
//        GsonBuilder builder = new GsonBuilder().setExclusionStrategies();
//        builder.excludeFieldsWithoutExposeAnnotation();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        Type integerType = new TypeToken<List<Integer>>() {}.getType();
        Type stringType = new TypeToken<List<String>>() {}.getType();

        String integerJson = gson.toJson(integerList, integerType);
        String stringJson = gson.toJson(stringList, stringType);
        Logger.json(integerJson);
        Logger.json(stringJson);

    }

}
