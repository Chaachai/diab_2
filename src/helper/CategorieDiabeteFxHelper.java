package helper;

import bean.CategorieDiabete;
import java.util.List;

import javafx.scene.control.TableView;

public class CategorieDiabeteFxHelper extends AbstractFxHelper<CategorieDiabete> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("TYPE DIABETE", "libelle")
        };
    }

    public CategorieDiabeteFxHelper(TableView<CategorieDiabete> table, List<CategorieDiabete> list) {
        super(titres, table, list);
    }

    public CategorieDiabeteFxHelper(TableView<CategorieDiabete> table) {
        super(titres, table);
    }

}
