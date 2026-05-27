package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String text1 = poemBeautifier.beautify("Uzdrowisko, busko", text -> "ABC" + text + "ABC");
        String text2 = poemBeautifier.beautify("Dzien dobry", text -> text.toUpperCase());
        String text3 = poemBeautifier.beautify("Jezdzisz na rowerze", text -> text + "??");
        String text4 = poemBeautifier.beautify("Krakow busko", text -> text.replace(" ", "."));

        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(text4);

    }
}
