//index(一覧表示)

package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
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

        em.close();

        //task一覧(tasks)をリクエストスコープにセット
        request.setAttribute("tasks", tasks);

        //index.jspを呼び出し
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
        rd.forward(request, response);

    }

}
