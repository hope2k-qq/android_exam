package com.example.android_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDAO userDAO;
    private RecyclerView rvUsers;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDAO = NetworkService.getInstance(getApplicationContext()).getUserDAO();

        rvUsers = findViewById(R.id.rvUsers);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        userAdapter = new UserAdapter();
        rvUsers.setAdapter(userAdapter);

        update();

        loadUsers();
    }

    private void loadUsers() {
        List<User> userList = userDAO.getAllUsers();
        userAdapter.setUsers(userList);
    }

    private void update() {
        NetworkService.getInstance(getApplicationContext()).renewalUsers();
    }
}
