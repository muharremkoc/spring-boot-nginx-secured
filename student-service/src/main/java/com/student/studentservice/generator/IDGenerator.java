package com.student.studentservice.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class IDGenerator implements IdentifierGenerator {

    private int startValue = 300;
    private int incrementSize = 58;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // Özel kimlik üretmek için gerekli kodları buraya yazın
        // Örneğin, bir atomik tam sayı kullanarak artan bir kimlik oluşturabilirsiniz.
        Connection connection = null;
        try {
            connection = session.getJdbcConnectionAccess().obtainConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select max(id) as nextval from students");

            if (rs.next()) {
                int id = rs.getInt("nextval") + incrementSize;

                if (id < startValue) {
                    id = startValue;
                }

                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                session.getJdbcConnectionAccess().releaseConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}