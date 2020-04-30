
public class mainMVC {
    PageView view = new PageView();
    PageModel model = new PageModel();
    PageDAO dao = new PageDAO();
    PageController control = new PageController(model, view, dao);
    
}
