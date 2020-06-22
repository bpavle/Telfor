package com.etf.telfor.data;/*
package com.etf.telfor.data;

public class Paper {
    private int paperId = -1;
    private String title;
    private String paper_abstract;
    private String keywords;

    public Paper() {
    }

    public Paper(String title, String paper_abstract, String keywords) {
        this.title = title;
        this.paper_abstract = paper_abstract;
        this.keywords = keywords;
    }

    public Paper(int paperId, String title, String paper_abstract, String keywords) {
        this.paperId = paperId;
        this.title = title;
        this.paper_abstract = paper_abstract;
        this.keywords = keywords;
    }

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaper_abstract() {
        return paper_abstract;
    }

    public void setPaper_abstract(String paper_abstract) {
        this.paper_abstract = paper_abstract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

/**
 *
 * @author Pikacu
 */
public class Paper implements Serializable{
    private int paperId = -1;
    private String title;
    private String paperAbstract;
    private String keywords;
    private String index;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }


    public Paper() {
    }


    public Paper(String title, String paperAbstract, String keywords) {
        this.title = title;
        this.paperAbstract = paperAbstract;
        this.keywords = keywords;
    }


    public Paper(int paperId,String title, String paperAbstract, String keywords) {
        this.paperId = paperId;
        this.title = title;
        this.paperAbstract = paperAbstract;
        this.keywords = keywords;
    }
    public Paper(int paperId,String title, String paperAbstract, String keywords,String index) {
        this.paperId = paperId;
        this.title = title;
        this.paperAbstract = paperAbstract;
        this.keywords = keywords;
        this.index=index;
    }
    /**
     * @return the paperId
     */
    public int getPaperId() {
        return paperId;
    }

    /**
     * @param paperId the paperId to set
     */
    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the paperAbstract
     */
    public String getPaperAbstract() {
        return paperAbstract;
    }

    /**
     * @param paperAbstract the paperAbstract to set
     */
    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Paper{" + "paperId=" + paperId + ", title=" + title + ", paperAbstract=" + paperAbstract + ", keywords=" + keywords + '}';
    }

}

