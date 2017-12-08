package behavioral_design_pattern.observer;

public class Client {

    public static void main(String[] args) {
        NewsPage newsPage = new NewsPage();
        Reader reader1 = new Reader();
        reader1.setName("丁丁");

        Reader reader2 = new Reader();
        reader2.setName("呵呵");

        Reader reader3 = new Reader();
        reader3.setName("五五");

        newsPage.attach(reader1);
        newsPage.attach(reader2);
        newsPage.attach(reader3);

        newsPage.setContent("今天天气不错");

    }
}
