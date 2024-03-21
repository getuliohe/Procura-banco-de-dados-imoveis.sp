package br.com.getulio.Projeto.linkar.banco.de.dados.imoveis.sp.service;
import java.sql.*;

public class SearchData {
    public static String getDataFromDB(String search) {
        StringBuilder result = new StringBuilder();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/imoveis.sp?user=root", "root", "ADttgh2017$");

            String query = "SELECT * FROM `imoveis.sp`.`imoveis_sp` WHERE `ID IMOVEL` = ? OR `NUMERO DO CONTRIBUINTE` = ? OR `NOME DE LOGRADOURO DO IMOVEL` = ? OR `NUMERO DO IMOVEL` = ? OR `COMPLEMENTO DO IMOVEL` = ? OR `BAIRRO DO IMOVEL` = ? OR `CEP DO IMOVEL` = ? OR `AREA DO TERRENO` = ? OR `VALOR DO M2 DO TERRENO` = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, search);
            statement.setString(2, search);
            statement.setString(3, search);
            statement.setString(4, search);
            statement.setString(5, search);
            statement.setString(6, search);
            statement.setString(7, search);
            statement.setString(8, search);
            statement.setString(9, search);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.append("ID IMOVEL: ")
                        .append(resultSet.getString("ID IMOVEL")).append(System.lineSeparator())
                        .append("NUMERO DO CONTRIBUINTE: ")
                        .append(resultSet.getString("NUMERO DO CONTRIBUINTE")).append(System.lineSeparator())
                        .append("NOME DE LOGRADOURO DO IMOVEL: ")
                        .append(resultSet.getString("NOME DE LOGRADOURO DO IMOVEL")).append(System.lineSeparator())
                        .append("NUMERO DO IMOVEL: ")
                        .append(resultSet.getString("NUMERO DO IMOVEL")).append(System.lineSeparator())
                        .append("COMPLEMENTO DO IMOVEL: ")
                        .append(resultSet.getString("COMPLEMENTO DO IMOVEL")).append(System.lineSeparator())
                        .append("BAIRRO DO IMOVEL: ")
                        .append(resultSet.getString("BAIRRO DO IMOVEL")).append(System.lineSeparator())
                        .append("CEP DO IMOVEL: ")
                        .append(resultSet.getString("CEP DO IMOVEL")).append(System.lineSeparator())
                        .append("AREA DO TERRENO: ")
                        .append(resultSet.getString("AREA DO TERRENO")).append(System.lineSeparator())
                        .append("VALOR DO M2 DO TERRENO: ")
                        .append(resultSet.getString("VALOR DO M2 DO TERRENO")).append(System.lineSeparator())
                        .append("-----------FIM-----------").append(System.lineSeparator());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }
}

