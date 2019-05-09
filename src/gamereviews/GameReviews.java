/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamereviews;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * A tarefa de cada dupla será dada pelo cálculo (código aluno 1 + código aluno
 * 2) % 3. 554450 + 581809 % 3 = 1
 *
 * Tarefa 1 - sumarizar para cada plataforma:
 *
 * + número de reviews desta plataforma + percentual de ‘Great’ reviews (sobre o
 * número de reviews desta plataforma) + média aritmética dos scores + desvio
 * padrão populacional dos scores + melhor jogo (basta indicar um entre os de
 * maior score) + pior jogo (basta indicar um entre os de menor score)
 *
 * Ao final: qual a plataforma com os jogos do gênero ‘Racing’ mais bem
 * avaliados?
 *
 */
public class GameReviews {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        String file = workingDir + "\\game-reviews.csv";

        SimpleReader f = new SimpleReader(file);
        String s = f.readLine(); // Primeira linhané titulo
        s = f.readLine();

        Map<String, Plataform> map = new TreeMap<String, Plataform>();

        int i = 2;

        try {
            while (s != null) {

                // Cria um array
                String[] data = s.split(";");

                Game game = new Game();
                game.setTitle(data[0]);
                game.setPlatform(data[1]);
                game.setScore_phrase(data[2]);
                game.setScore(Float.parseFloat(data[3]));
                game.setGenre(data[4]);
                game.setEditors_choice(data[5]);
                game.setRelease_year(Integer.parseInt(data[6]));

                //System.out.println(game.toString());
                Plataform p;
                if (!map.containsKey(game.getPlatform())) {
                    p = new Plataform();
                } else {
                    p = map.get(game.getPlatform());
                }

                p.reviews++;
                if (game.getScore_phrase().equalsIgnoreCase("great")) {
                    p.reviews_great++;
                }
                p.total_score += game.getScore();
                p.setBestGame(game);
                p.setWorstGame(game);
                p.games.add(game);

                map.put(game.getPlatform(), p);

                i++;

                s = f.readLine();
            }
        } catch (Exception e) {
            System.out.println(e +" "+i);
        }

        f.close();

        for (String plat : map.keySet()) {
            System.out.println("");
            System.out.println("------------------- " + plat + " ------------------- ");
            System.out.println(" Total reviews    : " + map.get(plat).reviews);
            System.out.println(" Média aritmética : " + map.get(plat).getMedia());
            System.out.println(" Desvio padrão    : " + map.get(plat).getDesvioPadrao());
            System.out.println(" % Great          : " + map.get(plat).getPercentualGreat());
            System.out.println(" Melhor jogo      : " + map.get(plat).bestGame.getTitle());
            System.out.println(" Pior jogo        : " + map.get(plat).worstGame.getTitle());
        }
    }

    private static class Plataform {

        private int reviews;
        private int reviews_great;
        private float total_score;
        private Game bestGame;
        private Game worstGame;
        private ArrayList<Game> games = new ArrayList();

        @Override
        public String toString() {
            return "Plataform{" + "reviews=" + reviews + ", reviews_great=" + reviews_great + ", total_score=" + total_score + '}';
        }

        public float getPercentualGreat() {
            return reviews_great * (reviews / 100);
        }

        public float getMedia() {
            return total_score * reviews_great;
        }

        public double getDesvioPadrao() {
            double i = 0;

            // Valores da amostra
            for (Game game : games) {
                double value = (game.getScore() - getMedia());
                i = i + Math.pow(value, 2);
            }

            // Elementos da população
            i = i / reviews;

            // Desvio padrão
            i = Math.sqrt(i);

            return Math.round(i);
        }

        public void setBestGame(Game g) {
            if (bestGame == null) {
                bestGame = g;
                return;
            }
            if (g.getScore() > bestGame.getScore()) {
                bestGame = g;
            }
        }

        public void setWorstGame(Game g) {
            if (worstGame == null) {
                worstGame = g;
                return;
            }
            if (g.getScore() < worstGame.getScore()) {
                worstGame = g;
            }
        }

    }

}
