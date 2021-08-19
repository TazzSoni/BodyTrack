package com.example.bodytrack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bodytrack.DAO.AtividadeDAO;
import com.example.bodytrack.DAO.SerieDAO;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.Serie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TestarSalvarSerie {
    private SerieDAO userDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.serieDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        Serie serie = new Serie();
        serie.setNumSerie(1);
        serie.setRepeticao(8);
        serie.setPeso(20);
        long id = userDao.insertOne(serie);

        List<Serie> series = db.serieDao().getAll();

        Serie retorno = new Serie();

        for (Serie s : series) {
            if (s.getSerieId() == id) {
                retorno = s;
            }
        }
        assertThat(id + "", equalTo(retorno.getSerieId() + ""));
    }
}

