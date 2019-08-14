package com.sematec.androidbasiccontact;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<String> myList;
    Context context;


    public Adapter(List<String> list, Context context) {
        myList = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view,context , myList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String name = myList.get(i);
        // i == position
        myViewHolder.button.setText(name);

        switch (i) {
            case 0:
                Intent dial = new Intent(this.context, DialActivity.class);
                this.context.startActivity(dial);
                break;
            case 1:
                Intent profile = new Intent(this.context, ProfileActivity.class);
                this.context.startActivity(profile);
                break;
            case 2:
                Intent intent3 = new Intent(this.context, Calendar.class);
                this.context.startActivity(intent3);
                break;

        }

    }


    @Override
    public int getItemCount() {
        return myList.size();
    }


    class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        Button button;
        List<String> list;
        Context context;

        public MyViewHolder(@NonNull final View itemView ,Context context ,List<String> list) {
            super(itemView);
            button = itemView.findViewById(R.id.btnSwitch);
            this.context = context;
            this.list = list;


        }


    }


}
