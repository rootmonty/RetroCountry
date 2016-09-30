package badebaba.retrocountry;

import java.util.List;

/**
 * Created by badebaba on 9/29/2016.
 */

public class Model_List {
    List<Model> modelList;

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> model) {
        this.modelList = model;
    }

    public void addmodel(Model model) {
        modelList.add(model);
    }
}
