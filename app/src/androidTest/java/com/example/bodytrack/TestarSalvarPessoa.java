package com.example.bodytrack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bodytrack.DAO.PessoaDAO;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.View.Cadastro;
import com.example.bodytrack.View.Home;
import com.example.bodytrack.View.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TestarSalvarPessoa {
    private PessoaDAO userDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.pessoaDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Pessoa user = new Pessoa("Rodrigo", "rod", "123", 105, 1.74);
        userDao.insertAll(user);

        List<Pessoa> pessoas = db.pessoaDao().getAll();

        Pessoa byName = new Pessoa();

        for (Pessoa p : pessoas) {
            if (p.getLogin().equals("rod")) {
                byName = p;
            }
        }
        assertThat(byName.getNome(), equalTo(user.getNome()));
    }
}