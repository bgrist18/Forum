package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("posts.txt");
        ArrayList<Post> posts = loadPosts(f); //loadposts returned an arraylist and we create an object for it here


        Scanner consoleScanner = new Scanner(System.in);

        int replyId = -1;
        while (true) {
            printPosts(posts, replyId); //only variable names when calling

            replyId = readId(consoleScanner.nextLine());


        }
    }

    public static ArrayList<Post> loadPosts(File f) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String replyId = columns[0];
            String author = columns[1];
            String text = columns[2];
            Post p = new Post(Integer.valueOf(replyId), author, text);
            posts.add(p);
        }
        return posts;
    }
    public static void printPosts(ArrayList<Post> posts, int replyId){     //not returning anyhting here
        System.out.println("Posts replying to " + replyId);
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            if (post.replyId == replyId) {
                System.out.printf("[%s] %s by %s\n", i, post.text, post.author);
            }
        }
    }
    public static int readId (String input){
        System.out.println("Type the id you want to see replies to:");
        return Integer.valueOf(input);
    }

}