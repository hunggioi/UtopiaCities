package com.example.utopiacities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.utopiacities.adapter.CustomAdapter;
import com.example.utopiacities.data.DBManager;
import com.example.utopiacities.model.Utopia;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtName,edtSub,edtNumber;
    Button btnSave;
    ListView listView;
    private CustomAdapter customAdapter;
    private List<Utopia> utopiaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBManager dbManager = new DBManager(this);
        dbManager.hello();
        init();
        utopiaList = dbManager.getAllUtopia();
        setCustomAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utopia utopia = createUtopia();
                if (utopia!= null){
                    dbManager.addUtopia(utopia);
                }
                utopiaList.clear();
                utopiaList.addAll(dbManager.getAllUtopia());
                setCustomAdapter();
            }
        });
    }

    private void init() {
        edtName = findViewById(R.id.edt_name);
        edtSub = findViewById(R.id.edt_sub);
        edtNumber = findViewById(R.id.edt_number);
        btnSave = findViewById(R.id.btn_save);
        listView = findViewById(R.id.list_item);
    }

    private Utopia createUtopia (){

        String name = edtName.getText().toString();
        String sub = edtSub.getText().toString();
        String number = edtNumber.getText().toString();

        Utopia utopia = new Utopia(name,sub,number);
        return utopia;
    }

    public void setCustomAdapter(){
        if (customAdapter == null){
            customAdapter = new CustomAdapter(this,R.layout.item_list_view,utopiaList);
            listView.setAdapter(customAdapter);
        }else {
            customAdapter.notifyDataSetChanged();
            listView.setSelection(customAdapter.getCount()- 1);
        }
    }

}