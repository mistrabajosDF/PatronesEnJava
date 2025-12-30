package P2_E17;

import java.util.Collection;
import java.util.List;

public class DatabaseAccessProxy implements DatabaseAccess {
    private DatabaseAccess realAccess;
    private boolean authenticated = false;

    public DatabaseAccessProxy(DatabaseAccess realAccess) {
        this.realAccess = realAccess;
    }

    public void authenticate(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            authenticated = true;
        }
    }

    private void checkAuthentication() {
        if (!authenticated) {
            throw new SecurityException("Usuario no autenticado.");
        }
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        checkAuthentication();
        return realAccess.insertNewRow(rowData);
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        checkAuthentication();
        return realAccess.getSearchResults(queryString);
    }
}

