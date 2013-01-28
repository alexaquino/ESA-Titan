/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esa.titan.restful.newsticker;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author tiloW7-2012
 */
@ManagedBean
@SessionScoped
public class ArticleManager implements Serializable {

    private Article dummy = new Article("Le Pong sours cross-Channel relations before Cameron EU speech",
            "2013-01-22T16:01:00Z",
            "http://www.guardian.co.uk/uk/2013/jan/22/french-gas-cloud-stink-south-east",
            "https://static-secure.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/1/22/1358860652111/Lubrizol-factory-in-Rouen-004.jpg",
            "As a metaphor made literal it was almost");
    private static ArrayList<Article> articles = new ArrayList<Article>();
    private int currentArticleIndex = 0;

    public ArticleManager() {
    }

    public String getArticleTitle() {
        return getCurrentArticle().title;
    }

    public String getArticlePublicationDate() {
        return getCurrentArticle().publicationDate;
    }

    public String getArticleUrl() {
        return getCurrentArticle().url;
    }

    public String getArticleImageUrl() {
        // TODO wenn url nicht gueltig, dann auf server lokales bild lenken!
        return getCurrentArticle().imageUrl;
    }

    public String getArticleContent() {
        String currentArticleContent = getCurrentArticle().content;

        if ("".equals(currentArticleContent)) {
            return "article not found";
        }

        return currentArticleContent;
    }

    private Article getCurrentArticle() {
        return articles.get(currentArticleIndex);
    }

    public void nextArticle() {
        Logger.getLogger(ArticleManager.class.getName()).log(Level.INFO, "### nextArticle wurde aufgerufen");
        currentArticleIndex++;
        if (articles.size() == currentArticleIndex) {
            currentArticleIndex = 0;
        }
    }

    public static void setArticles(ArrayList<Article> articles) {
        ArticleManager.articles = articles;
    }

    public void openExternURL() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(getArticleUrl());
    }
}
