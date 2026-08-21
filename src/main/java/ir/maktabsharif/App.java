package ir.maktabsharif;

import ir.maktabsharif.model.Developer;
import ir.maktabsharif.model.Edition;
import ir.maktabsharif.model.Game;
import ir.maktabsharif.repository.impl.DeveloperRepositoryImpl;
import ir.maktabsharif.repository.impl.GameRepositoryImpl;
import ir.maktabsharif.service.DeveloperService;
import ir.maktabsharif.service.DeveloperServiceImpl;
import ir.maktabsharif.service.GameService;
import ir.maktabsharif.service.GameServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl());
        GameService gameService = new GameServiceImpl(new GameRepositoryImpl());



        Developer developer = new Developer();
        developer.setName("CD Projekt");
        developer.setCountry("iran");




        Game game1 = new Game();
        game1.setTitle("Cyberpunk 2077");
        game1.setPrice(new BigDecimal(250));
        game1.setDescription("stedhstsrth");
        game1.setDeveloper(developer);



        Game game2 = new Game();
        game2.setTitle("The Witcher 3");
        game2.setPrice(new BigDecimal(650));
        game2.setDescription("fgjhdfyjhdr");
        game2.setDeveloper(developer);

        developer.setGames(List.of(game1,game2));


        Edition edition1 = new Edition();
        edition1.setGame(game1);
        edition1.setName("first edition");
        edition1.setPrice(new BigDecimal(120));


        Edition edition2 = new Edition();
        edition2.setGame(game2);
        edition2.setName("secund edition");
        edition2.setPrice(new BigDecimal(245));



        Edition edition3 = new Edition();
        edition3.setGame(game2);
        edition3.setName("third edition");
        edition3.setPrice(new BigDecimal(520));


        game1.setEditions(List.of(edition1));
        game2.setEditions(List.of(edition2,edition3));


        developerService.create(developer);


    }
}
