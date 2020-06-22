package com.etf.telfor.api;

import com.etf.telfor.data.Author;
import com.etf.telfor.data.AuthorPaper;
import com.etf.telfor.data.Chairperson;
import com.etf.telfor.data.Paper;
import com.etf.telfor.data.Section;
import com.etf.telfor.data.Session;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("author/{authorId}")
    Call<Author> getAuthorById(@Path("authorId") int authorId);

    @GET("author")
    Call<ArrayList<Author>> getAllAuthors();

    @GET("author/paper")
    Call<ArrayList<Paper>> getAllPapers();

    @GET("author/paper/{paperId}")
    Call<Paper> getPaperById(@Path("papersId") int papersId);

    @GET("author/paper/forAuthor/{authorId}")
    Call<ArrayList<Paper>> getPapersByAuthor(@Path("authorId") int authorId);

    @GET("author/authorPapers/{authorPaperId}")
    Call<AuthorPaper> getAuthorPaperById(@Path("authorPaperId") int authorPaperId);

    @GET("author/forPaper/{paperId}")
    Call<ArrayList<Author>> getAuthorsByPaper(@Path("paperId") int paperId);

    @GET("author/authorPapers")
    Call<ArrayList<AuthorPaper>> getAllAuthorPapers();

    @GET("session/chairperson/{chairpersonId}")
    Call<Chairperson> getChairpersonById(@Path("chairpersonId") int chairpersonId);

    @GET("session/chairperson")
    Call<ArrayList<Chairperson>> getAllChairpersons();

    @GET("session/{sessionId}")
    Call<Session> getSessionById(@Path("sessionId") int sessionId);

    @GET("session")
    Call<ArrayList<Session>> getAllSessions();

    @GET("session/section/{sectionId}")
    Call<Section> getSectionById(@Path("sectionId") int sectionId);

    @GET("session/section")
    Call<ArrayList<Section>> getAllSections();

    @GET("session/section/forChairperson/{chairpersonId}")
    Call<ArrayList<Section>> getSectionsByChairperson(@Path("chairpersonId") int chairpersonId);
}
