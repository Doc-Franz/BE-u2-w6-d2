package com.example.blogging.model;

public class Blog {

    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public Blog(String categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.id = (int) (Math.random() * 300);
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/" + Math.random() * 1000;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getCover() {
        return cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public int getTempoDiLettura() {
        return tempoDiLettura;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setTempoDiLettura(int tempoDiLettura) {
        this.tempoDiLettura = tempoDiLettura;
    }
}
