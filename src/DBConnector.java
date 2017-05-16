package services;

import com.sun.istack.internal.Nullable;

import java.sql.Connection;
import javax.swing.*;
import java.io.*;
import java.sql.DriverManager;
import java.util.Properties;

import static util.Util.showMessage;

public class DBConnector {
  private static DBConnector ourInstance = new DBConnector();
  private Connection connection;

  private static final File configFile = new File("DB.properties");
  private static final String dbClass = "com.mysql.jdbc.Driver";

  private static final String host_KEY = "host";
  private static final String login_KEY = "login";
  private static final String password_KEY = "password";

  private static final String host_VALUE = "localhost:3306/sanatory";
  private static final String login_VALUE = "root";
  private static final String password_VALUE = "root";

  @Nullable
  public Connection createConnection() throws IOException {
    if (initFile()) return connect();
    return null;
  }

  @Nullable
  private Connection connect() {
    try {
      Class.forName(dbClass);
      return connection != null ? connection : (connection = DriverManager.getConnection("jdbc:mysql://" + host_VALUE, login_VALUE, password_VALUE));
    } catch (Exception e) {
      e.printStackTrace();
      showMessage("ERROR:", e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
    }
    return connection;
  }

  private boolean initFile() throws IOException {
    if (!configFile.exists()) {
      if (configFile.createNewFile()) {

        try (OutputStream outputStream = new FileOutputStream(configFile)) {
          Properties properties = new Properties();
          properties.setProperty(host_KEY, host_VALUE);
          properties.setProperty(login_KEY, login_VALUE);
          properties.setProperty(password_KEY, password_VALUE);
          properties.store(outputStream, "This is a sample for java properties");

        } catch (IOException e) {
          showMessage("ERROR:", "cant write into file!", JOptionPane.ERROR_MESSAGE);
        }
      } else {
        showMessage("ERROR:", "NEW FILE CANT CREATE!", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    return getProperties();
  }

  private boolean getProperties() throws FileNotFoundException {

    try (InputStream inputStream = new FileInputStream(configFile)) {

      Properties prop = new Properties();
      prop.load(inputStream);

    } catch (Exception e) {
      e.printStackTrace();
      showMessage("NOT VALID ARGUMENT ->", e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  public static DBConnector getInstance() {
    return ourInstance;
  }

  private DBConnector() {
  }
}