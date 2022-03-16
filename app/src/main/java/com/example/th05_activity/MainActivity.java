package com.example.th05_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvProducts;
    ProductAdapter productAdapter;
    ArrayList<Product> products;
    private Button btnDonut, btnPinkDonut, btnFloat;
    private ImageButton btnPlus;
    private EditText txtSearch;
    int position = -1;
    private ArrayList<Product> listChuaXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnDonut = findViewById(R.id.btnDonut);
        btnFloat = findViewById(R.id.btnFoat);
        btnPinkDonut = findViewById(R.id.btnPink);

        txtSearch = findViewById(R.id.txtSearch);
        lvProducts = findViewById(R.id.layout01);

        products = new ArrayList<>();
        products.add(new Product(R.drawable.yellow,"Tasty Donut",10.00,
                "Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        products.add(new Product(R.drawable.pink,"Pink Donut",20.00,
                "Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        products.add(new Product(R.drawable.green,"Float Donut",30.00,"Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        products.add(new Product(R.drawable.red,"Tasty Donut",40.00,
                "Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));

        listChuaXoa = new ArrayList<>();
        listChuaXoa.add(new Product(R.drawable.yellow,"Tasty Donut",10.00,
                "Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        listChuaXoa.add(new Product(R.drawable.pink,"Pink Donut",20.00,"Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        listChuaXoa.add(new Product(R.drawable.green,"Float Donut",30.00,"Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        listChuaXoa.add(new Product(R.drawable.red,"Tasty Donut",40.00,"Order a Large Pizza but the size is the equivalent of a medium/small from other places at the same price range."));
        productAdapter = new ProductAdapter(this,R.layout.one_product,products);
        lvProducts.setAdapter(productAdapter);

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtSearch.getText().toString().isEmpty() && products.size()==1){
                    Toast.makeText(MainActivity.this, "Do DO DO", Toast.LENGTH_SHORT).show();
                    products.clear();
                    for (Product p:listChuaXoa
                         ) {
                        products.add(p);
                    }
                    productAdapter.notifyDataSetChanged();
                }
                else{
                    listChuaXoa = products;
                    for (Product product:products) {
                        if(txtSearch.getText().toString().trim().equals(product.getName())){
                            Toast.makeText(MainActivity.this, "xxx", Toast.LENGTH_SHORT).show();
                            Product temp = product;
                            products.clear();
                            products.add(temp);
                            productAdapter.notifyDataSetChanged();
                            break;
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Toast.makeText(MainActivity.this, "co ma", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
                else if(i == 1){
                    Toast.makeText(MainActivity.this, "co ma 2", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}