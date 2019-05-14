package helper;

import bean.Cabinet;
import java.util.List;

import javafx.scene.control.TableView;

public class CabinetFxHelper extends AbstractFxHelper<Cabinet> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("N#", "id"),
            new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Adresse", "adresse"),
            new AbstractFxHelperItem("Telephone", "telephone")
        };
    }

    public CabinetFxHelper(TableView<Cabinet> table, List<Cabinet> list) {
        super(titres, table, list);
    }

    public CabinetFxHelper(TableView<Cabinet> table) {
        super(titres, table);
    }

}
