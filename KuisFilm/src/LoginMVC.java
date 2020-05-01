
public class LoginMVC {
    viewLogin view = new viewLogin();
    modelLogin model = new modelLogin();
    daoLogin dao = new daoLogin();
    controllerLogin controller = new controllerLogin(model, view, dao);
}
