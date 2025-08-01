package com.example.collegeapp.ebook;

public class EbookData {
    private String pdfUrl, pdfTitle;

    public EbookData() {
    }

    public EbookData(String pdfTitle, String pdfUrl) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfURL() {
        return pdfUrl;
    }

    public void setPdfURL(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }
}
