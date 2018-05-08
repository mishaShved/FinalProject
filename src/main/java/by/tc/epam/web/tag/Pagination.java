package by.tc.epam.web.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pagination extends SimpleTagSupport {

    int currentPage;
    int maxPage;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    @Override
    public void doTag() throws JspException, IOException {


        JspWriter out = getJspContext().getOut();

        out.print("<table>");
        out.print("<tr>");
        out.print("<td>");
        out.print("<nav aria-label=\"Page navigation example\">");
        out.print("<ul class=\"pagination\">");

        if(maxPage == 2){
            out.print(createPageLink(1));
            out.print(createPageLink(2));
        }else if(maxPage == 3){
            out.print(createPageLink(1));
            out.print(createPageLink(2));
            out.print(createPageLink(3));
        }else {

            if (currentPage >= 3) {
                out.print(createPageLink(1));
                if (currentPage > 3) {
                    createEllipse(out);
                }
            }

            if (currentPage == 1) {
                for (int i = currentPage, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            } else if (currentPage == maxPage) {
                for (int i = currentPage - 2, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            } else {
                for (int i = currentPage - 1, j = 0; j < 3 && j < maxPage; i++, j++) {
                    out.print(createPageLink(i));
                }
            }

            if (currentPage <= maxPage - 2) {
                if (currentPage < maxPage - 2) {
                    createEllipse(out);
                }
                out.print(createPageLink(maxPage));
            }


        }

        out.print("</ul>");
        out.print("</nav>");

        out.print("</td>");
        out.print("</tr>");
        out.print("</table>");

    }

    private String createPageLink(int page){

        StringBuilder form = new StringBuilder();

        form.append("<li class=\"page-item\">")
                .append("<a class=\"page-link\" href=\"/MishaBet?command=showStakes&page=")
                .append(page).append("\">")
                .append(page)
                .append("</a></li>");

        return form.toString();
    }

    private void createEllipse(JspWriter out) throws IOException {

        out.print("</ul>");
        out.print("</nav>");
        out.print("</td>");
        out.print("<td>");
        out.print(" ..... ");
        out.print("</td>");
        out.print("<td>");
        out.print("<nav aria-label=\"Page navigation example\">");
        out.print("<ul class=\"pagination\">");

    }
}