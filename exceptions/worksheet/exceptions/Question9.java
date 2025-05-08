package worksheet.exceptions;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServiceLayerException extends Exception {
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ControllerLayerException extends Exception {
    public ControllerLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Repository {
    public void getData() throws SQLException {
        throw new SQLException("Database connection failed");
    }
}

class Service {
    private Repository repository = new Repository();

    public void processData() throws ServiceLayerException {
        try {
            repository.getData();
        } catch (SQLException e) {
            throw new ServiceLayerException("Failed to process data", e);
        }
    }
}

public class Question9 {

    private static final Logger LOGGER = Logger.getLogger(Question9.class.getName());
    private static Service service = new Service();

    public static void main(String[] args) {
        try {
            service.processData();
        } catch (ServiceLayerException e) {
            LOGGER.log(Level.SEVERE, "Error in controller layer", e);
        }
    }
}