/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esa.titan.restful.newsticker;

import java.io.IOException;
import java.util.ArrayList;
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
public class ArticleManager {

    private Article dummy = new Article("Le Pong sours cross-Channel relations before Cameron EU speech",
            "2013-01-22T16:01:00Z",
            "http://www.guardian.co.uk/uk/2013/jan/22/french-gas-cloud-stink-south-east",
            "https://static-secure.guim.co.uk/sys-images/Guardian/Pix/pictures/2013/1/22/1358860652111/Lubrizol-factory-in-Rouen-004.jpg",
            "As a metaphor made literal it was almost");
    private ArrayList<Article> articles = new ArrayList<Article>();
    private int i = 0;

    public ArticleManager() {
        articles.add(dummy);
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
        return getCurrentArticle().content;
    }

    private Article getCurrentArticle() {
        return articles.get(i);
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void openExternURL() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(getArticleUrl());
    }
}
