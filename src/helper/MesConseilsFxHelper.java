package helper;

import bean.Conseils;
import java.util.List;

import javafx.scene.control.TableView;

public class MesConseilsFxHelper extends AbstractFxHelper<Conseils> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("TITRE", "titre"),
            new AbstractFxHelperItem("CONSEIL", "conseils")
        };
    }

    public MesConseilsFxHelper(TableView<Conseils> table, List<Conseils> list) {
        super(titres, table, list);
    }

    public MesConseilsFxHelper(TableView<Conseils> table) {
        super(titres, table);
    }

}
