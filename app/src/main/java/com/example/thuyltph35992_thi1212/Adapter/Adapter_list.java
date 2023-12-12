package com.example.thuyltph35992_thi1212.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuyltph35992_thi1212.DAO.DiemDanhDAO;
import com.example.thuyltph35992_thi1212.DTO.DiemDanhDTO;
import com.example.thuyltph35992_thi1212.R;

import java.util.List;

public class Adapter_list extends RecyclerView.Adapter<Adapter_list.ViewHoder> {
    List<DiemDanhDTO> list;
    Context context;
    DiemDanhDAO diemDanhDAO;
    public Adapter_list(List<DiemDanhDTO> list, Context context) {
        this.list = list;
        this.context = context;
        diemDanhDAO = new DiemDanhDAO(context);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHoder(((Activity) context).getLayoutInflater().inflate(R.layout.item_nv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, @SuppressLint("RecyclerView") int position) {
        holder.ma.setText("" + list.get(position).getMaSV());
        holder.ten.setText("" + list.get(position).getHoTen());
        holder.email.setText("" + list.get(position).getEmail());

        holder.tong_vang.setText("" + list.get(position).getTong_vang());

        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn xóa");
                builder.setIcon(R.drawable.baseline_warning_amber_24);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        diemDanhDAO.xoa(list.get(position));
                        load();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

    }

    private void load() {
        list.clear();
        list.addAll(diemDanhDAO.getData());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView ma, ten, email,tong_vang;
        ImageView xoa;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            ma = itemView.findViewById(R.id.tv_ma);
            ten = itemView.findViewById(R.id.tv_ten);
            email = itemView.findViewById(R.id.tv_email);
            tong_vang = itemView.findViewById(R.id.tv_tong_vang);
            xoa = itemView.findViewById(R.id.delete);

        }
    }
}
