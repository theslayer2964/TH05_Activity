package com.example.th05_activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Product> productList;
    private int positionSelected = -1;

    public ProductAdapter(Context context, int layout, List<Product> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ImageView imgPicture = view.findViewById(R.id.imgAnh);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtPrice = view.findViewById(R.id.txtPrice);
        ImageView btnPlus = view.findViewById(R.id.btnPlus);

        Product product = productList.get(i);
        txtName.setText(product.getName());
        txtPrice.setText(String.valueOf(product.getPrice()));
        imgPicture.setImageResource(product.getPicture());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + product.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("s" ,(Serializable) product);
                context.startActivity(intent);
            }
        });

        final ConstraintLayout constraintLayout = view.findViewById(R.id.layoutOneLine);
        if (positionSelected == i) {
            constraintLayout.setBackgroundColor(Color.rgb(241, 176, 0));
        } else {
            constraintLayout.setBackgroundColor(Color.rgb(244, 221, 221));
        }


        return view;

    }
}
