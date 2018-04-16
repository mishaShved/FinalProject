package by.tc.epam.tag;

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

        out.print(createPageLink(1));

        if(currentPage <= 2){
            out.print(createPageLink(2));
            out.print(createPageLink(3));
        }

        if(currentPage > 3){
            out.print("<td>...</td>");
        }

        if(currentPage > 2 && currentPage < maxPage - 1){
            for(int i = currentPage - 1; i <= currentPage + 1; i++){
                out.print(createPageLink(i));
            }
        }

        if(currentPage >= maxPage - 1){
            out.print(createPageLink(maxPage - 2));
            out.print(createPageLink(maxPage - 1));
        }

        if(currentPage < maxPage - 2){
            out.print("<td>...</td>");
        }

        out.print(createPageLink(maxPage));

        out.print("</tr>");
        out.print("</table>");

    }

    private String createPageLink(int page){

        StringBuilder form = new StringBuilder();

        form.append("<td>").append(page).append("</td>");

        return form.toString();
    }
}