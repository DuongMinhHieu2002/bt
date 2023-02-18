package com.example.cuttomlv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvhanghoa;
    ArrayList<Hanghoa> arrayList;
    Adapterhanghoa adapterNuoc;
    Context context;
    EditText edtNuoc;
    EditText edtThudo;
    EditText edtDongia;
    Button btnthem;
    Button btnsua;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        arrayList = new ArrayList<>();
        AddArrList();
        context=this;
        adapterNuoc=new Adapterhanghoa(context,R.layout.item_nuoc,arrayList);
        lvhanghoa.setAdapter(adapterNuoc);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenhang=edtNuoc.getText().toString();
                String soluong=edtThudo.getText().toString();
                String dongia=edtDongia.getText().toString();
                if (TextUtils.isEmpty(tenhang)||TextUtils.isEmpty(soluong)||TextUtils.isEmpty(dongia)){
                    Toast.makeText(context,"du lieu chua day du",Toast.LENGTH_LONG).show();
                }
                else{
                    arrayList.add(new Hanghoa(tenhang,dongia,R.drawable.coca,soluong));
                    adapterNuoc.notifyDataSetChanged();
                    edtNuoc.setText(null);
                    edtThudo.setText(null);
                    edtDongia.setText(null);
                }
            }
        });
        lvhanghoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtThudo.setText(arrayList.get(position).soluong);
                edtNuoc.setText(arrayList.get(position).Tenhanghoa);
                edtDongia.setText(arrayList.get(position).dongia);
                vitri=position;
            }
        });
        lvhanghoa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xacnhanxoa();
//                Toast.makeText(context,"du lieu chua day du",Toast.LENGTH_LONG).show();
//                arrayList.remove(vitri);
                return false;

            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenhang= edtNuoc.getText().toString();
                String soluong=edtThudo.getText().toString();
                String dongia=edtDongia.getText().toString();
                int imgAnh=arrayList.get(vitri).imgnuoc;
                arrayList.set(vitri,new Hanghoa(tenhang,dongia,imgAnh,soluong));
                adapterNuoc.notifyDataSetChanged();
                edtNuoc.setText(null);
                edtThudo.setText(null);
                edtDongia.setText(null);
            }
        });
    }

   public void xacnhanxoa() {
        AlertDialog.Builder adl=new AlertDialog.Builder(this);
        adl.setTitle("Thông báo");
        adl.setIcon(R.mipmap.ic_launcher);
        adl.setMessage("Bạn có muốn xóa quoc gia này không ?");
       adl.setPositiveButton("Có", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               arrayList.remove(vitri);
               adapterNuoc.notifyDataSetChanged();
           }
       });
       adl.setNegativeButton("Không", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
        adl.show();
    }

    private void AddArrList() {
        arrayList.add(new Hanghoa("Cocacola","19000 vnd",R.drawable.coca,"10"));
        arrayList.add(new Hanghoa("Nước lọc","19000 vnd",R.drawable.ll,"10"));
        arrayList.add(new Hanghoa("Pessi","19000 vnd",R.drawable.ps,"10"));
        arrayList.add(new Hanghoa("Sting dâu","19000 vnd",R.drawable.st,"10"));

    }


    private void Anhxa() {
        lvhanghoa=findViewById(R.id.lvNuoc);
        btnthem=findViewById(R.id.btnThem);
        btnsua=findViewById(R.id.btnsua);
        edtNuoc=findViewById(R.id.edtNuoc);
        edtThudo=findViewById(R.id.edtThuDo);
        edtDongia=findViewById(R.id.edtdongia);
    }
}