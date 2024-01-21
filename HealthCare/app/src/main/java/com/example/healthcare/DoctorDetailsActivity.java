package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Moloy Banarjee", "Hospital Address : Labaid", "Exp : 5yrs", "Mobile No : 01345495940", "500"},
                    {"Doctor Name : Yasin Bashar", "Hospital Address : Square", "Exp : 3yrs", "Mobile No : 01965425780", "300"},
                    {"Doctor Name : Emran Ahmed", "Hospital Address : Ragib Rabeya", "Exp : 9yrs", "Mobile No : 01878620432", "800"},
                    {"Doctor Name : Amit Sharma", "Hospital Address : Mount Adora", "Exp : 15yrs", "Mobile No : 01997826565", "1200"},
                    {"Doctor Name : Nusrat Jahan", "Hospital Address : United", "Exp : 2yrs", "Mobile No : 01317879580", "200"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Abu Sawon", "Hospital Address : Aichi", "Exp : 5yrs", "Mobile No : 01652476706", "700"},
                    {"Doctor Name : Tajwar Rahman", "Hospital Address : Ambia", "Exp : 4yrs", "Mobile No : 01534566877", "300"},
                    {"Doctor Name : Nixon Antu", "Hospital Address : Arif Memorial", "Exp : 1yrs", "Mobile No : 01943347869", "200"},
                    {"Doctor Name : Sadia Farzana", "Hospital Address : BGB Hospital", "Exp : 3yrs", "Mobile No : 01990875761", "400"},
                    {"Doctor Name : Ema", "Hospital Address : Ibn Sina", "Exp : 6yrs", "Mobile No : 01897121345", "800"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Farzine", "Hospital Address : Oasis", "Exp : 3yrs", "Mobile No : 01390908735", "400"},
                    {"Doctor Name : Nafi Ullah", "Hospital Address : Nurjahan", "Exp : 3yrs", "Mobile No : 01894457768", "300"},
                    {"Doctor Name : Kaykobad", "Hospital Address : Pongu", "Exp : 9yrs", "Mobile No : 01767343358", "800"},
                    {"Doctor Name : Amit Joy", "Hospital Address : Shalahuddin", "Exp : 10yrs", "Mobile No : 0177892565", "900"},
                    {"Doctor Name : Arnob Sen", "Hospital Address : MH Samorita ", "Exp : 4yrs", "Mobile No : 01713676730", "300"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Meraj Islam", "Hospital Address : Heart Foundation", "Exp : 6yrs", "Mobile No : 01343468704", "500"},
                    {"Doctor Name : Shovon", "Hospital Address : farazy", "Exp : 2yrs", "Mobile No : 017465800912", "200"},
                    {"Doctor Name : Shanto", "Hospital Address : Kumudini", "Exp : 6yrs", "Mobile No : 01775610482", "800"},
                    {"Doctor Name : Sazzad", "Hospital Address : Duwell", "Exp : 1yrs", "Mobile No : 01590258935", "200"},
                    {"Doctor Name : Durba", "Hospital Address : Holy Family", "Exp : 2yrs", "Mobile No : 01911907135", "200"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Shaeakh", "Hospital Address : Medinova", "Exp : 8yrs", "Mobile No : 01876908470", "900"},
                    {"Doctor Name : Niloy", "Hospital Address : Popular", "Exp : 4yrs", "Mobile No : 01990845112", "300"},
                    {"Doctor Name : Mridul", "Hospital Address : Samorita", "Exp : 9yrs", "Mobile No : 01578789054", "1000"},
                    {"Doctor Name : Gour", "Hospital Address : Continental Hospital", "Exp : 12yrs", "Mobile No : 01989072351", "1200"},
                    {"Doctor Name : Ashraful", "Hospital Address : AMZ Hospital", "Exp : 5yrs", "Mobile No : 01387611190", "700"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @SuppressLint("SuspiciousIndentation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonCartCheckout);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText (title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

            list = new ArrayList();
            for (int i = 0; i < doctor_details.length; i++) {
                item = new HashMap<String, String>();
                item.put ("line1", doctor_details[i][0]);
                item.put ("line2", doctor_details[i][1]);
                item.put ("line3", doctor_details[i][2]);
                item.put ("line4", doctor_details[i][3]);
                item.put ("line5", "Cons Fees :" + doctor_details[i][4]+"/-");
                list.add(item);
            }

            sa = new SimpleAdapter(this, list,
                    R.layout.multi_lines,
                    new String[]{"line1", "line2", "line3", "line4", "line5"},
                    new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
            );

        ListView lst = findViewById(R.id.listViewCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}