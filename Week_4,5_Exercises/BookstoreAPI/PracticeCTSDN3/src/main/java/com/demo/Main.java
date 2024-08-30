package com.demo;

public class Main {

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();

        Document wordDoc = wordFactory.createDocument();


        // Open each document
        wordDoc.open();  // Output: Opening a Word document.
    }
}
