package com.example.intelcorei5.androidsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String DATABASE_NAME ="mydatabase";

    SQLiteDatabase mDatase;

    EditText et1,et2,et3;
    Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);

        createTable();

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);




    }

    private void createTable(){
        String sql= "CREATE TABLE stu (\n" +
                "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    name varchar(200) NOT NULL,\n" +

                "    marks varchar(200) NOT NULL\n" +
                ");";

        mDatase.execSQL(sql);
    }

    private void addStu(){
         String id = et1.getText().toString().trim();
        String name = et2.getText().toString().trim();
        String marks = et3.getText().toString().trim();

        if(id.isEmpty()){
            et1.setError("ID cannt be empty");
            et1.requestFocus();
            return;
        }

        if(name.isEmpty()){
            et2.setError("Name cannt be empty");
            et2.requestFocus();
            return;
        }

        if(marks.isEmpty()){
            et3.setError("Marks cannt be empty");
            et3.requestFocus();
            return;
        }

        String sql = "INSERT INTO stu(id,name,marks)"+ "VALUES(?,?,?)";

        mDatase.execSQL(sql,new String[]{id,name,marks});

        Toast.makeText(this,"Student Added",Toast.LENGTH_SHORT).show();

    }

    public void onClick(View view){
            switch (view.getId()) {
                case R.id.bt1:

                addStu();
            }

    }
}
