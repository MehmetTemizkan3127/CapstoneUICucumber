package pages;

public class AllPages {

    private HomePage homePage;
    private LoginPage loginPage;
    private UsersPage usersPage;
    private UserDetailPage userDetailPage;
    private RemoteUnitsPage remoteUnitsPage;
    private DepartmentsPage departmentsPage;
    private DepartmentDetailPage departmentDetailPage;
    private TeamsPage teamsPage;
    private RolesPage rolesPage;
    private PermissionsPage permissionsPage;
    private NewDepartmentPage newDepartmentPage;
    private TeamDetailPage teamDetailPage;
    private NewTeamPage newTeamPage;
    private NewRemoteUnitPage newRemoteUnitPage;
    private EditRemoteUnitsPage editRemoteUnitsPage;
    private EditDepartmentPage editDepartmentPage;
    private DashboardPage dashboardPage;
    private ProfilePage profilePage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public UsersPage getUsersPage() {
        if (usersPage == null) {
            usersPage = new UsersPage();
        }
        return usersPage;
    }

    public UserDetailPage getUserDetailPage() {
        if (userDetailPage == null) {
            userDetailPage = new UserDetailPage();
        }
        return userDetailPage;
    }

    public RemoteUnitsPage getRemoteUnitsPage(){
        if (remoteUnitsPage == null) {
            remoteUnitsPage = new RemoteUnitsPage();
        }
        return remoteUnitsPage;
    }

    public DepartmentsPage getDepartmentsPage() {
        if (departmentsPage==null){
            departmentsPage = new DepartmentsPage();
        }
        return departmentsPage;
    }

    public DepartmentDetailPage getDepartmentDetailPage() {
        if (departmentDetailPage == null){
            departmentDetailPage = new DepartmentDetailPage();
        }
        return departmentDetailPage;
    }

    public TeamsPage getTeamsPage() {
        if (teamsPage == null){
            teamsPage = new TeamsPage();
        }
        return teamsPage;
    }

    public RolesPage getRolesPage() {
        if (rolesPage == null){
            rolesPage = new RolesPage();
        }
        return rolesPage;
    }

    public PermissionsPage getPermissionsPage() {
        if (permissionsPage == null){
            permissionsPage = new PermissionsPage();
        }
        return permissionsPage;
    }

    public NewDepartmentPage getNewDepartmentPage() {
        if (newDepartmentPage == null){
            newDepartmentPage = new NewDepartmentPage();
        }
        return newDepartmentPage;
    }

    public TeamDetailPage getTeamDetailPage() {
        if (teamDetailPage == null){
            teamDetailPage = new TeamDetailPage();
        }
        return teamDetailPage;
    }

    public NewTeamPage getNewTeamPage() {
        if (newTeamPage == null){
            newTeamPage = new NewTeamPage();
        }
        return newTeamPage;
    }

    public NewRemoteUnitPage getAddNewRemoteUnitPage() {
        if (newRemoteUnitPage == null){
            newRemoteUnitPage = new NewRemoteUnitPage();
        }
        return newRemoteUnitPage;
    }

    public EditRemoteUnitsPage getEditRemoteUnitsPage() {
        if (editRemoteUnitsPage == null){
            editRemoteUnitsPage = new EditRemoteUnitsPage();
        }
        return editRemoteUnitsPage;
    }

    public EditDepartmentPage getEditDepartmentPage() {
        if (editDepartmentPage == null){
            editDepartmentPage = new EditDepartmentPage();
        }
        return editDepartmentPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProfilePage getProfilePage() {
        if (profilePage == null){
            profilePage = new ProfilePage();
        }
        return profilePage;
    }


}
