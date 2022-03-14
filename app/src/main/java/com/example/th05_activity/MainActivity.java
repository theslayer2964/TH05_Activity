package com.example.th05_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        products.add(new Product(R.drawable.yellow,"Tasty Donut",10.00,"xxx"));
        products.add(new Product(R.drawable.pink,"Pink Donut",20.00,"xxx"));
        products.add(new Product(R.drawable.green,"Float Donut",30.00,"xxx"));
        products.add(new Product(R.drawable.red,"Tasty Donut",40.00,"xxx"));

        listChuaXoa = new ArrayList<>(products);
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
                    for (Product p:listChuaXoa) {
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
        
    }
}