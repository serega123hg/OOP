package seventh;
import java.io.*;
import java.net.*;
import java.util.*;

public class Crawler {
    static LinkedList <URLDepthPair> findLink = new LinkedList<>();
    static LinkedList <URLDepthPair> viewedLink = new LinkedList<>();

    public static void Process(String addressStart, int maxDepth) throws IOException {
        findLink.add(new URLDepthPair(addressStart, 0));
        while (!findLink.isEmpty()) {
            URLDepthPair current = findLink.removeFirst();
            if (current.depth <= maxDepth) {
                //Socket socket = new Socket(current.getHost(), 80);
                Socket socket = new Socket(current.getHost(), 443);

                socket.setSoTimeout(5000);
                try {
                    Scan(current.getURL(), current.depth);
                    viewedLink.add(current);
                }
                catch (IOException e) {
                    viewedLink.add(current);
                }
                socket.close();
            }
        }
    }

    public static void Scan(String addressHad, int currentPrevious) throws IOException {
        URL address = new URL(addressHad);
        BufferedReader in = new BufferedReader(new InputStreamReader(address.openStream()));
        String inputLine;
        while (((inputLine = in.readLine()) != null)) {
            if (inputLine.contains("<a") && inputLine.contains("href=")) {
                String linkToShow = inputLine.substring(inputLine.indexOf("href=") + 6);
                if ((linkToShow.startsWith("http://") || linkToShow.startsWith("https://")) && (!linkToShow.matches("^[а-яА-Я]+$"))) {
                //if ((linkToShow.startsWith("http://")) && (!linkToShow.matches("^[а-яА-Я]+$"))) {
                    linkToShow = linkToShow.substring(0, linkToShow.indexOf('"'));
                    URLDepthPair catchPair = new URLDepthPair(linkToShow, currentPrevious + 1);
                    if ((URLDepthPair.check(findLink, catchPair)) && (URLDepthPair.check(viewedLink, catchPair))) {
                        findLink.add(catchPair);
                    }
                }
            }
        }
        in.close();
    }

    public static void showLinks(LinkedList<URLDepthPair> viewedLink) {
        for (URLDepthPair i: viewedLink)
            System.out.println("Глубина: " + i.getDepth() + "\tСсылка: " + i.getURL());
    }

    public static void main(String[] args) throws IOException {
        String httpPage = "https://tildoshnaya.com/";
        //String httpPage = "http://info.cern.ch/";
        int depth = 2;
        try {
            Process(httpPage, depth);
            showLinks(viewedLink);
        }
        catch (IOException e) {
            showLinks(viewedLink);
            System.out.println("Ошибка");
        }
    }
}
