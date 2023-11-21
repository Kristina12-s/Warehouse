package cs.vsu.ru.KristinaPetrova;

import cs.vsu.ru.KristinaPetrova.database.DatabaseSQL;
import cs.vsu.ru.KristinaPetrova.json.Deserializer;
import cs.vsu.ru.KristinaPetrova.logic.Logic;

import java.io.File;

import static cs.vsu.ru.KristinaPetrova.Main.soutSomeInfo;

public class JSON_to_base {
    public static void main(String[] args) {
        File file = new File("test.json");
        Database db = DatabaseSQL.getINSTANCE();
        db.deleteAll();
        Deserializer deserializer = new Deserializer(db);
        deserializer.deserialize(file);
        Logic logic = new Logic(db);

        System.out.println("read");
        soutSomeInfo(db, logic);
    }
}
