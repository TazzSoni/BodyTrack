package com.example.bodytrack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bodytrack.DAO.AtividadeDAO;
import com.example.bodytrack.DAO.TreinoDao;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Treino;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TestarSalvarAtividade {
    private AtividadeDAO userDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.atividadeDAO();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Atividade atividade = new Atividade();
        atividade.setNome("Atividade 1");
        userDao.insertAll(atividade);

        List<Atividade> atividades = db.atividadeDAO().getAll();

        Atividade byName = new Atividade();

        for (Atividade a : atividades) {
            if (a.getNome().equals("Atividade 1")) {
                byName = a;
            }
        }
        assertThat(byName.getNome(), equalTo(atividade.getNome()));
    }
}
