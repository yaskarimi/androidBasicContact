package com.sematec.androidbasiccontact;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        String name = myList.get(i);
        // i == position
        myViewHolder.button.setText(name);

    }


    @Override
    public int getItemCount() {
        return myList.size();
    }



    class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder  {

        Button button;
        List<String> list;
        Context context;

        public MyViewHolder(@NonNull final View itemView , final Context context , final List<String> list) {
            super(itemView);
            button = itemView.findViewById(R.id.btnSwitch);
            this.context = context;
            this.list = list;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent dial = new Intent(context, DialActivity.class);
                            context.startActivity(dial);
                            Log.d("TAG" , "dial has been clicked");
                            break;
                        case 1:
                            Intent profile = new Intent(context, ProfileActivity.class);
                            context.startActivity(profile);
                            break;
                        case 2:
                            Intent intent3 = new Intent(context, Calendar.class);
                            context.startActivity(intent3);
                            break;
                    }
                }
            });

        }







}}

