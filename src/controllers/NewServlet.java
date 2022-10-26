package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        //Taskのインスタンスを生成
        Task t = new Task();

        //tの各フィールドにデータを代入
        //contentに初期値セット
        String content = "hello";
        t.setContent(content);

        //created_at,updated_atにセット
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        t.setCreated_at(currentTime);
        t.setUpdated_at(currentTime);

        //DBに保存
        em.persist(t); //DBに保存
        em.getTransaction().commit(); //データの新規登録を確定

        //自動採番されたIDの値を表示
        response.getWriter().append(Integer.valueOf(t.getId()).toString());

        //EntityManagerを終了
        em.close();
    }

}
