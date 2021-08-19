package com.example.bodytrack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bodytrack.DAO.AtividadeDAO;
import com.example.bodytrack.DAO.PessoaDAO;
import com.example.bodytrack.DAO.SerieDAO;
import com.example.bodytrack.DAO.TreinoDao;
import com.example.bodytrack.Model.AppDatabase;
import com.example.bodytrack.Model.Atividade;
import com.example.bodytrack.Model.AtividadeSerieCrossRef;
import com.example.bodytrack.Model.AtividadeSeries;
import com.example.bodytrack.Model.Pessoa;
import com.example.bodytrack.Model.PessoaTreinoCrossRef;
import com.example.bodytrack.Model.PessoaTreinos;
import com.example.bodytrack.Model.Serie;
import com.example.bodytrack.Model.Treino;
import com.example.bodytrack.Model.TreinoAtividadeCrossRef;
import com.example.bodytrack.Model.TreinoAtividades;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;


@RunWith(AndroidJUnit4.class)
public class TesteGeralPersistencia {
    private PessoaDAO userDao;
    private TreinoDao treinoDao;
    private AtividadeDAO atividadeDao;
    private SerieDAO serieDao;
    private AppDatabase db;

    Pessoa user = new Pessoa("Rodrigo", "rod", "123", 105, 1.74);
    Treino treino = new Treino();
    Atividade atividade = new Atividade();
    Serie serie = new Serie();

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        userDao = db.pessoaDao();
        treinoDao = db.treinoDao();
        atividadeDao = db.atividadeDAO();
        serieDao = db.serieDao();


        treino.setNome("Treino 1");


        atividade.setNome("Atividade 1");

        serie.setNumSerie(1);
        serie.setRepeticao(8);
        serie.setPeso(20);

        userDao.insertAll(user);

        long idTreino = treinoDao.insertOne(treino);
        long idAtividade = atividadeDao.insertOne(atividade);
        long idSerie = serieDao.insertOne(serie);

        AtividadeSerieCrossRef atividadeSerieCrossRef = new AtividadeSerieCrossRef();
        atividadeSerieCrossRef.setSerieId(idSerie);
        atividadeSerieCrossRef.setAtividadeId(idAtividade);
        db.atividadeCrossRefDAO().insertAll(atividadeSerieCrossRef);

        TreinoAtividadeCrossRef treinoAtividadeCrossRef = new TreinoAtividadeCrossRef();
        treinoAtividadeCrossRef.setAtividadeId(idAtividade);
        treinoAtividadeCrossRef.setTreinoId(idTreino);
        db.treinoCrossRefDAO().insertAll(treinoAtividadeCrossRef);

        PessoaTreinoCrossRef pessoaTreinoCrossRef = new PessoaTreinoCrossRef();
        pessoaTreinoCrossRef.setTreinoId(idTreino);
        pessoaTreinoCrossRef.setLogin(user.getLogin());
        db.pessoaCrossRefDAO().insertAll(pessoaTreinoCrossRef);
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void buscarPessoa() throws Exception {


        List<Pessoa> pessoas = db.pessoaDao().getAll();

        Pessoa byName = new Pessoa();

        for (Pessoa p : pessoas) {
            if (p.getLogin().equals("rod")) {
                byName = p;
            }
        }
        assertThat(byName.getNome(), equalTo(user.getNome()));
    }

    @Test
    public void buscarTreinoPessoas() throws Exception {

        List<PessoaTreinos> pessoasTreinos = db.pessoaTreinosDAO().getPessoaTreinos();
        ;
        List<Treino> treinos = pessoasTreinos.get(0).treinos;

        Treino byName = new Treino();

        for (Treino p : treinos) {
            if (p.getNome().equals("Treino 1")) {
                byName = p;
            }
        }
        assertThat(byName.getNome(), equalTo(treino.getNome()));
    }

    @Test
    public void buscarAtividadeTreino() throws Exception {

        List<Atividade> atividades = db.treinoatividadesDAO().getAtividadesTreino();
        Atividade byName = new Atividade();

        for (Atividade a : atividades) {
            if (a.getNome().equals("Atividade 1")) {
                byName = a;
            }
        }
        assertThat(byName.getNome(), equalTo(atividade.getNome()));
    }

    @Test
    public void buscarSerieAtividade() throws Exception {

        List<Serie> series = db.atividadeSerieDAO().getSeriesAtividade();

        Serie retorno = new Serie();

        for (Serie s : series) {
            if (s.getNumSerie() == 1) {
                retorno = s;
            }
        }
        assertThat(1 + "", equalTo(retorno.getNumSerie() + ""));
    }
}
