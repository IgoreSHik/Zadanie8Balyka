package com.example.zadanie8balyka;

import static android.view.View.*;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class SensorListAdapter extends RecyclerView.Adapter<SensorListAdapter.SensorViewHolder> {

    Context context;
    List<Sensor> sensorList;

    public SensorListAdapter(Context ct, List<Sensor> sl)
    {
        context = ct;
        sensorList = sl;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sensor_list_item, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        holder.nazwa.setText(sensorList.get(position).getName());
        holder.typ.setText(Integer.toString(sensorList.get(position).getType()));

        holder.constraintLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SensorDetailsActivity.class);
                intent.putExtra("Nazwa", sensorList.get(position).getName());
                intent.putExtra("Typ", Integer.toString(sensorList.get(position).getType()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    public class SensorViewHolder extends RecyclerView.ViewHolder {

        TextView nazwa, typ;
        ConstraintLayout constraintLayout;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            nazwa = itemView.findViewById(R.id.sensorName);
            typ = itemView.findViewById(R.id.sensorType);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }

    /*String text;

        @Nullable
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            TextView here = (TextView) view.findViewById(R.id.sensorName);
            here.setText(text);
        }

        public SensorListAdapter(String text) {
            super(R.layout.sensor_list_item);
            this.text = text;
        }*/
}