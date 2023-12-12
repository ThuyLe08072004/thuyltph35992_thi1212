package com.example.thuyltph35992_thi1212.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuyltph35992_thi1212.Adapter.Adapter_list;
import com.example.thuyltph35992_thi1212.DAO.DiemDanhDAO;
import com.example.thuyltph35992_thi1212.DTO.DiemDanhDTO;
import com.example.thuyltph35992_thi1212.R;

import java.util.List;


public class Frag_list extends Fragment {
    RecyclerView recyclerView;
    ImageButton imageButton;
    Adapter_list adapterList;
    List<DiemDanhDTO> list;
    DiemDanhDAO diemDanhDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_list, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcv_list);
        imageButton = view.findViewById(R.id.ibtn_add);
        diemDanhDAO = new DiemDanhDAO(getContext());
        list = diemDanhDAO.getData();

        adapterList = new Adapter_list(list, getContext());
        recyclerView.setAdapter(adapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view1 = getActivity().getLayoutInflater().inflate(R.layout.dialog_, null, false);
                builder.setView(view1);
                Dialog dialog = builder.create();
                dialog.show();
//                TextView id;
                EditText ma, ten, email, tong_vang;
                Button them, huy;
//id=view1.findViewById(R.id.tv_id);
                ma = view1.findViewById(R.id.edt_ma);
                ten = view1.findViewById(R.id.edt_ten);
                email = view1.findViewById(R.id.edt_email);
                tong_vang = view1.findViewById(R.id.edt_vang);
                them = view1.findViewById(R.id.btn_them);
                huy = view1.findViewById(R.id.btn_huy);
                them.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ma.getText().toString().isEmpty() ||
                                ten.getText().toString().isEmpty() ||
                                email.getText().toString().isEmpty() ||
                                tong_vang.getText().toString().isEmpty()) {
                            Toast.makeText(getContext(), "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String masv = ma.getText().toString();
                        if (masv.length() < 1 || masv.length() > 7) {
                            Toast.makeText(getContext(), "Độ dài masv phải thuộc khoảng từ 1 đến 7 kí tự", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int tong =Integer.parseInt(tong_vang.getText().toString());
if (tong<1){
    Toast.makeText(getContext(), "Tổng vắng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
    return;
}
if (diemDanhDAO.add(new DiemDanhDTO(ma.getText().toString(), ten.getText().toString(),email.getText().toString(), Integer.parseInt(tong_vang.getText().toString()))) > 0) {
                            Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            list.clear();
                            list.addAll(diemDanhDAO.getData());
                            adapterList.notifyDataSetChanged();
                            dialog.dismiss();
//                            playMusic();

                        }
                        else {
                            Toast.makeText(getContext(), "Thất bại", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ma.setText("");
                        ten.setText("");
                        email.setText("");
                        tong_vang.setText("");
                    }
                });
            }
        });
    }

//    private void playMusic() {
//        try {
//            Uri soundUri = Uri.parse("android.resource://" + getContext().getPackageName() + "/raw/success_sound");
//            MediaPlayer mediaplayer = new MediaPlayer();
//            mediaplayer.setDataSource(getContext(), soundUri);
//            mediaplayer.prepare();
//            mediaplayer.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
//    private void showFullInfoDialog(int position) {
//        // Retrieve the selected NhanVien object
//        NhanVien selectedNhanVien = list.get(position);
//
//        // Create and show a dialog displaying full information
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("Full Information")
//                .setMessage("ID: " + selectedNhanVien.getMa() +
//                        "\nName: " + selectedNhanVien.getTen() +
//                        "\nAge: " + selectedNhanVien.getTuoi())
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .show();
//    }
