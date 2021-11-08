package connection;

public enum ConnectionEnum {
    CONNECTION_ENUM;

    private Connection connection;

    ConnectionEnum(){
        connection = new Connection();
    }

    public Connection getConnection() {
        return connection;
    }
}
