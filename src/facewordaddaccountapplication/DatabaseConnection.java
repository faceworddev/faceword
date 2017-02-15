package facewordaddaccountapplication;

public class DatabaseConnection 
{
    private String url = "50.87.145.151";
    private String username = "faceword_root";
    private String password = "diCoOkHxmKpGgby!B0";
    
    public DatabaseConnection()
    {
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("scott");
        dataSource.setPassword("tiger");
        dataSource.setServerName("myDBHost.example.org");
    }
}
