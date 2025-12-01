package com.caarlos.mangalibrary;

import com.caarlos.mangalibrary.model.Manga;
import com.caarlos.mangalibrary.service.MangaApi;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MangaApi api = new MangaApi();

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a manga title: ");
        String query = in.nextLine();

        try {
            List<Manga> results = api.searchManga(query);

            for (Manga m : results) {
                System.out.println(m.getTitle());
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            in.close();
        }
    }
}