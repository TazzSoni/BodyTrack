package com.example.bodytrack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bodytrack.DAO.PessoaDAO;
import com.example.bodytrack.DAO.TreinoDao;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.Model.Treino;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TestarSalvarTreino {
    private TreinoDao userDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.treinoDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Treino treino = new Treino();
        treino.setNome("Treino 1");
        userDao.insertAll(treino);

        List<Treino> treinos = db.treinoDao().getAll();

        Treino byName = new Treino();

        for (Treino p : treinos) {
            if (p.getNome().equals("Treino 1")) {
                byName = p;
            }
        }
        assertThat(byName.getNome(), equalTo(treino.getNome()));
    }
}
