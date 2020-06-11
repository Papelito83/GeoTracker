package com.example.randoglingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button joinGroupButton;
    private Button validateJoinIDButton;
    private Button validateJoinPasswordButton;
    private Button createGroupButton;
    private Button goBackJoinIDButton;
    private Button goBackJoinPasswordButton;
    private Button goBackCreateButton;
    private Button validateCreateGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_view);

        Handler handler=new Handler();
        Runnable r=new Runnable() {
            public void run() {
                displayHomeActivity();
            }
        };
        handler.postDelayed(r, 3000);


    }

    public void displayHomeActivity() {
        setContentView(R.layout.home_view);
        joinGroupButton = findViewById(R.id.joinGroupButton);
        joinGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayJoinGroupActivity();
            }
        });

        createGroupButton = findViewById(R.id.createGroupButton);
        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCreateGroupActivity();
            }
        });
    }


    public void displayJoinGroupActivity() {
        setContentView(R.layout.join_id_view);
        goBackJoinIDButton = findViewById(R.id.goBackJoinIDButton);
        goBackJoinIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayHomeActivity();
            }
        });

        validateJoinIDButton = findViewById(R.id.validateJoinIDButton);
        validateJoinIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idGroup = (EditText) findViewById(R.id.joinGroupID);
                if( TextUtils.isEmpty(idGroup.getText())){
                    idGroup.setError( "Veuillez renseigner un ID" );
                }else {
                    displayJoinGroupPasswordActivity();
                }
            }
        });
    }

    public void displayJoinGroupPasswordActivity() {
        setContentView(R.layout.join_password_view);
        validateJoinPasswordButton = findViewById(R.id.validateJoinPasswordButton);
        validateJoinPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idGroup = (EditText) findViewById(R.id.passwordJoinGroup);
                if( TextUtils.isEmpty(idGroup.getText())){
                    idGroup.setError( "Veuillez renseigner un mot de passe" );
                }else {
                    displayMapActivity();
                }
            }
        });
        goBackJoinPasswordButton = findViewById(R.id.goBackJoinPasswordButton);
        goBackJoinPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayJoinGroupActivity();
            }
        });
    }

    public void displayCreateGroupActivity() {
        setContentView(R.layout.create_group_view);
        goBackCreateButton = findViewById(R.id.goBackCreateButton);
        goBackCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayHomeActivity();
            }
        });

        validateCreateGroupButton = findViewById(R.id.validateCreateGroupButton);
        validateCreateGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText groupNameCreate = (EditText) findViewById(R.id.groupNameCreate);
                EditText groupPasswordCreate = (EditText) findViewById(R.id.groupPasswordCreate);
                if( TextUtils.isEmpty(groupNameCreate.getText()) || TextUtils.isEmpty(groupPasswordCreate.getText())){
                    if( TextUtils.isEmpty(groupNameCreate.getText())) {
                        groupNameCreate.setError( "Veuillez renseigner un nom" );
                    }
                    if( TextUtils.isEmpty(groupPasswordCreate.getText())) {
                        groupPasswordCreate.setError( "Veuillez renseigner un mot de passe" );
                    }
                }else {
                    displayMapActivity();
                }
            }
        });
    }

    public void displayMapActivity() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
