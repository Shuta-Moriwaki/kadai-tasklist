//index(一覧表示)

package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //DBへの問い合わせ→結果をgetResultList()でリスト形式で取得→Taskクラスのオブジェクトになり格納
        List<Task> tasks = em.createNamedQuery("getAllTasks", Task.class).getResultList();
        response.getWriter().append(Integer.valueOf(tasks.size()).toString());

        em.close();
    }

}
